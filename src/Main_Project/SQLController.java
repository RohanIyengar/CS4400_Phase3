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
    private String hi;

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
            String sqlQuery = "SELECT Username,Password,UserType FROM USER WHERE Username=\'" + username +  "\'" +
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

    public void addUser(String username, String password, String email, String year, String major, String userType) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "INSERT INTO USER " +
                    "VALUES (\'" + username + "\',\'" + password + "\',\'" +
                    email + "\',\'" +
                    year + "\',\'" + major + "\',\'" + userType + "\')";
            System.out.println(sqlQuery);
            statement.executeUpdate(sqlQuery);
            System.out.println("User with username: (" + username + ") added successfully");
            //String sqlQuery2 = "DELETE FROM USER WHERE Username = \'" + username + "\'";
            //statement.executeUpdate(sqlQuery2);
            //System.out.println("User with username: (" + username + ") deleted successfully");
        } catch(SQLException e) {
            System.err.println("Exception in adding user to user table: " + e.getMessage());
            throw e;
        }
    }

    public void addAllUsers() throws SQLException {
        try {
            addUser("Rohan", "Rohan", "riyengar6@gatech.edu", "Senior", "Electrical Engineering", "Admin");
            addUser("Ashika", "Ashika", "aganesh32@gatech.edu", "Senior", "Computer Science", "Admin");
            addUser("Sonali", "Sonali", "ssingh313@gatech.edu", "Senior", "Computer Science", "Admin");
            addUser("Hardik", "Hardik", "htuteja3@gatech.edu", "Senior", "Industrial Engineering", "Admin");
            addUser("Monica", "Monica", "sweat@gatech.edu", "Senior", "Computer Science", "Admin");
            addUser("Test", "Test", "test@gatech.edu", "Freshman", "Undecided", "User");
            addUser("Joe", "Joe", "joe@gatech.edu", "Freshman", "Computer Engineering", "User");
            addUser("Moe", "Moe", "moe@gatech.edu", "Freshman", "Electrical Engineering", "User");
            addUser("Lo", "Lo", "lo@gatech.edu", "Freshman", "Industrial Design", "User");
            addUser("Go", "Go", "go@gatech.edu", "Freshman", "Business Administration", "User");
            addUser("Jim", "Jim", "jim@gatech.edu", "Sophomore", "Biomedical Engineering", "User");
            addUser("Kim", "Kim", "kim@gatech.edu", "Sophomore", "Mechanical", "User");
            addUser("Lim", "Lim", "lim@gatech.edu", "Sophomore", "Undecided", "User");
            addUser("Mim", "Mim", "mim@gatech.edu", "Sophomore", "Computer Science", "User");
            addUser("Pim", "Pim", "pim@gatech.edu", "Sophomore", "Computational Media", "User");
            addUser("Joan", "Joan", "joan@gatech.edu", "Junior", "Undecided", "User");
            addUser("Goan", "Goan", "goan@gatech.edu", "Junior", "Computational Media", "User");
            addUser("Sloan", "Sloan", "sloan@gatech.edu", "Junior", "Computer Science", "User");
            addUser("Ploan", "Ploan", "ploan@gatech.edu", "Junior", "Psychology", "User");
            addUser("Eloan", "Eloan", "eloan@gatech.edu", "Junior", "Economics", "User");
            addUser("Sai", "Sai", "sai@gatech.edu", "Senior", "Electrical Engineering", "User");
            addUser("Hi", "Hi", "hi@gatech.edu", "Senior", "Undecided", "User");
            addUser("Bye", "Bye", "bye@gatech.edu", "Senior", "Computer Science", "User");
            addUser("Jii", "Jii", "jii@gatech.edu", "Senior", "International Affairs", "User");
            addUser("Mii", "Mii", "mii@gatech.edu", "Senior", "Physics", "User");
        } catch(SQLException e) {
            System.err.println("Exception in adding user");
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
            System.err.println("Exception in adding category from user table: " + e.getMessage());
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
            System.err.println("Exception in adding designation to table: " + e.getMessage());
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

    public void addAllDepartments() throws SQLException {
        try {
            Statement statement = conn.createStatement();
            List<String> departments = Arrays.asList("College of Computing", "College of Design",
                    "College of Engineering", "College of Sciences",
                    "Ivan Allen College of Liberal Arts", "Scheller College of Business");
            for (String dept : departments) {
                String sqlQuery = "INSERT INTO DEPARTMENT " +
                        "VALUES (\'" + dept + "\')";
                System.out.println(sqlQuery);
                statement.executeUpdate(sqlQuery);
            }
            System.out.println("All Departments added successfully");

        } catch(SQLException e) {
            System.err.println("Exception in getting user from user table: " + e.getMessage());
            throw e;
        }
    }

    public ObservableList<String> getAllDepartments() throws SQLException {
        List<String> departments = new ArrayList<String>();
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT * FROM DEPARTMENT";
            ResultSet res = statement.executeQuery(sqlQuery);
            while (res.next()) {
                String currDepartment = res.getString("Name");
                departments.add(currDepartment);
            }
            return FXCollections.observableList(departments);
        } catch(SQLException e) {
            System.err.println("Exception in getting user from user table: " + e.getMessage());
            throw e;
        }
    }

    public void addAllMajors() throws SQLException {
        try {
            Statement statement = conn.createStatement();
            List<String> queries = new ArrayList<String>();
            queries.add("INSERT INTO MAJOR " + "VALUES ('Computational Media', 'College of Computing')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Computer Science', 'College of Computing')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Architecture', 'College of Design')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Industrial Design', 'College of Design')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Music Technology', 'College of Design')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Aerospace Engineering', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Biomedical Engineering', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Chemical and Biomolecular', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Chemical and Biomolecular+BioTech', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Civil Engineering', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Computer Engineering', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Electrical Engineering', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Environmental Engineering', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Industrial Engineering', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Materials Science and Engineering', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Mechanical Engineering', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Nuclear and Radiological Engineering', 'College of Engineering')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Applied Mathematics', 'College of Sciences')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Applied Physics', 'College of Sciences')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Biochemistry', 'College of Sciences')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Biology', 'College of Sciences')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Chemistry', 'College of Sciences')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Discrete Mathematics', 'College of Sciences')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Earth and Atmospheric Sciences', 'College of Sciences')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Physics', 'College of Sciences')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Psychology', 'College of Sciences')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Applied Language+Intercultural Studies', 'Ivan Allen College of Liberal Arts')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Economics', 'Ivan Allen College of Liberal Arts')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Economics and International Affairs', 'Ivan Allen College of Liberal Arts')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Global Economics and Modern Languages', 'Ivan Allen College of Liberal Arts')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('History, Technology, and Society', 'Ivan Allen College of Liberal Arts')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('International Affairs', 'Ivan Allen College of Liberal Arts')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('International Affairs+Modern Languages', 'Ivan Allen College of Liberal Arts')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Literature, Media, and Communication', 'Ivan Allen College of Liberal Arts')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Public Policy', 'Ivan Allen College of Liberal Arts')");
            queries.add("INSERT INTO MAJOR " + "VALUES ('Business Administration', 'Scheller College of Business')");
            for (String sqlQuery : queries) {
                System.out.println(sqlQuery);
                statement.executeUpdate(sqlQuery);
            }
            System.out.println("All Majors added successfully");

        } catch (SQLException e) {
            System.err.println("Exception in getting user from user table: " + e.getMessage());
            throw e;
        }
    }

    public ObservableList<String> getAllMajorNames() throws SQLException {
        List<String> majors = new ArrayList<String>();
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT * FROM MAJOR";
            ResultSet res = statement.executeQuery(sqlQuery);
            while (res.next()) {
                String currDepartment = res.getString("Name");
                majors.add(currDepartment);
            }
            return FXCollections.observableList(majors);
        } catch(SQLException e) {
            System.err.println("Exception in getting majors from major table: " + e.getMessage());
            throw e;
        }
    }

    public String getDepartment(String username) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT DeptName FROM MAJOR WHERE Name = (SELECT Major FROM USER WHERE Username = \'" + username +"\')";
            //System.out.println(sqlQuery);
            ResultSet res = statement.executeQuery(sqlQuery);
            //String result = "";
            if (!res.next()) {
                throw new SQLDataException("User not in database");
            }
            return res.getString("DeptName");
        } catch(SQLException e) {
            System.err.println("Exception in getting user's department: " + e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        SQLController controller = new SQLController();
        System.out.println(controller.checkIfUserExists("Hi"));
//        try {
//            controller.addAllDepartments();
//            controller.addAllCategories();
//            controller.addAllDesignations();
//            controller.addAllMajors();
//            controller.addAllUsers();
//        } catch(SQLException e) {
//            System.err.println("error adding departments to database");
//        }
        try {
            System.out.println(controller.getDepartment("Hi"));
        } catch(SQLException e) {
            System.err.println("Error getting dept");
        }
        try {
            List<String> designations = controller.getAllMajorNames();
            for (String s: designations) {
                System.out.println(s);
            }
        } catch(SQLException e) {
            System.err.println("Error adding categories to database");
        }
    }
}
