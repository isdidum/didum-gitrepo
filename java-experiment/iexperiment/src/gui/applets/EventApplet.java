
package gui.applets;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
 *<object code="EventApplet" name="eApplet" align="center" vspace=800 hspace=50 width=150 height=20></object>
 */
/**
 * @author A., Didum
 * @date February 01, 2013
 * @decription EventApplet(): concrete class
 * @notes Converting an application to an applet:
 * <p>1. Current class under construction must extend JApplet.</p>
 * <p>2. Delete the method main().</p>
 * <p>3. Eliminate any use of the setTitle method.</p>
 * <p>4. Replace the construtor, if any, by the method void init()</p>
 * Example: methods called when an applet begins: init(), start(), paint()
 * Example: method called when an applet ends: stop(), destroy()
 */
public class EventApplet extends JApplet{
	/**serialVersionUID is required for EventApplet*/
	private static final long serialVersionUID = -4716152911105201172L;
	/**or this*/
	//private static final long serialVersionUID = 1L;
	JButton btnAlpha, btnBeta;
	JLabel txtTag;
	
	/**
	 * EventApplet(): default constructor replaced by void init() <br />
	 * initialize the applet
	 */
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI(); 	// initialize the GUI		
				}
			});
		} catch (Exception err) {
			//err.printStackTrace();
			System.out.println("Can\'t create because of "+ err);
		}
	}
	
	//this applet does not need to override start(), stop(), or destroy()
	
	/**
	 * makeGUI(): mutator - sets up and initialize the GUI
	 */
	public void makeGUI() {
		setSize(255, 150);
		new Insets(5,5,0,0);
		//setBounds(800, 50, 275, 250);
		
		// set the applet to use flow layout
		setLayout(new FlowLayout(5,5,FlowLayout.LEFT));
		txtTag = new JLabel("Press a button");
		
		// make two buttons
		btnAlpha = new JButton("Alpha");
		btnBeta = new JButton("Beta");
		
		//add action listener for alpha
		btnAlpha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtAction) {
				txtTag.setText("You pressed Alpha.");
			}
		});
		
		//add action listener for beta
		btnBeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtAction) {
				txtTag.setText("You pressed Beta.");
			}
		});
		
		//add the buttons to the content pane
		add(btnAlpha,-1);
		add(btnBeta,-1);
		add(txtTag,-1);
	}
}
