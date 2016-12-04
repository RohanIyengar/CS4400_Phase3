package Main_Project;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.Serializable;


public class Main  extends Application implements Serializable {

    /**
     Stage.
     */
    static Stage primaryStage ;

    /**
     Config 1 scene.
     */

    @Override
    public void start(Stage stage) throws Exception{
        MasterController controller = MasterController.getInstance();
        controller.setStage(stage);
        controller.loadLoginScene();
        stage.setTitle("Group 54 - Phase 3");
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
