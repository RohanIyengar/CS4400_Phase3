package Main_Project;

import javafx.fxml.FXML;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class EditProfileController {
    /* ===============================================================
                           EDIT PROFILE SCREEN FUNCTIONS
     ===============================================================
  * */
    @FXML
    private void setBackEditProfile() {
        MasterController.getInstance().loadMeScene();
    }
}
