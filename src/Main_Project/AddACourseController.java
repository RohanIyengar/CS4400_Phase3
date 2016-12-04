package Main_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class AddACourseController {
    @FXML
    private void setBackAdmin() {
        MasterController.getInstance().loadChooseFunctionalityScene();
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
    private ComboBox<String> designationCourse;

    @FXML
    private ComboBox<String> categoryCourse;

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
    private Button submitBtn;

    @FXML
    private void setSubmitBtn() {
        if (courseNumberAddCourse == null || courseNumberAddCourse.getText().trim().isEmpty()) {
            invalidCourseNum.setVisible(true);

        } else if (courseNameAddCourse == null || courseNameAddCourse.getText().trim().isEmpty()) {
            invalidCourseNum.setVisible(false);
            invalidCourseName.setVisible(true);
        } else if (instructorCourse == null || instructorCourse.getText().trim().isEmpty()) {
            invalidCourseName.setVisible(false);
            invalidInstructorName.setVisible(true);
        } else if (estimatedNumberofStudents == null || estimatedNumberofStudents.getText().trim().isEmpty()) {
            invalidInstructorName.setVisible(false);
            invalidStudentsAddCourse.setVisible(true);
        } else if (designationCourse == null) {
            invalidStudentsAddCourse.setVisible(false);
            invalidDesignationCourse.setVisible(true);
        } else if (categoryCourse == null) {
            invalidDesignationCourse.setVisible(false);
            invalidCategoryCourse.setVisible(true);
        } else {
            return;
        }
    }

        @FXML
        private final ObservableList<String> desigList =
                FXCollections.observableArrayList("CS", "BME",
                        "ChemE");

    @FXML
    private final ObservableList<String> cat1List =
            FXCollections.observableArrayList("CS", "BME",
                    "ChemE");

    public final void initialize() throws IOException {
        designationCourse.getItems().clear();
        designationCourse.getItems().addAll(desigList);

        categoryCourse.getItems().clear();
        categoryCourse.getItems().addAll(cat1List);


        }
    }

