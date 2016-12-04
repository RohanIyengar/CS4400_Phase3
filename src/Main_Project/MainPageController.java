package Main_Project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.sql.SQLException;

import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.scene.input.MouseEvent;
/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class MainPageController {

    SQLController sContr = new SQLController();
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
     new MainPageTableEntry("Bio Degradable Compost", "Course"),
     new MainPageTableEntry("Animal Life Cycle", "Project"),
    new MainPageTableEntry("Networking 2", "Course"),
    new MainPageTableEntry("Urban Forest", "Course")

            );

    @FXML
    private void setApplyFilter() {

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
            FXCollections.observableArrayList("Freshman", "Sophomore",
                    "Junior", "Senior");
    @FXML
    private final ObservableList<String> cat1List = getcatList();
    @FXML
    private final ObservableList<String> desigList = getdesigList();
    @FXML
    private final ObservableList<String> majorList = getMajorList();

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

    public static String tempText = "";

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
        TableColumn courseCol = new TableColumn("Type");

        mainPageTable.setEditable(false);
        Callback<TableColumn, TableCell> cellFactory =
                new Callback<TableColumn, TableCell>() {
                    public TableCell call(TableColumn p) {
                        TableCell cell = new TableCell<MainPageTableEntry, String>() {
                            @Override
                            public void updateItem(String item, boolean empty) {
                                super.updateItem(item, empty);
                                setText(empty ? null : getString());
                                setGraphic(null);
                            }

                            private String getString() {
                                return getItem() == null ? "" : getItem().toString();
                            }
                        };


                        cell.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()      {
                            @Override
                            public void handle(MouseEvent event) {
                                if (event.getClickCount() > 1) {
                                    TableCell c = (TableCell) event.getSource();

                                    System.out.println(c.getText());
                                    int index = c.getTableRow().getIndex();
                                    tempText = populateTable.get(index)
                                            .getName();

                                    if(populateTable.get(index).getCourse()
                                            .equals("Course")){
                                        MasterController.getInstance().loadViewCourseScene();
                                    } else {
                                        MasterController.getInstance()
                                                .loadViewProjectScene();
                                    }

                                }
                            }
                        });
                        return cell;
                    }
                };
        nameCol.setCellValueFactory(
                new PropertyValueFactory<MainPageTableEntry,String>("name")
        );
        nameCol.setMaxWidth(200);
        nameCol.setCellFactory(cellFactory);

        courseCol.setCellValueFactory(
                new PropertyValueFactory<MainPageTableEntry,String>("course")
        );
        courseCol.setMaxWidth(200);
        courseCol.setCellFactory(cellFactory);


        mainPageTable.getColumns().clear();
        mainPageTable.getColumns().addAll(nameCol, courseCol);
    }

}
