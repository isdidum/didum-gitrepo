
package gui.applets.layouts.custom;

import java.awt.*;

import javax.swing.*;
//import java.applet.*;

/**
 * @author A., Didum
 * @date February 23, 2013
 * @description GBJApplet(): an abstract layout manager which extends GridBagLayout Manager
 */
public abstract class GBJApplet extends JApplet {
	/** serialized id*/
	private static final long serialVersionUID = 1L;
		
	/**
	 * @description GBJApplet(): default constructor - GBLayout has only one constructor
	 */
	public GBJApplet() {
		super();
		setFont(new Font("SansSerif", Font.PLAIN, 13));
	}
	
	/**@description addButton(): accessor - adds JButton to component*/
	protected void addButton(String title, GridBagLayout gbg, GridBagConstraints gbc) {
		JButton jbtn = new JButton();
		if(title != null) {
			jbtn.setText(title);
		} else {
			title = "";
		}
		gbg.setConstraints(jbtn, gbc);
		add(jbtn,-1);
	}
	//method overload
	protected void addButton(String title, int cx, GridBagLayout gbg, GridBagConstraints gbc) {
		JButton jbtn = new JButton();
		if(title != null) {
			jbtn.setText(title);
		} else {
			title = "";
		}
		gbg.setConstraints(jbtn, gbc);
		gbc.gridx = cx;
		add(jbtn,-1);
	}
	
	/**@description addLabel(): accessor - adds JLabel to component*/
	protected void addLabel(String title, GridBagLayout gbg, GridBagConstraints gbc) {
		Label jlbl = new Label();
		if(title != null) {
			jlbl.setText(title);
		} else {
			title = "";
		}
		gbg.setConstraints(jlbl, gbc);
		add(jlbl,-1);
	}
	//method overload
	protected void addLabel(String title, int cx, GridBagLayout gbg, GridBagConstraints gbc) {
		Label jlbl = new Label();
		if(title != null) {
			jlbl.setText(title);
		} else {
			title = "";
		}
		gbg.setConstraints(jlbl, gbc);
		gbc.gridx = cx;
		add(jlbl,-1);
	}
	
	/**@description addTextField(): accessor - adds JTextField to component*/
	protected void addTextField(String title, GridBagLayout gbg, GridBagConstraints gbc) {
		TextField jfield = new TextField();
		if(title != null) {
			jfield.setText(title);
			jfield.setForeground(new Color(12,123,253));
		} else {
			title = "";
		}
		gbg.setConstraints(jfield, gbc);
		add(jfield,-1);
	}
	//method overload
	protected void addTextField(String title, int cx, GridBagLayout gbg, GridBagConstraints gbc) {
		TextField jfield = new TextField();
		if(title != null) {
			jfield.setText(title);
			jfield.setForeground(new Color(12,123,253));
		} else {
			title = "";
		}
		gbg.setConstraints(jfield, gbc);
		gbc.gridx = cx;
		add(jfield,-1);
	}
	
	/**@description addTextArea(): accessor - adds JTextArea to component*/
	protected void addTextArea(String title, GridBagLayout gbg, GridBagConstraints gbc) {
		TextArea jarea = new TextArea();
		if(title != null) {
			jarea.setText(title);
		} else {
			title = "";
		}
		gbg.setConstraints(jarea, gbc);
		add(jarea,-1);
	}
	//method overload
	protected void addTextArea(String title, int cx, GridBagLayout gbg, GridBagConstraints gbc) {
		TextArea jarea = new TextArea();
		if(title != null) {
			jarea.setText(title);
		} else {
			title = "";
		}
		gbg.setConstraints(jarea, gbc);
		gbc.gridx = cx;
		add(jarea,-1);
	}
}
