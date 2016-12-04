package Main_Project;

import java.sql.*;
import Main_Project.User;

/**
 * Created by Rohan on 12/3/2016.
 */
public class SQLController {
    private Connection conn;

    public SQLController() {
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Starting connection");
            conn = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/cs4400_Team_54",
                    "cs4400_Team_54",
                    "EMO7L7Dn");
            if(!conn.isClosed())
                System.out.println("Successfully connected to " +
                        "MySQL server using TCP/IP...");
        } catch(Exception e) {
            System.err.println("Exception in creating connection: " + e.getMessage());
        }
    }

    public void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            System.out.println("Starting connection");
            conn = DriverManager.getConnection("jdbc:mysql://academic-mysql.cc.gatech.edu/cs4400_Team_54",
                    "cs4400_Team_54",
                    "EMO7L7Dn");
            if(!conn.isClosed())
                System.out.println("Successfully connected to " +
                        "MySQL server using TCP/IP...");
        } catch(Exception e) {
            System.err.println("Exception in creating connection: " + e.getMessage());
        }
    }

    public void closeConnection() {
        System.out.println("Closing connection");
        try {
            if(conn != null)
                conn.close();
        } catch(SQLException e) {
            System.err.println("Exception in closing connection: " + e.getMessage());
        }
    }

    public boolean checkIfUserExists(String username) {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT Username FROM User WHERE Username=\'" + username +  "\';";
            ResultSet res = statement.executeQuery(sqlQuery);
            return res.next();
        } catch(SQLException e) {
            System.err.println("Exception in deleting user table: " + e.getMessage());
        }
        return false;
    }

    public User getUser(String username, String password) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT Username,Password,UserType FROM User WHERE Username=\'" + username +  "\'" +
                    "AND Password = \'" + password +  "\'";
            ResultSet res = statement.executeQuery(sqlQuery);
            if (!res.next()) {
                throw new SQLDataException("Invalid username password combination");
            }
            String currUser = res.getString("Username");
            String currPass = res.getString("Password");
            String currUserType = res.getString("UserType");
            return new User(currUser, currPass, currUserType);
        } catch(SQLException e) {
            System.err.println("Exception in getting user from user table: " + e.getMessage());
            throw e;
        }
    }
}
