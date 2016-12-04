package Main_Project;

import javafx.fxml.FXML;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class ChooseFunctionalityController {
     /* ===============================================================
                            ADMIN VIEW: CHOOSE FUNCTIONALITY SCREEN FUNCTIONS
       ===============================================================
    * */



    @FXML
    private void setViewPopularProjects() {
        MasterController.getInstance().loadPopularProjectScene();
    }

    @FXML
    private void setViewApplicationReport() {
        MasterController.getInstance().loadApplicationReportScene();
    }

    @FXML
    private void setViewApplications() {
        MasterController.getInstance().loadViewApplicationScene();
    }

    @FXML
    private void setAddAProject() throws InterruptedException {

        MasterController.getInstance().loadAddAProject();


    }

    @FXML
    private void setAddACourse() {
        MasterController.getInstance().loadAddACourse();
    }

    @FXML
    private void setLogoutBtn() {
        MasterController.getInstance().loadLoginScene();
    }
    @FXML
    private void setBackAdmin() {
        MasterController.getInstance().loadChooseFunctionalityScene();
    }

}
