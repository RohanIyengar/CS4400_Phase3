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
import java.sql.SQLException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class AddACourseController {
    SQLController sContr = new SQLController();

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
        }
//        else if (designationCourse.getSelectionModel().getSelectedIndex()
//                == -1) {
//            invalidStudentsAddCourse.setVisible(false);
//            invalidDesignationCourse.setVisible(true);
//        } else if (categoryCourse.getSelectionModel().getSelectedIndex()
//                == -1) {
//            invalidDesignationCourse.setVisible(false);
//            invalidCategoryCourse.setVisible(true);
//        }
        else {


            try {
                System.out.println("do i reach here");

                sContr.addCourse(courseNameAddCourse.getText(),
                        courseNumberAddCourse.getText(),
                        instructorCourse.getText(),
                        Integer.parseInt(estimatedNumberofStudents
                                .getText()),
                        designationCourse.getSelectionModel().getSelectedItem(),
                        categoryCourse.getSelectionModel().getSelectedItem());
            } catch (SQLException e) {
                System.out.println("Could not add course.");
            }
//            catch (NullPointerException e) {
//                System.out.println("Could not add course.");
//            }
        }
    }

        @FXML
        private final ObservableList<String> desigList =getdesigList();

    @FXML
    private final ObservableList<String> cat1List =getcatList();

    @FXML
    public ObservableList<String> getcatList() {
        ObservableList<String> toRet = FXCollections.observableArrayList();
        try {
            toRet = sContr.getAllCategories();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toRet;
    }
    @FXML
    public ObservableList<String> getdesigList() {
        ObservableList<String> toRet = FXCollections.observableArrayList();
        try {
            toRet = sContr.getAllDesignations();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toRet;
    }

    public final void initialize() throws IOException {
        designationCourse.getItems().clear();
        designationCourse.getItems().addAll(desigList);

        categoryCourse.getItems().clear();
        categoryCourse.getItems().addAll(cat1List);

        }
    }

