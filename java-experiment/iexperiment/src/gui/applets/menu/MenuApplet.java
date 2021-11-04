package gui.applets.menu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * @author A., Didum
 * @Date February 22, 2013
 * @Description MenuApplet(): adds series of nested menus to a pop-up window
 */

//creates frame window(JApplet is part of swing while Applet is of applet)
public class MenuApplet{
	MenuFrame menuFrame;

	public MenuApplet() {
		menuFrame = new MenuFrame("Menu Client");
		int width = 250;  //Integer.parseInt(getParameter("width"));
		int height = 250; //Integer.parseInt(getParameter("height"));
	
		menuFrame.setSize(new Dimension(width, height));	//frame window
	}
	
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MenuApplet frame = new MenuApplet();
				frame.menuFrame.setVisible(true);
			}
		});
	}	
}

class GetDialog extends Dialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	GetDialog(Frame parent, String title){
		super(parent, title, false);
		setLayout(new FlowLayout());
		setSize(300,200);
		
		add(new Label("Press this button"));
		Button b;
		add(b= new Button("Cancel"));
		b.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evta) {
		dispose();
	}
	
	public void paint(Graphics g) {
		g.drawString("This is in the dialog box", 10, 70);
	}
}

class MenuFrame extends Frame {
	private static final long serialVersionUID = 1L;
	String msg = "";
	CheckboxMenuItem debug, test;
	
	//constructor
	MenuFrame(String title){
		super(title);
			
		//creates menu bar and add it to frame
		MenuBar mbar = new MenuBar();
		setMenuBar(mbar);
	
		//creates the menu items
		Menu file = new Menu("File");
		MenuItem item1, item2, item3, item4, item5;
		file.add(item1 = new MenuItem("New..."));
		file.add(item2 = new MenuItem("Open..."));
		file.add(item3 = new MenuItem("Close"));
		file.add(item4 = new MenuItem("-"));
		file.add(item5 = new MenuItem("Quit..."));
		mbar.add(file);
		
		Menu edit = new Menu("Edit");
		MenuItem item6, item7, item8, item9;
		edit.add(item6 = new MenuItem("Cut"));
		edit.add(item7 = new MenuItem("Copy"));
		edit.add(item8 = new MenuItem("Paste"));
		edit.add(item9 = new MenuItem("-"));
		
		Menu sub = new Menu("Special", true);
		MenuItem item10, item11, item12;
		sub.add(item10 = new MenuItem("First"));
		sub.add(item11 = new MenuItem("Second"));
		sub.add(item12 = new MenuItem("Third"));
		edit.add(sub);
		
		//checkable menu items
		debug = new CheckboxMenuItem("Debug");
		edit.add(debug);
		test = new CheckboxMenuItem("Testing");
		edit.add(test);
		
		mbar.add(edit);

		//registers it to receive action listener events
		item1.addActionListener(new GetMenuHandler(this));
		item2.addActionListener(new GetMenuHandler(this));
		item3.addActionListener(new GetMenuHandler(this));
		item4.addActionListener(new GetMenuHandler(this));
		item5.addActionListener(new GetMenuHandler(this));
		item6.addActionListener(new GetMenuHandler(this));
		item7.addActionListener(new GetMenuHandler(this));
		item8.addActionListener(new GetMenuHandler(this));
		item9.addActionListener(new GetMenuHandler(this));
		item10.addActionListener(new GetMenuHandler(this));
		item11.addActionListener(new GetMenuHandler(this));
		item12.addActionListener(new GetMenuHandler(this));
		//item listener events
		debug.addItemListener(new GetMenuHandler(this));
		test.addItemListener(new GetMenuHandler(this));
		
		//registers it to receive those events
		addWindowListener(new GetWindowAdapter(this));
	}
	
	public void paint(Graphics g) {
		g.drawString(msg, 10, 190);
		
		if(debug.getState()) {
			g.drawString("Debug is on", 10, 200);
		}else {
			g.drawString("Debug is off", 10, 200);
		}
		
		if(test.getState()) {
			g.drawString("Testing is on", 10, 210);
		} else {
			g.drawString("Testing is off", 10, 210);
		}
	}
} //ends menuFrame
	
class GetWindowAdapter extends WindowAdapter{
	MenuFrame menuFrame;
	public GetWindowAdapter(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	public void windowClosing(WindowEvent wevt) {
		menuFrame.setVisible(false);
		menuFrame.dispose();
	}
}
	
class GetMenuHandler implements ActionListener, ItemListener {
	MenuFrame menuFrame;
	public GetMenuHandler(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}
	
	//handles action events
	public void actionPerformed(ActionEvent aevt) {
		String msg = "You selected: ";
		String arg = aevt.getActionCommand();
		GetDialog dialog = new GetDialog(menuFrame, "Dialog Box");
		
		if(arg.equals("New...")) {
			msg += "New.";
			dialog.setVisible(true);
		} else if(arg.equals("Open...")) {
			msg += "Open.";
			dialog.setVisible(true);
		} else if(arg.equals("Close")) {
			msg += "Close.";
			dialog.setVisible(true);
		} else if(arg.equals("Quit...")) {
			msg += "Quit.";
			dialog.setVisible(true);
		} else if(arg.equals("Edit")) {
			msg += "Edit.";
			dialog.setVisible(true);
		} else if(arg.equals("Cut")) {
			msg += "Cut.";
			dialog.setVisible(true);
		} else if(arg.equals("Copy")) {
			msg += "Copy.";
			dialog.setVisible(true);
		} else if(arg.equals("Paste")) {
			msg += "Paste.";
			dialog.setVisible(true);
		} else if(arg.equals("First")) {
			msg += "First.";
			dialog.setVisible(true);
		} else if(arg.equals("Second")) {
			msg += "Second.";
			dialog.setVisible(true);
		} else if(arg.equals("Third")) {
			msg += "Third.";
			dialog.setVisible(true);
		} else if(arg.equals("Debug")) {
			msg += "Debug.";
		} else if(arg.equals("Testing")) {
			msg += "Testing.";
		}
		
		menuFrame.msg = msg;
		menuFrame.repaint();						
	}
	
	//handles item events
	public void itemStateChanged(ItemEvent evti) {
		menuFrame.repaint();
	}
} //ends GetMenuHandler

