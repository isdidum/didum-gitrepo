package gui.swingapps.dnloads;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author A., Didum
 * @date February 21, 2013
 * @description ProgressRenderer(): renders the current progress of a download list in GUI's PeformsDownload JTable instance
 */
public class ProgressRenderer extends JProgressBar implements TableCellRenderer {
	//instance vars
	private static final long serialVersionUID = 1L;
	
	/**ProgressRenderer(): specific constructor*/
	public ProgressRenderer(int min, int max) {
		super(min, max);
	}
	
	/**getTableCellRendererComponent():accessor-return this JProgressar as the renderer for the given table cell*/
	public Component getTableCellRendererComponent(JTable t, Object v, boolean is, boolean hf, int r, int c) {
		//set JProgressBar's percent complete value
		setValue((int) ((Float) v).floatValue());
		return this;
	}

}
