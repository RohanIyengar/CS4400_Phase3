package Main_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class MeController {

    SQLController sContr = new SQLController();

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

