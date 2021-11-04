package gui.swingapps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author A., Didum
 * @date February 01, 2013
 * @decription EventGui(): concrete class
 */
public class EventGui {
	// class constant variables
	private static final int XPOS = 800;
	private static final int YPOS = 50;
	private static final int WINW = 230;
	private static final int WINH = 150;
	private static final int TXTW = 17;
	private static FlowLayout LAYOUT = new FlowLayout();
	private static String legend = "This program indicates event invoked by the user";
	private static final String LEGEND = legend;	
	
	// class instance variables
	JFrame window;
	JLabel txtTag;
	JButton btnAlpha, btnBeta;
	private JTextArea legendArea = new JTextArea(LEGEND, 2, TXTW);
	/**
	 * EventGui() - default constructor
	 */
	public EventGui() {
		txtTag = new JLabel("Press a button");
		
		window = new JFrame();
		window.setLayout(LAYOUT);
		window.setSize(WINW, WINH);
		window.setBounds(XPOS, YPOS, WINW, WINH);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		legendArea.setEditable(false);
		legendArea.setLineWrap(true);
		legendArea.setWrapStyleWord(true);
		legendArea.setBackground(window.getBackground());
		
		//make buttons
		btnAlpha = new JButton("Alpha");
		btnBeta = new JButton("Beta");
		
		//add action listener for alpha
		btnAlpha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtAction) {
				txtTag.setText("You pressed Alpha");
			}
		});
		
		//add action listener for beta
		btnBeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evtAction) {
				txtTag.setText("You pressed Beta");
			}
		});
		
		//add legend text to content pane
		window.add(legendArea);
		
		//add buttons to content pane
		window.add(btnAlpha);
		window.add(btnBeta);
		
		//add text to content pane
		window.add(txtTag);	
		
		//display the window
		window.setVisible(true);
		window.setTitle("Event-Listener");

	}

	/**
	 * main(): mutator - application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new EventGui();
			}
		});
	}

}
