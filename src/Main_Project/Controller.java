package Main_Project;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Parent;


<<<<<<< Updated upstream
    }

    @FXML
    private void setMyApplication() {

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
    private Text cannotApplyMsg;

    @FXML
    private void setBackViewProject() {
        MasterController.getInstance().loadMainPageScene();
    }

    @FXML
    private void setApply() {
        Boolean requirementsMet = false;
        if(!requirementsMet) {
            cannotApplyMsg.setVisible(true);
        }

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
        setUpAddProject();
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


    /* ===============================================================
                          ADMIN: ADD A PROJECT FUNCTIONS
       ===============================================================
    * */
    @FXML
    private TextField projectName;

    @FXML
    private TextField advisorNameAddProj;

    @FXML
    private TextField advisorEmail;
    @FXML
    private TextField projDescription;
    @FXML
    private TextField numStudents;

    @FXML
    private SplitMenuButton category1Btn;


    @FXML
    private SplitMenuButton category2Btn;

    @FXML
    private SplitMenuButton projDesignation;

    @FXML
    private Text invalidProjectName;

    @FXML
    private Text invalidAdvisorName;

    @FXML
    private Text invalidEmail;

    @FXML
    private Text validEmail;

    @FXML
    private Text invalidDescription;

    @FXML
    private Text invalidCategory;

    @FXML
    private Text invalidDesignation;

    @FXML
    private Text invalidNumber;

    @FXML
    private Button submitBtn;

    @FXML
    private void setSubmitBtn() {
        setUpAddProject();
        if(projectName == null || projectName.getText().trim().isEmpty()) {
            invalidProjectName.setVisible(true);
        } else if (advisorNameAddProj == null || advisorNameAddProj.getText().trim().isEmpty()) {
            invalidProjectName.setVisible(false);
            invalidAdvisorName.setVisible(true);
        }
        else if (advisorEmail == null || advisorEmail.getText().trim().isEmpty()) {
            invalidAdvisorName.setVisible(false);
            invalidEmail.setVisible(true);
        }
        else if (projDescription == null || projDescription.getText().trim().isEmpty()) {
            invalidEmail.setVisible(false);
            invalidDescription.setVisible(true);
        }
        else if (category1Btn.getText().equals("Select")) {
            invalidDescription.setVisible(false);
            invalidCategory.setVisible(true);
        }
<<<<<<< Updated upstream
        else if (projDesignation.getText().equals("Select")) {
=======
        else if (category2Btn == null) {
            invalidCategory.setVisible(false);
            invalidCategory.setVisible(true);
        }
        else if (numStudents == null || numStudents.getText().trim().isEmpty()) {
            invalidCategory.setVisible(false);
            invalidNumber.setVisible(true);
        }
        else if (projDesignation == null) {
>>>>>>> Stashed changes
            invalidCategory.setVisible(false);
            invalidDesignation.setVisible(true);
        }
        else {
            return;

        }

    }
=======
public class Controller {
>>>>>>> Stashed changes




}