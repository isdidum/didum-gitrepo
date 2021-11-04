package pconcrete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//import callable.print.Printable;
import gui.applets.layouts.custom.GBJFrame;

/**
 * TaskListView: Responds to user requests and interact with TaskListModel
 * @author A., Didum
 * @date August 11, 2013
 * @project Case-Studies
 * @see pconcrete.TaskListModel
 * @see pclient.TaskClient
 */
public class TaskListView extends GBJFrame implements ActionListener {
	/** serial version UID*/
	private static final long serialVersionUID = 1L;
	
	/**descriptionField of type JTextArea, is a window object*/
	private JTextArea descriptionField;
	
	/**nameField of type JTextField, is a window object*/
	private JTextField nameField, countField;
	
	/**variable to hold a button, is a window object*/
	private JButton findFirstBtn, findNextBtn, insertBeforeBtn, insertAfterBtn,
			replaceBtn, removeBtn, restoreBtn, firstBtn, previousBtn, nextBtn, lastBtn;
	
	/**variable to hold label, is a window object*/
	private JLabel nameLbl, descriptionLbl, countLbl;
	
	private String text = "This program allows user to maintain a list of tasks, commonly\n knownly as a to-do list.";
	
	public TaskListView() {
		//instantiates window object
		setGuiTitle("Task List GUI by Didum"); 
		//setGuiWidth(370); setGuiHeight(280); setGuiXPos(700); setGuiYPos(50);
		setGuiDimension(700,50,370,280);
		setGuiTextAreaColor(255,255,255); setGuiInsets(3); 
		isGuiPanelBdrEnabled(false); 
		setGuiTxtFieldWidthTxtAreaFont(40,13); //setGuiTextAreaFont(13); setGuiTextFieldWidth(40); 
		setGuiTextRowColSpan(5,1); //setGuiTextRowSpan(5); setGuiTextColSpan(1);
		
		frameLocation();
		addTextArea(text, 0,0, 0,0, 0,0, 3,1, true,false, true,false);
		nameLbl = addLabel("Name: ", 0,1, 5,4, 0,0, 1,1, true);
		nameField = addTextField(1,1, 80,4, 0,0, 1,1, true,true,false,false);
		insertBeforeBtn = addButton("Insert Before", 2,1, 1,4, 0,0, 1,1, true,false,false);
		
		descriptionLbl = addLabel("Description: ", 0,2, 5,4, 0,0, 1,1, true);
		descriptionField = addTextArea("description...", 1,2, 1,4, 1,0, 1,4, true,true, false,true);
		insertAfterBtn = addButton("Insert After", 2,2, 1,4, 0,0, 1,1, true,false,false);
		replaceBtn = addButton("Replace", 2,3, 1,4, 0,0, 1,1, true,false,false);
		removeBtn = addButton("Remove", 2,4, 1,4, 0,0, 1,1, true,false,false);
		restoreBtn = addButton("Restore", 2,5, 1,4, 0,0, 1,1, true,false,false);
		
		countLbl = addLabel("Count: ", 0,6, 5,4, 0,0, 1,1, true);
		countField = addTextField(1,6, 80,4, 0,0, 1,1, true,true,false,true);
		
		findFirstBtn = addButton("Find First", 1,6, 1,4, 0,0, 1,1, true,false,true);
		//findNextBtn = addButton("Find Last", 1,6, 1,4, 0,0, 1,1, true,false,true);//relative
		//firstBtn = addButton("<<", 2,5, 1,4, 0,0, 1,1, true,false);
		//previousBtn = addButton("<", 2,5, 1,4, 0,0, 1,1, true,false);
		//nextBtn = addButton(">", 2,5, 1,4, 0,0, 1,1, true,false);
		//lastBtn = addButton(">>", 2,5, 1,4, 0,0, 1,1, true,false);
		
		//findFirstBtn, findNextBtn, insertBeforeBtn, insertAfterBtn,
		//replaceBtn, removeBtn, restoreBtn, firstBtn, previousBtn, nextBtn, lastBtn;
		
		isGuiVisible(true, false);
		
		//adds action events listener
		btnFindFirst(); btnFindNext(); btnInsertBefore(); btnInsertAfter(); btnReplace();
		btnRemove(); btnRestore(); btnFirst(); btnPrevious(); btnNext(); btnLast();
		
		/*
		setGuiInsets(3);
		frameLocation();
		addTextArea("", 0,0, 0,0, 0,0, 3,1);
		setGuiWidth(300); setGuiHeight(180);
		addLabel("Didum", 0,1, 5,4, 0,0, 1,1); text1 = addTextField(1,1, 95,4, 0,0, 1,1);
		addButton("Send", 2,1, 0,0, 0,0, 1,1);
		
		setGuiDoubleField(text1, 85.98);
		Output.println("The parsed dbl: "+getGuiDoubleField());
		
		addLabel("Abraham", 0,2, 5,4, 0,0, 1,1); addTextField(1,2, 95,4, 0,0, 1,1);
		addTextField(2,2, 50,4, 0,0, 1,1);
		
		isGuiVisible(true, true);
		*/
	}
	
	/**
	 * btnFindFirst(): mutator - finds the first task
	 */
	public void btnFindFirst() {
		try {
			findFirstBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnFindNext(): mutator - finds the next task
	 */
	public void btnFindNext() {
		try {
			findNextBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnInsertBefore(): mutator - inserts the new task before the current task
	 */
	public void btnInsertBefore() {
		try {
			insertBeforeBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnInsertAfter(): mutator - inserts the new task after the current task
	 */
	public void btnInsertAfter() {
		try {
			insertAfterBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnReplace(): mutator - replaces the current task with task
	 */
	public void btnReplace() {
		try {
			replaceBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnRemove(): mutator - removes the current task
	 */
	public void btnRemove() {
		try {
			removeBtn.addActionListener(this);
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * btnRestore(): mutator - restores the task
	 */
	public void btnRestore() {
		try {
			restoreBtn.addActionListener(this);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	public static void main(String args[]){
		new TaskListView();
	}
}
