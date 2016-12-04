package Main_Project;

import javafx.fxml.FXML;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class PopularProjectController {
    @FXML
    private void setBackAdmin() {
        MasterController.getInstance().loadChooseFunctionalityScene();
    }
}
