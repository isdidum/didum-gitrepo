package gui.swingapps.dnloads;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author A., Didum
 * @date February 21, 2013
 * @description PerformsDowload(): concrete class that performs actual downloading of a file
 */
public class PerformsDownload extends Observable implements Runnable{
	//max size of download buffer
	private static final int MAX_BUFFER_SIZE = 1024;
	//status names
	public static final String STRATUSES[] = {"Downloading", "Pause", "Complete", "Cancelled", "Error"};
	//status codes
	public static final int DOWNLOADING = 0;
	public static final int PAUSED = 1;
	public static final int COMPLETE = 2;
	public static final int CANCELLED = 3;
	public static final int ERROR = 4;
	
	//instance vars
	private URL url;		//download url
	private int size;		//size of download in bytes
	private int downloaded;	//number of bytes downloaded
	private int status;		//current status of download
	
	/**
	 * PerformsMainDownload(): specific constructor
	 */
	public PerformsDownload(URL url) {
		this.url = url;
		size = -1;
		downloaded = 0;
		status = DOWNLOADING;
	
		//begin the download
		download();
	}
	
	/**getUrl(): accessor - gets download's url*/
	public String getUrl() throws Exception{
		return url.toString();
	}
	
	/**getSize(): accessor - gets download's size*/
	public int getSize() throws Exception{
		return size;
	}
	
	/**getProgress(): accessor - gets download's progress*/
	public float getProgress() throws Exception{
		return ((float) downloaded /size) * 100;
	}
	
	/**getStaus(): accessor - gets download's status*/
	public int getStatus() throws Exception{
		return status;
	}
	
	/**pause(): mutator - pauses download*/
	public void pause() throws Exception{
		status = PAUSED;
		stateChanged();
	}
	
	/**resume(): mutator - resumes download*/
	public void resumel() throws Exception{
		status = DOWNLOADING;
		stateChanged();
		download();
	}
	
	/**cancel(): mutator - cancel download*/
	public void cancel() throws Exception{
		status = CANCELLED;
		stateChanged();
	}
	
	/**error(): mutator - mark download as having an error*/
	private void error(){
		try {	
			status = ERROR;
			stateChanged();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**download(): mutator - start/resume downloading*/
	private void download(){
		Thread thread = new Thread(this);
		thread.start();
	}
	
	/**getFileName(): accessor - gets file name portion of url*/
	public String getFileName(URL url) throws Exception{
		String fileName = url.getFile();
		return fileName.substring(fileName.lastIndexOf('/') + 1);
	}
	
	/**run(): mutator - abstract run implementation of the Interface Runnable*/
	public void run(){
		RandomAccessFile file = null;
		InputStream stream = null;
		try {
			//open connecton to URL
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			//specify what portion of the file to download
			connection.setRequestProperty("Range", "bytes="+ downloaded +"-");
			
			//connect to server
			connection.connect();
			
			//make sure response code is in the 200 range
			int contentLength = connection.getContentLength();
			if(contentLength < 1) {
				error();
			}
			
			//set the size of this download if it hasn't alread set
			if(size == -1) {
				size = contentLength;
				stateChanged();
			}
			
			//openfile and seek to the end of it
			file = new RandomAccessFile(getFileName(url), "rw");
			file.seek(downloaded);
			
			stream = connection.getInputStream();
			while(status == DOWNLOADING) {
				//size buffer according to how much of the file is left to download
				byte buffer[];
				if((size - downloaded) > MAX_BUFFER_SIZE) {
					buffer = new byte[MAX_BUFFER_SIZE];
				} else {
					buffer = new byte[size-downloaded];
				}
				
				//read from server into buffer
				int read = stream.read(buffer);
				if(read == -1) {
					break;
				}
				
				//write buffer to file
				file.write(buffer, 0, read);
				downloaded += read;
				stateChanged();
			}
			
			//change status to complete if this point was reached because downloading has finished
			if(status == DOWNLOADING) {
				status = COMPLETE;
				stateChanged();
			}
		} catch (Exception e) {
			error();
		} finally {
			//close file
			if(file != null) {
				try {
					file.close();
				} catch(Exception e) {}
			}
			
			//close connection to server
			if(stream != null) {
				try {
					stream.close();
				} catch (Exception e) {}
			}
		}
	}
	
	/**stateChanged(): mutator - notify observers that this download's status has changed*/
	private void stateChanged() {
		setChanged();
		notifyObservers();
	}
}
