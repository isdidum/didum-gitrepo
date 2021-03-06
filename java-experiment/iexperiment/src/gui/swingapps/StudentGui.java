
package gui.swingapps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.awt.geom.Line2D;

import callable.Sort;
import pconcrete.Student;
import generics.window.WinListener;
import gui.swingapps.msgbox.MessageBox;

/**
 * StudentGui: This is a GUI-Based program that computes the average of three test scores.<br />  
 * It allows you to view each student record via control buttons: first, previous, next, & last.
 * @author A., Didum
 * @date January 29, 2013
 * @project Case-Studies
 * @see pconcrete.Student.java 
 */
public class StudentGui /*extends JFrame*/ implements ActionListener {
	/**
	 * if extends JFrame is added to this class definition
	 *
	private static final long serialVersionUID = 1L;
	*/
	//class constants
	private static final int XPOS = 700;				//pixels
	private static final int YPOS = 50;					//pixels
	private static final int WIN_WIDTH = 363;			//pixels
	private static final int WIN_HEIGHT = 250;			//pixels
	private static final int NAME_TXT_WIDTH = 20;		//characters/bytes
	private static final int EXAM_TXT_WIDTH = 10;		//characters/bytes
	private static final int LEGEND_WIDTH = WIN_WIDTH;	//pixels
	private static final int HOR = 10;					//pixels horizontally
	private static final int VER = 5;					//pixels vertically
	private static final FlowLayout LAYOUT_STYLE = new FlowLayout(FlowLayout.LEFT, HOR, VER);
	
	/**text in legend area*/
	private static String legend = "Program computes average of three test scores";
	private static final String LEGEND = legend;
	private static final Color SEA_BLUE = new Color(120,115,255); //min:0 - max:255
	
	//instance variables
	private JFrame window, msg;
	private JLabel nameTag, t1Tag, t2Tag, t3Tag, meanTag, countTag, indexTag;
	private JTextField nameTxt, t1Txt, t2Txt, t3Txt, meanTxt, countTxt, indexTxt;
	private JButton addBtn, modifyBtn, firstBtn, previousBtn, nextBtn, lastBtn, clearBtn; 
	private JTextArea legendArea, msgArea;
	
	/**reference variable to hold an array of Student object*/
	private Student students[];
	
	private MessageBox refmbx = new MessageBox();
	
	/**variable to hold position of current student, initially -1*/
	private int studentIndex;
	
	/**variable to hold current number of students, initially 0*/
	private int studentCount;
	
	/**reference variable to hold Sort object*/
	private Sort sort;
	
	/**
	 * StudentGui(): default constructor
	 */
	public StudentGui() {
		sort = new Sort();
		studentIndex = -1;
		studentCount = 0;
		students = new Student[5];
		
		msg = new JFrame();
		msgArea = new JTextArea("", 2, NAME_TXT_WIDTH);
		
		window = new JFrame();
		legendArea = new JTextArea(LEGEND, 2, LEGEND_WIDTH);
		
		nameTag = new JLabel("Name");
		nameTxt = new JTextField(NAME_TXT_WIDTH);
		
		t1Tag = new JLabel("Test1");
		t1Txt = new JTextField(NAME_TXT_WIDTH);
		
		t2Tag = new JLabel("Test2");
		t2Txt = new JTextField(EXAM_TXT_WIDTH-3);
		
		t3Tag = new JLabel("Test3");
		t3Txt = new JTextField(EXAM_TXT_WIDTH-3);
		
		meanTag = new JLabel("Mean");
		meanTxt = new JTextField(EXAM_TXT_WIDTH);
		
		countTag = new JLabel("Count");
		countTxt = new JTextField(EXAM_TXT_WIDTH+1);
		
		indexTag = new JLabel("Current Index");
		indexTxt = new JTextField(NAME_TXT_WIDTH+2);
		
		//window layout
		window.setLayout(LAYOUT_STYLE);
		
		addBtn = new JButton("Add");
		modifyBtn = new JButton("Modify");
		clearBtn = new JButton("Clear");
		firstBtn = new JButton("<<");
		previousBtn = new JButton("<");
		nextBtn = new JButton(">");
		lastBtn = new JButton(">>");
		
		//adds action events listener
		btnAdd(); btnModify(); btnFirst(); btnPrevious(); btnNext(); btnLast(); btnClear();
		showCurrentStudent();
		frameSize(); frameExit(); frameLocation(); frameLegend(); frameArrange();
		frameBgColor(); frameDisplay();
	}
			
