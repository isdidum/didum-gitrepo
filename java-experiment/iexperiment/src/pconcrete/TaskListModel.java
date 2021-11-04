package pconcrete;

//import gui.swingapps.msgbox.MessageBox;

import java.util.ArrayList;
import java.util.List;

import callable.io.Output;

/**
 * TaskListModel: Maintains the to-do list in response to requests from the <br /> class TaskListView 
 * and keeps track of the current task
 * @author A., Didum
 * @date February 28, 2013
 * @see pconcrete.TaskDesign
 */
//-----------------------------------------------------------------------------------
//this is still under construction, please see p.452 of Fundamentals of Java, 2nd Ed
//-----------------------------------------------------------------------------------
public class TaskListModel extends TaskDesign {
	
	//MessageBox msgbox;
	
	/**tdlist is a variable to hold List elements, ArrayList(); it's zero-based naming convention*/
	private List<Object> tdlist;
	
	/**variable to hold current task, initially 0*/
	private int currentTask;
	
	public TaskListModel() {
		currentTask = 0;
		tdlist = new ArrayList<Object>();
		//msgBox("", true);
		TaskDesign task = new TaskDesign(getName(), getDescription());
		tdlist.add(currentTask, task);
	}
	
	/**
	 * hasCurrentPosition(): facilitator - returns true if the model <br />
	 * has a current position; otherwise, returns false
	 * @return currentPosition
	 */
	public boolean hasCurrentPosition() {
		try {
			if(initSize() != 0){
				return false;
			} else {
				return true;
			}
		} catch(Exception err) { err.printStackTrace();	}
		return false;
	}
	
	/**
	 * getTask(): accessor - returns the current task or null if there is none
	 * @return currentTask
	 */
	public TaskDesign getTask() {
		try{
			if(tdlist.isEmpty()){
				//throw new IllegalStateException("Todo list is Empty");
				return null;
			} else {
				//peeks top task
				return (TaskDesign) tdlist.get(initSize() - 1); //(todolist.size() - 1);
			}
		} catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * initSize(): accessor - returns the number of elements in the to-do list
	 * @return task in to-do list
	 */
	public int initSize() {
		try{
			if(tdlist.size() != -1)
				return tdlist.size();
		} catch(Exception err){err.printStackTrace();}
		return 0;
	}
	
	/**
	 * insertBefore(): mutator/accessor - inserts the new task before the current task. <br />The new task becomes
	 * current. Returns an error message if the new task does not have a name or <br /> 
	 * if there was no current task in a nonempty list; otherwise, return null
	 * @param task
	 * @return null or an error message
	 */
	public String insertBefore(TaskDesign task){
		try{
			task = new TaskDesign(getName(), getDescription());
			tdlist.add(currentTask, task);	//inserts
			
			if(taskValidation() != null)
				return taskValidation();	//this already has error messages
			return null;
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * insertAfter(): mutator/accessor - inserts the new task after the current task. <br />The new task becomes
	 * current. Return an error message if the new task does not have a name or <br />
	 * if there was no current task in a nonempty list; otherwise, returns null
	 * @param task
	 * @return null or an error message
	 */
	public String insertAfter(TaskDesign task){
		try{
			task = new TaskDesign(getName(), getDescription());
			tdlist.add(currentTask, task);	//inserts
			
			if(taskValidation() != null)
				return taskValidation();	//this already has error messages
			return null;
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * replace(): mutator/accessor - replaces the current task with task. The new task <br /> becomes
	 * current. Return an error message if the new task does not have a name or <br />
	 * if there was no current task in a nonempty list; otherwise, returns null
	 * @param task
	 * @return null or an error message
	 */
	public String replace(TaskDesign task){
		try{
			task = new TaskDesign(getName(), getDescription());
			tdlist.set(currentTask, task);	//replaces task
			
			if(taskValidation() != null)
				return taskValidation();	//this already has error messages
			return null;
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * remove(): accessor - removes the current task.  If the list becomes empty or <br />
	 * the deleted task was the last task, no task is current; otherwise, the next task becomes <br />
	 * the current task. Returns an error message if there was no task; otherwise, returns null
	 * @return null or an error message
	 */
	public String remove(){
		try{
			//
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * getFirst(): accessor - makes the first task current if there is one. Always returns null
	 * @return
	 */
	public String getFirst(){
		try{
			if(tdlist.size() != -1)
				return (String) tdlist.get(0);	//possible error with array index
			return null;
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * getPrevious(): accessor - makes the previous task current if there one, else no change. <br />
	 * Always returns null
	 * @return null
	 */
	public String getPrevious(){
		try{
			//
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * getNext(): accessor - makes the next task current if there is one, else no change. Always returns null
	 * @return null
	 */
	public String getNext(){
		try{
			//
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * getLast(): accessor - makes the last task current if there is one. Always returns null
	 * @return null
	 */
	public String getLast(){
		try{
			if(tdlist.size() != -1)
				return (String) tdlist.get(initSize()-1);
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * findFirst(): mutator/accessor - starting at the beginning of the list, searches <br />
	 * for a task whose name is the same as the one in the specified task. Makes current <br />
	 * the first instance of a task with this name or leave no task current if the search fails <br />
	 * Returns an error message if the specified task has no name; otherwise, returns null
	 * @param task
	 * @return null or an error message
	 */
	public String findFirst(TaskDesign task){
		try{
			//
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * findNext(): mutator/accessor - starting at the current task, searches for a task <br />
	 * whose name is the same as the one in the specified task. Makes current the first instance <br />
	 * of a task with this name or leaves no task current if the search fails. Returns an error message <br />
	 * if the specified task has no name; otherwise, returns null
	 * @param task
	 * @return null or an error message
	 */
	public String findNext(TaskDesign task){
		try{
			//
		}catch(Exception err){err.printStackTrace();}
		return null;
	}
		
	public static void main(String args[]){
		TaskListModel tlm = new TaskListModel();
		Output.println(tlm.hasCurrentPosition());
		Output.println(tlm.getTask());
		Output.println(tlm.initSize());
		//Output.println(tlm.insertBefore(.args.clone().));
	}

}

