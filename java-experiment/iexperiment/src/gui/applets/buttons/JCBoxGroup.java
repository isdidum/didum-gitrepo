package gui.applets.buttons;

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="JCBoxGroup" x=800 y=50 width=300 height=50></applet>
*/

/**
 * @author A., Didum
 * @date February 17, 2013
 * @description JCheckBox(): concrete class applet JCheckBox
 */
public class JCBoxGroup extends Applet implements ItemListener{
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = 1L;
	private String msg = "";
	Checkbox winxp, winvista, solaris, mac, cbxlist[];
	CheckboxGroup cbxgroup;
	public void init() {
		cbxgroup = new CheckboxGroup();
		winxp = new Checkbox("Windows XP", cbxgroup, false);
		winvista = new Checkbox("Windows Vista", cbxgroup, false);
		solaris = new Checkbox("Solaris", cbxgroup, true);
		mac = new Checkbox("Mac OS X", cbxgroup, false);
		
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
		msg = "Current selection: ";
		msg += cbxgroup.getSelectedCheckbox().getLabel();
		gra.drawString(msg, 6, 100);
	}
}
