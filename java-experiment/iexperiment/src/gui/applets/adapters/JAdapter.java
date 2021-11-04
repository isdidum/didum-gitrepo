package gui.applets.adapters;

import java.awt.event.*;
import java.applet.*;

/*
 <applet code="JAdapter" width=300 height=50></applet>
 */

/**
 * @author A., Didum
 * @date February 17, 2013
 * @description JAdapter(): concrete class JAdapter
 * @notes An adapter class provides an empty implementation of all methods in an event listener interface<br />
 * 	An adapter class allows you to receive & process only some of the envents that are handled by a particular event listener interface <br />
 *  To do, simply extend an event listener interface by going after the events of interest
 */

public class JAdapter extends Applet {
	
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = 1L;
	
	public void init() {
		addMouseListener(new JMouseAdapter(this));
		addMouseMotionListener(new JMouseMotionAdapter(this));
	}

	public class JMouseAdapter extends MouseAdapter {
		JAdapter jadapter;
		public JMouseAdapter(JAdapter jadapter) {
			this.jadapter = jadapter;
		}
	
		// Handles mouse clicked
		public void mouseClicked(MouseEvent evtMouse) {
			jadapter.showStatus("Mouse clicked");
		}
	}
	
	public class JMouseMotionAdapter extends MouseMotionAdapter {
		JAdapter jadapter;
		public JMouseMotionAdapter(JAdapter jadapter) {
			this.jadapter = jadapter;
		}
	
		// Handles mouse dragged
		public void mouseDragged(MouseEvent evtMouse) {
			jadapter.showStatus("Mouse dragged");
		}
	}
}
