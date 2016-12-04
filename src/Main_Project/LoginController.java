package Main_Project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class LoginController {
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

        if (username == null || username.getText().trim().isEmpty()) {
            if (password != null || !password.getText().trim().isEmpty()) {
                invalidPassword.setVisible(false);
            }

            invalidUsername.setVisible(true);
        }

        else if (password == null || password.getText().trim().isEmpty()) {
            if (username != null || !username.getText().trim().isEmpty()){
                invalidUsername.setVisible(false);
            }

            invalidPassword.setVisible(true);
        } else {
            invalidUsername.setVisible(false);
            invalidPassword.setVisible(false);
            //TODO: CHECK HERE FOR VALID LOG IN CREDENTIALS

            boolean isValid = true;
            System.out.println(username.getText());
            if (isValid) {
                //TODO: CHECK IF THE USER LOG IN IS ADMIN OR NOT

                boolean isAdmin = false;

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

}
