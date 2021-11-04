package gui.applets.buttons;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="JCheckBox" x=800 y=50 width=300 height=50></applet>
*/

/**
 * @author A., Didum
 * @date February 17, 2013
 * @decription JCheckBox(): concrete class applet JCheckBox
 */
public class JCheckBox extends Applet implements ItemListener{
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = 1L;
	private String msg = "";
	Checkbox winxp, winvista, solaris, mac, cbxlist[];
	public void init() {
		winxp = new Checkbox("Windows XP", null, true);
		winvista = new Checkbox("Windows Vista", null, false);
		solaris = new Checkbox("Solaris", null, false);
		mac = new Checkbox("Mac OS X", null, false);
		
		cbxlist = new Checkbox[4];
		//stores reference to button as added
		cbxlist[0] = (Checkbox) add(winxp);
		cbxlist[1] = (Checkbox) add(winvista);
		cbxlist[2] = (Checkbox) add(solaris);
		cbxlist[3] = (Checkbox) add(mac);
		
		for(int i=0; i<cbxlist.length; i++) {
			cbxlist[i].addItemListener(this);
		}
	}
	
	public void itemStateChanged(ItemEvent evtItem) {
		repaint();
	}
	
	//displays current state of the check boxes
	public void paint(Graphics gra) {
		msg = "Current state: ";
		gra.drawString(msg, 6, 80);
		
		/*int i=0;
		while(i<cbxlist.length) {
			msg += cbxlist[i].getLabel()+" "+cbxlist[i].getState();
			i++;
		}*/
		msg = cbxlist[0].getLabel()+"= "+cbxlist[0].getState();
		gra.drawString(msg, 6, 100);
		msg = cbxlist[1].getLabel()+"= "+cbxlist[1].getState();
		gra.drawString(msg, 6, 120);
		msg = cbxlist[2].getLabel()+"= "+cbxlist[2].getState();
		gra.drawString(msg, 6, 140);
		msg = cbxlist[3].getLabel()+"= "+cbxlist[3].getState();
		gra.drawString(msg, 6, 160);	
	}
}
