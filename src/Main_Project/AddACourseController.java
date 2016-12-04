package Main_Project;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class AddACourseController {
    @FXML
    private void setBackAdmin() {
        MasterController.getInstance().loadChooseFunctionalityScene();
    }
}
    /* ===============================================================
                          ADMIN: ADD A COURSE FUNCTIONS
       ===============================================================
    * */
    @FXML
    private TextField courseNumberAddCourse;

    @FXML
    private TextField courseNameAddCourse;

    @FXML
    private TextField instructorCourse;

    @FXML
    private TextField estimatedNumberofStudents;

    @FXML
    private SplitMenuButton designationCourse;

    @FXML
    private SplitMenuButton categoryCourse;

    @FXML
    private Text invalidCourseNum;

    @FXML
    private Text invalidCourseName;

    @FXML
    private Text invalidInstructorName;

    @FXML
    private Text invalidDesignationCourse;

    @FXML
    private Text invalidCategoryCourse;

    @FXML
    private Text invalidStudentsAddCourse;

    @FXML
    private Button submitBtn1;

    @FXML
    private void setSubmitBtn1() {
        if(courseNumberAddCourse == null || courseNumberAddCourse.getText().trim().isEmpty()) {
            invalidCourseNum.setVisible(true);

        } else if (courseNameAddCourse == null || courseNumberAddCourse.getText().trim().isEmpty()) {
            invalidCourseNum.setVisible(false);
            invalidCourseName.setVisible(true);
        }
        else if (instructorCourse == null || instructorCourse.getText().trim().isEmpty()) {
            invalidCourseName.setVisible(false);
            invalidInstructorName.setVisible(true);
        }
        else if (estimatedNumberofStudents == null || estimatedNumberofStudents.getText().trim().isEmpty()) {
            invalidInstructorName.setVisible(false);
            invalidStudentsAddCourse.setVisible(true);
        }
        else if (designationCourse.getText().equals("Select")) {
            invalidStudentsAddCourse.setVisible(false);
            invalidDesignationCourse.setVisible(true);
        }
        else if (categoryCourse.getText().equals("Select")) {
            invalidDesignationCourse.setVisible(false);
            invalidCategoryCourse.setVisible(true);
        }
        else {
            return;

        }
    }