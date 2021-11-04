package gui.applets.layouts;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 * <applet code="Gridlayout" width=300 height=200></applet>
 */

public class Gridlayout extends Applet implements ActionListener {
	private static final long serialVersionUID = 1L;
	static final int n = 4;
	int table[][] = new int[n][n]; //two dimensional table
	Button btn[][];
	String msg;
	
	public void init() {
		msg = "";
		setLayout(new GridLayout(4, 4));
		setFont(new Font("Aerial", Font.BOLD, 15));
		setSize(260,150);
		btn = new Button[n][n];
		
		for(int i=0; i<table.length; i++) {
			for(int j=0; j<table[i].length; j++) {
				table[i][j] = i*n+j;
				if(table[i][j] > 0) {
					btn[i][j] = (Button) add(new Button(""+table[i][j])); 
					
					//register to receive action events
					btn[i][j].addActionListener(this);
				}
			}
		}
		
	}
	
	public void actionPerformed(ActionEvent evtA) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(evtA.getSource() == btn[i][j]) {
					msg = "Hits: "+btn[i][j].getLabel();
				}
			}
		}
		repaint();
	}
	
	public void paint(Graphics g) {
		for(int i=0; i<n; i++) {
			g.drawString(msg, 260, 150);
		}
	}

}
