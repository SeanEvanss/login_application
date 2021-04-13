package org.example;

import java.applet.Applet;
import java.sql.*;

public class LoginValidator {

    private Connection conn;
    private Statement stmt;
    private ResultSet rset;
    private String sqlUser = "root";
    private String sqlPassword = "1234";

    LoginValidator(){

    }

    // User input username and password validation
    public boolean queryLoginDatabase(String inputUserName, String inputUserPassword) {

        // Load mysql jdbc Driver Class
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Driver Class Load Error");
            return false;
        }
        try{
            // Construct a database 'Connection' object called 'conn'
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_authentication_db", sqlUser, sqlPassword);

            // Construct a 'Statement' object called 'stmt' inside the Connection created
            stmt = conn.createStatement();

            // Perform input validation to detect attacks
            // Select username and password from database
            String query = "select userName, userPassword from user_auth_data where userName=? and userPassword=? ";
            PreparedStatement pstmt = conn.prepareStatement( query );
            pstmt.setString( 1, inputUserName);
            pstmt.setString( 2, inputUserPassword);

            // Write a SQL query string. Execute the SQL query via the 'Statement'.
            //  The query result is returned in a 'ResultSet' object called 'rset'.
            System.out.println("The SQL statement is: " + pstmt.toString() + "\n"); // Echo For debugging
            rset = pstmt.executeQuery();
            // Process the 'ResultSet' by scrolling the cursor forward via next().
            //  For each row, retrieve the contents of the cells with getXxx(columnName).
            System.out.println("The record selected is:");

            // rset.next() inside the whole-loop repeatedly moves the cursor to the next row.
            // It returns false if no more rows.
            while(rset.next()) {   // Repeatedly process each row
                String userName = rset.getString("userName");  // retrieve a 'String'-cell in the row
                String userPassword = rset.getString("userPassword");  // retrieve a 'double'-cell in the row
                System.out.println(userName + ", " + userPassword);
                if(userName.equals(inputUserName) && userPassword.equals(inputUserPassword))
                {
                    conn.close();
                    return true;
                }
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
