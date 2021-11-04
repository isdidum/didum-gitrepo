package gui.swingapps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.util.TimerTask;

import callable.Sort;
import callable.io.Print;
/**
 * @author A., Didum
 * @date January 25, 2013
 * @description Temperature(): concrete class for temperature conversion via GUI
 */
public class Temperature implements ActionListener {
	//class constants
	private static final int XPOS = 700;			//pixels
	private static final int YPOS = 50;				//pixels
	private static final int WINDOW_WIDTH = 300;	//pixels
	private static final int WINDOW_HEIGHT = 310; 	//pixels
	private static final int TEXT_WIDTH = 20;		//characters/bytes
	private static final FlowLayout LAYOUT_STYLE = new FlowLayout(); //.awt file
	/**text in legend area*/
	private static String legend = "Program computes temperature scale of all four temperatures: degrees, celsius, kelvin, and rankine";
	private static final String LEGEND = legend;
	private static final Color SEA_BLUE = new Color(110,225,255); //min:0 - max:255
	
	/**GUI window*/
	private JFrame window, msg;
	
	/**the legend area*/
	private JTextArea legendArea, msgArea1, msgArea2;
	
	/** label tag*/
	private JLabel fahrTag, celTag, rankTag, kelTag;
	
	/**text field storage variable*/
	private JTextField fahrText, celText, rankText, kelText;
	
	/**GUI button*/
	private JButton runButton, resetButton;
	
	/** invokes method toFixed() from class Sort() to set precision*/
	private Sort sort;
	private Print view;
	private double tempStck[];
	
	/**value in text field storage variables*/
	String kv, fv, cv, rv;
	
	/**
	 * Temperature(): default constructor
	 */
	public Temperature() {
		window = new JFrame("Temperature Widget by Didum");
		msg = new JFrame();
		msgArea1 = new JTextArea("", 2, TEXT_WIDTH);
		msgArea2 = new JTextArea("", 2, TEXT_WIDTH);
		legendArea = new JTextArea(LEGEND, 2, TEXT_WIDTH);
		
		// user entry area for fahrenheit temperature, .swing file
		fahrTag = new JLabel("Fahrenheit temperature");
		fahrText = new JTextField(TEXT_WIDTH);
				
		// user entry area for celsius temperature
		celTag = new JLabel("Celsius temperature");
		celText = new JTextField(TEXT_WIDTH);
		
		// user entry area for rankine temperature
		rankTag = new JLabel("Rankine temperature");
		rankText = new JTextField(TEXT_WIDTH);
		
		// user entry area for kelvin temperature
		kelTag = new JLabel("Kelvin temperature");
		kelText = new JTextField(TEXT_WIDTH);
				
		// run/reset buttons, .swing file
		runButton = new JButton("Enter");
		resetButton = new JButton("Clear");
		
		tempStck = new double[4];
		sort = new Sort();
		view = new Print();
		
		// register event listener
		runBtnHandler();
		resetBtnHandler();
	}
		
