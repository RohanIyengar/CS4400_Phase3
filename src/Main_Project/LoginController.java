package Main_Project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class LoginController {
    public Stage primaryStage;

    private SQLController sqlContr = new SQLController();

    private Boolean getIsValid(String u, String p) {
        try {
            sqlContr.getUser(u, p);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    private Boolean getIsAdmin(String u, String p) {
        try {
            return sqlContr.getUser(u, p).getUserType().equals("Admin");
        } catch (SQLException e) {
            return false;
        }
    }
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


            boolean isValid = getIsValid(username.getText(), password.getText());
            if (isValid) {
                System.out.println("Logged in! Welcome, " + username.getText());
                boolean isAdmin = getIsAdmin(username.getText(),password.getText());

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
