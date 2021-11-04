package gui.applets;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
 <applet code="MouseEventApplet" width=300 height=10></applet>
 */

/**
 * @author A., Didum
 * @date February 15, 2013
 * @description MouseEventApplet(): concrete class MouseEventApplet
 * @notes Converting an application to an applet:
 * <p>1. Current class under construction must extend JApplet.</p>
 * <p>2. Delete the method main().</p>
 * <p>3. Eliminate any use of the setTitle method.</p>
 * <p>4. Replace the construtor, if any, by the method void init()</p>
 */
public class MouseEventApplet  extends Applet implements MouseListener, MouseMotionListener {
	
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = 1L;
	//instance vars
	String msg = "";
	int mouseX = 0, mouseY = 0;	//mouse coordinates
	
	/**
	 * MouseEventApplet() = init()
	 */
	public void init() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}
	
	/**
	 * mouseClicked(): mutator - handles mouse clicked
	 */
	public void mouseClicked(MouseEvent evtMouse) {
		try {
			mouseX = 0;
			mouseY = 10;
			msg = "Mouse clicked.";
			repaint();
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * mouseEntered(): mutator - handles mouse entered
	 */
	public void mouseEntered(MouseEvent evtMouse) {
		try {
			mouseX = 0;
			mouseY = 10;
			msg = "Mouse entered.";
			repaint();
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * mouseExited(): mutator - handles mouse exited
	 */
	public void mouseExited(MouseEvent evtMouse) {
		try {
			mouseX = 0;
			mouseY = 10;
			msg = "Mouse exited.";
			repaint();
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * mousePressed(): mutator - handles button pressed
	 */
	public void mousePressed(MouseEvent evtMouse) {
		try {
			mouseX = evtMouse.getX();
			mouseY = evtMouse.getY();
			msg = "Mouse Down";
			repaint();
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * mouseReleased(): mutator - handles button released
	 */
	public void mouseReleased(MouseEvent evtMouse) {
		try {
			mouseX = evtMouse.getX();
			mouseY = evtMouse.getY();
			msg = "Mouse Up";
			repaint();
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * mouseDragged(): mutator - handles mouse dragged
	 */
	public void mouseDragged(MouseEvent evtMouse) {
		try {
			mouseX = evtMouse.getX();
			mouseY = evtMouse.getY();
			msg = "Mouse Dragged";
			showStatus("Dragging mouse at "+mouseX+", "+mouseY);
			repaint();
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * mouseMoved(): mutator - handles mouse move
	 */
	public void mouseMoved(MouseEvent evtMouse) {
		try {
			showStatus("Moving mouse at "+evtMouse.getX()+", "+evtMouse.getY());
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * paint(): mutator - displays msg in applet window at current x,y location
	 */
	public void paint(Graphics graphics) {
		try {
			graphics.drawString(msg, mouseX, mouseY);
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
}
