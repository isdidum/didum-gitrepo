package gui.applets.menu;

import java.awt.*;
import java.awt.event.*;

/**
 * @author A., Didum
 * @date February 22, 2013
 * @description FiledialogApp(): This is an application, not an applet.
 */
class FiledialogApp {
	/**FiledialogApp(): default constructor*/
	public FiledialogApp() {
		// no requirements
	}

	/**
	 * main(): mutator - application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		MyFrame frame = new MyFrame("File Dialog Client");
		frame.setVisible(true);
		frame.setSize(250,250);
		FileDialog filed = new FileDialog(frame, "File Dialog", FileDialog.LOAD);
		filed.setVisible(true);
		/*
		 * FileDialog.LOAD = the box is selecting a file for reading = default
		 * FileDialog.SAVE = the box is selecting a file for writing
		 */
	}
}

class MyFrame extends Frame{
	private static final long serialVersionUID = 1L;
	/**MyFrame(): specific constructor*/
	public MyFrame(String title) {
		super(title);
		
		//remove the window when closed
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}
	
	//or this
	/*class JWindowAdapter extends WindowAdapter{
		public JWindowAdapter() {
			//default constructor
		};
		public void windowClosing(WindowEvent evtWin) {
			System.exit(0);
		}
	}*/
	
}


