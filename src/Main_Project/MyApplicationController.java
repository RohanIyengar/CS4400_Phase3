package Main_Project;

import javafx.fxml.FXML;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class MyApplicationController {

    /* ===============================================================
                            MY APPLICATION SCREEN FUNCTIONS
      ===============================================================
   * */
    @FXML
    private void setBackMyApplication() {
        MasterController.getInstance().loadMeScene();
    }
}
