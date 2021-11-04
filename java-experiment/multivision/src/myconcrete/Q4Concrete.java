/**
 * @author Didum
 * date: October 18, 2012
 */

package myconcrete;

import myabstract.Q4Abstract;

public class Q4Concrete extends Q4Abstract{
	
	/*
	 * Q4Concrete(): default constructor and now a subclass
	 * parent-class or superclass or Base: Q4Abstract 
	 * child-class or subclass or Derived: Q4Concrete
	 */
	public Q4Concrete() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void upperCaseNameCheck(String str) {
		//implementation details
		char myStr[] = new char[str.length()];
		char myUppercase[] = new char[str.length()];
		char myLowercase[] = new char[str.length()];
		int icntr = 0, jcntr = 0;
		String myOutput = "", mystr = "";
		
		try{
			for(int i=0; i<str.length(); i++){
				myStr[i] = str.charAt(i);
				if(Character.isUpperCase(myStr[i]) == true){
					myUppercase[i] = myStr[i];
					icntr++;
					mystr += myUppercase[i]+",";
				} else if(Character.isLowerCase(myStr[i]) == true) {
					myLowercase[i] = myStr[i];
					jcntr++;
				}
			}
			myOutput = "i. Input string: '"+str+"'\n\tTotal uppercase characters: "+icntr+", which are: "+mystr;
			System.out.println(myOutput);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void convertLowerToUpperCase(String str) {
		// implementation details
		String storeLower;

		try{
			storeLower = str.toUpperCase();
			System.out.println("ii. Lowercase converted to uppercase: "+storeLower);
		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
