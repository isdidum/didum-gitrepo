package gui.applets.layouts;

//import java.awt.*;
import javax.swing.*;

/**
 * @author A., Didum
 * @date February 27, 2013
 * @description Borderlayout(): Demonstrate the use of BorderLayout Manager
 * @notes The BoxLayout() manager places components in top, bottom, left, right, & center locations
 * 
 * I'm still having issues BoxLayout out constructor manager - this code errs
 */
public class Boxlayout {
	//instance vars
	private JFrame frame;
	private JButton bn, bs, bw, be, bc;
	
	/**
	 * Borderlayout(): default constructor
	 */
	public Boxlayout() {
		frame = new JFrame("Box Layout");
		bn = new JButton("Button 1");
		bc = new JButton("Button 2");
		bw = new JButton("Button 3");
		bs = new JButton("Button 4");
		be = new JButton("Button 5");
		
		initFrame();
	}
	
	/**
	 * initFrame(): mutator - starts the frame
	 */
	private void initFrame() {
		frame.add(bn);//, BoxLayout.LINE_AXIS);
		frame.add(bc);//, BoxLayout.LINE_AXIS);
		frame.add(bw);//, BoxLayout.LINE_AXIS);
		frame.add(bs);//, BoxLayout.LINE_AXIS);
		frame.add(be);//, BoxLayout.LINE_AXIS);
		
		/*
		 new BoxLayout(frame, BoxLayout.LINE_AXIS); 
		new BoxLayout(bc, 2);
		new BoxLayout(bw, 3);
		new BoxLayout(bs, 4);
		new BoxLayout(be, 5);
		*/
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setLayout(new BoxLayout(null, 1));
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Boxlayout();
			}
		});
	}
}