package callable.file;

import java.io.FileReader;			//necessary for characters read line
import java.io.BufferedReader;		//necessary for whole line read line
//import java.io.IOException;
import callable.io.Print;

/**
 * @author A., Didum
 * @date October 9, 2012
 * @description ReadFile(): This program reads any normal data/text files
 */
public class ReadFile {
	//instance variable
	private String path;
	private Print view;
	
	/**
	 * @description ReadFile(): default constructor
	 */
	public ReadFile() {
		this("");
		view = new Print();
	}
	/**
	 * @description ReadFile(): specific constructor
	 * @param file_path
	 */
	public ReadFile(String file_path) {
		path = file_path;
	}
	
	/**
	 * @description setFilePath(): mutator - sets and collects the file path
	 * @param path - the absolute path containing the directory of the file
	 * @notes this method is used in conjunction when its class default constructor is invoked
	 */
	public void setFilePath(String path) {
		try {
			this.path= path;
		} catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	/**
	 * @description getFilePath(): accessor - gets the file path
	 * @return - the absolute path containing the directory of the file
	 * @notes this method is used in conjunction when its class default constructor is invoked
	 */
	public String getFilePath(){
		try {
			return path;
		}catch(Exception err) {
			err.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @description getFile(): accessor - returns each individual line of text from text file in an array
	 * @return array containing lines of texts in a file
	 */
	public String[] getFile() {
		BufferedReader buffer = null;
		String readData[] = null;
		int i;
		try{
			buffer = new BufferedReader(new FileReader(path)); 
			
			int numOfLines = getLines(); 	//getLines(): invocation
			readData = new String[numOfLines];
			
			for(i=0; i<numOfLines; i++){
				//accesses lines of text and stores in an array
				readData[i] = buffer.readLine();
			}

			return readData;
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				if(buffer != null){
					buffer.close();
				}
			} catch(Exception e){
				view.debug("Error closing a read file: "+ e.getMessage());
			}
		}
		
		return null; //readData;
	}
	
	/**
	 * @description getLines(): accessor method - counts number of lines of text in a text file and returns count-total 
	 * @return numOfLine - an integer containing total number of lines in a file
	 */
	public int getLines() {
		BufferedReader bReader = null;
		String curLine;
		int numOfLine = 0;
		try {
			bReader = new BufferedReader(new FileReader(path));
			
			while((curLine = bReader.readLine()) != null){
				numOfLine += 1; //numOfLine++ or ++numOfLine
			}

			boolean var = curLine == null ? true : false;	//ternary/conditional operator
			if(!var) view.debug("getLines(): "+var);
			
			return numOfLine;
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				if(bReader != null){
					bReader.close();
				}
			} catch(Exception e){
				view.println("Error closing a read file: "+ e.getMessage());
			}
		}
		
		return 0;
	}
}
