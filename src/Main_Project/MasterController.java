package Main_Project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;


public class MasterController implements Serializable {

    private Stage stage;


    private Scene loginScene;


    private Scene editProfileScene;


    private Scene mainPageScene;

    private Scene meScene;


    private Scene myApplicationScene;


    private Scene newStudentRegistrationScene;

    private Scene viewProjectScene;
    private Scene viewCourseScene;
    private Scene chooseFunctionalityScene;
    private Scene applicationReportScene;
    private Scene popularProjectScene;
    private Scene viewApplicationScene;

    private Scene addProjectScene;
    private Scene addCourseScene;
    /**
     * Creates a singleton
     */
    private final static MasterController masterController
            = new MasterController();

    public static MasterController getInstance() {
        return masterController;
    }



    private MasterController() {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            loginScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource("EditProfile.fxml"));
            editProfileScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
            mainPageScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource("Me.fxml"));
            meScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource(
                    "MyApplication.fxml"));
            myApplicationScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource(
                    "NewStudentRegistration.fxml"));
            newStudentRegistrationScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource(
                    "ViewProject.fxml"));
            viewProjectScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource(
                    "ViewCourse.fxml"));
            viewCourseScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource(
                    "ChooseFunctionality.fxml"));
            chooseFunctionalityScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource(
                    "ApplicationReport.fxml"));
            applicationReportScene = new Scene(root);


            root = FXMLLoader.load(getClass().getResource(
                    "PopularProject.fxml"));
            popularProjectScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource(
                    "Application.fxml"));
            viewApplicationScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource(
                    "AddaProject.fxml"));
            addProjectScene = new Scene(root);

            root = FXMLLoader.load(getClass().getResource(
                    "AddaCourse.fxml"));
            addCourseScene = new Scene(root);


        } catch (IOException e) {
            System.out.println("MasterController(): " + e);
        }
    }


    public final void loadLoginScene() {
        stage.setScene(loginScene);
    }


    public final void loadEditProfileScene() {
        stage.setScene(editProfileScene);
    }

    public final void loadMainPageScene() {
        stage.setScene(mainPageScene);
    }


    public final void loadMeScene() {
        stage.setScene(meScene);
    }


    public final void loadMyApplicationScene() {
        stage.setScene(myApplicationScene);
    }

    public final void loadNewStudentRegistrationScene() {
        stage.setScene(newStudentRegistrationScene);
    }


    public final void loadViewProjectScene() {
        stage.setScene(viewProjectScene);
    }

    public final void loadViewCourseScene() {
        stage.setScene(viewCourseScene);
    }

    public final void loadChooseFunctionalityScene() {
        stage.setScene(chooseFunctionalityScene);
    }

    public final void loadApplicationReportScene() {
        stage.setScene(applicationReportScene);
}


    public final void loadPopularProjectScene() {
        stage.setScene(popularProjectScene);
    }

    public final void loadViewApplicationScene() {
        stage.setScene(viewApplicationScene);
    }

    public final void loadAddAProject() {
        stage.setScene(addProjectScene);

    }

    public final void loadAddACourse() {
        stage.setScene(addCourseScene);
    }




    /**
     * Sets stage to given Stage.
     *
     * @param stage Stage
     */
    public final void setStage(final Stage stage) {
        this.stage = stage;
    }



}
