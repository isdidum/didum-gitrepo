package gui.swingapps.applets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import callable.io.Print;

/*
 * <applet code="JTogglebutton" width=300 height=100></applet>
 */
/**
 * @author A., Didum
 * @date February 19, 2013
 * @description JTogglebutton(): concrete class for JTextButton
 */
public class JTogglebutton extends JApplet {
	//instance var
	JLabel jlab;
	JToggleButton jbtn;
	Print view;
	private static final long serialVersionUID = 1L;
	
	public void init() {
		try {
			view = new Print();
			
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
				}
			});
		} catch (Exception err) {
			view.println("Can't create because of "+err);
			err.printStackTrace();
		}
	}

	private void makeGUI() {
		//set flow layout
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setSize(200, 90);
		setBackground(new Color(112,108,205));
		
		//creates label to content pane
		jlab = new JLabel("Button state: off");
		
		//make a toggle button
		jbtn = new JToggleButton("Off/On");
		
		//register to receive item events listener
		jbtn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent evtI) {
				String str = jbtn.getText();
				if(jbtn.isSelected()) {
					String on = str.substring(str.indexOf("On", 0), str.length());
					jlab.setText("Button state: "+ on);
				} else {
					String off = str.substring(str.indexOf("Off", 0), str.indexOf("/", 0));
					jlab.setText("Button state: "+ off);
				}
				//shows text when user presses enter
				showStatus("Button is pressed");
			}
		});
		
		//add the toggle button and label to content pane
		add(jbtn);
		add(jlab);
	}

}