	/**
	 * runBtnHandler(): mutator - handles button clicked/registers event listener
	 * @Notes method main() gets deactivated and flows of control is handed to the constructor
	 * 	plus the constructor needs this button so the user can constantly update input fields
	 */
	public void runBtnHandler() {
		try {
			runButton.addActionListener(this);
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * runBtnHandler(): mutator - handles button clicked/registers event listener
	 * @Notes method main() gets deactivated and flows of control is handed to the constructor
	 * 	plus the constructor needs this button so the user can constantly update input fields
	 */
	public void resetBtnHandler() {
		try {
			resetButton.addActionListener(this);
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * frameSize(): mutator - sets window width and height
	 */
	public void frameSize() {
		try {
			window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * frameExit(): mutator - closes windows when program is x'd out
	 */
	public void frameExit() {
		try {
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//msg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * frameLocation(): mutator - positions current window in designated spot
	 */
	public void frameLocation() {
		try {
			window.setBounds(XPOS, YPOS, WINDOW_WIDTH, WINDOW_HEIGHT); //moves the window to a new location
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * frameLegend(): mutator - invalidates editable legend area
	 */
	public void frameLegend() {
		try {
			legendArea.setEditable(false);
			legendArea.setLineWrap(true);
			legendArea.setWrapStyleWord(true);
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * frameBgColor(): mutator - sets background of window container
	 */
	public void frameBgColor() {
		try {
			Container c = window.getContentPane();
			legendArea.setBackground(SEA_BLUE); 	// window.getBackground() or Color.WHITE
			c.setBackground(SEA_BLUE); 				// null = use default color
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * frameArrange(): mutator - arranges components of the window 
	 */
	public void frameArrange() {
		try {
			window.setLayout(LAYOUT_STYLE);
			// legend
			window.add(legendArea);
			
			// fahrenheit
			window.add(fahrTag);
			window.add(fahrText);
			// celsius
			window.add(celTag);
			window.add(celText);
			// rankine
			window.add(rankTag);
			window.add(rankText);
			// kelvin
			window.add(kelTag);
			window.add(kelText);
			// buttons
			window.add(resetButton);
			window.add(runButton);
			
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * frameDisplay(): mutator - displays the window 
	 */
	public void frameDisplay() {
		try {
			window.setVisible(true);
			window.setResizable(false);
			//window.setTitle("Temperature GUI Widget");
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * tempFahrenheit(): accessor - calculates temperatures
	 * @return temperature array list
	 */
	public double[] tempFahrenheit() {
		double ftemp=0.0, ctemp=0.0, rtemp=0.0, ktemp=0.0;
		
		try {
			if(getTextInput().equals(fv) && getTextInput() != null && !getTextInput().equals("nan")) {
				ftemp = Double.parseDouble(fv);
				ctemp = (5.0 / 9.0) * (ftemp - 32.0);
				ktemp = ctemp + 273.15;
				rtemp = 1.80 * ktemp;				
			
				tempStck[0] = ftemp;
				tempStck[1] = ctemp; 
				tempStck[2] = rtemp;
				tempStck[3] = ktemp;
				return tempStck;
			}
		} catch(Exception err) {
			err.printStackTrace();
		}
		//return tempStck;
		return null;
	}
	
	/**
	 * tempCelsius(): accessor - calculates temperatures
	 * @return temperature array list
	 */
	public double[] tempCelsius() {
		double ftemp=0.0, ctemp=0.0, rtemp=0.0, ktemp=0.0;
		
		try {
			if(getTextInput().equals(cv) && getTextInput() != null && !getTextInput().equals("nan")) {
				ctemp = Double.parseDouble(cv); 
				ftemp = (9.0 / 5.0) * ctemp + 32.0;
				ktemp = ctemp + 273.15;
				rtemp = 1.80 * ktemp;
				
				tempStck[0] = ftemp;
				tempStck[1] = ctemp; 
				tempStck[2] = rtemp;
				tempStck[3] = ktemp;
				return tempStck;
			}
		} catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * tempRankine(): accessor - calculates temperatures
	 * @return temperature array list
	 */
	public double[] tempRankine() {
		double ftemp=0.0, ctemp=0.0, rtemp=0.0, ktemp=0.0;
		
		try {
			if(getTextInput().equals(rv) && getTextInput() != null && !getTextInput().equals("nan")) {
				rtemp = Double.parseDouble(rv);
				ftemp = rtemp - 459.67;
				ctemp = (5.0 / 9.0) * (ftemp - 32.0);
				ktemp = ctemp + 273.15;
				
				tempStck[0] = ftemp;
				tempStck[1] = ctemp; 
				tempStck[2] = rtemp;
				tempStck[3] = ktemp;
				return tempStck;
			}
		} catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * tempKelvin(): accessor - calculates temperatures
	 * @return temperature array list
	 */
	public double[] tempKelvin() {
		double ftemp=0.0, ctemp=0.0, rtemp=0.0, ktemp=0.0;
		
		try {
			if(getTextInput().equals(kv) && getTextInput() != null && !getTextInput().equals("nan")) {
				ktemp = Double.parseDouble(kv);
				rtemp = 1.80 * ktemp;
				ctemp = ktemp - 273.15;
				ftemp = (9.0 / 5.0) * ctemp + 32.0;	
				
				tempStck[0] = ftemp;
				tempStck[1] = ctemp; 
				tempStck[2] = rtemp;
				tempStck[3] = ktemp;
				return tempStck;
			}
		} catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
				
	/**
	 * getTextInputs(): accessor - returns string object
	 */
	public String getTextInput() {
		try {
			//get text from input stream/field
			fv = fahrText.getText().trim();
			cv = celText.getText().trim();
			rv = rankText.getText().trim();
			kv = kelText.getText().trim();
			
			if((!fv.equals("") || cv.length() != 0) && sort.isNumber(fv)) {
				return fv;
			} else if((!cv.equals("") || cv.length() != 0) && sort.isNumber(cv)) { 
				return cv;
			} else if((!rv.equals("") || rv.length() != 0) && sort.isNumber(rv)) {
				return rv;
			} else if((!kv.equals("") || kv.length() != 0) && sort.isNumber(kv)) {
				return kv;
			} else if(fv.equals("") && cv.equals("") && kv.equals("") && rv.equals("")) {
				return null; //works as intended
			} else if(!sort.isNumber(fv) || !sort.isNumber(cv) || !sort.isNumber(rv) || !sort.isNumber(kv)){
				return "nan";
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @Descripton setFocus(): mutator - upon mouse-down, clear input stream
	 *
	public void setFocus() {
		try {
			if(fahrText.hasFocus()) {
				System.out.println("hfocus: "+fahrText.hasFocus()+" isfocusOwner: "+fahrText.isFocusOwner()
						+" isgFTKeyEnable: "+fahrText.getFocusTraversalKeysEnabled());
				fahrText.setText(fahrValue.replaceAll(fahrValue.substring(0, fahrValue.length()), ""));
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}*/
	
	/**
	 * setResults(): mutator - parses results from double to string then push them back to the input fields
	 */
	public void setResults() {
		String fstr="", cstr="", rstr="", kstr="";
		double temp[] = new double[4];
		
		try {
			if(getTextInput() != null && !getTextInput().equals("nan") && getTextInput().equals(fv)) {
				for(int i=0; i<tempFahrenheit().length; i++) {
					temp[i] = tempFahrenheit()[i];
					view.println("tempFahr: "+sort.toFixed(String.valueOf(temp[i]),3));
					//System.out.println("tempFahr: "+temp[i]); //sop() above is for seeing output in console window and using method toFixed()
				}
			} else if(getTextInput() != null && !getTextInput().equals("nan") && getTextInput().equals(cv)) {
				for(int i=0; i<tempCelsius().length; i++) {
					temp[i] = tempCelsius()[i];
					view.println("tempCel: "+sort.toFixed(String.valueOf(temp[i]),3));
				}
			} else if(getTextInput() != null && !getTextInput().equals("nan") && getTextInput().equals(rv)) {
				for(int i=0; i<tempRankine().length; i++) {
					temp[i] = tempRankine()[i];
					view.println("tempRank: "+sort.toFixed(String.valueOf(temp[i]),3));
				}
			} else if(getTextInput() != null && !getTextInput().equals("nan") && getTextInput().equals(kv)) {
				for(int i=0; i<tempKelvin().length; i++) {
					temp[i] = tempKelvin()[i];
					view.println("tempKel: "+sort.toFixed(String.valueOf(temp[i]),3));
				}
			} else if(getTextInput() == null) {
				runButton.setToolTipText("You did not supply any value at all");
				msgBox1();
			} else if(getTextInput().equals("nan")) {
				runButton.setToolTipText("You provided a non-numeric input");
				msgBox2();
			}
			
			if(getTextInput() != null && !getTextInput().equals("nan")) {
				runButton.setToolTipText(null);
				msg.setVisible(false);
				
				// sets precision on floating-point number
				fstr = sort.toFixed(String.valueOf(temp[0]), 2);
				cstr = sort.toFixed(String.valueOf(temp[1]), 2);
				rstr = sort.toFixed(String.valueOf(temp[2]), 2);
				kstr = sort.toFixed(String.valueOf(temp[3]), 2);
				
				// sets solution
				fahrText.setText(fstr);
				celText.setText(cstr);
				rankText.setText(rstr);
				kelText.setText(kstr);
				//setFocus();
			}

		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * msgBox1(): facilitator - facilitates messages to the screen 
	 */
	public void msgBox1() {
		try {
			msg.setTitle("Message Center");
			msg.setVisible(true);
			String st1 = "You failed to supply a numeric value into an input field";
			msgArea1 = new JTextArea(st1, 2, TEXT_WIDTH-10);
			msgArea1.setLineWrap(true);
			msgArea1.setWrapStyleWord(true);
			msgArea1.setEditable(false); msgArea2.setVisible(false);
			msg.add(msgArea1);
			msg.setBounds(XPOS+320, YPOS+50, WINDOW_WIDTH-40, WINDOW_HEIGHT-200);
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * msgBox2(): facilitator - facilitates messages to the screen 
	 */
	public void msgBox2() {
		try {
			msg.setTitle("Message Center");
			msg.setVisible(true);
			String st2 = "You provided a non-numeric value, namely, a string literal into a field";
			msgArea2 = new JTextArea(st2, 2, TEXT_WIDTH-10);
			msgArea2.setLineWrap(true);
			msgArea2.setWrapStyleWord(true);
			msgArea2.setEditable(false);
			msg.add(msgArea2); msgArea1.setVisible(false);
			msg.setBounds(XPOS+320, YPOS+50, WINDOW_WIDTH-40, WINDOW_HEIGHT-200);
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
		
	/**
	 * resetResults(): mutator - resets result text fields
	 */
	public void resetTextInput() {
		try {
			if(getTextInput() == null || getTextInput().equals("nan")) {
				fahrText.setText(fv.replaceAll(fv.substring(0, fv.length()), ""));
				celText.setText(cv.replaceAll(cv.substring(0, cv.length()), ""));
				rankText.setText(rv.replaceAll(rv.substring(0, rv.length()), ""));
				kelText.setText(kv.replaceAll(kv.substring(0, kv.length()), ""));
			} else {
				fahrText.setText(fv.replaceAll(fv.substring(0, fv.length()), ""));
				celText.setText(cv.replaceAll(cv.substring(0, cv.length()), ""));
				rankText.setText(rv.replaceAll(rv.substring(0, rv.length()), ""));
				kelText.setText(kv.replaceAll(kv.substring(0, kv.length()), ""));
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
		
	/**
	 * actionPeformed(): mutator - run button action event handler
	 * @Notes implementing this event action handling method is the only requirement of the ActionListener interface.
	 * 	Its signature definition is as follows: public void actionPerformed(ActionEvent e)
	 */
	public void actionPerformed(ActionEvent evtAction) {
		try {			
			String str = evtAction.getActionCommand(); 	//getSource();
			if(str.equals("Enter")) {					//runButton.getText().equals("Enter")
				setResults();
				view.debug("Button clicked: "+ runButton.getText());
			} else if(str.equals("Clear")) {
				resetTextInput();
				msg.setVisible(false);
				view.debug("Button clicked: "+ resetButton.getText());
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * main(): mutator - application entry point and is where execution begins 
	 * @param args
	 */
	public static void main(String args[]) {
		Temperature temp = new Temperature();
		temp.frameSize();
		temp.frameExit();
		temp.frameLocation();
		temp.frameLegend();
		temp.frameArrange();
		temp.frameBgColor();
		temp.frameDisplay();
	}
}
