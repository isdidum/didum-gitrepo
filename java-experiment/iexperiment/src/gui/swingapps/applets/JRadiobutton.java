package gui.swingapps.applets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import callable.io.Print;

/*
 * <applet code="JRadiobutton" width=300 height=100></applet>
 */
/**
 * @author A., Didum
 * @date February 19, 2013
 * @description JRadiobutton(): concrete class for JRadioButton
 */
public class JRadiobutton extends JApplet implements ActionListener{
	//instance var
	JLabel jlab;
	JRadioButton rbtn1, rbtn2, rbtn3, rbtn4;
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
		setSize(250, 90);
		setBackground(new Color(112,108,205));
		
		//creates label to content pane
		jlab = new JLabel("Select a language", JLabel.LEADING);
		
		//adds check boxes to the content pane
		rbtn1 = new JRadioButton("AS3");
		rbtn1.addActionListener(this); add(rbtn1);
		
		rbtn2 = new JRadioButton("Java");
		rbtn2.addActionListener(this); add(rbtn2);
		
		rbtn3 = new JRadioButton("C++");
		rbtn3.addActionListener(this); add(rbtn3);
		
		rbtn4 = new JRadioButton("JS");
		rbtn4.addActionListener(this); add(rbtn4);
		
		//define a button group
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbtn1); bg.add(rbtn2); bg.add(rbtn3); bg.add(rbtn4);
		
		//add the toggle button and label to content pane
		add(jlab);
	}

	@Override
	//register to receive item events listener
	public void actionPerformed(ActionEvent evtAction) {
		msg = evtAction.getActionCommand() + " is selected.";
		jlab.setText(msg);
		//shows text when user presses enter
		showStatus("Selected: "+evtAction.getActionCommand());
	}

}

