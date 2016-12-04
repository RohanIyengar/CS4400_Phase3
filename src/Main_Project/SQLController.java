package Main_Project;

import java.sql.*;
import Main_Project.User;
import javafx.collections.FXCollections;
import javafx.collections.ModifiableObservableListBase;
import javafx.collections.ObservableList;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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
            String sqlQuery = "SELECT Username FROM USER WHERE Username=\'" + username +  "\';";
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

    public void addUser(String username, String password, String email, int year, String major, String userType) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "INSERT INTO USER " +
                    "VALUES (\'" + username + "\',\'" + password + "\',\'" +
                    email + "\'," +
                    year + ",\'" + major + "\',\'" + userType + "\')";
            System.out.println(sqlQuery);
            statement.executeUpdate(sqlQuery);
            System.out.println("User with username: (" + username + ") added successfully");
            String sqlQuery2 = "DELETE FROM USER WHERE Username = \'" + username + "\'";
            statement.executeUpdate(sqlQuery2);
            System.out.println("User with username: (" + username + ") deleted successfully");
        } catch(SQLException e) {
            System.err.println("Exception in getting user from user table: " + e.getMessage());
            throw e;
        }
    }

    public void addAllCategories() throws SQLException{
        try {
            Statement statement = conn.createStatement();
            List<String> categories = Arrays.asList("computing for good", "doing good for your neighborhood",
                    "reciprocal teaching and learning", "urban development", "adaptive learning",
                    "technology for social good", "sustainable communities", "crowd-sourced", "collaborative action");
            for (String category : categories) {
                String sqlQuery = "INSERT INTO CATEGORY " +
                        "VALUES (\'" + category + "\')";
                System.out.println(sqlQuery);
                statement.executeUpdate(sqlQuery);
            }
            System.out.println("All Categories added successfully");

        } catch(SQLException e) {
            System.err.println("Exception in getting user from user table: " + e.getMessage());
            throw e;
        }
    }

    public ObservableList<String> getAllCategories() throws SQLException {
        List<String> categories = new ArrayList<String>();
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT * FROM CATEGORY";
            ResultSet res = statement.executeQuery(sqlQuery);
            while (res.next()) {
                String currCategory = res.getString("Name");
                categories.add(currCategory);
            }
            return FXCollections.observableList(categories);
        } catch(SQLException e) {
            System.err.println("Exception in getting user from user table: " + e.getMessage());
            throw e;
        }
    }

    public void addAllDesignations() throws SQLException{
        try {
            Statement statement = conn.createStatement();
            List<String> designations = Arrays.asList("Sustainable Communities", "Community");
            for (String designation : designations) {
                String sqlQuery = "INSERT INTO DESIGNATION " +
                        "VALUES (\'" + designation + "\')";
                System.out.println(sqlQuery);
                statement.executeUpdate(sqlQuery);
            }
            System.out.println("All Designations added successfully");

        } catch(SQLException e) {
            System.err.println("Exception in getting user from user table: " + e.getMessage());
            throw e;
        }
    }

    public ObservableList<String> getAllDesignations() throws SQLException {
        List<String> designations = new ArrayList<String>();
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT * FROM DESIGNATION";
            ResultSet res = statement.executeQuery(sqlQuery);
            while (res.next()) {
                String currDesignation = res.getString("Name");
                designations.add(currDesignation);
            }
            return FXCollections.observableList(designations);
        } catch(SQLException e) {
            System.err.println("Exception in getting user from user table: " + e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        SQLController controller = new SQLController();
        System.out.println(controller.checkIfUserExists("Hi"));
        try {
            controller.addUser("Rohan", "1234", "riyengar6@gatech.edu", 2017, "EE", "ADMIN");
        } catch(SQLException e) {
            System.err.println("Error adding user to database");
        }
        try {
            List<String> designations = controller.getAllDesignations();
            for (String s: designations) {
                System.out.println(s);
            }
        } catch(SQLException e) {
            System.err.println("Error adding categories to database");
        }
    }
}
