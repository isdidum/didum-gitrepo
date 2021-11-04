package gui.swingapps.applets;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.tree.*;
//import javax.swing.table.*;


import callable.io.Print;

/*
 * <applet code="JTabbedpane" width=300 height=100></applet>
 */
/**
 * @author A., Didum
 * @date February 19, 2013
 * @description JTabbedpane(): concrete class for JTabbedPane
 * @notes usage of Outer & Inner classes
 * <p>1. an Inner class has access to all variables and methods defined in outer class, <br />
 * 	but the reverse is not true</p>
 * <p>2. an Inner class is not visible outside of an outer class</p>
 * <p>3. an Inner class can be accessed by programs in other packages via Outer.Inner</p>
 * <p>4. anonymouse Inner & adapter classes allow you to implement a particular method from an <br />
 * 	abstract class and not all methods defined in a superclass</p>
 */
public class JTabbedpane extends JApplet {
	//instance var
	Print view;
	String msg = "";
	static final int WINX = 600;
	static final int WINY = 250;
	private static final long serialVersionUID = 1L;
	
	public void init() {
		try {
			view = new Print();
			
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
					
					new SoccerPanel();
					new ContinentsPanel();
					new ColorsPanel();
					new JTreePanel();
					new JTablePanel();
					
					//SoccerPanel soccer = new SoccerPanel(); this works
					//soccer.constructGUI();
				}
			});
		} catch (Exception err) {
			view.println("Can't create because of "+err);
			err.printStackTrace();
		}
	}
	
	/**
	 * makeGUI(): mutator - makes the gui
	 */
	private void makeGUI() {
		//set flow layout
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setSize(WINX, WINY);
		setBackground(new Color(10,220,130));
		setMaximumSize(new Dimension(WINX, WINY));
		
		//creates each tabbed pane with its class
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Cities", new CitiesPanel());
		jtp.addTab("Colors", new ColorsPanel());
		jtp.addTab("Continents", new ContinentsPanel());
		jtp.addTab("TeamSoccer", new SoccerPanel());
		jtp.addTab("JavaTree", new JTreePanel());
		jtp.addTab("JavaTable", new JTablePanel());
		add(jtp);
		
		//sets preferred dimension of the table within the container
		jtp.setPreferredSize(new Dimension(WINX-100,WINY-20));
	}

	/**
	 * CitiesPanel(): anonymous inner class
	 */
	class CitiesPanel extends JPanel{
		//instance var
		private static final long  serialVersionUID = 1L;
		
		/**CitiesPanel(): default constructor*/
		public CitiesPanel() {
			JButton b1 = new JButton("Lagos");
			add(b1);
			JButton b2 = new JButton("London");
			add(b2);
			JButton b3 = new JButton("Las Vegas");
			add(b3);
			JButton b4 = new JButton("Hawaii");
			add(b4);
			JButton b5 = new JButton("Beljing");
			add(b5);
		}
	}
	
	/**
	 * ColorsPanel(): anonymous inner class
	 */
	class ColorsPanel extends JPanel implements ItemListener{
		//instance var
		JCheckBox b1, b2, b3, b4, b5, b6;
		
		private static final long  serialVersionUID = 1L;
		
		/**ColorsPanel(): default constructor*/
		public ColorsPanel() {
			//creates check boxes
			b1 = new JCheckBox("Red");
			b2 = new JCheckBox("Blue");
			b3 = new JCheckBox("Cyan");			
			b4 = new JCheckBox("Magenta");
			b5 = new JCheckBox("Brown");
			b6 = new JCheckBox("Purple");
			
			//adds components to container
			add(b1); add(b2); add(b3); add(b4); add(b5); add(b6);
			
			//registers to receive events item listener
			b1.addItemListener(this); b2.addItemListener(this);	b3.addItemListener(this); 
			b4.addItemListener(this); b5.addItemListener(this); b6.addItemListener(this);
		}
		
		public void itemStateChanged(ItemEvent evtItem) {			
			JCheckBox str = (JCheckBox)evtItem.getItem();
			msg = str.getText();
			
			if(str.isSelected() == true) {
				showStatus("Currently checked: "+ msg);
			}else if(str.isSelected() == true) {
				showStatus("Currently checked: "+ msg);
			}else if(str.isSelected() == true) {
				showStatus("Currently checked: "+ msg);
			}else if(str.isSelected() == true) {
				showStatus("Currently checked: "+ msg);
			}else if(str.isSelected() == true) {
				showStatus("Currently checked: "+ msg);
			}else if(str.isSelected() == true) {
				showStatus("Currently checked: "+ msg);
			} else {
				showStatus("Currently unchecked: "+ msg);
			}
		}
		
	}
	
	/**
	 * ContinentsPanel(): anonymous inner class
	 */
	class ContinentsPanel extends JPanel{
		//instance var
		private static final long  serialVersionUID = 1L;
		JComboBox jcb;
		JLabel jlab;
		
		/**ContinentsPanel(): default constructor*/
		public ContinentsPanel() {
			jcb = new JComboBox();
			jlab = new JLabel("Choose one");
			setLayout(new FlowLayout());
			constructRegions();
		}
		
		private void constructRegions() {	
			jcb.addItem("Africa");
			jcb.addItem("South America");
			jcb.addItem("North America");
			jcb.addItem("Europe");
			jcb.addItem("Asia");
			jcb.addItem("Antarctica");
			jcb.addItem("Australia");
			add(jcb);
			
			jcb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evtAction) {
					String str = (String) jcb.getSelectedItem();
					jlab.setText("Choose one: "+str);
					showStatus("Continent selection: "+str);
				}
			});
			
			add(jlab);
		}
	}
	
	/**
	 * SoccerPanel(): anonymous inner class
	 */
	class SoccerPanel extends JPanel{
		//instance var
		private static final long  serialVersionUID = 1L;
		//array constants
		String teams[] = {"Brazil", "Spain", "Naija", "France", "Germany", "Italy", "Japan", "Mexico", "Argentina"};
		JList jlist;
		JLabel jlab;
		JScrollPane jscr;
		
		/**SoccerPanel(): default constructor*/
		public SoccerPanel() {
			//creates a list
			jlist = new JList(teams);
			constructGUI();
		}
		
		private void constructGUI() {
			//sets the list selection mode to single selection
			jlist.setSelectedIndex(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			
			//adds the list to a scroll pane
			jscr = new JScrollPane(jlist);
			
			//sets the preferred size of the scroll pane
			jscr.setPreferredSize(new Dimension(120, 90));
			
			//makes a label that displays the selection
			jlab = new JLabel("Choose a country", JLabel.CENTER);
			
			//adds selection listener for the list
			jlist.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent evtList) {
					//get the index of the changed item
					int idx = jlist.getSelectedIndex();
					
					//displays selection, if item was selected
					if(idx != -1) {
						jlab.setText("Current selection: "+ teams[idx]);
					} else {
						jlab.setText("Choose a country");
					}
					showStatus("Country selection: "+ teams[idx]);
				}
			});
			
			//adds the list and label to the content pane
			add(jscr);
			add(jlab);
		}
	}
	
	/**
	 * JTreePanel(): anonymous inner class
	 */
	class JTreePanel extends JPanel{
		//instance var
		JTree tree;
		JLabel jlab;
		private static final long  serialVersionUID = 1L;
		
		DefaultMutableTreeNode top, a, a1, a2, a3, a4, b, b1, b2, b3;
		
		/**JTreePanel(): default constructor*/
		public JTreePanel() {
			setSize(200,50);
			//creates tree's top node
			top = new DefaultMutableTreeNode("Toptier");
			
			//creates subtree
			a = new DefaultMutableTreeNode("Tier 1/1");
			top.add(a);
			a1 = new DefaultMutableTreeNode("Tier 1/2");
			a.add(a1);
			a2 = new DefaultMutableTreeNode("Tier 1/3");
			a.add(a2);
			//creates sub-subtree
			a3 = new DefaultMutableTreeNode("Tier 1/3 - 1");
			a2.add(a3);
			a4 = new DefaultMutableTreeNode("Tier 1/3 - 2");
			a2.add(a4);
			//creates subtree
			b = new DefaultMutableTreeNode("Tier 2/1");
			top.add(b);
			b1 = new DefaultMutableTreeNode("Tier 2/2");
			b.add(b1);
			b2 = new DefaultMutableTreeNode("Tier 2/3");
			b.add(b2);
			b3 = new DefaultMutableTreeNode("Tier 2/3");
			b.add(b3);
			
			seedTree();
		}
	
		private void seedTree() {
			//creates the tree
			tree = new JTree(top);
			tree.setPreferredSize(new Dimension(WINX-400,50));
			new Insets(4,4,4,4);
			
			//adds the tree to a scroll pane
			JScrollPane jsp = new JScrollPane(tree);
			add(jsp);
			
			//adds the scroll pane to the content pane
			jlab = new JLabel();
			add(jlab, BorderLayout.SOUTH);
			
			//handles tree selection events
			tree.addTreeSelectionListener(new TreeSelectionListener() {
				public void valueChanged(TreeSelectionEvent tse) {
					//jlab.setText("Selection: "+tse.getPath());
					showStatus("Selection: "+tse.getPath());
				}
			});
		}
	}
	
	/**
	 * JTablePanel(): anonymous inner class
	 */
	class JTablePanel extends JPanel{
		//instance var
		JTable table;
		//JLabel jlab;
		private static final long  serialVersionUID = 1L;
				
		/**JTablePanel(): default constructor*/
		public JTablePanel() {
			makeTableGUI();
		}
	
		private void makeTableGUI() {
			//initializes column headings
			String colHeads[] = {"Name", "Phone", "ID#"};
			
			//initialize table object
			Object data[][] = {
				{"Ken Green", "223-345-5545", "454"},
				{"John Warning", "515-325-2345", "135"},
				{"No Body", "223-346-5945", "154"},
				{"Adidum Bar", "121-045-0545", "424"},
				{"Ledum Noble", "212-345-5545", "432"},
				{"Tuka Ade", "203-345-5540", "445"},
				{"Brady Tompson", "223-221-5545", "554"},
				{"Asland Grady", "618-345-5145", "816"},
				{"Ellen Marko", "816-331-5045", "408"}
			};	
		
			//creates the table
			table = new JTable(data, colHeads);

			//sets the table selection mode to single selection
			table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			
			//sets column and row selection as a single selected cell unit
			table.setCellSelectionEnabled(true);
						
			//adds selection listener for the list
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent evtlist) {
					//Object obj = (Object)evtlist.getSource();				
					int rows[] = table.getSelectedRows();
					int cols[] = table.getSelectedColumns();
					
					for(int i=0; i<rows.length; i++) {
						for(int j=0; j<cols.length; j++) {
							msg = (String)table.getValueAt(rows[i], cols[j]);
							if(rows[i] > -1 && cols[j] > -1) {
								repaint();
								showStatus("Selection: "+msg);
							}
						}
					}
				}
			});
			
			//adds the table to a scroll pane
			JScrollPane jsp = new JScrollPane(table);
			//adds the scroll pane to the content pane
			add(jsp);		
		}	
	}
	
	
}

