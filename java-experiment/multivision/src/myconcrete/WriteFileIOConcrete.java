/**
 * @author A., Didum
 * date: October 20, 2012
 */
package myconcrete;

import java.io.FileWriter;			//necessary for characters write line
import java.io.BufferedWriter;		//necessary for whole line write line
import myconcrete.ReadFileIOConcrete; //necessary for file read

public class WriteFileIOConcrete {
	
	//instance variable
	private String wfilename;
	private String ipath;
	//invokes ReadFileIOConcrete
	public ReadFileIOConcrete iReadFile;
	
	/**
	 * WriteFileIOConcrete(): default class constructor
	 */
	public WriteFileIOConcrete(String filePath) {
		ipath = filePath;
		wfilename = "";
		iReadFile = new ReadFileIOConcrete(ipath); 
	}
	
	//setFileName(): mutator method - sets filename
	public void setFileName(String nameTheFile){
		try{
			wfilename = nameTheFile;
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//storeFileLines(): accessor method - writes to a file
	public String getFileName(){
		try{
			return wfilename;
		} catch(Exception e){
			e.printStackTrace();
		}
		return wfilename;
	}
	
	//writeToFileLines(): accessor method - writes to a file
	public void writeToFileName(){
		FileWriter writer;
		BufferedWriter wBuffer;
		String myLine[] = iReadFile.getFile();
		String writeData[] = null, writeData1[] = null, writeData2[] = null, writeData3[] = null;
		
		try{
			writer = new FileWriter(wfilename+".txt");
			wBuffer = new BufferedWriter(writer); 
			
			int numOfLines = iReadFile.getLines(); 	//getLines(): invocation
			writeData = new String[numOfLines];
			
			writeData = myLine[0].split(":"); 
			writeData1 = myLine[1].split(":");
			writeData2 = myLine[2].split(":");
			writeData3 = myLine[3].split(":");
			
			wBuffer.write(systemWriteOut(writeData));		
			wBuffer.write("\n************************\n");
			wBuffer.write(systemWriteOut(writeData1));
			wBuffer.write("\n************************\n");
			wBuffer.write(systemWriteOut(writeData2));
			wBuffer.write("\n************************\n");
			wBuffer.write(systemWriteOut(writeData3));
			
			wBuffer.flush();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//systeWriteOut(): mutator method - processes output
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
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;//addText;
	}

}
