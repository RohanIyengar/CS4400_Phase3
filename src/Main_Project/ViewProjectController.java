package Main_Project;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class ViewProjectController {

    /* ===============================================================
                             VIEW PROJECT SCREEN FUNCTIONS
       ===============================================================
    * */

    @FXML
    private Text projectTitle;
    @FXML
    private Text adminName;

    @FXML
    private Text projectDescription;

    @FXML
    private Text designationName;

    @FXML
    private Text requirementsName;

    @FXML
    private Text numberOfStudents;
    @FXML
    private Text cannotApplyMsg;

    @FXML
    private void setBackViewProject() {
        MasterController.getInstance().loadMainPageScene();
    }

    @FXML
    private void setApply() {
        Boolean requirementsMet = false;
        if(!requirementsMet) {
            cannotApplyMsg.setVisible(true);
        }

    }
}
