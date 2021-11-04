package gui.applets;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.URL;

/*
*<applet code="TitleApplet" width=300 height=100>
*/
/**
 * @author A., Didum
 * @description TitleApplet() - concrete class TitleApplet
 * @date Feb 18, 2013
 */

public class TitleApplet extends Applet{
	//instance var
	private static final long serialVersionUID = 1L;
	GFrame frame;
	URL url, doc;
	
	public void init() {
		url = getCodeBase();
		doc = getDocumentBase();
		
		//frame = new GFrame(); //default c
		frame = new GFrame("A Frame Window");
		frame.setSize(250, 250);
		frame.setVisible(true);
	}
	
	public void start() {
		frame.setVisible(true);
	}
	
	public void stop() {
		frame.setVisible(false);
	}
	
	public void paint(Graphics g) {
		g.drawString("This is in applet window", 10, 20);
		g.drawString(url.toString(), 10, 40);
		g.drawString(doc.toString(), 10, 50);
	}
	
	/**
	 * @author A., Didum
	 * @description GFrame(): inner class that extends Frame
	 */
	class GFrame extends Frame {
		String msg;
		int x, y;
		JWindow jWindowAdapter;
		private static final long serialVersionUID = 1L;
		
		//default constructor
		public GFrame() {
			this("Frame Window: Didum", 10, 40, "C-1: You are in a frame window");	//chaining constructors
			
			jWindowAdapter = new JWindow(this);
			addWindowListener(jWindowAdapter);
		}
		
		//specific constructor
		public GFrame(String title) {
			this(title, 10, 40, "C-2: This is a frame window");	//chaining constructors
			
			//object to handle window events
			jWindowAdapter = new JWindow(this);
			
			//register to receive events
			addWindowListener(jWindowAdapter);
		}
		
		//specific constructor
		public GFrame(String title, int x, int y, String msg) {
			super(title);
			this.x = x;
			this.y = y;
			this.msg = msg;
			
			jWindowAdapter = new JWindow(this);
			addWindowListener(jWindowAdapter);
		}
		
		/**
		 * @description paint(): mutator - displays events to frame window
		 */
		public void paint(Graphics gra) { //range:x=10,y=40
			gra.drawString(msg, x, y);
		}
	}
	
	/**
	 * @author A., Didum
	 * JWindow(): adapter class that extends WindowAdapter
	 */
	class JWindow extends WindowAdapter {
		GFrame gframe;
		public JWindow(GFrame gframe) {
			this.gframe = gframe;
		}
		
		public void windowClosing(WindowEvent evtWindow) {
			gframe.setVisible(false);
		}
	}

}
