package gui.applets;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
 <applet code="KeyApplet" width=300 height=50></applet>
 */

/**
 * @author A., Didum
 * @date February 15, 2013
 * @decription KeyApplet(): concrete class KeyApplet
 * @notes Converting an application to an applet:
 * <p>1. Current class under construction must extend JApplet.</p>
 * <p>2. Delete the method main().</p>
 * <p>3. Eliminate any use of the setTitle method.</p>
 * <p>4. Replace the construtor, if any, by the method void init()</p>
 */
public class KeyApplet extends Applet implements KeyListener {
	
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = 1L;
	//instance vars
	private String msg = "";
	private int X = 10, Y = 20;	//coordinates
	
	/**
	 * init() - starts applet
	 */
	public void init() {
		addKeyListener(this); //use KeyAdapter to simply implementation of empty methods
		setSize(250, 150);
	}
	
	public void keyPressed(KeyEvent evtKey) {
		try {
			showStatus("Key Down");
			repaint();
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	public void keyReleased(KeyEvent evtKey) {
		try {
			showStatus("Key Up");
			repaint();
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	public void keyTyped(KeyEvent evtKey) {
		try {
			msg += evtKey.getKeyChar();
			repaint();
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	public void paint(Graphics graphics) {
		try {
			graphics.drawString("Select up/down arrow to see action", 10, 100);
			graphics.drawString(msg, X, Y);
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
}
