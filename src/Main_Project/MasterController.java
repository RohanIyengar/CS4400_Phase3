package Main_Project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;

import java.lang.Object;

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
    /**
     * Creates a singleton
     */
    private final static MasterController masterController
            = new MasterController();

    /**
     * Returns the single instance of MasterController within the entire scope of
     * the project.
     *
     * @return MasterController
     */
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

    public final void loadViewcoureScene() {
        stage.setScene(viewCourseScene);
    }

    public final void loadChooseFunctionalityScene() {
        stage.setScene(chooseFunctionalityScene);
    }

    public final void loadApplicationReportScene() {
        stage.setScene(applicationReportScene);
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
