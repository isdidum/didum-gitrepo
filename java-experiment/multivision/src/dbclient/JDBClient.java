/**
 * @author Didum
 * date: November 15, 2012
 */

package dbclient;

import java.sql.*; 	//necessary for MySQL Connection
import database.*;

public class JDBClient {

	public static Connection jCon;
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		try {
			//JDBCFactory jFactory = new JDBCFactory();  //for .dat prop
			DBFactory jFactory = new DBFactory();		 //for .txt prop
			jCon = jFactory.getConnection();
			
			//insert into
			Statement jStatement = jCon.createStatement();
			String jSql = "insert into jdatabase.main values(5, 'Java', 'JAVA', '2733 River Ridge Rd', 'Des Moines', 'Iowa', 'Nov 18, 2012')";
			jCon.setAutoCommit(false);
			jStatement.executeUpdate(jSql);
			jCon.commit();
			jCon.setAutoCommit(true);
			
			//select from
			String jSqlSelect = "select * from jdatabase.sample1 where Firstname like '%D%'";
			ResultSet jRset = jStatement.executeQuery(jSqlSelect);
			System.out.println("Row: " + jRset.getRow()); 
			//System.out.println("Firtname: " + myRset.getInt("Firstname"));
			
			jStatement.close();
			jFactory.jConClose(); //closes connection
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
