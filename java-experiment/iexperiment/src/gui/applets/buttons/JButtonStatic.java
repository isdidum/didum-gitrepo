package gui.applets.buttons;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
 * @author A., Didum
 * @date February 17, 2013
 * @description JButtonStatic(): concrete class applet JButtonStatic
 */
public class JButtonStatic extends Applet implements ActionListener{
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = 1L;
	private String msg = "";
	Button yes, no, maybe, btnlist[];
	
	public void init() {
		yes = new Button("Yes");
		no = new Button("No");
		maybe = new Button("Maybe");
		
		//add button to applet
		add(yes);
		add(no);
		add(maybe);
		
		//register to receive action events
		yes.addActionListener(this);
		no.addActionListener(this);
		maybe.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent evtAction) {
		String str = evtAction.getActionCommand();
		if(str.equals(yes.getLabel())) {
			msg = "You pressed " + yes.getLabel() + ".";
		} else if(str.equals(no.getLabel())) {
			msg = "You pressed " + no.getLabel() + ".";
		} else {
			msg = "You pressed " + maybe.getLabel() + ".";
		}
		repaint();
	}
	
	public void paint(Graphics gra) {
		gra.drawString(msg, 6, 100);
	}

}
