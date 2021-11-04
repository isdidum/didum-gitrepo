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
 * @decription JListOption(): concrete class applet JListOption
 */
public class JListOption extends Applet implements ItemListener {
	//instance var
	private String msg = "";
	private Choice os, browser;
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = 1L;
	
	public void init() {
		os = new Choice();
		browser = new Choice();
		
		//add items to os list
		os.add("Windows XP");
		os.add("Windows Vista");
		os.add("Solaris");
		os.add("Mac OS X");
		
		//add items to browser list
		browser.add("Internet Explorer");
		browser.add("Mozzila Firefox");
		browser.add("Google Chrome");
		browser.add("Opera");
		browser.add("Safari");
		
		//add choice to list window
		add(os);
		add(browser);
		
		//register to receive item events
		os.addItemListener(this);
		browser.addItemListener(this);
	}
	
	public void itemStateChanged(ItemEvent evtItem) {
		repaint();
	}
	
	//displays current selections
	public void paint(Graphics g) {
		msg = "Current OS: ";
		msg += os.getSelectedItem();
		g.drawString(msg, 6, 120);
		
		msg =  "Current Browser: ";
		msg += browser.getSelectedItem();
		g.drawString(msg, 6, 140);
	}
}
