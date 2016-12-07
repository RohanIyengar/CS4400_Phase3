package Main_Project;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

import java.sql.SQLException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class ViewCourseController {
    SQLController sContr = new SQLController();
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

    @FXML
    private void loadNewCourse() {
        courseTitle.setText(MainPageController.tempText);
        courseTitle.setVisible(true);


        try {
            CourseInfo data = sContr.getCourseInfo(MainPageController.tempText);

            courseName.setText(data.getCourseNum());
            courseName.setVisible(true);

            instructorName.setText(data.getInstructor());
            instructorName.setVisible(true);

            designationNameCourse.setText(data.getDesignation());
            designationNameCourse.setVisible(true);

            categoryName.setText(String.valueOf(data.getCategories()));
            categoryName.setVisible(true);

            numberOfStudentsCourse.setText(String.valueOf(data.getStudents()));
            numberOfStudentsCourse.setVisible(true);
        } catch (SQLException e) {
            courseName.setText("Can't find on database");
            courseName.setVisible(true);

            instructorName.setText("Can't find on database");
            instructorName.setVisible(true);

            designationNameCourse.setText("Can't find on database");
            designationNameCourse.setVisible(true);

            categoryName.setText(String.valueOf("Can't find on database"));
            categoryName.setVisible(true);

            numberOfStudentsCourse.setText(String.valueOf("Can't find on database"));
            numberOfStudentsCourse.setVisible(true);
        }
        catch (NullPointerException e) {
           System.out.println("Null Pointer.");
        }


    }
}
