package gui.applets.layouts.custom;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import generics.window.WinListener;

//import callable.print.Mark;

/**
 * GBJFrame: GBJFrame is GridBag GUI window constructed from JFrame
 * @authors A., Didum
 * @date July 20, 2013
 * @since JDK 7.0
 */
public class GBJFrame extends JFrame {
	/** default serial version ID*/
	private static final long  serialVersionUID = 1L;
	private String sTitle;
	private int xPos, yPos, i, j, k, width, height, fsize;
	private int iTxtWidth, ispan, jspan;
	private boolean jpl;
	private JTextField jtext = new JTextField();
	//public Print pt = new Print();
	
	//creates objects
	GridBagLayout gbLayout = new GridBagLayout();
	GridBagConstraints gbConst = new GridBagConstraints();
	JPanel jPanel = new JPanel();
	Insets jinsets;
    Border border;
	
	/**variable to hold legend text*/
	private String sTxtAreaTitle;
	
	/**variable used to specific frame window color*/
	private Color color;
	
	/**
	 * GBJFrame(): specific or parameterized constructor
	 * @param title - frame window title
	 * @param fsize - font size
	 * @param xPos - x position of frame window
	 * @param yPos - y position of frame window
	 * @param w - width of frame window
	 * @param h - height of frame window
	 * @param i - 1st color parameter
	 * @param j - 2nd color parameter
	 * @param k - 3rd color parameter
	 * @param t - insets from top
	 * @param l - insets from left
	 * @param b - insets from right
	 * @param r - insets from right
	 * @param jpl - true to enable JPanel border, false otherwise
	 * @param tw - width of JTextField
	 * @param is - row span of JTextArea
	 * @param js - column span of JTextArea
	 */
	public GBJFrame(String title, String text, int fsize, int xPos, int yPos, int w, int h, int i, int j, int k, 
			int t, int l, int b, int r, boolean jpl, int tw, int is, int js) {
		super(title); sTitle = title;
		sTxtAreaTitle = text; iTxtWidth = tw; ispan = is; jspan = js;
		width = w; height = h; this.xPos = xPos; this.yPos = yPos;
		border = BorderFactory.createLineBorder(new Color(0,0,0));
		color = new Color(i, j, k);	this.fsize = fsize;
		jinsets = new Insets(t, l, b, r);
		gbConst.insets = jinsets;	//this spaces components apart
		this.jpl=jpl;
		//these are non-dependent injection methods
		frameLayout(); frameExit(); frameContentPane();
	}
	
	/**
	 * GBJFrame(): default constructor
	 */
	public GBJFrame(){
		super(); sTitle = "";
		sTxtAreaTitle = ""; width = 0; height = 0; fsize = 0;
		i = 0; j = 0; k = 0; xPos = 0; yPos = 0;
		iTxtWidth = 0; ispan = 0; jspan = 0;
		border = BorderFactory.createLineBorder(new Color(i,j,k)); //(Color.black);
		color = new Color((int)(Math.random()*256));
		jpl=false;
		//these are non-dependent injection methods
		frameLayout(); frameExit(); frameContentPane();
	}
	
	/**
	 * setGuiInsets(): mutator - sets Insets object
	 * @param top - insets from the top
	 * @param left - insets from the left
	 * @param bottom - insets from the bottom
	 * @param right - insets from the right
	 * @note setGuiInsets() has two methods, the other method takes a single parameter.
	 */
	public void setGuiInsets(int top, int left, int bottom, int right){
		jinsets = new Insets(top, left, bottom, right);
		gbConst.insets = jinsets;	//this spaces components apart
	}
	
	/**
	 * setGuiInsets(): mutator - sets Insets object
	 * @param inset - top=left=bottom=right
	 * @note setGuiInsets() has two methods, the other method takes four parameters.
	 */
	public void setGuiInsets(int inset){
		jinsets = new Insets(inset,inset,inset,inset);
		gbConst.insets = jinsets;	//this spaces components apart
	}
	
