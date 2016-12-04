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
    private SplitMenuButton category1Btn;


    @FXML
    private SplitMenuButton category2Btn;

    @FXML
    private SplitMenuButton projDesignation;

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
    private final ObservableList<String> testerList =
            FXCollections.observableArrayList("Human",
                    "Flapper", "Bonzoid", "Ugaite", "Buzzite",
                    "Strandoid", "Pegasite", "Techoid");


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
        else if (category1Btn.getText().equals("Select")) {
            invalidDescription.setVisible(false);
            invalidCategory.setVisible(true);
        }
        else if (projDesignation.getText().equals("Select")) {
            invalidCategory.setVisible(false);
            invalidDesignation.setVisible(true);
        }
        else {
            return;
        }

    }

    @FXML
    private ComboBox tester;

    @FXML
    private ChoiceBox tester2;
    @FXML
    private void setBackAdmin() {
        MasterController.getInstance().loadChooseFunctionalityScene();
    }
    public final void initialize() throws IOException {
        tester.setItems(testerList);
    }

}
