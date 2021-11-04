/**
 * @author Didum
 * date: October 17, 2012
 */

package myfileio;

import java.io.*;

public class ReadWriteFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			//read sampleIn.txt
			
			//Prepare the file you want to read
			FileReader fr = new FileReader("readfile.txt");
			
			//Red the file into bufferedReader object
			BufferedReader  br = new BufferedReader(fr); //reads stream of characters
			//Read contents
			System.out.println(br.readLine());
			br.close();
			fr.close();
			
			//write to a file
			FileWriter fw = new FileWriter("writefile.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			//write content
			bw.write("This is cool!\nwow, me likie..");
			bw.flush(); //ensure everything in bw file goes through, minimize and hit f5
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
