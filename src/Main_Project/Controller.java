package Main_Project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Controller {
    private Scene root;
    public Stage primaryStage;

    /* ===============================================================
                             LOGIN SCREEN FUNCTIONS
       ===============================================================
    * */
    @FXML
    private Button loginBtn;

    @FXML
    private Button registerBtn;

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private Text invalidMsg;
    @FXML
    private Text invalidUsername;
    @FXML
    private Text invalidPassword;


    @FXML
    private void setLoginBtn() {
        System.out.println(username);
        if (username == null || username.getText().trim().isEmpty()) {
            if (password != null || !password.getText().trim().isEmpty()) {
                invalidPassword.setVisible(false);
            }
//            System.out.println("No username entered.");
//            username.setText("Please fill in a username!");
            invalidUsername.setVisible(true);
         }

        else if (password == null || password.getText().trim().isEmpty()) {
            if (username != null || !username.getText().trim().isEmpty()){
                invalidUsername.setVisible(false);
            }
//            System.out.println("No password entered.");
//            password.setText("Please fill in a password!");
            invalidPassword.setVisible(true);
        } else {
            invalidUsername.setVisible(false);
            invalidPassword.setVisible(false);
            //TODO: CHECK HERE FOR VALID LOG IN CREDENTIALS
            boolean isValid = true;
            if (isValid) {
                //TODO: CHECK IF THE USER LOG IN IS ADMIN OR NOT
                boolean isAdmin = true;
                if (isAdmin) {
                    MasterController.getInstance().loadChooseFunctionalityScene();
                } else {
                    MasterController.getInstance().loadMainPageScene();
                }


            }
            else {
                invalidMsg.setVisible(true);
            }

        }


    }

    @FXML
    private void setRegistrationBtn() throws IOException {
          Parent root = null;
        root = FXMLLoader.load(getClass().getResource("NewStudentRegistration.fxml"));
        primaryStage = new Stage();
        primaryStage.setTitle("Group 54 Phase 3");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();


    }


    /* ===============================================================
                             REGISTRATION SCREEN FUNCTIONS
       ===============================================================
    * */
    @FXML
    private Text emailExistsMsg;

    @FXML
    private TextField gtEmailAddr;

    @FXML
    private TextField usernameNSR;
    @FXML
    private TextField password1NSR;
    @FXML
    private TextField password2NSR;

    @FXML
    private Text invalidUsernameNSR;

    @FXML
    private Text invalidPasswordNSR;

    @FXML
    private Text wrongPasswordNSR;

    @FXML
    private Text invalidgtEmailAddrNSR;
    @FXML
    private Button createBtn;
    @FXML
    private void setCreateBtn() {
        invalidUsernameNSR.setVisible(false);
        invalidPasswordNSR.setVisible(false);
        wrongPasswordNSR.setVisible(false);
        invalidgtEmailAddrNSR.setVisible(false);
        Parent root = null;
        Boolean gtEmailExists = false;
        if (gtEmailExists) {
            //TODO: CHECK TO SEE IF DATABASE HAS GT EMAIL ALREADY OR NOT
            emailExistsMsg.setVisible(true);
        } else if (usernameNSR == null || usernameNSR.getText().trim()
                .isEmpty()){
            //CHECK TO SEE IF WE HAVE AN INPUTTED USERNAME
            invalidUsernameNSR.setVisible(true);
//            System.out.println("This is the usernameNSR: " + usernameNSR.toString());
        } else if(gtEmailAddr == null || gtEmailAddr.getText().trim()
                .isEmpty()){
            //CHECK TO SEE IF WE HAVE AN INPUTTED PASSWORD
            invalidUsernameNSR.setVisible(false);
            invalidgtEmailAddrNSR.setVisible(true);

        } else if(password1NSR == null || password1NSR.getText().trim()
                .isEmpty()){
            //CHECK TO SEE IF WE HAVE AN INPUTTED PASSWORD
            invalidUsernameNSR.setVisible(false);
            invalidPasswordNSR.setVisible(true);

        } else if (!password1NSR.getText().equals(password2NSR.getText())){
            //CHECK TO SEE IF WE HAVE MATCHING PASSWORDS
            invalidgtEmailAddrNSR.setVisible(false);
            wrongPasswordNSR.setVisible(true);
        } else {
            wrongPasswordNSR.setVisible(false);
//            CHECK TO SEE IF WE CREATED AN ACCOUNT SUCCESSFULLY
            Boolean success = true;
            if (success) {
                System.out.println("Made an account succesfully.");
                Stage stage = (Stage) createBtn.getScene().getWindow();
                // do what you have to do
                stage.close();
            }
            else {
                System.out.println("Could not create account successfully...");
            }

        }


    }

    /* ===============================================================
                             MAIN PAGE SCREEN FUNCTIONS
       ===============================================================
    * */


//    @FXML
//    private void setAddCategory() {
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource("category.fxml"));
//            primaryStage = new Stage();
//            primaryStage.setTitle("Group 54 Phase 3");
//            primaryStage.setScene(new Scene(root, 700, 500));
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    /* ===============================================================
                             ME SCREEN FUNCTIONS
       ===============================================================
    * */

        @FXML
    private void setMe() {
//        Parent root = null;
            //            root = FXMLLoader.load(getClass().getResource("Me.fxml"));
//            primaryStage = new Stage();
//            primaryStage.setTitle("Group 54 Phase 3");
//            primaryStage.setScene(new Scene(root));
//            primaryStage.show();
            MasterController.getInstance().loadMeScene();

        }

    @FXML
    private void setEditProfile() {
//        Parent root = null;
        //            root = FXMLLoader.load(getClass().getResource("EditProfile.fxml"));
//            primaryStage = new Stage();
//            primaryStage.setTitle("Group 54 Phase 3");
//            primaryStage.setScene(new Scene(root));
//            primaryStage.show();
        MasterController.getInstance().loadEditProfileScene();

    }

    @FXML
    private void setMyApplication() {
//        Parent root = null;
        //            root = FXMLLoader.load(getClass().getResource("MyApplication" +
//                    ".fxml"));
//            primaryStage = new Stage();
//            primaryStage.setTitle("Group 54 Phase 3");
//            primaryStage.setScene(new Scene(root));
//            primaryStage.show();
        MasterController.getInstance().loadMyApplicationScene();

    }

    @FXML
    private void setBackMe() {
        MasterController.getInstance().loadMainPageScene();
    }

    /* ===============================================================
                             EDIT PROFILE SCREEN FUNCTIONS
       ===============================================================
    * */
    @FXML
    private void setBackEditProfile() {
        MasterController.getInstance().loadMeScene();
    }

    /* ===============================================================
                             MY APPLICATION SCREEN FUNCTIONS
       ===============================================================
    * */
    @FXML
    private void setBackMyApplication() {
        MasterController.getInstance().loadMeScene();
    }

    /* ===============================================================
                             VIEW PROJECT SCREEN FUNCTIONS
       ===============================================================
    * */

    @FXML
    private Text projectTitle;
    @FXML
    private Text adminName;

    @FXML
    private Text projectDescription;

    @FXML
    private Text designationName;

    @FXML
    private Text requirementsName;

    @FXML
    private Text numberOfStudents;

    @FXML
    private void setBackViewProject() {
        MasterController.getInstance().loadMainPageScene();
    }

     /* ===============================================================
                             VIEW COURSE SCREEN FUNCTIONS
       ===============================================================
    * */

    @FXML
    private Text courseTitle;

    @FXML
    private Text courseName;

    @FXML
    private Text instructorName;

    @FXML
    private Text designationNameCourse;

    @FXML
    private Text categoryName;

    @FXML
    private Text numberOfStudentsCourse;

    @FXML
    private void setBackViewCourse() {
        MasterController.getInstance().loadMainPageScene();
    }

      /* ===============================================================
                            ADMIN VIEW: CHOOSE FUNCTIONALITY SCREEN FUNCTIONS
       ===============================================================
    * */



    @FXML
    private void setViewPopularProjects() {
        MasterController.getInstance().loadPopularProjectScene();
    }

    @FXML
    private void setViewApplicationReport() {
        MasterController.getInstance().loadApplicationReportScene();
    }

    @FXML
    private void setViewApplications() {
        MasterController.getInstance().loadViewApplicationScene();
    }

    @FXML
    private void setAddAProject() {
        MasterController.getInstance().loadAddAProject();
    }

    @FXML
    private void setAddACourse() {
        MasterController.getInstance().loadAddACourse();
    }

    @FXML
    private void setLogoutBtn() {
        MasterController.getInstance().loadLoginScene();
    }

     /* ===============================================================
                            ADMIN VIEW: APPLICATION REPORT SCREEN FUNCTIONS
       ===============================================================
    * */

    @FXML
    private void setBackAdmin() {
        MasterController.getInstance().loadChooseFunctionalityScene();
    }


}