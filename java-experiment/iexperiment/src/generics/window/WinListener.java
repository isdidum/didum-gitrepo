package generics.window;
import java.awt.event.*;

/**
 * WinListener: simply closes a JFrame or JApplet window
 * @author A., Didum
 * @date July 20, 2013
 * @notes with implements WindowsListener, you'll force to carry along <br /> 
 * empty override methods-now commented out; however, with extends WindowAdapter, <br /> 
 * overridden methods are no longer needed
 */
//public class WinListener implements WindowListener*/ {
public class WinListener extends WindowAdapter {	
	/**
	 * GenWinListener(): default constructor
	 */
	public WinListener() {}
	
	/**
	 * windowClosing(): closes frame window
	 * @param evt - JFrame.addWindowListener(new WinListener());
	 */
	public void windowClosing (WindowEvent evt){
		try{
			System.exit(0);
		}catch(Exception err){
			err.printStackTrace();
		}
	}
/*
	@Override
	public void windowOpened(WindowEvent e) {}
	
	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}
*/
}
