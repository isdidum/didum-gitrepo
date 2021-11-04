package gui.applets.layouts;

//Use the GridBagConstraints to determine how the component
//is displayed within the GridBagLayout. ipadx and ipady are used
//to pad the component within the cell(s). The weightx and weighty
//are used to give a weighting to the component to specify how the
//any extra space is handled by a row or column. gridx and gridy are
//the position coordinates for the component within the grid. fill 
//determines what happens to sizing of a component if it doesn't completely
//fill its cell. gridwidth and gridheight specify how many cells (either 
//in a row or column) the component will take up.

//Imports are listed in full to show what's being used
//could just import javax.swing.* and java.awt.* etc..

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;


public class GridBadlayout {
  JFrame guiFrame, newFrame;
  GridBagConstraints cons;
  GridBagLayout gridBag;
  JPanel compPanel;
  
  public GridBadlayout() {
      guiFrame = new JFrame();
      newFrame = new JFrame("Child GridBagLayout");
      
      //make sure the program exits when the frame closes
      guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      guiFrame.setTitle("Parent GridBagLayout");
      guiFrame.setSize(600,300);
    
      //This will center the JFrame in the middle of the screen
      guiFrame.setLocationRelativeTo(null);
      
      //creating a border to highlight the component areas
      Border outline = BorderFactory.createLineBorder(Color.black);
      
      //create GribBagLayout and the GridBagLayout Constraints
      gridBag = new GridBagLayout();
      cons = new GridBagConstraints();
      
      cons.fill = GridBagConstraints.BOTH;
      
      compPanel = new JPanel();
      compPanel.setLayout(gridBag);
      
      cons.gridx = 2;
      cons.gridy = 2;
      JLabel randomLbl = new JLabel("In Xanadu did Kubla Khan, A stately pleasure-dome decree");
      randomLbl.setBorder(outline);
      gridBag.setConstraints(randomLbl, cons);
      compPanel.add(randomLbl);
      
      //Use the GridBagConstraints to determine how the component
      //is displayed within the GridBagLayout. ipadx and ipady are used
      //to pad the component within the cell(s). The weightx and weighty
      //are used to give a weighting to the component to specify how
      //any extra space is handled by a row or column. gridx and gridy are
      //the position coordinates for the component within the grid. fill 
      //determines what happens to sizing of a component if it doesn't completely
      //fill its cell. gridwidth and gridheight specify how many cells (either 
      //in a row or column) the component will take up.

      cons.ipady = 100;
      cons.ipadx = 100;
      cons.weighty = 1.0;
      //cons.weightx = 1.0;
      cons.gridx = 0;
      cons.gridy = 0;
      JLabel tallLbl = new JLabel("Tall and Long");
      tallLbl.setBorder(outline);
      gridBag.setConstraints(tallLbl, cons);
      compPanel.add(tallLbl);
             
      cons.ipady = 50;
      cons.ipadx = 100;
      cons.weightx = 0;
      cons.gridx = 0;
      cons.gridy = 1;
      JButton hello = new JButton("Hello");
      gridBag.setConstraints(hello, cons);
      compPanel.add(hello);
      
      cons.ipady = 100;
      cons.ipadx = 10;
      cons.gridx = 1;
      cons.gridy = 1;
      JButton goodbye = new JButton("GoodBye");
      gridBag.setConstraints(goodbye, cons);
      compPanel.add(goodbye);
      
      cons.weightx = 0;
      cons.gridx = 0;
      cons.gridy = 2;
      JButton eh = new JButton("eh?");
      gridBag.setConstraints(eh, cons);
      compPanel.add(eh);
      
      guiFrame.add(compPanel);
      guiFrame.setVisible(true);	//change to true
      
      //***********************************************************************
      newFrameWindow();
      newFrame.setLayout(gridBag);
      newFrame.setSize(350, 300);
      newFrame.setBounds(700, 100, 350, 300);
      newFrame.setVisible(false);
      newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  private void newFrameWindow(){
	  JButton gbtn = new JButton("Btn1");
	  cons.gridx = 0;
	  cons.gridy = 0;
	  
	  cons.weightx = 0;
	  cons.weighty = 0;
	  
	  cons.gridwidth = 1;
	  cons.gridheight = 1;
	  
	  cons.ipadx = 1;
	  cons.ipady = 1;
	  gridBag.setConstraints(gbtn, cons);
	  //cons.fill = GridBagConstraints.VERTICAL;
	  
	  newFrame.add(gbtn);
	  //----------------------------------
	  JButton gbtn2 = new JButton("Btn2");
	  cons.gridx = 1;
	  cons.gridy = 1;
	  
	  cons.weightx = 0;
	  cons.weighty = 0;
	  
	  cons.gridwidth = 1;
	  cons.gridheight = 1;
	  
	  cons.ipadx = 1;
	  cons.ipady = 1;
	  gridBag.setConstraints(gbtn2, cons);
	  newFrame.add(gbtn2);
	  //--------------------------------------
	  JButton gbtn3 = new JButton("Btn3");
	  cons.gridx = 2;
	  cons.gridy = 2;
	  
	  cons.weightx = 0;
	  cons.weighty = 0;
	  
	  cons.gridwidth = 1;
	  cons.gridheight = 1;
	  
	  cons.ipadx = 1;
	  cons.ipady = 1;
	  gridBag.setConstraints(gbtn3, cons);
	  newFrame.add(gbtn3);
	  //----------------------------------------
	  JButton gbtn4 = new JButton("Btn4");
	  cons.gridx = 3;
	  cons.gridy = 3;
	  
	  cons.weightx = 0;
	  cons.weighty = 0;
	  
	  cons.gridwidth = 1;
	  cons.gridheight = 1;
	  
	  cons.ipadx = 1;
	  cons.ipady = 1;
	  gridBag.setConstraints(gbtn4, cons);
	  newFrame.add(gbtn4);
	  //-----------------------------------------
	  JButton gbtn5 = new JButton("Btn5");
	  cons.gridx = 2;
	  cons.gridy = 4;
	  
	  cons.weightx = 2;		//stretches component horizontally, hence stretches all components in this column
	  cons.weighty = 0;
	  
	  cons.gridwidth = 1;
	  cons.gridheight = 1;
	  
	  cons.ipadx = 1;
	  cons.ipady = 1;
	  gridBag.setConstraints(gbtn5, cons);
	  newFrame.add(gbtn5);
  }
  
  public static void main(String[] args) {
      //Use the event dispatch thread for Swing components
      EventQueue.invokeLater(new Runnable(){
         @Override
          public void run() {
              new GridBadlayout();         
          }
      });       
 }
  
}

