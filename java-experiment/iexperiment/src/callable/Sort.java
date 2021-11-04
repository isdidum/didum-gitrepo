package callable;

import callable.io.Print;

/**
 * Sort(): concrete class
 * @author A., Didum
 * @date January 17, 2013
 */
public class Sort {
	// private instance variables
	private double list[] = null;
	private int low, high;
	private Print view;
	
	/**
	 * Sort(): default constructor
	 */
	public Sort() {
		this(0, null, 0, 0); //chaining constructor
		list = new double[0];
		low = 0;
		high = 0;
		view = new Print();
	}
	
	/**
	 * Sort(): specific/paramerized constructor
	 * @param size, list, min, max
	 */
	public Sort(int size, double list[], int min, int max) {
		this.list = new double[size];
		this.list = list;
		low = min;
		high = max;
		view = new Print();
	}
			
	/**
	 * ascendSort(): accessor - sorts data from low to high (A-Z)
	 * @return a-z sort
	 */
	public double[] ascendSort(double asnd[]) {
		try {
			double temp = 0.0;
			for(int i=0; i < asnd.length; i++) {
				for(int j=(i+1); j < asnd.length; j++) {
					if(asnd[i] > asnd[j]) {
						temp = asnd[i];		//technique: variable swap
						asnd[i] = asnd[j];
						asnd[j] = temp;
					}
				}
			}
			return asnd;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return asnd;
	}
	
	/**
	 * descendSort(): accessor - sorts date from high to low (Z-A)
	 * @return z-a sort
	 */
	public double[] descendSort(double dsnd[]) {
		try {
			double temp = 0.0;
			for(int i=0; i < dsnd.length; i++) {
				for(int j=(i+1); j < dsnd.length; j++) {
					if(dsnd[i] < dsnd[j]) {
						temp = dsnd[i];			//technique: variable swap
						dsnd[i] = dsnd[j];
						dsnd[j] = temp;
					}
				}
			}
			return dsnd;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return dsnd;
	}
	
	/**
	 * getOddSort(): accessor - sorts odd data from low to high
	 * @return odd numbers sort
	 */
	public double[] getOddSort(double listOdd[]) {
		try {
			return ascendSort(listOdd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ascendSort(listOdd); //listOdd;
	}
		
	/**
	 * getEvenSort(): accessor - sorts even data from low to high
	 * @return even numbers sort
	 */
	public double[] getEvenSort(double listEven[]) {
		try {
			return ascendSort(listEven);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return ascendSort(listEven);
	}
		
	/**
	 * findPrime(): mutator - finds prime number
	 */
	public void findPrime() {
		try {
			int innerLimit, i, j;
			for(i = low; i <= high; i++) {
				innerLimit = (int)Math.sqrt(i);
				for(j = 2; j <= innerLimit; j++) {
					if(i % j == 0) {
						break;
					}
				}
				if(j > innerLimit) {
					view.print("\n"+i + " is prime");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * findMaximum(): accessor - finds maximum value of collected array data
	 * @return maximum value
	 **/
	public double findMaximum() {
		double tempMax = 0.0;
		try {
			tempMax = list[1];
			for(int i=0; i < list.length; i++) {
				if(list[i] > tempMax) {
					tempMax = list[i];
				}
			}
			return tempMax;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tempMax;
	}
		
	/**
	 * findMinimum(): accessor - finds minimum value of collected array data
	 * @return minimum value
	 */
	public double findMinimum() {
		double tempMin = 0.0;
		try {
			tempMin = list[1];
			for(int i = 0; i < list.length; i++) {
				if(list[i] < tempMin) {
					tempMin = list[i];
				}
			}
			return tempMin;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tempMin;
	}
	
	/**
	 * @date January 24, 2013 
	 * toFixed(): accessor - takes an integer and a string expression to return a fixed precision 
	 *  Returns a new string that is based on the specified parameters 
     *	<code>stringExp</code> and<code>intv</code>. The integer parameter, <code>intv</code> 
     * 	must be greater than or equal one in order for this method to return its string expression.
     *  <p>Examples:
     *  <blockquote><pre>
     *  toFixed("24.57485", 1) returns "24.6"
     *  toFixed("24.57485", 4) returns "24.5749"
     *  </pre></blockquote>
	 * @return fixed precision rounded to the next positive integer
	 */
	public String toFixed(String stringExp, int intv) {
		String str = "";
		String leadPrecision;
		String trailPrecision, fakePrecision;
		String toPrecision, dot, lastNum;
		try {
			if(intv >= 1) {
				int decimalPoint = stringExp.indexOf(".", 0);
				int xpressionLength = stringExp.length();
				int fromDotToEnd = Math.abs(xpressionLength - decimalPoint);
				if(fromDotToEnd <= 5 && intv < 50) {
					/**
					 * concatenates 50 zeros to expression
					 * this addition is required in order to avoid choking method substring()
					 */
					stringExp += "00000000000000000000000000000000000000000000000000";	
					int decimalPointv = stringExp.indexOf(".", 0);
					leadPrecision = stringExp.substring(0, decimalPointv);
					trailPrecision = stringExp.substring(decimalPointv+1, (decimalPointv+intv+1));
					
					fakePrecision = stringExp.substring(decimalPointv+1, (decimalPointv+intv+2));
					lastNum = fakePrecision.substring(fakePrecision.length()-1, fakePrecision.length());
					int intTrailPrecision = Integer.parseInt(trailPrecision);
					if(Integer.parseInt(lastNum) >= 5) {
						intTrailPrecision = Integer.parseInt(trailPrecision) + 1;
						trailPrecision = String.valueOf(intTrailPrecision);
					}
					dot = stringExp.substring(decimalPointv, decimalPointv+1);
					
					toPrecision = leadPrecision +dot+ trailPrecision;
					str = toPrecision;
					return str;
				}else if(intv > 50){
					return str = "";
				} else {
					if(decimalPoint != -1) {
						/**
						 * concatenates 50 zeros to expression
						 * this addition is required to supplement when evaluation has characters less than the provided intv
						 */
						stringExp += "00000000000000000000000000000000000000000000000000";
						leadPrecision = stringExp.substring(0, decimalPoint);
						trailPrecision = stringExp.substring(decimalPoint+1, (decimalPoint+intv+1));
						
						fakePrecision = stringExp.substring(decimalPoint+1, (decimalPoint+intv+2));
						lastNum = fakePrecision.substring(fakePrecision.length()-1, fakePrecision.length());
						int intTrailPrecision = Integer.parseInt(trailPrecision);
						if(Integer.parseInt(lastNum) >= 5) {
							intTrailPrecision = Integer.parseInt(trailPrecision) + 1;
							trailPrecision = String.valueOf(intTrailPrecision);
						}
						dot = stringExp.substring(decimalPoint, decimalPoint+1);
						
						toPrecision = leadPrecision +dot+ trailPrecision;
						str = toPrecision;
						return str;
					} else if(decimalPoint == -1) {
						str = stringExp;
						return str;
					}
				}
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * isNumber(): facilitator - determines if a string is a numeric value<br />
	 *  Returns a boolean <code>false</code> if the string, <code>strParam</code>, is any thing
	 *  other than a numeric value, true otherwise.
	 *  <p>Examples
	 *  <blockquote><pre>
	 *  isNumber("")	  returns "false"
     *  isNumber("-24.57") returns "false"
     *  isNumber("24.57") returns "true"
     *  isNumber("&*%4d") returns "false"
     *  </pre></blockquote>
	 * @param strParam this is the string input parameter to be provided in order to get a return value
	 * @return boolean: true/false?
	 */
	public boolean isNumber(String strParam) {
		boolean isNumber = false;
		String firstChar = "";
		//char index = ' ';
		
		try {
			if(strParam.length() != 0) {			
			for(int i=0; i < strParam.length(); i++) { //<=
				firstChar = strParam.substring(0,1); 
				if(firstChar.equals("-")) {
					//index = strParam.charAt(i); //i+1
					if(!Character.isDigit(strParam.charAt(i+1))) {
						return isNumber;
					} else {
						isNumber = true;
					}
				} else if(!firstChar.equals("-")){
					//index = strParam.charAt(i);
					if(!Character.isDigit(strParam.charAt(i))) {
						return isNumber;
					} else {
						isNumber = true;
					}
				}
			}
			} else {
				return isNumber;
			}
			//return isNumber;
		} catch(Exception err) {
			err.printStackTrace();
		}
		return isNumber;
	}
	
	/**
	 * addToString(): mutator - displays results
	 */
	public void displayContents(double asnd[], double dsnd[], double even[], double odd[]) {
		String str = "", toMax, toMin;
		try {
			//int x = Integer.parseInt(args[0]);
			//char x = Character.parseInt(args[0]);
			toMax = String.valueOf(findMaximum());
			toMin = String.valueOf(findMinimum());
			str += "\nData [Maximum, Minimum] := ["+toFixed(toMax,3)+", "+toFixed(toMin,3)+"]";
			view.print(str);
			
			System.out.print("\nAscending sort := ");
			for(double x: ascendSort(asnd))
				view.print(x+", ");

			System.out.print("\nDescending sort := ");
			for(double i: descendSort(dsnd))
				view.print(i+", ");
			
			System.out.print("\nEvent sort := ");
			for(double j: getEvenSort(even))
				view.print(j+", ");
			
			System.out.print("\nOdd sort := ");
			for(double k: getOddSort(odd))
				view.print(k+", ");
			
			findPrime();
			view.print("\nisNumber? "+isNumber("63.00"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
