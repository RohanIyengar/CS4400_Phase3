package Main_Project;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class RegistrationController {

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
}
