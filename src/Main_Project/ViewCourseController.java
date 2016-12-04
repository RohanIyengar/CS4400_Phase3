package Main_Project;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class ViewCourseController {
    /* ===============================================================
                             VIEW COURSE SCREEN FUNCTIONS
       ===============================================================
    * */

    @FXML
    private Text courseTitle;

    @FXML
    private Text courseName;

    @FXML
    private Text instructorName;

    @FXML
    private Text designationNameCourse;

    @FXML
    private Text categoryName;

    @FXML
    private Text numberOfStudentsCourse;

    @FXML
    private void setBackViewCourse() {
        MasterController.getInstance().loadMainPageScene();
    }
}
