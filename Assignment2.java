package assignmentday4;

import java.sql.*;

public class Assignment2 {
	
	public static void main(String args[]) {
		try {
		// 1 - load the driver
	    Class.forName("com.mysql.cj.jdbc.Driver");

	    // 2 - create connection
	    Connection ct = DriverManager.getConnection("jdbc:mysql://localhost:3306/tweetdb", "root", "Satya76600*");

	    // 3- create Statement
	    //Statement st = ct.createStatement();
	    PreparedStatement pst= ct.prepareStatement("select * from tweet where Name like 'a%'");
	    ResultSet rs = pst.executeQuery();
	    while (rs.next()) {
	        int account_id = rs.getInt(1);
	        String name = rs.getString(2);
	        String tweetname=rs.getString(3);
	        int likes = rs.getInt(4);
	        int dislikes=rs.getInt(5);

	        System.out.println(account_id + "\t" + name + "\t" + tweetname + "\t" + likes + "\t" + dislikes);
	    }

	    // 5 - close connection
	    rs.close();
	    pst.close();
	    ct.close();
		}
		catch(Exception e) {
			System.out.println("Exception........");
		}
	}

}
