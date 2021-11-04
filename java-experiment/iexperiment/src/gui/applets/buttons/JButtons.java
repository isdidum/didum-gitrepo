package gui.applets.buttons;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/**
 * @author A., Didum
 * @date February 17, 2013
 * @decription JButtons(): concrete class applet JButtons
 */
public class JButtons extends Applet implements ActionListener{
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = 1L;
	private String msg = "";
	Button yes, no, maybe, btnlist[];
	
	public void init() {
		yes = new Button("Yes");
		no = new Button("No");
		maybe = new Button("Maybe");
		btnlist = new Button[3];
		
		//stores reference to button as added
		btnlist[0] = (Button) add(yes);
		btnlist[1] = (Button) add(no);
		btnlist[2] = (Button) add(maybe);
		
		//register to receive action events
		for(int i=0; i<btnlist.length; i++) {
			btnlist[i].addActionListener(this);
		}
	}
	
	public void actionPerformed(ActionEvent evtAction) {
		for(int i=0; i<btnlist.length; i++) {
			if(evtAction.getSource() == btnlist[i]) {
				msg = btnlist[i].getLabel() +" is pressed.";
			}
		}
		repaint();
	}
	
	public void paint(Graphics gra) {
		gra.drawString(msg, 6, 100);
	}

}
