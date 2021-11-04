package gui.swingapps;

import java.awt.*;
import java.awt.event.*;
//import java.applet.*;
import javax.swing.*;

/**
 * @author A., Didum
 * @description AppFrame: concrete class that extends Frame
 * @date February 18, 2013
 */
public class AppFrame extends Frame {
	private static final long serialVersionUID = 1L;
	String msg, mmsg;
	int mx, my;
	static Color color = new Color(123,130,255);
	
	/**
	 * AppFrame(): default constructor
	 */
	public AppFrame(String title) {
		super(title);
		msg = "Click inside container to pin mouse";
		mmsg = "";
		mx = my = 30;
		addKeyListener(new JKeyAdapter(this));
		addMouseListener(new JMouseAdapter(this));
		addWindowListener(new JWindowAdapter());
		//setSize(250,250);
	}
	
	public void paint(Graphics g) {
		g.drawString(msg, 10, 40);
		g.drawString(mmsg, mx, my);
	}
	
	/**
	 * main(): mutator - application entry point
	 * @param args
	 */
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//new AppFrame("AWT-Based Application");
				AppFrame appwin = new AppFrame("Window Application");
				appwin.setVisible(true);
				appwin.setSize(250, 250);
				appwin.setBounds(800, 50, 250, 250);
				appwin.setResizable(false);
				appwin.setBackground(color);
				appwin.setEnabled(true);
				
			}
		});
	}
	
	/**
	 * @author A., Didum
	 * JKeyAdapter(): inner class that KeyAdapter
	 */
	class JKeyAdapter extends KeyAdapter{
		AppFrame appwin;
		
		 /** JKeyAdapter(): specific constructor*/
		public JKeyAdapter(AppFrame appwin) {
			this.appwin = appwin;
		}
		
		public void keyType(KeyEvent evtKey) {
			appwin.mmsg += evtKey.getKeyChar();
			appwin.repaint();
		}
	}
	
	/**
	 * @author A., Didum
	 * JMouseAdapter(): inner class that MouseAdapter
	 */
	class JMouseAdapter extends MouseAdapter{
		AppFrame appwin;
		
		 /** JMouseAdapter(): specific constructor*/
		public JMouseAdapter(AppFrame appwin) {
			this.appwin = appwin;
		}
		
		public void mousePressed(MouseEvent evtMouse) {
			appwin.mx = evtMouse.getX();
			appwin.my = evtMouse.getY();
			appwin.mmsg = "Mouse Down at "+appwin.mx+", "+appwin.my;
			appwin.repaint();
		}
	}
	
	/**
	 * @author A., Didum
	 * JWindowAdapter(): inner class that WindowAdapter
	 */
	class JWindowAdapter extends WindowAdapter{
		 /** JWindowAdapter(): default constructor*/
		public JWindowAdapter() {
			//default constructor
		};
		public void windowClosing(WindowEvent evtWin) {
			System.exit(0);
		}
	}

}
