package Main_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class AddAProjectController {
    /* ===============================================================
                          ADMIN: ADD A PROJECT FUNCTIONS
       ===============================================================
    * */
    SQLController sContr = new SQLController();

    @FXML
    private TextField projectName;

    @FXML
    private TextField advisorNameAddProj;

    @FXML
    private TextField advisorEmail;
    @FXML
    private TextField projDescription;
    @FXML
    private TextField numStudents;

    @FXML
    private ComboBox<String> category1Btn;


    @FXML
    private ComboBox<String> category2Btn;

    @FXML
    private ComboBox<String> projDesignation;

    @FXML
    private ComboBox<String> majorReq;

    @FXML
    private ComboBox<String> yearReq;

    @FXML
    private ComboBox<String> depReq;


    @FXML
    private Text invalidProjectName;

    @FXML
    private Text invalidAdvisorName;

    @FXML
    private Text invalidEmail;

    @FXML
    private Text invalidNumber;

    @FXML
    private Text invalidDescription;

    @FXML
    private Text invalidCategory;

    @FXML
    private Text invalidDesignation;

    @FXML
    private Button submitBtn;




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
    @FXML
    public ObservableList<String> getDepList() {
        ObservableList<String> toRet = FXCollections.observableArrayList();
        try {
            toRet = sContr.getAllDepartments();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toRet;
    }

    @FXML
    private final ObservableList<String> cat1List = getcatList();

    @FXML
    private final ObservableList<String> cat2List = getcatList();

    @FXML
    private final ObservableList<String> desigList = getdesigList();

    @FXML
    private final ObservableList<String> majorList = getMajorList();
    @FXML
    private final ObservableList<String> yearList =
            FXCollections.observableArrayList("Freshman", "Sophomore",
                    "Junior", "Senior");

    @FXML
    private final ObservableList<String> depList = getDepList();

    @FXML
    private void setSubmitBtn() {

        if(projectName == null || projectName.getText().trim().isEmpty()) {
            invalidProjectName.setVisible(true);
        } else if (advisorNameAddProj == null || advisorNameAddProj.getText().trim().isEmpty()) {
            invalidProjectName.setVisible(false);
            invalidAdvisorName.setVisible(true);
        }
        else if (advisorEmail == null || advisorEmail.getText().trim().isEmpty()) {
            invalidAdvisorName.setVisible(false);
            invalidEmail.setVisible(true);
        }
        else if (projDescription == null || projDescription.getText().trim().isEmpty()) {
            invalidEmail.setVisible(false);
            invalidDescription.setVisible(true);
        }
        else if (category1Btn == null) {
            invalidDescription.setVisible(false);
            invalidCategory.setVisible(true);
        }

        else if (projDesignation == null) {
            invalidCategory.setVisible(false);
            invalidDesignation.setVisible(true);
        }
        else {
            return;
        }

    }


    @FXML
    private void setBackAdmin() {
        MasterController.getInstance().loadChooseFunctionalityScene();
    }
    public final void initialize() throws IOException {
        category1Btn.getItems().clear();
        category1Btn.getItems().addAll(cat1List);

        category2Btn.getItems().clear();
        category2Btn.getItems().addAll(cat2List);

        projDesignation.getItems().clear();
        projDesignation.getItems().addAll(desigList);

        majorReq.getItems().clear();
        majorReq.getItems().addAll(majorList);

        yearReq.getItems().clear();
        yearReq.getItems().addAll(yearList);

        depReq.getItems().clear();
        depReq.getItems().addAll(depList);
    }

}
