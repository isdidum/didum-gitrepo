package collections.comparable;

import java.util.*;

import callable.io.Print;
/**
 * StudentGpa: stores student names and their GPA using treeset
 * @author A., Didum
 * @date February 26, 2013
 * @notes Comparable interface imparts natural ordering to classes that implement it for example
 * <p> String elements - alphabetical order<br />
 *  Date elements - chronological order <br />
 *  Integer elements - numerical order</p>
 */
public class StudentGpa implements Comparable<Object> {
	//instance var
	String firstName, lastName;
	int studentID;
	double GPA = 0.0;
	
	/**
	 * StudentGpa(): specific constructor
	 */
	public StudentGpa(String fn, String ln, int id, double GPA) {
		firstName = fn;
		lastName = ln;
		studentID = id;
		this.GPA = GPA;
	}
	
	public String firstName() {
		return firstName;
	}
	
	public String lastName() {
		return lastName;
	}
	
	public int studentID() {
		return studentID;
	}
	
	public double GPA() {
		return GPA;
	}
	
	@Override
	public int compareTo(Object object) {
		double f = GPA - ((StudentGpa)object).GPA;
		if(f == 0.0)
			return 0;		//signifies equals
		else if(f < 0.0)	
			return -1;		//negative value signifies less than or before
		else
			return 1;		//positive value signifies more than or after
	}

	/**
	 * main(): application entry point
	 * @param args
	 */
	public static void main(String[] args) {
		Print view = new Print();
		TreeSet<Object> studentSet = new TreeSet<Object>();
		studentSet.add(new StudentGpa("Mike", "Hikes", 101, 3.95));
		studentSet.add(new StudentGpa("John", "Doe", 102, 2.89));
		studentSet.add(new StudentGpa("Jim", "Jeremy", 103, 3.60));
		studentSet.add(new StudentGpa("Kelly", "Grant", 104, 2.57));
		studentSet.add(new StudentGpa("Alex", "Tom", 100, 3.47));
		
		Object[] studentArray = studentSet.toArray();
		StudentGpa s;
		for(Object obj: studentArray) {
			s = (StudentGpa) obj;
			view.printf("Name = %s %s ID = %d GPA = %1.12f\n",s.firstName(), s.lastName(), s.studentID(), s.GPA());
		}
	}
}
