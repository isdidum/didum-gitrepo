package gui.swingapps.msgbox;

/**
 * MessageBox: created to facilitate message to programs
 * @author A., Didum
 * @date August 4, 2013
 */
public class MessageBox {
	
	//MessageBox(): default constructor
	public MessageBox(){}
	
	//MessageBox(): specific or parameterized constructor
	public MessageBox(String msg, boolean bool) {
		msgBox(msg, bool);
	}
	
	/**
	 * msgBox(): facilitator - displays message in a GUI window
	 * @param msg text to be aired
	 * @param bool accepts true/false value to air <code>msg</code>
	 * @return message
	 */
	public String msgBox(String msg, boolean bool) {
		String str = "";
		try {
			if(bool) {
				str = msg;
				return str;
			} else {
				str = null;
			}
		} catch (Exception err) {err.printStackTrace();}
		return null;
	}
}
