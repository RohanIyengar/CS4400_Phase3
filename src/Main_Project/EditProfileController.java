package Main_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class EditProfileController {
    SQLController sContr = new SQLController();

    /* ===============================================================
                           EDIT PROFILE SCREEN FUNCTIONS
     ===============================================================
  * */
    @FXML
    private ComboBox<String> majorList;
    @FXML
    private ComboBox<String> yearList;

    @FXML
    private Text designationList;

    @FXML
    private Text departmentList;


    @FXML
    private final ObservableList<String> yList =
            FXCollections.observableArrayList("Freshman", "Sophomore",
                    "Junior", "Senior");


    @FXML
    private final ObservableList<String> mList = getMajorList();

    @FXML
    public ObservableList<String> getMajorList() {
        ObservableList<String> toRet = FXCollections.observableArrayList();
        try {
            toRet = sContr.getAllMajorNames();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toRet;
    }

    @FXML
    public String getdesigList() {
        String toRet ="";
        try {
            System.out.println(MasterController.getUsername());
            toRet = sContr.getDepartment(MasterController.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toRet;
    }


    @FXML
    private void setBackEditProfile() {
        try {
            sContr.updateUser(MasterController.getUsername(), majorList.getSelectionModel()
                    .getSelectedItem().toString(),yearList.getSelectionModel()
                    .getSelectedItem()
                    .toString() );
            System.out.println("Updated major to: " + majorList.getSelectionModel()
                    .getSelectedItem().toString());

            System.out.println("Updated year to: " + yearList.getSelectionModel()
                    .getSelectedItem()
                    .toString());
            MasterController.getInstance().loadMeScene();
        } catch (SQLException e) {
            System.out.println("Nothing was changed.");
            MasterController.getInstance().loadMeScene();
        }
        catch (NullPointerException e) {
            System.out.println("Nothing was changed.");
            MasterController.getInstance().loadMeScene();
        }


        departmentList.setText(getdesigList());

    }

    public final void initialize() throws IOException {
        majorList.getItems().clear();
        majorList.getItems().addAll(mList);

        yearList.getItems().clear();
        yearList.getItems().addAll(yList);

//        designationList.setText("Pulling from database...");

    }
}