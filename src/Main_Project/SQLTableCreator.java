package Main_Project;

/**
 * Created by Rohan on 12/3/2016.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLTableCreator {

    private Connection conn;

    public SQLTableCreator() {
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

    public void createUserTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE USER " +
                    "(Username VARCHAR(15) NOT NULL," +
                    "Password VARCHAR(15) NOT NULL," +
                    "Email VARCHAR(30) NOT NULL," +
                    "Year INT NOT NULL," +
                    "Major VARCHAR(20) NOT NULL," +
                    "UserType VARCHAR(5) NOT NULL," +
                    "PRIMARY KEY (Username)," + "FOREIGN KEY (Major) REFERENCES MAJOR(Name))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Users Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating user table: " + e.getMessage());
        }
    }

    public void deleteUserTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE USER ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Users Table deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting user table: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        SQLTableCreator creator = new SQLTableCreator();
        creator.closeConnection();
        creator.createConnection();
        creator.deleteUserTable();
        //creator.createUserTable();
    }
}

