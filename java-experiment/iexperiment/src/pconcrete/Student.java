
package pconcrete;

/**
 * @author A., Didum
 * @date January 29, 2013
 * Student(): concrete class for Student to be used in a GUI
 * @see gui.swingapps.StudentGui.java
 */
public class Student {
	//instance variable
	private String name;
	private double tests[];
	
	/**
	 * Student(): default constructor
	 */
	public Student() {
		name = "";
		for(int i=0; i<3; i++) {
			tests[i] = 0;
		}
	}
	
	/**
	 * Student(): specific constructor
	 * @param nm - student name
	 * @param t - tests array
	 */
	public Student(String nm, double t[]) {
		tests = new double[3];
		name = nm;
		for(int i=0; i<3; i++) {
			tests[i] = t[i];
		}
	}
	
	/**
	 * Student(): specific constructor object
	 * @param s - student object
	 */
	public Student(Student s) {
		name = s.name;
		for(int i=0; i<3; i++) {
			tests[i] = s.tests[i];
		}
	}
	
	/**
	 * setName(): mutator - sets a student's name
	 */
	public void setName(String nm) {
		try {
			name = nm;
		} catch(Exception err) {err.printStackTrace();}
	}
	
	/**
	 * getName(): accessor - gets a student's name
	 */
	public String getName() {
		try {
			return name;
		} catch (Exception err) {err.printStackTrace();}
		return null;
	}
	
	/**
	 * setScore(): mutator - sets a student's test score
	 */
	public void setScore(int i, double score) {
		try {
			tests[i-1] = score;
		} catch (Exception err) {err.printStackTrace();}
	}
	
	/**
	 * getScore(): accessor - gets a student's test score
	 * @param i index variable
	 * @return student test
	 */
	public double getScore(int i) {
		try {
			return tests[i-1];
		} catch (Exception err) {err.printStackTrace();}
		return 0.0;
	}
	
	/**
	 * getAverage(): accessor - gets the average of a student's test scores
	 * @return test scores mean
	 */
	public double getAverage() {
		int sum = 0;
		try {
			for(int i=0; i<3; i++) {
				sum += tests[i];
			}
			return sum / 3.0;
		} catch (Exception err) {err.printStackTrace();}
		return 0.0;
	}
	
	/**
	 * getHighScore(): accessor - gets high score of a student's test scores
	 * @return high score
	 */
	public double getHighScore() {
		double highScore = tests[0];
		try {
			for(int i=0; i<3; i++) {
				highScore = Math.max(highScore, tests[i]);
			}
			return highScore;
		} catch (Exception err) {err.printStackTrace();}
		return 0.0;
	}
	
	/**
	 * toString(): facilitator - processes output message
	 * @return test scores and average 
	 */
	public String toString() {
		String str = "";
		try {
			str = "Name: "+name+"\n";
			for(int i=0; i<3; i++) {
				str += "test "+i+" : "+tests[i]+"\n";  
			}
			str += "Average: "+getAverage();
			return str;
		} catch (Exception err) {err.printStackTrace();}
		return null;
	}
	
	/**
	 *  validateData(): facilitator - ensures valid data is processed &
	 *  returns null if there are no errors
	 *  @return validation message
	 */
	public String validateData() {
		String str;
		try {
			if(name.equals("")) return "SORRY: name required";
			for(int i=0; i<3; i++) {
				if(tests[i] < 0 || tests[i] > 100) {
					str = "SORRY: must have "+ 0.01 +" <= test score <= "+100.00;
					return str;
				} else if(tests[i] == 0){
					return "SORRY: all test scores required.";
				}
			}
		} catch (Exception err) {err.printStackTrace();}
		return null;
	}
}
