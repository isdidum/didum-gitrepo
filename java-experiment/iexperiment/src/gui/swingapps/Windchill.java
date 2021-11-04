
package gui.swingapps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import callable.Sort;
/**
 * @author A., Didum
 * @date January 24, 2013
 * @description Windchill(): concrete class
 */
public class Windchill implements ActionListener {

	// class constants and instance variables
	private static final int XPOS = 800;
	private static final int YPOS = 50;
	private static final int WINDOW_WIDTH = 275;		//pixels
	private static final int WINDOW_HEIGHT = 250;		//pixels
	private static final int TEXT_WIDTH = 20;			//characters/bytes
	private static final FlowLayout LAYOUT_STYLE = new FlowLayout(); //.awt file
	private static String legend = "This windchill calculator is intended for velocities greater than 4 mph.";
	private static final String LEGEND = legend;
		
	// window for GUI, .swing file
	private JFrame window = new JFrame("Windchill Calculator");
	// legend, .swing file
	private JTextArea legendArea = new JTextArea(LEGEND, 2, TEXT_WIDTH);
	
	// user entry area for temperature, .swing file
	private JLabel fahrTag = new JLabel("Fahrenheit temperature");
	private JTextField fahrText = new JTextField(TEXT_WIDTH);
		
	// user entry area for windspeed
	private JLabel windTag = new JLabel("Windspeed (mph)");
	private JTextField windText = new JTextField(TEXT_WIDTH);
		
	// user entry area for windchill result
	private JLabel chillTag = new JLabel("Windchill temperature");
	private JTextField chillText = new JTextField(TEXT_WIDTH);
		
	// run button, .swing file
	private JButton runButton = new JButton("Run");
	
	// set precision
	Sort precision;
	
	/**
	 * @description Windchill(): default constructor
	 */
	public Windchill() {
		precision = new Sort();
		// configure GUI
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setBounds(XPOS, YPOS, WINDOW_WIDTH, WINDOW_HEIGHT); //moves the window to a new location
		
		legendArea.setEditable(false);
		legendArea.setLineWrap(true);
		legendArea.setWrapStyleWord(true);
		legendArea.setBackground(window.getBackground());
		
		chillText.setEditable(false);
		chillText.setBackground(Color.WHITE);
				
		// register event listener
		runButton.addActionListener(this);
		
		//arrange components in GUI
		window.setLayout(LAYOUT_STYLE);
		window.add(legendArea);
		window.add(fahrTag);
		window.add(fahrText);
		window.add(windTag);
		window.add(windText);
		window.add(chillTag);
		window.add(chillText);
		window.add(runButton);
		
		//display GUI
		//window.setVisible(true);
	}
	
	/**
	 * @Description actionPeformed(): run button action event handler
	 * @Notes implementing this event action handling method is the only requirement of the ActionListener interface.
	 * 	Its signature definition is as follows: public void actionPerformed(ActionEvent e)
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			// get user's response
			String response1 = fahrText.getText();
			// wraps primitive by converting to double
			double t = Double.parseDouble(response1);
			
			// get user's response
			String response2 = windText.getText();
			// wraps primitive type by converting to double
			double v = Double.parseDouble(response2);
			
			// compute windchill
			double windchillTemperature = 0.081*(t-91.4)*(3.71*Math.sqrt(v) + 5.81 - 0.25*v) + 91.4;
			
			/*int perceivedTemperature = (int)Math.round(windchillTemperature);
			String output = String.valueOf(perceivedTemperature);
			didum bypassed these two lines by implementing method toFixed()
			*/
			
			//display windchill
			String output = precision.toFixed(String.valueOf(windchillTemperature), 5);
			chillText.setText(output);
			String wpg4mph = "According to U.S. National Weather Service";
			chillText.setToolTipText(wpg4mph);
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
		
	/**
	 * @Description main() - application entry point 
	 * @Notes execution begins in method main()
	 * @param args
	 */
	public static void main(String[] args) {
		Windchill gui = new Windchill();
		// displays GUI
		gui.window.setVisible(true);
	}
}
