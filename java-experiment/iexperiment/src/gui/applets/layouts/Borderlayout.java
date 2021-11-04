package gui.applets.layouts;

import java.awt.*;
import javax.swing.*;

/**
 * @author A., Didum
 * @date February 27, 2013
 * @description Boxlayout(): Demonstrate the use of BoxLayout Manager
 * @notes The BorderLayout manager adds components from left to right, add from top to bottom <br /> in a single row of colunm
 */
public class Borderlayout {
	//instance vars
	private JFrame frame;
	private JButton bn, bs, bw, be, bc;
	
	/**
	 * Borderlayout(): default constructor
	 */
	public Borderlayout() {
		frame = new JFrame("Border Layout");
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
		frame.add(bn, BorderLayout.NORTH);
		frame.add(bc, BorderLayout.SOUTH);
		frame.add(bw, BorderLayout.EAST);
		frame.add(bs, BorderLayout.WEST);
		frame.add(be, BorderLayout.CENTER);
		
		frame.setSize(400, 200);
		frame.setVisible(true);
		frame.setLayout(new BorderLayout());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Borderlayout();
			}
		});
	}

}
