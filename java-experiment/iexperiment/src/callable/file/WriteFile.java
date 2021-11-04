
package callable.file;

import java.io.FileWriter;				//necessary for characters write line
import java.io.BufferedWriter;			//necessary for whole line write line
import callable.file.ReadFile; 			//necessary for file read

/**
 * WriteFile: writes to an output file system
 * @author A., Didum
 * date: October 9, 2012
 */
public class WriteFile {
	
	//instance variable
	private String wfilename;
	//invokes ReadFile
	private ReadFile readFile;
	private String dirPath = "C:/Users/Didum/Documents/wksp/java/iexperiment/src/collections/property/text";
	
	/**
	 * WriteFile(): specific constructor
	 * @param filePath - file path
	 * @param nameTheFile - output filename
	 */
	public WriteFile(String filePath, String nameTheFile) {
		try{
			readFile = new ReadFile(filePath);
			if(nameTheFile.equals(""))
				wfilename = "defaultFileName";
			else
				wfilename = nameTheFile;
		} catch(Exception e){e.printStackTrace();}	 
	}
	
	/**
	 * setFileName(): mutator - sets filename that output will get written to
	 */
	public void setFileName(String nameTheFile){
		try{
			if(nameTheFile.equals(""))
				wfilename = "defaultFileName";
			else
				wfilename = nameTheFile;
		} catch(Exception e){e.printStackTrace();}
	}
	
	/**
	 * storeFileLines(): accessor - writes to a file
	 * @return
	 */
	public String getFileName(){
		try{
			return wfilename;
		} catch(Exception e){e.printStackTrace();}
		return null;
	}
	
	/**
	 * getPath(): accessor - returns absolute output path
	 * @return
	 */
	public String getAbsPath(){
		try{
			String istr = dirPath + getFileName() + ".txt";		
			return istr;
		} catch(Exception err){err.printStackTrace();}
		return null;
	}
	
	/**
	 * writeToFileLines(): accessor - writes to an output file
	 */
	public void writeToFileName(){
		BufferedWriter wBuffer = null;
		//iReadFile is a reference variable to ReadFileIOConcrete class
		String writer, myLine[] = readFile.getFile();
		String writeData0[] = null, writeData1[] = null, writeData2[] = null, writeData3[] = null;
		
		try{
			writer = getAbsPath(); //Explicit location via absolute path
			wBuffer = new BufferedWriter(new FileWriter(writer)); 
			
			int numOfLines = readFile.getLines(); 	//getLines(): invocation
			writeData0 = new String[numOfLines];
			writeData1 = new String[numOfLines];
			writeData2 = new String[numOfLines];
			writeData3 = new String[numOfLines];
			
			//Notes writeData0 - writeData3 does not use index
			writeData0 = myLine[0].split(":"); 
			writeData1 = myLine[1].split(":");
			writeData2 = myLine[2].split(":");
			writeData3 = myLine[3].split(":");
			
			wBuffer.write(systemWriteOut(writeData0));		
			wBuffer.write("\n************************\n");
			wBuffer.write(systemWriteOut(writeData1));
			wBuffer.write("\n************************\n");
			wBuffer.write(systemWriteOut(writeData2));
			wBuffer.write("\n************************\n");
			wBuffer.write(systemWriteOut(writeData3));
			
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			try{
				if(wBuffer != null){
					wBuffer.flush();
				}
			} catch(Exception e){
				System.err.println("Error closing a write file: "+ e.getMessage());
			}
		}
	}
	
	/**
	 * systeWriteOut(): mutator - processes output
	 * @param myAry
	 * @return addText
	 */
	public String systemWriteOut(String myAry[]){ //void
		String addText = "";
		try{
			for(int i=0; i<myAry.length; i++){
				if(i == 0) addText += "Firstname: "+myAry[i];
				if(i == 1) addText += "\nLastname: "+myAry[i];
				if(i == 2) addText += "\nAge: "+myAry[i];
				if(i == 3) addText += "\nState: "+myAry[i];
			}
			return addText;
		} catch(Exception e){e.printStackTrace();}		
		return null;
	}

}
