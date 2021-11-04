/**
 * @author Didum
 * @date November 15, 2012
 */

package database;

import java.sql.*;
import java.util.*;		//necessary for properties
import java.io.*;		//necessary for bufferedReader

import callable.file.*;	//imported file from project iexperiment, using import system, 14 April 2013
import callable.io.Print;

public class DBFactory extends Print {
	//instance variables ... data fields
	private String path = "C:/Users/Dee/Documents/wksp/java/jdbc/src/collections/properties/";  
	private String srcType = "jdbcprop.txt";
	private ReadFile readFile = null;
	private Properties prop = null;
	public static Connection jCon = null;
	
	/**
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @description JDBCFacroty(): default constructor
	 */
	public DBFactory() throws InstantiationException, IllegalAccessException {
		try {
			readFile = new ReadFile();
			prop = new Properties();
			
			for(int i=0; i<initProperty().length; i++){
				if(i == 1) {//prevent showing password
					println("initProperty(): 1 :CONNECTION-INFO Locked");
				} else {
					println("initProperty(): "+i+" :"+initProperty()[i]);
				}
			}
			try {
				Class.forName(initProperty()[0]).newInstance();
			} catch (ClassNotFoundException e) { 
				e.printStackTrace(); 
			}
			
			jCon = DriverManager.getConnection(initProperty()[1]);
			println("-----Open database: dbdidum-----");
		} catch (SQLException e){ e.printStackTrace(); }
	}
	
	/**
	 * @description initProperty(): accessor - loads SQL-Connection setup via property load method
	 */
	public String[] initProperty(){
		String dbValue [] = null;
		int i = 0;
		try{
			dbValue = new String[lineCounts()];
			prop.load(new FileInputStream(path + srcType));
			
			for(String key: prop.stringPropertyNames()){
				String value = prop.getProperty(key);
				dbValue[i] = value;	//dont need the key
				if(i == prop.size() - 1) continue;
				i++;
			} 
			return dbValue;
		}catch(Exception e){ e.printStackTrace(); }
		return null;
	}
	
	/**
	 * @description linesCounts(): accessor - returns total number of lines in a file
	 * @return integer contain number of lines
	 */
	public int lineCounts(){
		try{
			readFile.setFilePath(path + srcType);
			return readFile.getLines() - 1;
		}catch(Exception e){ e.printStackTrace(); }
		return 0;
	}
	
	/**
	 * @description getConnection(): accessor - returns connection to jDB
	 * @return connection
	 */
	public Connection getConnection(){
		try{
			return jCon;
		} catch (Exception e) { e.printStackTrace(); }
		return null;
	}
	
	/**
	 * @description jConValidation(): mutator - validates connection with messages
	 */
	public void jConClose(){
		try {
			jCon.close();
			println("-----Close database: dbdidum-----");
		} catch (Exception e) { e.printStackTrace(); }
	}
}