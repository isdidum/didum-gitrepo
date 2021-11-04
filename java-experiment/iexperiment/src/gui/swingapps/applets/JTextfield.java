package gui.swingapps.applets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import callable.io.Print;

/*
 * <applet code="JTextfield" width=300 height=100></applet>
 */
/**
 * @author A., Didum
 * @date February 19, 2013
 * @description JTextfield(): concrete class for JTextField
 */
public class JTextfield extends JApplet{
	//instance var
	JTextField jtf;
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
		
		//adds text field to content pane
		jtf = new JTextField(15);
		add(jtf);
		
		//register to receive action events listener
		jtf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtA) {
				//shows text when user presses enter
				showStatus(jtf.getText());
			}
		});
	}

}
