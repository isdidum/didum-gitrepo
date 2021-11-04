/**
 * @author Didum
 * date: November 15, 2012
 */

package database;

import java.sql.*;
import java.util.*;		//necessary for properties
import java.io.*;		//necessary for bufferedReader

import callable.file.*;	//imported file from project iexperiment, using import system, 14 April 2013
import callable.io.Print;

public class JDBCFactory {
	//instance variables
	private String path = "C:/Users/Didum/Documents/scripts/wksp/jdbc/src/collections/properties/"; 
	private String srcType = "jdbcprop.dat";
	private ReadFile readFile = null;
	private Properties prop = null;
	public static Connection jCon = null;
	private Print view;
	/**
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @Description JDBCFacroty(): default constructor
	 */
	public JDBCFactory() throws InstantiationException, IllegalAccessException {
		try {
			prop = new Properties();
			view = new Print();
			for(int i=0; i<init().length; i++)
				view.println("init(): "+i+" :"+init()[i]);
			try {
				Class.forName(init()[4]).newInstance();
			} catch (ClassNotFoundException e) { 
				e.printStackTrace(); 
			}
			//jCon = DriverManager.getConnection(init()[1]);
			
			jCon = DriverManager.getConnection(init()[0] + init()[1], init()[2], init()[3]); //or
			/**
			 * these work as well
			 * jCon = DriverManager.getConnection(init()[0] + init()[1] + init()[2]);
			 * jCon = DriverManager.getConnection(init()[0]); if using jdbcprop.txt
			 */
		} catch (SQLException e){ e.printStackTrace(); }
	}
	
	/**
	 * @Description init(): accessor - loads SQL-Connection setup via property load method
	 */
	public String[] init(){
		try{
			prop.load(new FileInputStream(path + srcType));
			String url = prop.getProperty("dbUrl");
			String name = prop.getProperty("dbName");
			String user = prop.getProperty("dbUserName");
			String pass = prop.getProperty("dbPassword");
			String driver = prop.getProperty("dbDriver");
			
			String props[] = {url, name, user, pass, driver}; 
			return props;
		}catch(Exception e){ e.printStackTrace(); }
		return null;
	}
	
	/**
	 * @Description linesCounts(): accessor - returns total number of lines in a file
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
	 * @Description getConnection(): accessor - returns connection to jDB
	 * @return connection
	 */
	public Connection getConnection(){
		try{
			return jCon;
		} catch (Exception e) { e.printStackTrace(); }
		return null;
	}
	
	/**
	 * @Description jConValidation(): mutator - validates connection with messages
	 */
	public void jConClose(){
		try {
			System.out.println("Opened database");
			jCon.close();
			System.out.println("Exited database");
		} catch (Exception e) { e.printStackTrace(); }
	}
}