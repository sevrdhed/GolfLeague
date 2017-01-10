import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	public Connection conn = null;

	public Connection createConnection(){
	
	
		Statement query = null;
		ResultSet result = null;
		try {

			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				System.out.println(e1.toString());
			}


			conn = DriverManager.getConnection(
					"jdbc:mysql://sql3.freesqldatabase.com:3306/sql3127568",
					"sql3127568", "SGcwR1hyRf");
			query = conn.createStatement();
			query.execute("Alter Table Golfers ADD WeekScore2 varchar(3)");
			//query.execute("Alter Table Golfers ADD WeekScore4 varchar(3), ADD WeekSlope4 varchar(3), ADD WeekRating4 decimal(3,2)");
			//result = query.executeQuery("SELECT GolferName FROM Golfers WHERE CurrentPoints = '30'");
			
			//result.next();
			//System.out.println(result.getString(1));
			
			System.out.println(conn.toString());

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return conn;


	}
	
	public void closeConnection(){
		try{
		conn.close();
		}catch(SQLException connEx)
		{
			System.out.println("SQLException: " + connEx.getMessage());
			System.out.println("SQLState: " + connEx.getSQLState());
			System.out.println("VendorError: " + connEx.getErrorCode());
		}
		}
	}