	/**
	 * btnAdd(): mutator - button to add student data on screen
	 */
	public void btnAdd() {
		try {
			addBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnModify(): mutator - button to modify student data on screen
	 */
	public void btnModify() {
		try {
			modifyBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnClear(): mutator - button to clear the screen
	 */
	public void btnClear() {
		try {
			clearBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnFirst(): mutator - button to show first record
	 */
	public void btnFirst() {
		try {
			firstBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnPrevious(): mutator - button to show previous record
	 */
	public void btnPrevious() {
		try {
			previousBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnNext(): mutator - button to show next record
	 */
	public void btnNext() {
		try {
			nextBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnLast(): mutator - button to show last record
	 */
	public void btnLast() {
		try {
			lastBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * frameSize(): mutator - sets window width and height
	 */
	public void frameSize() {
		try {
			window.setSize(WIN_WIDTH, WIN_HEIGHT);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * frameExit(): mutator - closes windows when program is x'd out
	 */
	public void frameExit() {
		try {
			//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//works
			window.addWindowListener(new WinListener());
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * frameLocation(): mutator - positions current window in designated spot
	 */
	public void frameLocation() {
		try {
			window.setBounds(XPOS, YPOS, WIN_WIDTH, WIN_HEIGHT); //moves the window to a new location
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * frameLegend(): mutator - invalidates editable legend area
	 */
	public void frameLegend() {
		try {
			legendArea.setEditable(false);
			legendArea.setLineWrap(true);
			legendArea.setWrapStyleWord(true);
			meanTxt.setEditable(false);
			countTxt.setEditable(false);
			indexTxt.setEditable(false);
		} catch(Exception err) {err.printStackTrace();}
	}
	
	/**
	 * frameContentPane(): mutator - sets windows content pane
	 */
	public Container frameContentPane() {
		try {
			Container mainWin = window.getContentPane();
			return mainWin;
		} catch (Exception err) {err.printStackTrace();}
		return null;
	}
	
	/**
	 * frameBgColor(): mutator - sets background of window container
	 */
	public void frameBgColor() {
		try {
			//Container c = window.getContentPane();
			legendArea.setBackground(SEA_BLUE); 		// window.getBackground() or Color.WHITE
			frameContentPane().setBackground(SEA_BLUE); // null = use default color
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/*paintComponent() does not work, it was meant to add a line to JFrame window
	public void paintComponent(Graphics graphics){
		//super.paintComponent();
		Graphics2D gra = (Graphics2D) graphics;
		Line2D line = new Line2D.Float(100,100,250,260);
		gra.draw(line);
	}*/
	
	/**
	 * frameArrange(): mutator - arranges components in frame window 
	 */
	public void frameArrange() {
		try {
			// legend
			window.add(legendArea);		
			
			//adds name label and its input field/box
			window.add(nameTag, JLabel.LEFT_ALIGNMENT);
			window.add(nameTxt, JTextField.RIGHT_ALIGNMENT);
			//adds add button
			window.add(addBtn, JButton.RIGHT_ALIGNMENT);
			//adds test1 label and its input field
			window.add(t1Tag, JLabel.LEFT_ALIGNMENT);
			window.add(t1Txt, JTextField.RIGHT_ALIGNMENT);
			//adds clear button
			window.add(clearBtn, JButton.RIGHT_ALIGNMENT);
						
			// adds test2 label and its input field
			window.add(t2Tag, JLabel.LEFT_ALIGNMENT);
			window.add(t2Txt, JTextField.RIGHT_ALIGNMENT); 
			// adds test3 label and its input field
			window.add(t3Tag, JLabel.LEFT_ALIGNMENT);
			window.add(t3Txt, JTextField.RIGHT_ALIGNMENT);
			//add modify button
			window.add(modifyBtn, JButton.RIGHT_ALIGNMENT);
			
			// adds average label and its input field
			window.add(meanTag, JLabel.LEFT_ALIGNMENT);
			window.add(meanTxt, JTextField.RIGHT_ALIGNMENT);
			// adds count label and its input field
			window.add(countTag, JLabel.LEFT_ALIGNMENT);
			window.add(countTxt, JTextField.RIGHT_ALIGNMENT);
			// adds index label and its input field
			window.add(indexTag);
			window.add(indexTxt);
			
			//an attemp to add a horizontal line to window, but failed
			//window.add(new JSeparator(SwingConstants.HORIZONTAL)); //JSeparator.HORIZONTAL));
			//window.add(new JSeparator(JSeparator.VERTICAL), BorderLayout.LINE_START);
			//adds buttons
			window.add(firstBtn, JButton.LEFT_ALIGNMENT);
			window.add(previousBtn, JButton.LEFT_ALIGNMENT);
			window.add(nextBtn, JButton.LEFT_ALIGNMENT);
			window.add(lastBtn, JButton.LEFT_ALIGNMENT);
			
		} catch(Exception err) {err.printStackTrace();}
	}
	
	/**
	 * frameDisplay(): mutator - displays the window 
	 */
	public void frameDisplay() {
		try {
			window.setVisible(true);
			window.setResizable(false);
			window.setTitle("Student Test Scores by Didum");
		}catch(Exception err) {err.printStackTrace();}
	}
		
	/**
	 * airMsg(): facilitator - facilitates messages to the screen 
	 */
	public void airMsg(String sAirmsg) {
		try {
			msg.setTitle("Message Center");
			msg.setVisible(true);
			msgArea = new JTextArea(sAirmsg, 2, NAME_TXT_WIDTH-10);
			msgArea.setLineWrap(true);
			msgArea.setWrapStyleWord(true);
			msgArea.setEditable(false);
			msg.add(msgArea);
			msg.setBounds(XPOS+400, YPOS+100, WIN_WIDTH-100, WIN_HEIGHT-170);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * add(): adds students to the student array
	 */
	private void add() {
		try {
			if(studentCount == students.length) {
				airMsg(refmbx.msgBox("SORRY: student array is full", true));
				clearScreen();
				showFirst();
				return;
			}
			
			Student stu = getDataOnScreen();
			String str = stu.validateData();
			//System.out.println("Didum-stu = "+stu+"\nString: "+str);
			
			if(str != null) {				//if the data is invalid,
				airMsg(refmbx.msgBox(str, true));	//then exit the method without
				return;						//adding the student
			}
			
			students[studentCount] = stu;
			studentIndex = studentCount;
			studentCount++;
			
			msg.setVisible(false);
			showCurrentStudent();	//only shows studentCount and studentIndex
			
			String nm = nameTxt.getText().trim();
			if(nm.length() != 0) clearScreen();
			
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * getDataOnScreen(): accessor - gets each student data from GUI
	 */
	private Student getDataOnScreen() {
		String nm = "";
		try {
			nm = nameTxt.getText().trim();
			
			double tests[] = new double[3]; 
			//input in t1Txt field is a string, auto-unboxed primitive value 
			tests[0] = Double.parseDouble(t1Txt.getText());
			tests[1] = Double.parseDouble(t2Txt.getText()); //Integer.parseInt(t2Txt.getText());
			tests[2] = Double.parseDouble(t3Txt.getText());
			
			Student stu = new Student(nm, tests);
			return stu;
			
		} catch(Exception err) {err.printStackTrace();}
		return null;
	}
	
	/**
	 * modify(): mutator - make changes to each student data from GUI
	 */
	private void modify() {
		try {
					
			Student stu = getDataOnScreen();
			String str = stu.validateData();
			
			if(str != null) {				//if the data is invalid,
				airMsg(refmbx.msgBox(str, true));	//then exit the method without
				return;						//adding the student
			}
			
			if(studentIndex != -1) {
				//first get the string values in text-fields
				Student dstu = students[studentIndex];
				String nm = nameTxt.getText().trim();
				String s1 = t1Txt.getText();
				String s2 = t2Txt.getText();
				String s3 = t3Txt.getText();
				
				//converts string values to double (AutoBox them, via Wrapper Class Double)
				dstu.setName(nm);
				dstu.setScore(1, Double.parseDouble(s1)); //Integer.parseInt(s1));
				dstu.setScore(2, Double.parseDouble(s2));
				dstu.setScore(3, Double.parseDouble(s3));
				
				//converts double values to string (AutoBox them) & set to text-fields
				nameTxt.setText(dstu.getName().trim()); //works
				t1Txt.setText(String.valueOf(dstu.getScore(1)));
				t2Txt.setText(String.valueOf(dstu.getScore(2)));
				t3Txt.setText(String.valueOf(dstu.getScore(3)));
			}
			showCurrentStudent();
			msg.setVisible(false);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * showFirst(): mutator - makes the first student data current if there is one
	 */
	private void showFirst() {
		try {
			if(studentCount == 0) {
				studentIndex = -1;
			} else {
				studentIndex = 0;
			}
			showCurrentStudent();
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * showPrevious(): mutator - makes the previous student data current if there is one
	 */
	private void showPrevious() {
		try {
			if(studentCount == 0) {
				studentIndex = -1;
			} else if(studentIndex != -1) {
				//studentIndex += -1; //works as well 
				studentIndex = Math.min(studentIndex-1, studentCount-1); //works
			}
			showCurrentStudent();
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * showNext(): mutator - makes the next student data current if there is one
	 */
	private void showNext() {
		try {
			if(studentCount == 0) {
				studentIndex = -1;
			} else {
				studentIndex = Math.min(studentCount-1, studentIndex+1);
			}
			showCurrentStudent();
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * showLast(): mutator - makes the last student data current if there one
	 */
	private void showLast() {
		try {
			if(studentCount == 0) { 
				studentIndex = -1; 
			} else {
				studentIndex = Math.max(studentCount-1, studentIndex-1); 
			}
			showCurrentStudent();
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * clearScreen(): mutator -  clears student data on screen after end-user clicked add button
	 */
	private void clearScreen(){
		try{
			nameTxt.setText("");
			t1Txt.setText("");
			t2Txt.setText("");
			t3Txt.setText("");
			meanTxt.setText("");
		} catch (Exception err){err.printStackTrace();}
	}
	
	/**
	 * showCurrentStudent(): mutator - displays the current student data from GUI
	 */
	private void showCurrentStudent() {
		try {
			if(studentIndex == -1) {
				nameTxt.setText("");
				t1Txt.setText("0");
				t2Txt.setText("0");
				t3Txt.setText("0");
				meanTxt.setText("0");
			} else {				
				Student stu = students[studentIndex];
				nameTxt.setText(stu.getName().trim());
				t1Txt.setText(String.valueOf(stu.getScore(1)));
				t2Txt.setText(String.valueOf(stu.getScore(2)));
				t3Txt.setText(String.valueOf(stu.getScore(3)));
				meanTxt.setText(sort.toFixed(String.valueOf(stu.getAverage()), 3));
				//System.out.println("Didum-1\nStu = "+stu);
			}
			countTxt.setText(String.valueOf(studentCount) + " / " + String.valueOf(students.length));
			indexTxt.setText(String.valueOf(studentIndex));
		} catch (Exception err) {err.printStackTrace();}
	}

	/**
	 * actionPeformed(): mutator - run button action event handler
	 * @notes implementing this event action handling method is the only requirement of the ActionListener interface.
	 * Its signature definition is as follows: public void actionPerformed(ActionEvent e)
	 */
	public void actionPerformed(ActionEvent evtAction) {
		String str = evtAction.getActionCommand();
		try {
			if(str.equals("Add")) {
				add();
			} else if(str.equals("Clear")) {
				clearScreen();
			} else if(str.equals("Modify")) {
				enableTextField();
				modify();
			} else if(str.equals("<<")) {
				firstBtn.setToolTipText("View first record");
				disableTextField();
				showFirst();
			} else if(str.equals("<")) {
				previousBtn.setToolTipText("View previous record");
				disableTextField();
				showPrevious();
			} else if(str.equals(">")) {
				nextBtn.setToolTipText("View next record");
				disableTextField();
				showNext();
			} else if(str.equals(">>")) {
				lastBtn.setToolTipText("View last record");
				disableTextField();
				showLast();
			}
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * disables text-fields
	 */
	private void disableTextField(){
		nameTxt.setEditable(false);
		t1Txt.setEditable(false);
		t2Txt.setEditable(false);
		t3Txt.setEditable(false);
		
		nameTxt.setBackground(new Color(200,200,230));
		t1Txt.setBackground(new Color(200,200,230));
		t2Txt.setBackground(new Color(200,200,230));
		t3Txt.setBackground(new Color(200,200,230));
	}
	
	/**
	 * enables text-fields
	 */
	private void enableTextField(){
		nameTxt.setEditable(true);
		t1Txt.setEditable(true);
		t2Txt.setEditable(true);
		t3Txt.setEditable(true);
		
		nameTxt.setBackground(new Color(255,255,255));
		t1Txt.setBackground(new Color(255,255,255));
		t2Txt.setBackground(new Color(255,255,255));
		t3Txt.setBackground(new Color(255,255,255));
	}
	
	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new StudentGui();
			}
		});
	}
}
