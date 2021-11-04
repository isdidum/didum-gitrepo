package gui.swingapps;

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

import gui.swingapps.dnloads.*;


/**
 * @author A., Didum
 * @date February 21, 2013
 * @description DownloadManger(): responsible for the GUI-Interface and makes use of DnloadsTablesModel & ProgressRenderer classes
 */
public class DownloadManager extends JFrame implements Observer{
	/**serializable class declaration*/
	private static final long serialVersionUID = 1L;
	
	/**adds download text field*/
	private JTextField addTextField;
	
	/**download table's data model*/
	private DnloadsTableModel tableModel;
	
	/**table listing downloads*/
	private JTable table;
	
	/**buttons for managing the selected download*/
	private JButton pauseBtn, resumeBtn;
	private JButton cancelBtn, clearBtn;
	
	/**currently selected download*/
	private PerformsDownload selectedDownload;
	
	//flag for whether or not table selection is being cleared
	private boolean clearing;
	
	/**
	 * DownloadManager(): default constructor
	 */
	public DownloadManager(String title) {
		super(title); //sets application title
		
		//sets window size
		setSize(640, 480);
		
		//handles window closing events
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				actionExit();
			}
		});
		
		//set up file menu
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenuItem fileExitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
		fileExitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtAction) {
				actionExit();
			}
		});
		
		fileMenu.add(fileExitMenuItem);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
		
		//sets up add panel
		JPanel addPanel = new JPanel();
		addTextField = new JTextField(30);
		addPanel.add(addTextField);
		JButton addButton = new JButton("Add Download");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtAction) {
				actionAdd();
			}
		});
		
		addPanel.add(addButton);
		
		//sets up PerformsDownloads table
		tableModel = new DnloadsTableModel();
		table = new JTable(tableModel);
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evtList) {
				tableSelectionChanged();
			}
		});
		
		//allows only one row at a time be selected
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		//set up ProgressBar as renderer for progress column
		ProgressRenderer renderer = new ProgressRenderer(0, 100);
		renderer.setStringPainted(true);	//shows progress text
		table.setDefaultRenderer(JProgressBar.class, renderer);
		
		//set up downlaods panel
		JPanel downloadsPanel = new JPanel();
		downloadsPanel.setBorder(BorderFactory.createTitledBorder("Download"));
		downloadsPanel.setLayout(new BorderLayout());
		downloadsPanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
		//sets up button panel
		JPanel buttonsPanel = new JPanel();
		
		pauseBtn = new JButton("Pause");
		pauseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					actionPause();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		pauseBtn.setEnabled(false);
		buttonsPanel.add(pauseBtn);
		
		resumeBtn = new JButton("Resume");
		resumeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					actionResume();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		resumeBtn.setEnabled(false);
		buttonsPanel.add(resumeBtn);
		
		cancelBtn = new JButton("Cancel");
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					actionCancel();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		cancelBtn.setEnabled(false);
		buttonsPanel.add(cancelBtn);
		
		clearBtn = new JButton("Resume");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					actionClear();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		clearBtn.setEnabled(false);
		buttonsPanel.add(clearBtn);
		
		//adds panels to display
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(addPanel, BorderLayout.NORTH);
		getContentPane().add(downloadsPanel, BorderLayout.CENTER);
		getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	}

	/**exits this program*/
	private void actionExit() {
		System.exit(0);
	}
	
	/**adds a new donwload*/
	private void actionAdd() {
		URL verifiedUrl = verifyUrl(addTextField.getText());
		if(verifiedUrl != null) {
			tableModel.addDownload(new PerformsDownload(verifiedUrl));
			addTextField.setText("");	//resets add text field
		} else {
			String msg = "Invalid Download URL";
			JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**verifies download URL*/
	private URL verifyUrl(String url) {
		//only allow HTTP URLs
		if(!url.toLowerCase().startsWith("http://")) {
			return null;
		}
		
		//verify format of URL
		URL verifiedUrl = null;
		try {
			verifiedUrl = new URL(url);
		} catch (Exception e) {
			return null;
		}
		
		//make sure URL specifies a file
		if(verifiedUrl.getFile().length() < 2) {
			return null;
		}
		
		return verifiedUrl;
	}
	
	/**called when table row selection changes*/
	private void tableSelectionChanged() {
		//unregister from receiving notifications
		if(selectedDownload != null) {
			selectedDownload.deleteObserver(DownloadManager.this);
		}
		
		//if not in the middle of clearing a download, set the selected download & register to receive notification from it
		if(!clearing && table.getSelectedRow() > -1) {
			selectedDownload = tableModel.getDownload(table.getSelectedRow());
			selectedDownload.addObserver(DownloadManager.this);
			try {
				updateButtons();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**puases the selected download*/
	private void actionPause() throws Exception {
		selectedDownload.pause();
		updateButtons();
	}
	
	/**resumes the selected download*/
	private void actionResume() throws Exception {
		selectedDownload.resumel();
		updateButtons();
	}
	
	/**cancels the selected download*/
	private void actionCancel() throws Exception{
		selectedDownload.cancel();
		updateButtons();
	}
	
	/**clears the selected download*/
	private void actionClear() throws Exception{
		clearing = true;
		tableModel.clearDownload(table.getSelectedRow());
		clearing = false;
		selectedDownload = null;
		updateButtons();
	}
	
	/**updates each buttons state based off of the currently selected download's status*/
	private void updateButtons() throws Exception {
		if(selectedDownload != null){
			int status = 0;
			try {
				status = selectedDownload.getStatus();
			} catch(Exception e) {}
			switch(status) {
				case PerformsDownload.DOWNLOADING:
					pauseBtn.setEnabled(true);
					resumeBtn.setEnabled(false);
					cancelBtn.setEnabled(true);
					clearBtn.setEnabled(false);
					break;
				case PerformsDownload.PAUSED:
					pauseBtn.setEnabled(false);
					resumeBtn.setEnabled(true);
					cancelBtn.setEnabled(true);
					clearBtn.setEnabled(false);
					break;
				case PerformsDownload.ERROR:
					pauseBtn.setEnabled(false);
					resumeBtn.setEnabled(true);
					cancelBtn.setEnabled(false);
					clearBtn.setEnabled(true);
					break;
				default: //Complete or Cancelled
					pauseBtn.setEnabled(false);
					resumeBtn.setEnabled(false);
					cancelBtn.setEnabled(false);
					clearBtn.setEnabled(true);
			}
		} else {
			//no download is selected in table
			pauseBtn.setEnabled(false);
			resumeBtn.setEnabled(false);
			cancelBtn.setEnabled(false);
			clearBtn.setEnabled(false);
		}
	}
	
	/**update(): mutator - update is called when PerformsDownload notifies its observers of any changes*/
	public void update(Observable o, Object arg){
		//updates buttons if the selected download has changed
		if(selectedDownload != null && selectedDownload.equals(o)) {
			try {
				updateButtons();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * main(): mutator - application entry point that runs the download manager
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				String title = "Download Manager: Feb 21, 2013 by Didum";
				DownloadManager manager = new DownloadManager(title);
				manager.setVisible(true);
			}
		});

	}

}
