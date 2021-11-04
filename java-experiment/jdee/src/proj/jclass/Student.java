//Author: A., Didum
//Date: September 16, 2012
//Purpose: Manage a student's name and three test scores

package proj.jclass;

public class Student {
	//instance variables
	//each student object has a name and three test scores
	private String name;		//student name
	private int test1;			//score on test 1
	private int test2;			//score on test 2
	private int test3;			//score on test 3
	
	//Student(): constructor method
	public Student(String nm, int t1, int t2, int t3){
		//initialize student's name and test scores
		name = nm;		//"";
		test1 = t1;		//0;
		test2 = t2;		//0;
		test3 = t3;		//0;
	}
	
	//setName(): mutator method - set student's name
	public void setName(String nm){
		name = nm;
	}
	
	//getName(): accessor method - get student's name
	public String getName(){
		return name;
	}
	
	//setScore(): mutator method - set student's score
	public void setScore(int i, int score){
		if(i == 1) 
			test1 = score;
		else if(i == 2) 
			test2 = score;
		else 
			test3 = score;
	}
	
	//getScore(): accessor method - get student's score
	public int getScore(int i){
		if(i == 1)
			return test1;
		else if(i == 2)
			return test2;
		else
			return test3;
	}
	
	//getAverage(): accessor method - get the average of test scores
	public int getAverage(){
		int average, sum = 0;
		for(int i=0; i<3; i++){
			sum += getScore(i);
		}
		average = (int)Math.round(sum/3);
		return average;
	}
	
	//getHighScore(): accessor method - returns highest score
	public int getHighScore() {
		int highScore;
		highScore = test1;
		if(test2 > highScore)
			highScore = test2;
		if(test3 > highScore)
			highScore = test3;
		return highScore;
	}
	
	//toString(): accessor method - return a string representation of the student
	public String toString(){
		String str;
		str = "Name:	"+name+"\n"+
		"Test 1:	"+test1+"\n"+
		"Test 2:	"+test2+"\n"+
		"Test 3:	"+test3+"\n"+
		"Average:	"+getAverage();
		return str; //int itg = test2 > test3 ? 1 : 0; condition statement
	}
	
}

/*
Problems were encountered during export:
	  Error exporting jsdidum/srcjs/txt/terminology.txt: Resource is out of sync with the file system: '/jsdidum/srcjs/txt/terminology.txt'.
	    Resource is out of sync with the file system: '/jsdidum/srcjs/txt/terminology.txt'.
*/
