package gui.swingapps.dnloads;

import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author A., Didum
 * @Date February 21, 2013
 * @Description ProgressRenderer(): houses DownloadManger's list of downloads & is the backing data source for GUI's PeformsDownload JTable instance. <br/ >
 *  Manages the download table's data
 */
public class DnloadsTableModel extends AbstractTableModel implements Observer{
	/**serializable class declaration*/
	private static final long serialVersionUID = 1L;
	
	/**names for the table's columns*/
	private static final String columnNames[] = {"Url", "Size", "Progress", "Status"};
	
	/**classes for each column's values*/
	private static final Class<?> columnClasses[] = {String.class, String.class, JProgressBar.class, String.class};
	
	/**the table's list of downloads via ArrayList of PerformsDownload*/
	private ArrayList<PerformsDownload> downloadList = new ArrayList<PerformsDownload>();
	
	/**
	 * @Description DnloadsTableModel(): default constructor
	 */
	public DnloadsTableModel() {
		// TODO Auto-generated constructor stub
	}
	
	/**@Description addDownloade(): mutator - adds a new download to the table*/
	public void addDownload(PerformsDownload download) {
		//register to be notified when the download changes
		download.addObserver(this);
		downloadList.add(download);
		
		//fire table row insertion notification to table
		fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
	}
	
	/**@Description getDownload(): accessor - gets a download from the list*/
	public PerformsDownload getDownload(int row) {
		return downloadList.get(row);
	}
	
	/**@Description clearDownload(): mutator - removes a download from the list*/
	public void clearDownload(int row) {
		downloadList.remove(row);
		
		//fire table row deletion notification to table
		fireTableRowsDeleted(row, row);
	}
	
	/**@Description getColumnCount(): accessor - gets a table's column count*/
	public int getColumnCount() {
		return columnNames.length;
	}
	
	/**@Description getColumnNames(): accessor - gets a column's name*/
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	/**@Description getColumnClass(): accessor - gets column's class*/
	public Class<?> getColumnClass(int col) {
		return columnClasses[col];
	}
	
	/**@Description getRowCount(): accessor - gets table's row count*/
	public int getRowCount() {
		return downloadList.size();
	}
	
	/**@Description getValueAt(): accessor - gets a specific row and column combination*/
	public Object getValueAt(int row, int col) {
		PerformsDownload download = downloadList.get(row);
		switch(col) {
			case 0:	//URL
				try {
					return download.getUrl();
				} catch (Exception e) {};
			case 1:	//Size
				try {
					int size = download.getSize();
					return (size == -1) ? "" : Integer.toString(size);
				} catch (Exception e) {}
			case 2: //Progress
				try {
					return new Float(download.getProgress());
				} catch (Exception e) {}
			case 3: //Status
				try {
					return PerformsDownload.STRATUSES[download.getStatus()];
				} catch (Exception e) {}
		}
		return "";
	}
	
	/**@Description update(): mutator - update is called when a PerformsDownload notifies its observers of any changes*/
	public void update(Observable o, Object arg) {
		int index = downloadList.indexOf(o);
		
		//fire table row update notification to table
		fireTableRowsUpdated(index, index);
	}

}
