/**
 * @author Didum
 * date: October 17, 2012
 */
package training3;

import java.util.Calendar;
//import java.util.GregorianCalendar;

public class FindUserAge {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Command Line Input: "12-20-1978" //mm dd yyyy
		String findAge = args[0];
		String fUserAge[] = findAge.split("-");
		int userYr, userMo, userDd;
		
		userMo = Integer.parseInt(fUserAge[0]);
		userDd = Integer.parseInt(fUserAge[1]);
		userYr = Integer.parseInt(fUserAge[2]);
		
		System.out.println("UserMo= "+userMo+" userDy= "+userDd+ " UserYr= "+userYr);
		//myCalendar(): invocation
		myCalendar(userYr, userMo, userDd);
	}
	
	//myCalendar(): mutator method
	public static void myCalendar(int uYr, int uMo, int uDd){
		int curYr, curMo, curDd, iMo, iDd;

		String gStr;
		Calendar getIns = Calendar.getInstance();
		//Calendar getIns = new GregorianCalendar();
		curMo = getIns.get(Calendar.MONTH)+1; //static access of month in class Calendar
		curYr = getIns.get(Calendar.YEAR);
		curDd = getIns.get(Calendar.DAY_OF_MONTH);
		
		
		if(curMo > uMo) iMo = (curMo - uMo);
		else iMo = (uMo - curMo);
		
		if(curDd > uDd) iDd = (curDd - uDd);
		else iDd = (uDd - curDd);
		
		gStr = "User is "+(curYr - uYr)
		 	+ " year(s) "+ iMo
		 	+ " month(s) "+iDd+" day(s)";
		System.out.println(gStr);
		
		//System.out.println("curMo: "+curMo+" curDy: "+curDd+" curYr: "+curYr);
	}
}
