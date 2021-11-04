package gui.swingapps.applets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import callable.io.Print;

/*
 * <applet code="JCheckbox" width=300 height=100></applet>
 */
/**
 * @author A., Didum
 * @date February 19, 2013
 * @description JCheckbox(): concrete class for JCheckBox
 */
public class JCheckbox extends JApplet implements ItemListener{
	//instance var
	JLabel jlab;
	JCheckBox cbx;
	Print view;
	String msg = "";
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
		jlab = new JLabel("Select languages");
		
		//adds check boxes to the content pane
		cbx = new JCheckBox("AS3");
		cbx.addItemListener(this); add(cbx);
		
		cbx = new JCheckBox("C");
		cbx.addItemListener(this); add(cbx);
		
		cbx = new JCheckBox("Java");
		cbx.addItemListener(this); add(cbx);
		
		cbx = new JCheckBox("JS");
		cbx.addItemListener(this); add(cbx);
		
		cbx = new JCheckBox("C++");
		cbx.addItemListener(this); add(cbx);
		
		//add the toggle button and label to content pane
		add(jlab);
	}

	@Override
	//register to receive item events listener
	public void itemStateChanged(ItemEvent evtItem) {
		JCheckBox cbx = (JCheckBox) evtItem.getItem();
		
		if(cbx.isSelected()) {
			msg = cbx.getText();
			jlab.setText(cbx.getText() +" is selected");
		} else {
			msg = "Cleared";
			jlab.setText(cbx.getText() +" is cleared");
		}
		//shows text when user presses enter
		showStatus("Selected: "+msg);
	}

}

