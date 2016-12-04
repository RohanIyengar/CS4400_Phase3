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
public class MyApplicationController {

    /* ===============================================================
                            MY APPLICATION SCREEN FUNCTIONS
      ===============================================================
   * */


    @FXML
    private TableView myAppList;

    @FXML
    private void loadMyApps() {
        myAppList.setItems(populateTable);
    }

    @FXML
    private final ObservableList<MyAppEntry> populateTable =
            FXCollections.observableArrayList(
                    new MyAppEntry("12/12",
                            "Project 1", "pending"),
                    new MyAppEntry("12/12",
                            "Project 1", "pending"),
                    new MyAppEntry("12/12",
                            "Project 1", "pending"),
                    new MyAppEntry("12/12",
                            "Project 1", "pending")
            );




    @FXML
    private void setBackMyApplication() {
        MasterController.getInstance().loadMeScene();
    }

    public final void initialize() throws IOException {

        TableColumn projCol = new TableColumn("Project");
        TableColumn dateCol = new TableColumn("Date");
        TableColumn statusCol = new TableColumn("Status");


        myAppList.setEditable(false);
        Callback<TableColumn, TableCell> cellFactory =
                new Callback<TableColumn, TableCell>() {
                    public TableCell call(TableColumn p) {
                        TableCell cell = new TableCell<MyAppEntry, String>() {
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
                                }
                            }
                        });
                        return cell;
                    }
                };
        projCol.setCellValueFactory(
                new PropertyValueFactory<MyAppEntry,String>("project")
        );
        projCol.setMaxWidth(200);
        projCol.setCellFactory(cellFactory);

        dateCol.setCellValueFactory(
                new PropertyValueFactory<MyAppEntry,String>
                        ("date")
        );
        dateCol.setCellFactory(cellFactory);
        dateCol.setMaxWidth(200);


        statusCol.setCellValueFactory(
                new PropertyValueFactory<MyAppEntry,String>
                        ("statuss")
        );
        statusCol.setCellFactory(cellFactory);
        statusCol.setMaxWidth(200);


        myAppList.getColumns().clear();
        myAppList.getColumns().addAll(projCol,dateCol,statusCol);

    }

}
