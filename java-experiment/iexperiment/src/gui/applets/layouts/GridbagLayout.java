package gui.applets.layouts;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 * <applet code="GridbagLayout" width=300 height=100></applet>
 */

// FlowLayout(), BorderLayout(), GridLayout(), CardLayout(), GridBagLayout()
public class GridbagLayout extends Applet implements ItemListener{
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = 1L;
	String msg = "";
	Checkbox winxp, winvista, solaris, mac;
	
	Button btn;
	public void init() {
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gblimit = new GridBagConstraints();
		setLayout(gbag);
		setSize(250, 190);
		
		//these are components to be added to the container
		winxp = new Checkbox("Windows XP", null, false);
		winvista = new Checkbox("Windows Visita", null, true);
		solaris = new Checkbox("Solaris", null, false);
		mac = new Checkbox("Mac OS X", null, false);
		
		btn = new Button("Didum");
		btn.setBackground(new Color(202,50,75));
		btn.setFocusable(true);
		
		//define the grid bag with weight of 1 for first row
		gblimit.weightx = 1.0;	//use a column weight of 1
		gblimit.ipadx = 100;	// pad by 200 units in pixels
		gblimit.ipady = 1;
		gblimit.insets = new Insets(4, 4, 0, 0);	//insets slightly from top-left, namely, this is padding of component
		gblimit.anchor = GridBagConstraints.NORTHEAST;
		
		//places window xp in constraints
		gblimit.weighty = 0;
		gblimit.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(winxp, gblimit);
		
		gblimit.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(btn, gblimit);
		
		//places window vista in constraints
		gblimit.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(winvista, gblimit);
		
		//gives second row a weight of 1
		gblimit.weighty = 1.0;
		gblimit.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(solaris, gblimit);
		gblimit.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(mac, gblimit);
		
		//adds the component to applet in this order
		add(winxp);
		add(winvista);
		add(solaris);
		add(mac);
		add(btn);
		
		//registers to receive item events
		winxp.addItemListener(this);
		winvista.addItemListener(this);
		solaris.addItemListener(this);
		mac.addItemListener(this);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evta) {
				String ebtn = evta.getActionCommand();
				if(ebtn.equals(btn.getLabel())) {
					showStatus("You pressed button");
					btn.setBounds(new Rectangle(6,165,60,25));
				}
			}
		});
	}

	public void itemStateChanged(ItemEvent evtItem) {
		repaint();
	}
	
	public void paint(Graphics g) {
		msg = "Current state: ";
		g.drawString(msg, 6, 80);
		
		msg = winxp.getLabel()+" = "+winxp.getState();
		g.drawString(msg, 6, 100);
		msg = winvista.getLabel()+" = "+winvista.getState();
		g.drawString(msg, 6, 120);
		msg = solaris.getLabel()+" = "+solaris.getState();
		g.drawString(msg, 6, 140);
		msg = mac.getLabel()+" = "+mac.getState();
		g.drawString(msg, 6, 160);
	}

}