	/**
	 * setGuiTitle(): mutator - sets title of frame window
	 * @param title - the title
	 */
	public void setGuiTitle(String title){ sTitle = title; }
	
	/**
	 * getGuiTitle(): accessor - returns title of frame window
	 * @return sTitle
	 */
	public String getGuiTitle(){ return sTitle;	}
	
	/**
	 * setGuiXYPos(): mutator - sets the window's x- and y- axes
	 * @param xPos - Java frame of reference w.r.t. x-axis position
	 * @param yPos - Java frame of reference w.r.t. y-axis position
	 *
	public void setGuiXYPos(int xPos, int yPos){
		this.xPos = xPos;
		this.yPos = yPos;
	}*/
	
	/**
	 * getGuiXYPos(): accessor - returns the window's x-y positions
	 * @return integer array x-y positions
	 *
	public int[] getGuiXYPos(){
		int pos[] = {this.xPos, this.yPos}; //array constant definition
		return pos;
	}*/
	
	/**
	 * setGuiDimenion(): mutator - sets window's x- and y- axes <br>and width and height dimensions, respectively.
	 * @param xPos - Java frame of reference w.r.t. x-axis position
	 * @param yPos - Java frame of reference w.r.t. y-axis position
	 * @param width - dimension along the x-axis
	 * @param height - dimension along the y-axis
	 */
	public void setGuiDimension(int xPos, int yPos, int width, int height){
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}
	
	/**
	 * getGuiDimension(): accessor - returns window's x- & y- axes <br>and width & height dimensions, respectively.
	 * @return dimension - array of [xpos, ypos, width, height] in this order
	 */
	public int[] getGuiDimension(){ //int dimension[] = {1,2};
		int[] dimension = {this.xPos, this.yPos, this.width, this.height};
		return dimension;
	}
	
	/**
	 * setGuiTextAreaRColor(): mutator - collects three integer parameters in the range from 0-255
	 * @param i : 0 <= i-range <= 255
	 * @param j : 0 <= j-range <= 255
	 * @param k : 0 <= k-range <= 255
	 */
	public void setGuiTextAreaRColor(int i, int j, int k){
		try {
			this.i = i;
			this.j = j;
			this.k = k;
			int x = (int)(Math.random()*(this.i*256));
			int y = (int)(Math.random()*(this.j*256));
			int z = (int)(Math.random()*(this.k*256));
			color = new Color(x,y,z);
		}catch(Exception err){err.printStackTrace();}
	}
		
	/**
	 * setGuiTextAreaColor(): mutator - collects three integer parameters in the range from 0-255
	 * @param i - 0 <= range <= 255
	 * @param j - 0 <= range <= 255
	 * @param k - 0 <= range <= 255
	 */
	public void setGuiTextAreaColor(int i, int j, int k){
		this.i = i;
		this.j = j;
		this.k = k;
		color = new Color(i,j,k);
	}
		
	/**
	 * setGuiTextAreaColor(): mutator - collects a single integer parameter for color setting
	 * @param c - 0 <= range <= 255
	 */
	public void setGuiTextAreaColor(int c){
		i = j = k = c;
		color = new Color(c);
	}
		
