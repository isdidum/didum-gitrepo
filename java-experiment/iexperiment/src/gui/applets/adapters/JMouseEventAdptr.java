package gui.applets.adapters;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;


/* <title>Didum Applet</title>
 * <applet code="MouseEventApplet" width=300 height=10></applet>
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
public class JMouseEventAdptr  extends Applet /*implements MouseListener, MouseMotionListener*/ {
	
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = 1L;
	//instance vars
	String msg = "";
	int mouseX = 0, mouseY = 0;	//mouse coordinates
		
	/**
	 * MouseEventApplet() = init()
	 */
	public void init() {
		
		addMouseListener(new JMouseClickedAdapter(this));
		addMouseListener(new JMouseEnteredAdapter(this));
		addMouseListener(new JMouseExitedAdapter(this));
		addMouseListener(new JMousePressedAdapter(this));
		addMouseListener(new JMouseReleasedAdapter(this));
		
		addMouseMotionListener(new JMouseDraggedAdapter(this));
		addMouseMotionListener(new JMouseMovedAdapter(this));
	}
	
	
	public class JMouseClickedAdapter extends MouseAdapter{
		//instance var
		private JMouseEventAdptr jMouseEvtAdptr;
		public JMouseClickedAdapter(JMouseEventAdptr jMouseEvtAdptr) {
			this.jMouseEvtAdptr = jMouseEvtAdptr;
		}
		
		/**
		 * mouseClicked(): mutator - handles mouse clicked
		 */
		public void mouseClicked(MouseEvent evtMouse) {
			try {
				mouseX = 0;
				mouseY = 10;
				msg = "Mouse clicked.";
				jMouseEvtAdptr.repaint();
			} catch(Exception err) {
				err.printStackTrace();
			}
		}
	}
	
	public class JMouseEnteredAdapter extends MouseAdapter{
		//instance var
		private JMouseEventAdptr jMouseEvtAdptr;
		public JMouseEnteredAdapter(JMouseEventAdptr jMouseEvtAdptr) {
			this.jMouseEvtAdptr = jMouseEvtAdptr;
		}
		
		/**
		 * mouseEntered(): mutator - handles mouse entered
		 */
		public void mouseEntered(MouseEvent evtMouse) {
			try {
				mouseX = 0;
				mouseY = 10;
				msg = "Mouse entered.";
				jMouseEvtAdptr.repaint();
			} catch(Exception err) {
				err.printStackTrace();
			}
		}
	}
	
	
	public class JMouseExitedAdapter extends MouseAdapter{
		//instance var
		private JMouseEventAdptr jMouseEvtAdptr;
		public JMouseExitedAdapter(JMouseEventAdptr jMouseEvtAdptr) {
			this.jMouseEvtAdptr = jMouseEvtAdptr;
		}
		
		/**
		 * mouseExited(): mutator - handles mouse exited
		 */
		public void mouseExited(MouseEvent evtMouse) {
			try {
				mouseX = 0;
				mouseY = 10;
				msg = "Mouse exited.";
				jMouseEvtAdptr.repaint();
			} catch(Exception err) {
				err.printStackTrace();
			}
		}
	}
	
	public class JMousePressedAdapter extends MouseAdapter{
		//instance var
		private JMouseEventAdptr jMouseEvtAdptr;
		public JMousePressedAdapter(JMouseEventAdptr jMouseEvtAdptr) {
			this.jMouseEvtAdptr = jMouseEvtAdptr;
		}
		
		/**
		 * mousePressed(): mutator - handles button pressed
		 */
		public void mousePressed(MouseEvent evtMouse) {
			try {
				mouseX = evtMouse.getX();
				mouseY = evtMouse.getY();
				msg = "Mouse Down";
				jMouseEvtAdptr.repaint();
			} catch(Exception err) {
				err.printStackTrace();
			}
		}
	}
	
	
	public class JMouseReleasedAdapter extends MouseAdapter{
		//instance var
		private JMouseEventAdptr jMouseEvtAdptr;
		public JMouseReleasedAdapter(JMouseEventAdptr jMouseEvtAdptr) {
			this.jMouseEvtAdptr = jMouseEvtAdptr;
		}
		
		/**
		 * mouseReleased(): mutator - handles button released
		 */
		public void mouseReleased(MouseEvent evtMouse) {
			try {
				mouseX = evtMouse.getX();
				mouseY = evtMouse.getY();
				msg = "Mouse Up";
				jMouseEvtAdptr.repaint();
			} catch(Exception err) {
				err.printStackTrace();
			}
		}
	}
	
	public class JMouseDraggedAdapter extends MouseMotionAdapter{
		//instance var
		private JMouseEventAdptr jMouseEvtAdptr;
		public JMouseDraggedAdapter(JMouseEventAdptr jMouseEvtAdptr) {
			this.jMouseEvtAdptr = jMouseEvtAdptr;
		}
		
		/**
		 * mouseDragged(): mutator - handles mouse dragged
		 */
		public void mouseDragged(MouseEvent evtMouse) {
			try {
				mouseX = evtMouse.getX();
				mouseY = evtMouse.getY();
				msg = "Mouse Dragged";
				jMouseEvtAdptr.showStatus("Dragging mouse at "+mouseX+", "+mouseY);
				jMouseEvtAdptr.repaint();
			} catch(Exception err) {
				err.printStackTrace();
			}
		}
	}
	
	public class JMouseMovedAdapter extends MouseMotionAdapter{
		//instance var
		private JMouseEventAdptr jMouseEvtAdptr;
		public JMouseMovedAdapter(JMouseEventAdptr jMouseEvtAdptr) {
			this.jMouseEvtAdptr = jMouseEvtAdptr;
		}
		
		/**
		 * mouseMoved(): mutator - handles mouse move
		 */
		public void mouseMoved(MouseEvent evtMouse) {
			try {
				jMouseEvtAdptr.showStatus("Moving mouse at "+evtMouse.getX()+", "+evtMouse.getY());
			} catch(Exception err) {
				err.printStackTrace();
			}
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
