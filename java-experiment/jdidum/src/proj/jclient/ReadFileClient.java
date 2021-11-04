/**
 * @author A., Didum
 * date: October 9, 2012
 */
package proj.jclient;

import java.io.IOException;
import proj.jclass.ReadFile;

public class ReadFileClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		//String filename = "../../jtxt/multivision.txt";
		String filename = "/Users/didum4/Documents/workspace/jdidum/src/jtxt/multivision.txt";
		
		try{
			ReadFile myfile = new ReadFile(filename);		//ReadFile(): class-invocation
			String strAry[], curLine[] = myfile.getFile();	//getFile(): class member/instance method
			String fChar, sChar;
			int i;
			
			for(i=0; i<curLine.length; i++){	//curLine: array with 1-element
				System.out.println("\n"+curLine[i]);
			}
			
			strAry = curLine[0].split(":");		//strAry: array with 4-elements
			fChar = strAry[0].substring(0, 1);
			sChar = strAry[1].substring(0, 1);
			
			for(i=0; i<strAry.length; ++i){
				if(i == 0) System.out.println("Firstname: "+fChar.toUpperCase() + strAry[i].substring(1));
				if(i == 1) System.out.println("Lastname: "+sChar.toUpperCase() + strAry[i].substring(1));
				if(i == 2) System.out.println("City: "+strAry[i]);
				if(i == 3) System.out.println("State: "+strAry[i]);
			}

		} catch(Exception e) {
			System.err.print("Error: "+ e.getMessage() + "\n Description: "+ e.toString());
		}
	}

}
