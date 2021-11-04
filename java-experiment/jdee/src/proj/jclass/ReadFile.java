/**
 * @author A., Didum
 * date: October 9, 2012
 */

package proj.jclass;

import java.io.IOException;
import java.io.FileReader;			//necessary for characters read line
import java.io.BufferedReader;		//necessary for whole line read line

public class ReadFile {
	
	private String path;	//instance variable
	
	//ReadFile(): class constructor method
	public ReadFile(String file_path) {
		path = file_path;
	}
	
	//OpenFile(): accessor method - returns lines of code from text file in an array
	public String[] getFile() throws IOException{
		FileReader reader = new FileReader(path);
		BufferedReader buffer = new BufferedReader(reader); 
		
		int numOfLines = getLines(); 	//getLines(): invocation
		String txtData[] = new String[numOfLines];
		
		int i;
		for(i=0; i<numOfLines; i++){
			//accesses lines of text and stores in an array
			txtData[i] = buffer.readLine();
		}
		
		buffer.close();
		return txtData;
	}
	
	//getLines(): accessor method - counts number of lines of text in a text file and returns count-total 
	public int getLines() throws IOException{
		FileReader file_to_read = new FileReader(path);
		BufferedReader bReader = new BufferedReader(file_to_read);
		
		String curLine;
		int numOfLine = 0;
		while((curLine = bReader.readLine()) != null){
			numOfLine += 1; //numOfLine++ or ++numOfLine
		}
		
		bReader.close();
		boolean var = curLine == null ? true : false;
		if(!var) System.err.print("getLines(): "+var);
		return numOfLine;
	}

}
