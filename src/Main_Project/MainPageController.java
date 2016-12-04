package Main_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.*;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class MainPageController {

      /* ===============================================================
                             MAIN PAGE SCREEN FUNCTIONS
       ===============================================================
    * */

    @FXML
    private ComboBox<String> yearMP;


    @FXML
    private ComboBox<String> designationMP;

    @FXML
    private ComboBox<String> categoryMP;

    @FXML
    private ComboBox<String> majorMP;


//    @FXML
//    private void setAddCategory() {
//        Parent root = null;
//        try {
//            root = FXMLLoader.load(getClass().getResource("category.fxml"));
//            primaryStage = new Stage();
//            primaryStage.setTitle("Group 54 Phase 3");
//            primaryStage.setScene(new Scene(root, 700, 500));
//            primaryStage.show();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


    @FXML
    private RadioButton projectRadio;
    @FXML
    private RadioButton courseRadio;
    @FXML
    private RadioButton bothRadio;


    @FXML
    private TableView mainPageTable;

    @FXML
    private void setResetFilter() {
        projectRadio.setSelected(false);
        courseRadio.setSelected(false);
        bothRadio.setSelected(false);

    }

    @FXML
    private final ObservableList<MainPageTableEntry> populateTable =
            FXCollections.observableArrayList(
     new MainPageTableEntry("Name1", "Course1"),
     new MainPageTableEntry("Name2", "Course2"),
    new MainPageTableEntry("Name2", "Course2"),
    new MainPageTableEntry("Name2", "Course2")

            );

    @FXML
    private void setApplyFilter() {


        mainPageTable.setEditable(true);
        mainPageTable.setItems(populateTable);
    }

    @FXML
    private void setBothRadio() {
        projectRadio.setSelected(false);
        courseRadio.setSelected(false);
        bothRadio.setSelected(true);
    }

    @FXML
    private void setRadioBtn() {
        if(projectRadio.isSelected() && courseRadio.isSelected()){
            setBothRadio();
        } else {
            bothRadio.setSelected(false);
        }

    }

    @FXML
    private void setMe() {

        MasterController.getInstance().loadMeScene();

    }
    @FXML
    private final ObservableList<String> yearList =
            FXCollections.observableArrayList("199", "123",
                    "24124");
    @FXML
    private final ObservableList<String> cat1List =
            FXCollections.observableArrayList("Humanties", "computing",
                    "sciences");
    @FXML
    private final ObservableList<String> desigList =
            FXCollections.observableArrayList("lol", "a",
                    "asd");
    @FXML
    private final ObservableList<String> majorList =
            FXCollections.observableArrayList("CS", "BME",
                    "ChemE");


    public final void initialize() throws IOException {
        yearMP.getItems().clear();
        yearMP.getItems().addAll(cat1List);

        designationMP.getItems().clear();
        designationMP.getItems().addAll(desigList);

        categoryMP.getItems().clear();
        categoryMP.getItems().addAll(cat1List);

        majorMP.getItems().clear();
        majorMP.getItems().addAll(majorList);

        TableColumn nameCol = new TableColumn("Name");
        TableColumn courseCol = new TableColumn("Course");
        nameCol.setCellValueFactory(
                new PropertyValueFactory<MainPageTableEntry,String>("name")
        );
        nameCol.setMaxWidth(200);
        courseCol.setCellValueFactory(
                new PropertyValueFactory<MainPageTableEntry,String>("course")
        );
        courseCol.setMaxWidth(200);
        mainPageTable.getColumns().clear();
        mainPageTable.getColumns().addAll(nameCol, courseCol);
    }

}
