package Main_Project;

import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.text.Text;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class ViewProjectController {
    SQLController sContr = new SQLController();
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
//        if(projectTitle.isVisible()) {
//            projectTitle.setVisible(false);
//        }
//       if(adminName.isVisible()) {
//           adminName.setVisible(false);
//       }
//       if(projectDescription.isVisible()) {
//           projectDescription.setVisible(false);
//       }
//       if(designationName.isVisible()) {
//           designationName.setVisible(false);
//       }
//        if(requirementsName.isVisible()){
//            requirementsName.setVisible(false);
//        }
//        if(numberOfStudents.isVisible()) {
//            numberOfStudents.setVisible(false);
//        }
        MasterController.getInstance().loadMainPageScene();
    }

    @FXML
    private void clickToView() {

        projectTitle.setText(MainPageController.tempText);
        projectTitle.setVisible(true);

        try {
            ProjectInfo data = sContr.getProjectInfo(MainPageController.tempText);

            adminName.setText(data.getAdvisorName());
            adminName.setVisible(true);

            projectDescription.setText(data.getDescription());
            projectDescription.setVisible(true);

            designationName.setText(data.getDesignation());
            designationName.setVisible(true);

            requirementsName.setText(String.valueOf(data.getRequirements()));
            requirementsName.setVisible(true);

            numberOfStudents.setText(String.valueOf(data.getStudents()));
            numberOfStudents.setVisible(true);
        } catch (SQLException e) {
            System.out.println("Was not able to find that project on our " +
                    "database...");
        }
        catch (NullPointerException e) {
            System.out.println("Was not able to find that project on our " +
                    "database...");
        }
    }

    @FXML
    private Button clickToViewBtn;

    @FXML
    private void setApply() {
        Boolean requirementsMet = false;
        if(!requirementsMet) {
            cannotApplyMsg.setVisible(true);
        }

    }

}