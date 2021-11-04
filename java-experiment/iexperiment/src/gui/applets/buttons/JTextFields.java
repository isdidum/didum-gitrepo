package gui.applets.buttons;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
 *<applet code="JCheckBox" x=800 y=50 width=300 height=50></applet>
 */
/**
 * @author A., Didum
 * @date February 18, 2013
 * @description JTextFields(): concrete class applet JTextFields
 */
public class JTextFields extends Applet implements ActionListener {
	private static final long serialVersionUID = 1L;
	TextField name, pass;
	TextArea tarea;
	Label namep, passp;
	Color color = new Color(200, 85, 250);
	public void init() {
		setLayout(new FlowLayout(FlowLayout.LEADING, 5, 5));
		setFont(new Font("SansSerif", Font.PLAIN, 12));
		setSize(360, 220);
		setBackground(color);
		
		namep = new Label("Name: ", Label.RIGHT);
		passp = new Label("Password: ", Label.RIGHT);
		
		name = new TextField(12);
		pass = new TextField(8);
		pass.setEchoChar('*');
		
		tarea = new TextArea(getTxt(), 7, 45);
		tarea.setEditable(false);
		tarea.setBackground(new Color(111,222,135));
		
		//arrange components
		add(namep);
		add(name);
		add(passp);
		add(pass);
		add(tarea);
		
		//register to receive action events
		name.addActionListener(this);
		pass.addActionListener(this);
	}
	
	private String getTxt() throws HeadlessException {
		String str = "Here are some of the Layout Managers available:\n";
		str += "FlowLayout, BorderLayout, GridLayout, CardLayout, & GridBadLayout\n";
		str += "Constructors: FlowLayout(), FlowLayout(int how), & FlowLayout(int hw, int hr, int vt)\n";
		str += "hr=FlowLayout.LEFT or .LEADING or .TRAILING-BorderLayout() & BorderLayout(int hr, int vr)\n";
		str += "GridLayout(), GridLayout(int r, int c), & GridLayout(int r, int c, int hr, int vt)\n";
		str += "CardLayout() & CardLayout(int hr, int vt), and GridBagLayout() with only one constructor\n";
		return str;
	}
	

	public void actionPerformed(ActionEvent aevt) {
		repaint();
	}
	
	public void paint(Graphics g) {
		String selected = name.getSelectedText();
		g.drawString("Name: "+name.getText(), 6, 185);
		g.drawString("Selected text in name: "+selected, 6, 200);
		g.drawString("Password: "+pass.getText(), 6, 215);
	}
}
