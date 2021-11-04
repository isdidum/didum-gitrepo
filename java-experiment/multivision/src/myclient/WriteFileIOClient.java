package myclient;

//import java.io.*;

import myconcrete.WriteFileIOConcrete;


public class WriteFileIOClient {
	//public static final int LINENUM = 4;

	public static void main(String[] args){
		String filename = "hwday4.txt";
		try{
			/**
			 *  Notes: class-invocation
			 *  WriteFileIOConcrete() invokes ReadFileIOConcrete()
			 *  WriteFileIOConcrete(string) takes a string literal for direct path as formal parameter  
			 *  WriteFileIOConcrete() auto create extension for setter method: setFileName(string)
			 */
			WriteFileIOConcrete wfile = new WriteFileIOConcrete(filename);
			
			//DO NOT add extension to the name of the file you wish to create
			//WriteFileIOConcrete auto create '.txt' extension
			wfile.setFileName("writefile2");
			wfile.writeToFileName();
			
			/*
			 * To access ReadFileIOConcrete, import it here, then uncomment the following
			 * ReadFileIOConcrete rfile = new ReadFileIOConcrete(filename);
			   //getFile: class member/instance method
			 * String curLine[] = rfile.getFile();
			   //System.out.println(myfile.getLines()); //output: 4
			 */

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
