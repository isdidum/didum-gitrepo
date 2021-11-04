/**
 * @author A., Didum
 * date: October 9, 2012
 */

package myconcrete;

//import java.io.IOException;
import java.io.FileReader;			//necessary for characters read line
import java.io.BufferedReader;		//necessary for whole line read line

public class ReadFileIOConcrete {
	
	private String path;	//instance variable
	
	//ReadIOFile(): default constructor
	public ReadFileIOConcrete(String file_path) {
		path = file_path;
	}
	
	//getFile(): accessor method - returns lines of code from text file in an array
	public String[] getFile() {/*throws IOException*/
		FileReader reader;
		BufferedReader buffer;
		String readData[] = null;
		int i;
		try{
			reader = new FileReader(path);
			buffer = new BufferedReader(reader); 
			
			int numOfLines = getLines(); 	//getLines(): invocation
			readData = new String[numOfLines];
			
			for(i=0; i<numOfLines; i++){
				//accesses lines of text and stores in an array
				readData[i] = buffer.readLine();
			}
			
			buffer.close();
			return readData;
		}catch(Exception e){
			e.printStackTrace();
		}
		return null; //readData;
	}
	
	//getLines(): accessor method - counts number of lines of text in a text file and returns count-total 
	public int getLines() {/*throws IOException*/
		FileReader file_to_read;
		BufferedReader bReader;
		String curLine;
		int numOfLine = 0;
		try {
			file_to_read = new FileReader(path);
			bReader = new BufferedReader(file_to_read);
			
			while((curLine = bReader.readLine()) != null){
				numOfLine += 1; //numOfLine++ or ++numOfLine
			}
			bReader.close();
			file_to_read.close();
			boolean var = curLine == null ? true : false;
			if(!var) System.err.print("getLines(): "+var);
			
			return numOfLine;
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return 0;//numOfLine;
	}
}
