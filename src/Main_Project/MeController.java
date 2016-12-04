package Main_Project;

import javafx.fxml.FXML;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class MeController {



    /* ===============================================================
                             ME SCREEN FUNCTIONS
       ===============================================================
    * */



    @FXML
    private void setEditProfile() {

        MasterController.getInstance().loadEditProfileScene();

    }

    @FXML
    private void setMyApplication() {

        MasterController.getInstance().loadMyApplicationScene();

    }

    @FXML
    private void setBackMe() {
        MasterController.getInstance().loadMainPageScene();
    }
}

