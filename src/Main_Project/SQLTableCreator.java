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
//            conn = DriverManager.getConnection("jdbc:mysql://localhost/test",
//                    "rohan",
//                    "rohan");
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
                    "Year VARCHAR(10) NOT NULL," +
                    "Major VARCHAR(40) NOT NULL," +
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

    public void createProjectTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE PROJECT" +
                    "(Name VARCHAR(100) NOT NULL," +
                    "Description VARCHAR(400) NOT NULL," +
                    "AdvisorEmail VARCHAR(25) NOT NULL," +
                    "AdvisorName VARCHAR(25) NOT NULL," +
                    "EstimatedNumStudents INT NOT NULL," +
                    "DesignationName VARCHAR(25) NOT NULL," +
                    "PRIMARY KEY (Name)," +
                    "FOREIGN KEY (DesignationName) REFERENCES DESIGNATION(Name))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Project Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating project table: " + e.getMessage());
        }
    }

    public void deleteProjectTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE PROJECT ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Project Table deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting project table: " + e.getMessage());
        }
    }

    public void createProjectRequirementTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE PROJECT_REQUIREMENT" +
                    "(Name VARCHAR(100) NOT NULL," +
                    "Requirement VARCHAR(40) NOT NULL," +
                    "PRIMARY KEY (Name, Requirement)," +
                    "FOREIGN KEY (Name) REFERENCES PROJECT(Name))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Project Requirement Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating project requirement table: " + e.getMessage());
        }
    }

    public void deleteProjectRequirementTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE PROJECT_REQUIREMENT ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Project Requirement Table deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting project requirement table: " + e.getMessage());
        }
    }

    public void createDesignationTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE DESIGNATION" +
                    "(Name VARCHAR(25) NOT NULL," +
                    "PRIMARY KEY (Name))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Designation Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating designation table: " + e.getMessage());
        }
    }

    public void deleteDesignationTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE DESIGNATION ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Designation deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting designation table: " + e.getMessage());
        }
    }

    public void createCategoryTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE CATEGORY" +
                    "(Name VARCHAR(40) NOT NULL," +
                    "PRIMARY KEY (Name))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Category Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating category table: " + e.getMessage());
        }
    }

    public void deleteCategoryTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE CATEGORY ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Category Table deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting category table: " + e.getMessage());
        }
    }

    public void createMajorTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE MAJOR" +
                    "(Name VARCHAR(40) NOT NULL," +
                    "DeptName VARCHAR(40) NOT NULL," +
                    "PRIMARY KEY (Name)," +
                    "FOREIGN KEY (DeptName) REFERENCES DEPARTMENT(Name))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Major Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating major table: " + e.getMessage());
        }
    }

    public void deleteMajorTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE MAJOR ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Major Table deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting major table: " + e.getMessage());
        }
    }

    public void createDepartmentTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE DEPARTMENT" +
                    "(Name VARCHAR(40) NOT NULL," +
                    "PRIMARY KEY (Name))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Department Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating department table: " + e.getMessage());
        }
    }

    public void deleteDepartmentTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE DEPARTMENT ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Major Table deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting major table: " + e.getMessage());
        }
    }

    public void createCourseTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE COURSE" +
                    "(Name VARCHAR(60) NOT NULL," +
                    "CourseNumber VARCHAR(20) NOT NULL," +
                    "Instructor VARCHAR(40) NOT NULL," +
                    "EstimatedNumStudents INT NOT NULL," +
                    "DesignationName VARCHAR(25) NOT NULL," +
                    "PRIMARY KEY (Name)," +
                    "FOREIGN KEY (DesignationName) REFERENCES DESIGNATION(Name))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Course Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating course table: " + e.getMessage());
        }
    }

    public void deleteCourseTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE COURSE ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Course Table deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting course table: " + e.getMessage());
        }
    }

    public void createApplyTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE APPLY" +
                    "(ProjectName VARCHAR(100) NOT NULL," +
                    "StudentName VARCHAR(15) NOT NULL," +
                    "Date VARCHAR(20) NOT NULL," +
                    "Status	VARCHAR(20)	NOT NULL," +
                    "PRIMARY KEY (ProjectName, StudentName)," +
                    "FOREIGN KEY (ProjectName) REFERENCES PROJECT(Name)," +
                    "FOREIGN KEY (StudentName) REFERENCES USER(Username))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Apply Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating apply table: " + e.getMessage());
        }
    }

    public void deleteApplyTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE APPLY ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Apply Table deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting apply table: " + e.getMessage());
        }
    }

    public void createProjectIsCategoryTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE PROJECT_IS_CATEGORY" +
                    "(ProjectName VARCHAR(100) NOT NULL," +
                    "CategoryName VARCHAR(40) NOT NULL," +
                    "PRIMARY KEY (ProjectName, CategoryName)," +
                    "FOREIGN KEY (ProjectName) REFERENCES PROJECT(Name)," +
                    "FOREIGN KEY (CategoryName) REFERENCES CATEGORY(Name))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Project_Is_Category Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating project_is_category table: " + e.getMessage());
        }
    }

    public void deleteProjectIsCategoryTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE PROJECT_IS_CATEGORY ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Project_Is_Category Table deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting project_is_category: " + e.getMessage());
        }
    }

    public void createCourseIsCategoryTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "CREATE TABLE COURSE_IS_CATEGORY" +
                    "(CourseName VARCHAR(60) NOT NULL," +
                    "CategoryName VARCHAR(40) NOT NULL," +
                    "PRIMARY KEY (CourseName, CategoryName)," +
                    "FOREIGN KEY (CourseName) REFERENCES COURSE(Name)," +
                    "FOREIGN KEY (CategoryName) REFERENCES CATEGORY(Name))";
            statement.executeUpdate(sqlQuery);
            System.out.println("Course_Is_Category Table created in database");
        } catch(SQLException e) {
            System.err.println("Exception in creating course_is_category table: " + e.getMessage());
        }
    }

    public void deleteCourseIsCategoryTable() {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "DROP TABLE COURSE_IS_CATEGORY ";
            statement.executeUpdate(sqlQuery);
            System.out.println("Course_Is_Category Table deleted in database");
        } catch(SQLException e) {
            System.err.println("Exception in deleting course_is_category table: " + e.getMessage());
        }
    }

    public void createAllTables() {
        //Creates all tables in the correct order
        this.createDesignationTable();
        this.createCategoryTable();
        this.createDepartmentTable();
        this.createMajorTable();
        this.createUserTable();
        this.createCourseTable();
        this.createProjectTable();
        this.createProjectRequirementTable();
        this.createApplyTable();
        this.createProjectIsCategoryTable();
        this.createCourseIsCategoryTable();
    }

    public void deleteAllTables() {
        this.deleteCourseIsCategoryTable();
        this.deleteProjectIsCategoryTable();
        this.deleteApplyTable();
        this.deleteProjectRequirementTable();
        this.deleteProjectTable();
        this.deleteCourseTable();
        this.deleteUserTable();
        this.deleteMajorTable();
        this.deleteDepartmentTable();
        this.deleteCategoryTable();
        this.deleteDesignationTable();
    }

    public static void main(String args[]) {
        SQLTableCreator creator = new SQLTableCreator();
        creator.createAllTables();
        //creator.deleteAllTables();
    }
}

