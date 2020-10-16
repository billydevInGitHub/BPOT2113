package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EbConnectionProvider {
    static int  provider=1; 
    
	public  static Connection get_connection () throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Connection conn=null; 
		switch(provider){
		case 1: return get_localDriverManager_Connection(); 
		case 2: return get_tomcat_jndi_connection();
		default: return get_localDriverManager_Connection();
		}
		
	}

	private static Connection get_tomcat_jndi_connection() {
		// adding code here when we try to implement the connection from tomcat connection pool
		return null;
	}

	private static Connection get_localDriverManager_Connection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Connection conn=null; 
			Class.forName("org.hsqldb.jdbc.JDBCDriver" ).newInstance ();
    		conn = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/miniebilldb", "SA", "");  
	
		return conn;
	}
}
