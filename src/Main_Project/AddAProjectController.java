package Main_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class AddAProjectController {
    /* ===============================================================
                          ADMIN: ADD A PROJECT FUNCTIONS
       ===============================================================
    * */
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
    private Text validEmail;

    @FXML
    private Text invalidDescription;

    @FXML
    private Text invalidCategory;

    @FXML
    private Text invalidDesignation;

    @FXML
    private Button submitBtn;

    @FXML
    private final ObservableList<String> cat1List =
            FXCollections.observableArrayList("Science", "Math", "history");

    @FXML
    private final ObservableList<String> cat2List =
            FXCollections.observableArrayList("Politics", "Psyc", "Chem");

    @FXML
    private final ObservableList<String> desigList =
            FXCollections.observableArrayList("lol", "ok", "yah");

    @FXML
    private final ObservableList<String> majorList =
            FXCollections.observableArrayList("CS", "BME", "ChemE");
    @FXML
    private final ObservableList<String> yearList =
            FXCollections.observableArrayList("1919", "1888", "2020");
    @FXML
    private final ObservableList<String> depList =
            FXCollections.observableArrayList("Humanties", "computing",
                    "sciences");

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
