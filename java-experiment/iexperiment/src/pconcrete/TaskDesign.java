package pconcrete;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import callable.file.ReadFile;

/**
 * TaskDesign: Stores the name and description of one task and provides these on demand
 * @author A., Didum
 * @date August 07, 2013
 * @see pconcrete.TaskListModel
 * @see pclient.TaskClient
 */
public class TaskDesign extends ReadFile {
	//private ReadFile readFile;
	private Properties prop = new Properties();
	private String filePath = "C:/Users/Didum/Documents/wksp/java/iexperiment/src/collections/property/text/";
	private String src = "nmtask.txt";
	
	private String name, desc;
	private boolean noname=false, nodesc=false;
	
	/**
	 * TaskDesign(): default constructor
	 */
	public TaskDesign() {
		name = ""; desc = "";
		loadTask();
	}
	
	/**
	 * TaskDesign(): specific or parameterized constructor
	 * @param nm - name of a person
	 * @param desc - description of task associated with a person's name
	 */
	public TaskDesign(String nm, String desc){
		name = nm; this.desc = desc;
		loadTask();
	}
	
	/**
	 * TaskDesign(): specific constructor object
	 * @param task - Task object
	 */
	public TaskDesign(TaskDesign task){
		name = task.name;
		desc = task.desc;
		loadTask();
	}
	
	/**
	 * loadTask(): mutator - loads the name and task description via properties <br /> 
	 * as key & value element pairs, respectively
	 */
	protected void loadTask(){
		int i=0;
		FileInputStream inputStream = null;
		try {
			//property methods: load(), put(), store()
			inputStream = new FileInputStream(filePath + src);
			prop.load(inputStream);
			inputStream.close();
			
			for(String key : prop.stringPropertyNames()) {
				String value = (String)prop.getProperty(key);
				setTask(key, value); //name = key; desc = value;
				if(i == prop.size()-1) continue;
				i++;
			}
		} catch(IOException err) {err.printStackTrace();}
	}
	
	/**
	 * setTask(): mutator - stores the name & description of one task
	 * @param nm - name of person
	 * @param desc - description of task
	 */
	public void setTask(String nm, String desc){
		try{
			name = nm;
			this.desc = desc;
		}catch(Exception err){err.printStackTrace();}
	}
	
	/**
	 * getName(): accessor - returns the name on demand
	 * @return name
	 */
	public String getName(){
		try{
			return name;
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * getDescription(): accessor - returns the description of task on demand
	 * @return desc - description of task
	 */
	public String getDescription(){
		try{
			return desc;
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * hasTask(): facilitator - validates that a task consists of name-description pairs
	 * @return boolean - true if name and description are not empty, false otherwise
	 */
	public boolean hasTask(){
		try{			
			if(getName().isEmpty() || getName().equals("")){
				return noname;
			}else if(getDescription().isEmpty() || getDescription().equals("")){
				return nodesc;
			} else if(!getName().equals("") && !getDescription().equals("")){
				noname=true; nodesc=true;
				return true;
			}
		}catch(Exception err){err.printStackTrace();}
		return false;
	}
	
	/**
	 * taskValidation(): facilitator - displays error message if no name-description pairs entered
	 * @return msg - error message
	 */
	public String taskValidation(){
		try{
			if(!hasTask() && noname){
				return "Error: no name, task is incomplete";
			} else if(!hasTask() && nodesc)
				return "Error: no description, task is incomplete";
			else if(hasTask() && noname && nodesc)
				return null; //null means it has task
				
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * toString(): facilitator - displays the content of name and description
	 */
	public String toString(){
		String string = "";
		try{
			string = getName() + ": "+ getDescription();
			return string;
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * lineCount(): accessor - return total number of lines in a file
	 * @return an integer containing number of lines
	 */
	public int lineCount() {
		try {
			setFilePath(filePath + src);
			return getLines()-2;	//-2 indicates comments in input file
		}catch(Exception err) {	err.printStackTrace();}		
		return 0;
	}
}
