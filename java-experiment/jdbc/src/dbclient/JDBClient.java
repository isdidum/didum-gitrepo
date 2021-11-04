/**
 * @author Didum
 * @date November 15, 2012
 */

package dbclient;

import java.sql.*; 	//necessary for MySQL Connection
import database.*;

public class JDBClient {

	static Connection jCon;
	
	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) {
		try {
			//JDBCFactory jFactory = new JDBCFactory(); //for .dat prop
			DBFactory jFactory = new DBFactory();		//for .txt prop
			jCon = jFactory.getConnection();
			
			//delete 5th row in table main in database dbdidum
			Statement jStatement = jCon.createStatement();
			String jSqlDelete = "DELETE FROM dbdidum.main WHERE ID LIKE '%5%' AND Firstname LIKE '%Java%'";
			jCon.setAutoCommit(false);
			jStatement.executeUpdate(jSqlDelete);
			jCon.commit();
			jCon.setAutoCommit(true);
			jFactory.println("5th row in table main is deleted.");
			
			//insert into table main in database dbdidum
			String jSql = "INSERT INTO dbdidum.main VALUES(5, 'Java', 'JAVA', '2733 River Ridge Rd', 'Des Moines', 'Iowa', 'Nov 18, 2012')";
			jCon.setAutoCommit(false);
			jStatement.executeUpdate(jSql);
			jCon.commit();
			jCon.setAutoCommit(true);
			jFactory.println("5th row in table main is updated.");
			
			//select from table main in database dbdidum
			String jSqlSelect = "SELECT * FROM dbdidum.main WHERE Firstname LIKE '%D%'";
			ResultSet jRset = jStatement.executeQuery(jSqlSelect);
			jFactory.println("Row: " + jRset.getRow()); 
			//jFactory..println("Firtname: " + myRset.getInt("Firstname"));
			
			if (jCon != null && !jCon.isClosed()) {
				jStatement.close();
				jFactory.jConClose(); //closes connection
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
