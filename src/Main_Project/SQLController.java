package Main_Project;

import java.sql.*;
import Main_Project.User;
import javafx.collections.FXCollections;
import javafx.collections.ModifiableObservableListBase;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public void updateUser(String username, String major, String year) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "UPDATE USER SET Major= \'" + major + "\', Year = \'"+ year + "\' WHERE Username = \'" + username+ "\'";
            statement.executeUpdate(sqlQuery);
        } catch(SQLException e) {
            System.err.println("Exception in getting user's department: " + e.getMessage());
            throw e;
        }
    }

    public void addProject(String name, String advisor, String advisorEmail, String desc, String designation, int est,
                           String majorReq, String yearReq, String departmentReq, String ... categories) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sqlProject = "INSERT INTO PROJECT (Name, EstimatedNumStudents, Description, AdvisorName,AdvisorEmail, DesignationName) " +
                    "VALUES (\'" + name + "\'," + est +",\'" + desc + "\',\'" + advisor + "\',\'" + advisorEmail + "\',\'" + designation + "\')";
            statement.executeUpdate(sqlProject);
            for (String cat: categories) {
                String sqlProjectIs = "INSERT INTO PROJECT_IS_CATEGORY (ProjectName, CategoryName) VALUES (\'" + name + "\',\'" + cat + "\')";
                statement.executeUpdate(sqlProjectIs);
            }
            if (majorReq != null) {
                String sqlProjectReq = "INSERT INTO PROJECT_REQUIREMENT (Name, Requirement) VALUES (\'" + name + "\',\'" + majorReq + "\')";
                statement.executeUpdate(sqlProjectReq);
            }
            if (yearReq != null) {
                String sqlProjectReqq = "INSERT INTO PROJECT_REQUIREMENT (Name, Requirement) VALUES (\'" + name + "\',\'" + yearReq + "\')";
                statement.executeUpdate(sqlProjectReqq);
            }
            if (departmentReq != null) {
                String sqlProjectReqqq = "INSERT INTO PROJECT_REQUIREMENT (Name, Requirement) VALUES (\'" + name + "\',\'" + departmentReq + "\')";
                statement.executeUpdate(sqlProjectReqqq);
            }
            System.out.println("Project with name: (" + name + ") added successfully");
        } catch(SQLException e) {
            System.err.println("Exception in adding project" + e.getMessage());
            throw e;
        }
    }
    public void addAllProjects() throws SQLException {
        try {
            addProject("Excel Peer Support Network", "Marnie Williams", "mwilliams@gatech.edu", "Excel (www.excel.gatech.edu) is a four-year, dual certificate program for students with intellectual and developmental disabilities. The Peer Support Network is designed to provide the individualized support necessary for Excel students to thrive at Georgia Tech.",
                    "Community", 60, "CS students only", "senior students only", null, "Computing for good", "doing good for your neighborhood", "reciprocal teaching and learning");
            addProject("ESW Hydroponics/Urban Farming Project", "Nicole Kinnard", "nkinnard12@gatech.edu", "The Hydroponics/Urban Farming Project experiments with different ways to grow produce in urban areas using limited space and water resources. We investigate both soil-based and hydroponic methods of growing in order to find the most efficient, economically viable, and environmentally sustainable way to grow produce in Atlanta.",
                    "Sustainable Communities", 7, null, "Junior students only", null, "urban development","sustainable communities");
            addProject("Excel Current Events","Ashley Bidlack", "abidlack313@gatech.edu","Excel Current Events is a participation (not for credit) course for degree-seeking students who are interested in developing their communication skills in conversations with adults with intellectual and developmental disabilities.",
                    "Community", 15, "COC students only", "senior students only", null , "computing for good", "doing good for your neighborhood", "reciprocal teaching and learning", "technology for social good");
            addProject("Shakespeare in Prison Project", "Sarah Higinbotham", "shiginbotham4@gatech.edu", "As the world celebrates the 400th anniversary of Shakespeare’s death in 2016, Georgia Tech students will travel to a high-security men’s prison outside Atlanta to discuss Shakespeare with incarcerated students.",
                    "Community",20, "College of Design students only", null, null, "urban development","sustainable communities");
            addProject("Know Your Water Project", "Neha Kumar", "nkumar12@gatech.edu", "This project will allow students to be part of a large, crowd-sourced study – at little cost to themselves – to contribute to a knowledge bank of how different communities treat and track their water quality. If you are interested in participating in this study, please let us know.",
                    "Sustainable Communities", 10, "CS students only","senior students only", null, "sustainable communities", "crowd sourced");
            addProject("Epic Intentions", "Yeji Lee", "ylee31@gatech.edu", "Epic Intentions connects an interdisciplinary team of students with a local nonprofit to apply technical skills for social and civic good to help make the nonprofits make a greater impact in the community.",
                    "Community", 20, "None", null, null,"doing good for your neighborhood", "collaborative action");
            addProject("Design of mHealth Tools for HIV Outreach Workers in Gujarat (India)", "Neha Kumar", "nkumar12@gatech.edu", "This project allows students to design tools that workerse in rural parts of India can use to combat HIV",
                    "Community", 10, "International Affairs students only", "COC students only", null, "technology for social good");
            addProject("Engineers for a Sustainable World Waste-Derived Nutrient System", "Nicole Kennard", "nkennard5@gatech.edu", "This project allows engineers to analyze how to fix depreciated soil and reinvigorite fields in these conditions",
                    "Sustainable Communities", 20, "Material Science and Engineering only", null, null, "technology for social good", "sustainable communities");
            addProject("Excel Collaborative Community Garden", "Marnie Williams", "mwilliams@gatech.edu", "A course on creating technology for a sustainable garden",
                    "Sustainable Communities", 30, "None", null, null, "urban development", "sustainable communities");
            addProject("Georgia Tech Waste Audit","Anne Rogers","arogers9@gatech.edu", "Course on tracking and auditing the waste at Georgia Tech through statistical methods",
                    "Sustainable Communities", 10, "None", null, null, "urban development","sustainable communities");
            addProject("Georgia Tech Poetry Competition", "Some Teacher", "steacher@gatech.edu", "Students will create and present poetry to their peers",
                    "Community", 5, null, "freshman students only", null, "crowd sourced");
            addProject("Designing Sustainable Power Grids", "Taylor John", "tjohn1@gatech.edu", "Students will design and create power grids to replace existing architecture in the United States",
                    "Sustainable Communities", 10, "EE students only", "senior students only", null, "urban development", "sustainable communities", "collaborative action");
            addProject("Creating Sustainable Gardens", "Ashley Patterson","apatterson@gatech.edu", "Students will learn which plants make a sustainable garden, focusing on urban communities",
                    "Sustainable Communities", 50, "None", null, null, "urban development", "sustainable communities");
            addProject("Bug Tracking System", "Tom Harrison", "tharrison@gatech.edu", "Students will design automated processes to track bugs and other issues in codes",
                    "Community", 40, "senior students only", null, null, "collaborative action", "computing for good");
            addProject("Dynamic Programming to Optimize Sustainable Wearables", "Tom Connelly", "tconnelly", "Students will learn how to implement dynamic programming algorithms to breakthrough the wearable market",
                    "Sustainable Communities", 20, "CS students only", "senior students only", null, "computing for good");
            addProject("Community Dance Lessons", "Diane Shin", "dshin4@gatech.edu", "Students will take community dance lessons and learn about different cultures through types of dance",
                    "Community", 20, "freshmen students only", "sophomore students only", null, "collaborative action");
            addProject("Study Abroad Farming Research", "Best Professor", "bprofessor1@gatech.edu", "Students will travel to South America, Europe, and Asia to research different methods of farming and how they could be improved to create a more sustainable community",
                    "Sustainable Communities", 35, "junior students only", "senior students only", null, "reciprocal teaching and learning", "collaborative action", "crowd sourced");
            addProject("The Design of Mobile Control Car Security System", "Haley Cruz", "hcruz19@gatech.edu", "Students will design a security system for cars that can be controlled by mobile phones and allows effective two-way communications between the alarm system and the car owner",
                    "Community", 15, "ME students only", "senior students only", null, "computing for good", "collaborative action");
            addProject("Football and Community", "Phil Simms", "psimms@gatech.edu", "Students will interact with a professional NFL commentator and write a paper on how football creates community",
                    "Community", 100, "freshman students only", "sophomore students only", null, "collaborative action");
            addProject("The Essence of Napping", "Last Teacher", "lteacher9@gatech.edu", "Students will learn how napping builds community",
                    "Community", 200, "None", null, null, "collaborative action");
        } catch(SQLException e) {
            System.err.println("Exception in adding course");
            throw e;
        }
    }


    public void addCourse(String name, String num, String instr, int est, String desig, String ... categories) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sqlCourse = "INSERT INTO COURSE (Name, CourseNumber, Instructor, EstimatedNumStudents, DesignationName) " +
                    "VALUES (\'" + name + "\',\'" + num +"\',\'" + instr + "\'," + est + ",\'" + desig + "\')";
            System.out.println(sqlCourse);
            statement.executeUpdate(sqlCourse);
            for (String cat: categories) {
                String sqlCourseIs = "INSERT INTO COURSE_IS_CATEGORY (CourseName, CategoryName) VALUES (\'" + name + "\',\'" + cat + "\')";
                System.out.println(sqlCourseIs);
                statement.executeUpdate(sqlCourseIs);
            }
            System.out.println("Course with name: (" + name + ") added successfully");
        } catch(SQLException e) {
            System.err.println("Exception in adding course" + e.getMessage());
            throw e;
        }
    }

    public void addApplication(String sName, String pName, java.util.Date date, String status) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String realDate = formatter.format(date);
            String sqlApp = "INSERT INTO APPLY (ProjectName, StudentName, Date, Status) " +
                    "VALUES (\'" + pName + "\',\'" + sName + "\',\'" + realDate + "\',\'" + status + "\')";
            statement.executeUpdate(sqlApp);
            System.out.println("Application for: (" + pName + " from:" + sName + ") added successfully");
        } catch (SQLException e) {
            System.err.println("Exception in adding applications " + e.getMessage());
        }
    }

    public void addAllApplications() throws SQLException, ParseException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            addApplication("Hi", "Creating Sustainable Gardens", formatter.parse("2016-05-14"), "Pending");
            addApplication("Hi", "Georgia Tech Waste Audit", formatter.parse("2016-03-12"), "Accepted");
            addApplication("Hi", "Georgia Tech Poetry Competition", formatter.parse("2016-10-14"), "Denied");
            addApplication("Joe", "Football and Community", formatter.parse("2016-01-16"), "Accepted");
            addApplication("Joe", "Bug Tracking System", formatter.parse("2016-03-25"), "Pending");
            addApplication("Kim", "The Essence of Napping", formatter.parse("2016-06-20"), "Pending");
            addApplication("Kim", "Excel Current Events", formatter.parse("2015-02-21"), "Denied");
            addApplication("Sloan", "Epic Intentions", formatter.parse("2016-07-26"), "Denied");
        } catch (SQLException e) {
           throw e;
        }
    }

    public void addAllCourses() throws SQLException {
        try {
            addCourse("Green Infrastructure: EPA Campus Rainwater Challenge","ARCH 4803","Richard Dagenhart", 26, "Sustainable Communities", "computing for good", "doing good for your neighborhood");
            addCourse("Problems in Biomedical Engineering", "BMED 2250", "Barbara Burks Fasse", 300, "Community", "computing for good", "doing good for your neighborhood");
            addCourse("Environment Policy and Politics", "PUBU 3315", "Alice Favero", 25, "Sustainable Communities", "urban development", "sustainable communities");
            addCourse("Urban Forest", "EAS 2803", "Monica Halka", 10, "Sustainable Communities", "urban development", "sustainable communities");
            addCourse("Honors Biological Principles; Honors Organismal Biology", "BIOL 1511", "Brian Hammer", 150, "Sustainable Communities", "sustainable Communities");
            addCourse("Introduction to Environmental Science", "EAS 1600", "Dana Hartley", 600, "Community", "urban development", "sustainable communities");
            addCourse("Habitable Planet", "EAS 1601", "Dana Hartley", 600, "Community", "urban development", "sustainable communities");
            addCourse("Physics of the Weather", "EAS 2750", "Dana Hartley", 30, "Community","urban development", "sustainable communities");
            addCourse("Project Management", "MGT 4450", "Richard Saap", 40, "Community", "adaptive learning", "urban development");
            addCourse("Ecomedia: Screening Sustainability", "ENGL 1102", "Sarah O Brien", 20, "Sustainable Communities", "sustainable communities", "collaborative action");
            addCourse("Technologies of Representation", "LMC 3414", "Lauren Klein", 50, "Community", "collaborative action", "crowd-sourced");
            addCourse("Community Historians & Westside Speaks", "LMC 4699", "Christopher LeDantec", 45, "sustainable communities", "technology for social good");
            addCourse("Semester in the City: Engaging Westside Communitites", "HTS 2803", "Todd Michney", 100, "Community", "urban development", "sustainable communities");
            addCourse("Spanish Service Learning", "SPAN 4150", "Juan Carlos Rodrigeuz", 25, "Community", "recipricol teaching and learning");
            addCourse("Sustainable Business Projects", "MGT 4803", "Jay Cranman", 45, "Sustainable Communities", "sustainable communities", "technology for social good");
            addCourse("Construction Management and Megaprojects", "CEE 4803", "Baabak Ashuri", 70, "Community","urban development", "sustainable Communities");
            addCourse("Sustainable Aquaponic Systems: The Food, Energy, Water Nexus", "CEE 4699", "Steven Van Ginkel", 40, "Sustainable Communities", "doing good for your neighborhood", "adaptive learning");
            addCourse("Objects and Design", "CS 2340", "Robert Waters", 250, "Sustainable Communities", "computing for good", "technology for social good");
            addCourse("First-Year Seminar", "GT 1000", "Colette Fournier", 150, "Community", "collaborative action");
            addCourse("Introduction to Database Systems", "CS 4400", "Monica Sweat", 100, "Sustainable Communities", "computing for good", "technology for social good");
        } catch(SQLException e) {
            System.err.println("Exception in adding course");
            throw e;
        }
    }

    public ProjectInfo getProjectInfo(String pName) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT AdvisorName, AdvisorEmail, Description, DesignationName, EstimatedNumStudents FROM PROJECT WHERE Name = \'" + pName + "\'";
            ResultSet projSet = statement.executeQuery(sqlQuery);
            if (!projSet.next()) {
                throw new SQLDataException("No project with name " + pName);
            }
            String advName = projSet.getString("AdvisorName");
            String advEmail = projSet.getString("AdvisorEmail");
            String desc = projSet.getString("Description");
            String desig = projSet.getString("DesignationName");
            int num = projSet.getInt("EstimatedNumStudents");
            String sqlCat = "SELECT CategoryName FROM PROJECT_IS_CATEGORY WHERE ProjectName = \'" + pName + "\'";
            ResultSet resSetCat = statement.executeQuery(sqlCat);
            List<String> categories = new ArrayList<String>();
            while (resSetCat.next()) {
                categories.add(resSetCat.getString("CategoryName"));
            }
            String sqlReq = "SELECT Requirement FROM PROJECT_REQUIREMENT WHERE Name = \'" + pName + "\'";
            ResultSet resSetReq = statement.executeQuery(sqlReq);
            List<String> reqs = new ArrayList<String>();
            while (resSetReq.next()) {
                reqs.add(resSetReq.getString("Requirement"));
            }
            return new ProjectInfo(advName, advEmail, desc, desig, num, categories, reqs);
        } catch(SQLException e) {
            System.err.println("Exception in getting project info " + e.getMessage());
            throw e;
        }
    }

    public CourseInfo getCourseInfo(String cName) throws SQLException {
        try {
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT CourseNumber, Instructor, EstimatedNumStudents , DesignationName FROM COURSE WHERE Name =\'" + cName + "\'";
            ResultSet courseSet = statement.executeQuery(sqlQuery);
            if (!courseSet.next()) {
                throw new SQLDataException("No course with name " + cName);
            }
            String courseNum = courseSet.getString("CourseNumber");
            String instr = courseSet.getString("Instructor");
            String desig = courseSet.getString("DesignationName");
            int num = courseSet.getInt("EstimatedNumStudents");
            String sqlCat = "SELECT CategoryName FROM COURSE_IS_CATEGORY WHERE CourseName = \'" + cName + "\'";
            ResultSet resSetCat = statement.executeQuery(sqlCat);
            List<String> categories = new ArrayList<String>();
            while (resSetCat.next()) {
                categories.add(resSetCat.getString("CategoryName"));
            }
            return new CourseInfo(courseNum, instr, desig, num, categories);
        } catch(SQLException e) {
            System.err.println("Exception in getting course info " + e.getMessage());
            throw e;
        }
    }

    public static void main(String[] args) {
        SQLController controller = new SQLController();
        System.out.println(controller.checkIfUserExists("Hi"));
        try {
            controller.addAllDepartments();
            controller.addAllCategories();
            controller.addAllDesignations();
            controller.addAllMajors();
            controller.addAllUsers();
        } catch(SQLException e) {
            System.err.println("error adding departments to database");
        }
        try {
            controller.addAllCourses();
            controller.addAllProjects();
            controller.addAllApplications();
            System.out.println(controller.getProjectInfo("Study Abroad Farming Research"));
        } catch(Exception e) {
            System.err.println("Error getting project");
        }
//        try {
//            List<String> designations = controller.getAllMajorNames();
//            for (String s: designations) {
//                System.out.println(s);
//            }
//        } catch(SQLException e) {
//            System.err.println("Error adding categories to database");
//        }
    }
}
