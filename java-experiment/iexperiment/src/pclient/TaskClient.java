/**
 * 
 */
package pclient;
import callable.io.Print;
import pconcrete.TaskDesign;
/**
 * TaskClient: client class to demonstrate model and view
 * @author A., Didum
 * @see pconcrete.TaskDesign
 */
public class TaskClient extends Object {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TaskDesign refTm = new TaskDesign();
		Print view = new Print();
		
		view.println("Number of lines: "+refTm.lineCount());
		view.println(refTm.toString());
		view.println(refTm.taskValidation());
		//view.println(refTm.getTaskName());
		//view.println(refTm.getTaskDescription());
	}

}
