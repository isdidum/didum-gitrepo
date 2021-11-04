/**
 * Author: A., Didum
 * Date: September 16, 2012
 * Purpose: Collectes student's names and three test scores
 */
package proj.jclient;

import proj.jclass.Student;

public class StudentClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Student student = new Student("Dee", 92, 95, 87);		//valid b/c construct has parameters
		//student.name = "Didum";			//rejected by compiler b/c name is private
		
		Student student = new Student("", 0,0,0);
		student.setName("Didum");
		student.setScore(1, (int)91.55);
		student.setScore(2, 84);
		student.setScore(3, 95);
		System.out.println(student.toString());
	}

}