	/**
	 * getGuiColor(): accessor - returns color
	 * @return color
	 */
	public Color getGuiColor(){
		try {
			return color;
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * isGuiPanelBdrEnabled(): mutator - enables border to JPanel component
	 * @param jpl - JPanel border enable
	 */
	public void isGuiPanelBdrEnabled(boolean jpl){this.jpl = jpl;}
	
	/**
	 * hasGuiPanelBdrEnabled(): accessor - returns boolean value
	 * @return jpl - true/false
	 */
	public boolean hasGuiPanelBdrEnabled(){
		try{
			if(jpl){
				return jpl;
			}
		}catch(Exception err){err.printStackTrace();}
		return false;
	}
		
	/**
	 * isGuiVisible(): mutator - displays the frame window
	 * @param bVisible - true makes frame window visible, false otherwise
	 * @param bResizable - true resizes allows for frame window resizing, false otherwise
	 */
	public void isGuiVisible(boolean visible, boolean resizable) {
		try {
			frameDimension();
			if(hasGuiPanelBdrEnabled()) jPanel.setBorder(border);
			
			if(visible){
				setVisible(visible);
				setResizable(resizable);
				setTitle(getGuiTitle());
			} else {
				setVisible(false);
				setResizable(false);
				setTitle("");
			}
		}catch(Exception err) {err.printStackTrace();}
	}
	
	/**
	 * setGuiTextFieldWidth(): mutator - sets the width of the JTextField & font-size of JTextArea, respectively.
	 * @param iTxtWidth : width of JTextField (of type integer)
	 * @param fsize : font-size of JTextArea (of type integer)
	 */
	public void setGuiTxtFieldWidthTxtAreaFont(int iTxtWidth, int fsize){ 
		this.iTxtWidth = iTxtWidth;
		this.fsize = fsize;
	}
	
	/**
	 * getGuiTxtFieldWidthTxtAreaFont(): returns width of JTextfield & font-size of JTextArea
	 * @return prop - array of [jTextFieldWidth, jTextAreaFontsize] in this order
	 */
	public int[] getGuiTxtFieldWidthTxtAreaFont(){ 
		int prop[] = {this.iTxtWidth, this.fsize};
		return prop;
	}
	
	/**
	 * setGuiTextRowColSpan(): mutator - sets the width/row & height/column span of the JTextArea
	 * @param row - rowspan of JTextArea (of type integer)
	 * @param col - colspan of JTextArea (of type integer)
	 */
	public void setGuiTextRowColSpan(int row, int col){ 
		ispan = row;
		jspan = col;
	}
	
	/**
	 * getGuiTextRowColSpan(): accessor - returns the width/row & height/column span of the JTextArea
	 * @return span - array of [rowspan, colspan] in this order
	 */
	public int[] getGuiTextRowColSpan(){
		//since names do not coincide, no this-keyword is used for instance variables
		int span[] = {ispan, jspan};
		return span;
	}
	
	/**
	 * setGuiIntegerField(): mutator - converts an integer parameter to string to store in JTextField
	 * @notes auto-boxes primitive iValue to Wrapper Object String
	 * @param jtext - of type JTextField
	 * @param iValue - of type integer
	 */
	public void setGuiIntegerField(JTextField jtext, int iValue){
		this.jtext = jtext;
		this.jtext.setText(String.valueOf(iValue));
	}
	
	/**
	 * getGuiIntegerField(): accessor - returns a parsed integer via auto-unbox
	 * @notes auto-unbox string value (jtext) to primitive type int
	 * @return - integer
	 */
	public int getGuiIntegerField(){ return Integer.parseInt(this.jtext.getText()); }
		
	/**
	 * setGuiDoubleField(): mutator - converts a double parameter to string to store in JTextField
	 * @notes auto-boxes primitive dValue to Wrapper Object String
	 * @param jtext - of type JTextField
	 * @param dValue - of type double
	 */
	public void setGuiDoubleField(JTextField jtext, double dValue){
		this.jtext = jtext;
		this.jtext.setText(String.valueOf(dValue));
	}
	
	/**
	 * getGuiDoubleField(): accessor - returns a parsed double via autoboxing 
	 * @notes auto-unbox string value (jtext) to primitive type double
	 * @return - double
	 */
	public double getGuiDoubleField(){ return Double.parseDouble(jtext.getText()); }
	
	/**
	 * setGuiStringField(): mutator - sets/writes texts to a JTextField component
	 * @param jtext - of type JTextField
	 * @param sValue - of type String
	 */
	public void setGuiStringField(JTextField jtext, String sValue){
		this.jtext = jtext;
		this.jtext.setText(sValue);
	}
	
	/**
	 * getGuiStringField(): accessor - retrieves and returns text from JTextField
	 * @return jtext
	 */
	public String getGuiStringField(){ return this.jtext.getText(); }
	
	/**
	 * frameLayout(): mutator - sets the layout for frame window
	 */
	public void frameLayout(){
		jPanel.setLayout(gbLayout);
		//setFont(new Font("SansSerif", Font.PLAIN, getGuiTextAreaFont()));
		setFont(new Font("SansSerif", Font.PLAIN, getGuiTxtFieldWidthTxtAreaFont()[1]));
		add(jPanel);
	}
		
	/**
	 * frameDimension(): facilitator - repositions window if need be
	 * @notes invoke method only when with and height of frame are set
	 */
	public void frameDimension(){
		if(this.width > 20 && this.height > 20){
			setSize(new Dimension(getGuiDimension()[2], getGuiDimension()[3]));
		} else {
			setSize(getGuiDimension()[2], getGuiDimension()[3]);
		}
	}
		
	/**
	 * frameExit(): facilitator - closes frame window when user x'd out
	 */
	public void frameExit(){
		addWindowListener(new WinListener());
		//setDefaultCloseOperation(GBJFrame.EXIT_ON_CLOSE);	//works
	}
	
	/**
	 * frameLocation(): mutator - positions current window in designated spot
	 */
	public void frameLocation() {
		try {
			if((this.xPos==0 && this.yPos==0) || ((this.xPos==this.width) && (this.yPos==this.height))){
				//This will center the JFrame in the middle of the screen
				setLocationRelativeTo(null);
			}else{
				//moves the window to a new location
				setBounds(this.xPos, this.yPos, this.width, this.height);
			}
		} catch (Exception err) {err.printStackTrace();}
	}
		
	/**
	 * contentPane(): mutator - sets background of window container
	 */
	public void frameContentPane() {
		Container div = getContentPane();
		div.setBackground(getGuiColor()); // null = use default color
	}
	
	/**
	 * addTextArea(): mutator - adds legend to frame window
	 * @param title : title of JTextArea
	 * @param row : gridx - vertical position of component
	 * @param col : gridy - horizontal position of component
	 * @param ipx : ipadx - vertical padding of component
	 * @param ipy : ipady - horizontal padding of component
	 * @param wx : weightx - if>0, stretches component size horizontally
	 * @param wy : weighty - if>0, stretches component size vertically
	 * @param gw : gridwidth - stretches component size horizontally (if>1, add gbConst.fill)
	 * @param gh : gridheight - stretches component size vertically (if>1, add gbConst.fill)
	 * @param e : true for editable text-area, false otherwise
	 */
	public JTextArea addTextAreaScroll(String title, int row, int col, int ipx, int ipy, double wx, double wy, int gw, int gh, boolean e){
		try {
			sTxtAreaTitle = title;
			//JTextArea jTextArea = new JTextArea(sTxtAreaTitle, getGuiTextRowSpan(), getGuiTextColSpan());
			JTextArea jTextArea = new JTextArea(sTxtAreaTitle, getGuiTextRowColSpan()[0], getGuiTextRowColSpan()[1]);
			jTextArea.setEditable(e);
			jTextArea.setLineWrap(true);
			jTextArea.setWrapStyleWord(true);
			//jTextArea.setFont(new Font("Serif", Font.ITALIC, getGuiTextAreaFont()));
			jTextArea.setFont(new Font("Serif", Font.ITALIC, getGuiTxtFieldWidthTxtAreaFont()[1]));
			jTextArea.setBackground(getGuiColor()); 	//window.getBackground() or Color.WHITE
			
			gbConst.gridx = row;
			gbConst.gridy = col;
			gbConst.weightx = wx;
			gbConst.weighty = wy;
			//gbConst.fill = GridBagConstraints.HORIZONTAL; //Horizontal, vertical
			gbConst.gridwidth = gw;		//uses gbConst.fill = GridBagConstraints.HORIZONTAL
			gbConst.gridheight = gh;	//uses gbConst.fill = GridBagConstraints.VERTICAL
			gbConst.ipadx = ipx;
			gbConst.ipady = ipy;
			//gbConst.anchor = GridBagConstraints.NORTH;
			gbLayout.setConstraints(jTextArea, gbConst);
			
			JScrollPane jScrollPane = new JScrollPane(jTextArea);//, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
			jScrollPane.setVisible(true);
			jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			jScrollPane.setPreferredSize(new Dimension(this.width, this.height));
			return (JTextArea)jPanel.add(jScrollPane);
		} catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * addTextArea(): pins down legend to frame window
	 * @param title : title of JTextArea
	 * @param row : gridx - vertical position of component
	 * @param col : gridy - horizontal position of component
	 * @param ipx : ipadx - vertical padding of component
	 * @param ipy : ipady - horinzontal padding of component
	 * @param wx : weightx - if>0, stretches component size horizontally
	 * @param wy : weighty - if>0, stretches component size vertically
	 * @param gw : gridwidth - stretches component size horizontally (if>1, add gbConst.fill)
	 * @param gh : gridheight - stretches component size vertically (if>1, add gbConst.fill)
	 * @param b : true to enable border around JTextArea, false otherwise
	 * @param e : true to enable editable JTextArea, false otherwise
	 * @param hor : true to fill constraints in horizontal direction, false otherwise
	 * @param ver : true to fill constraints in vertical direction, false otherwise
	 */
	public JTextArea addTextArea(String title, int row, int col, int ipx, int ipy, double wx, double wy, int gw, int gh, 
			boolean b, boolean e, boolean hor, boolean ver){
		try {
			sTxtAreaTitle = title;
			//JTextArea jTextArea = new JTextArea(sTxtAreaTitle, getGuiTextRowSpan(), getGuiTextColSpan());
			JTextArea jTextArea = new JTextArea(sTxtAreaTitle, getGuiTextRowColSpan()[0], getGuiTextRowColSpan()[1]);
			//jTextArea.setEditable(hasGuiTextAreaEditable());
			jTextArea.setLineWrap(true);
			jTextArea.setWrapStyleWord(true);
			//jTextArea.setFont(new Font("Serif", Font.ITALIC, getGuiTextAreaFont()));
			jTextArea.setFont(new Font("Serif", Font.ITALIC, getGuiTxtFieldWidthTxtAreaFont()[1]));
			jTextArea.setBackground(getGuiColor()); 	//window.getBackground() or Color.WHITE
			jTextArea.setEditable(e); //jTextArea.setRows(gw); jTextArea.setColumns(gh);
			if(b) jTextArea.setBorder(border);
			jTextArea.setSize(gw, gh);
			
			gbConst.gridx = row;
			gbConst.gridy = col;
			gbConst.weightx = wx;
			gbConst.weighty = wy;
			if(hor) gbConst.fill = GridBagConstraints.HORIZONTAL;	//Horizontal
			if(ver) gbConst.fill = GridBagConstraints.VERTICAL;		//Vertical
			gbConst.gridwidth = gw;		//uses gbConst.fill = GridBagConstraints.HORIZONTAL
			gbConst.gridheight = gh;	//uses gbConst.fill = GridBagConstraints.VERTICAL
			gbConst.ipadx = ipx;
			gbConst.ipady = ipy;
				
			gbConst.anchor = GridBagConstraints.NORTH;
			gbLayout.setConstraints(jTextArea, gbConst);
			return (JTextArea)jPanel.add(jTextArea);
			
		} catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * addTextField(): pins JTextField component to frame window
	 * @param row : gridx - vertical position of component
	 * @param col : gridy - horizontal position of component
	 * @param ipx : ipadx - vertical padding of component
	 * @param ipy : ipady - horinzontal padding of component
	 * @param wx : weightx - if>0, stretches component size horizontally
	 * @param wy : weighty - if>0, stretches component size vertically
	 * @param gw : gridwidth - stretches component size horizontally (if>1, add gbConst.fill)
	 * @param gh : gridheight - stretches component size vertically (if>1, add gbConst.fill)
	 * @param b : true to enable border on JTextField, false otherwise
	 * @param e : true to enable editable JTextField, false otherwise
	 * @param a : true to enable center justified, false otherwise for left-justified
	 * @param r : true enables gbc.gridwidth=contraints.relative, false for gbc.gridwidth=gw 
	 */
	public JTextField addTextField(int row, int col, int ipx, int ipy, double wx, double wy, int gw, int gh, 
			boolean b, boolean e, boolean a, boolean r){
		try {
			int txtfield = 0;
			//JTextField jTextField = new JTextField(getGuiTextFieldWidth());
			JTextField jTextField = new JTextField(getGuiTxtFieldWidthTxtAreaFont()[0]);
			jTextField.setEditable(e);
			if(b) jTextField.setBorder(border);
			if(a) txtfield = JTextField.CENTER;
			else txtfield = JTextField.LEFT;
			
			gbConst.gridx = row;
			gbConst.gridy = col;
			gbConst.weightx = wx;
			gbConst.weighty = wy;
			if(r) gbConst.gridwidth = GridBagConstraints.RELATIVE;
			else gbConst.gridwidth = gw;		//uses gbConst.fill = GridBagConstraints.HORIZONTAL
			gbConst.gridheight = gh;	//uses gbConst.fill = GridBagConstraints.VERTICAL
			//gbConst.gridwidth = GridBagConstraints.RELATIVE; //relative or remainder
			gbConst.ipadx = ipx;
			gbConst.ipady = ipy;
				
			gbLayout.setConstraints(jTextField, gbConst);
			return (JTextField) jPanel.add(jTextField, txtfield);
			
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
		
	/**
	 * addButton(): pins JButton to frame window
	 * @param title - title of JButton
	 * @param row : gridx - horizontal position of component
	 * @param col : gridy - horizontal position of component
	 * @param ipx : ipadx - vertical padding of component
	 * @param ipy : ipady - horinzontal padding of component
	 * @param wx : weightx - if>0, stretches component size horizontally
	 * @param wy : weighty - if>0, stretches component size vertically
	 * @param gw : gridwidth - stretches component size horizontally (if>1, add gbConst.fill)
	 * @param gh : gridheight - stretches component size vertically (if>1, add gbConst.fill)
	 * @param b : true to enable border on JButton, false otherwise
	 * @note if border is enabled, ipx & ipy paddings on button is disregarded
	 * @param a : true to enable center justified, false otherwise for left-justified
	 * @param r : true enables gbc.gridwidth=contraints.relative, false for gbc.gridwidth=gw 
	 */
	public JButton addButton(String title, int row, int col, int ipx, int ipy, double wx, double wy, int gw, int gh, 
			boolean b, boolean a, boolean r){
		try {
			int jBtn = 0;
			JButton jButton = new JButton(title);
			if(b) jButton.setBorder(border);
			jButton.setBounds(row, col, ipx, ipy); //(row,col,gw,gh);
			if(a) jBtn = JButton.CENTER;
			else jBtn = JButton.LEFT;
			
			gbConst.gridx = row;
			gbConst.gridy = col;
			gbConst.weightx = wx;
			gbConst.weighty = wy;
			if(r) gbConst.gridwidth = GridBagConstraints.REMAINDER;
			else gbConst.gridwidth = gw;		//uses gbConst.fill = GridBagConstraints.HORIZONTAL
			gbConst.gridheight = gh;	//uses gbConst.fill = GridBagConstraints.VERTICAL
			//gbConst.gridwidth = GridBagConstraints.RELATIVE;
			gbConst.ipadx = ipx;
			gbConst.ipady = ipy;
			
			gbLayout.setConstraints(jButton, gbConst);			
			return (JButton) jPanel.add(jButton, jBtn);
			
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
		
	/**
	 * addLabel(): pins JLabel to frame window
	 * @param title - title that goes into JLabel
	 * @param row : gridx - horizontal position of component
	 * @param col : gridy - vertical position of component
	 * @param ipx : ipadx - vertical padding of component
	 * @param ipy : ipady - horinzontal padding of component
	 * @param wx : weightx - if>0, stretches component size horizontally
	 * @param wy : weighty - if>0, stretches component size vertically
	 * @param gw : gridwidth - stretches component size horizontally (if>1, add gbConst.fill)
	 * @param gh : gridheight - stretches component size vertically (if>1, add gbConst.fill)
	 * @param b : true to enable border on JLable, false otherwise
	 */
	public JLabel addLabel(String title, int row, int col, int ipx, int ipy, double wx, double wy, int gw, int gh, boolean b){
		try {
			JLabel jLabel = new JLabel(title);
			if(b) jLabel.setBorder(border);
			gbConst.gridx = row;
			gbConst.gridy = col;
			gbConst.gridwidth = gw;		//uses gbConst.fill = GridBagConstraints.HORIZONTAL
			gbConst.gridheight = gh;	//uses gbConst.fill = GridBagConstraints.VERTICAL
			gbConst.ipadx = ipx;
			gbConst.ipady = ipy;
			gbConst.weightx = wx;
			gbConst.weighty = wy;
			
			gbLayout.setConstraints(jLabel, gbConst);
			return (JLabel) jPanel.add(jLabel, JLabel.CENTER);
			
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
		
	//main(): application entry point - this is namely for testing purposes ... delete when done testing gui
	public static void main(String args[]){
		
		String text = "Hi, you're now viewing the modelview GUI by Didum";
		//GBJFrame refGui = new GBJFrame("GBFrame GUI", text, 14, 700,50, 300,180, 120,115,255, 5,5,5,5, true, 20,5,20);
		GBJFrame refGui = new GBJFrame();
		refGui.setGuiTitle("GBFrame GUI by Didum");
		refGui.setGuiDimension(700, 50, 300, 200);
		
		//for color (245,245,245), (120,255,115), (256,0,0)=red
		refGui.setGuiTextAreaColor(255,255,255); refGui.setGuiInsets(3); 
		refGui.isGuiPanelBdrEnabled(true); 
		refGui.setGuiTxtFieldWidthTxtAreaFont(20,13);
		refGui.setGuiTextRowColSpan(5,20);
		
		refGui.frameLocation();
		refGui.addTextArea(text, 0,0, 0,0, 0,0, 3,1, true, false, true, false);
		refGui.addLabel("MyLabel-1", 0,1, 5,4, 0,0, 1,1, true); 
		refGui.addTextField(1,1, 95,4, 0,0, 1,1, true, true, false, false);
		refGui.addButton("Send", 2,1, 0,4, 0,0, 1,1, true, true, false);
		
		refGui.addLabel("MyLabel-2", 0,2, 5,4, 0,0, 1,1, true); 
		refGui.addTextField(1,2, 95,4, 0,0, 1,1, true, true, false,false);
		refGui.addTextField(2,2, 50,4, 0,0, 1,1, true, true, false, false);
		
		refGui.isGuiVisible(true, false);
		
		//testing
		//pt.println(1+2+"3");	//33
		//pt.println(1+2+'3');	//54
		//pt.println("3"+1+2);	//312
		//pt.println("3"+(1+2));	//33
	}
}
/*
 * if import javax.servlet is highlighted,
 * add library (myservlet)
 * navigate to j2eetools->apache-tomcate->servlet-api.jar 
 */
