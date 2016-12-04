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

public class PopularProjectController {

    @FXML
    private TableView popList;



    @FXML
    private final ObservableList<PopularTableEntry> populateTable =
            FXCollections.observableArrayList(
                    new PopularTableEntry("Project1",
                            "10"),
                    new PopularTableEntry("Project2",
                            "23"),
                    new PopularTableEntry("Project3",
                            "42"),
                    new PopularTableEntry("Project4",
                            "14")
            );

    @FXML
    private void setLoadPopProjects() {
        popList.setItems(populateTable);
    }



    @FXML
    private void setBackAdmin() {
        MasterController.getInstance().loadChooseFunctionalityScene();
    }

    public final void initialize() throws IOException {

        TableColumn projCol = new TableColumn("Project");
        TableColumn numCol = new TableColumn("# of Applicants");


        popList.setEditable(false);
        Callback<TableColumn, TableCell> cellFactory =
                new Callback<TableColumn, TableCell>() {
                    public TableCell call(TableColumn p) {
                        TableCell cell = new TableCell<AppsTableEntry, String>() {
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
                new PropertyValueFactory<AppsTableEntry,String>("project")
        );
        projCol.setMaxWidth(200);
        projCol.setCellFactory(cellFactory);

        numCol.setCellValueFactory(
                new PropertyValueFactory<AppsTableEntry,String>
                        ("number")
        );
        numCol.setCellFactory(cellFactory);
        numCol.setMaxWidth(200);


        popList.getColumns().clear();
        popList.getColumns().addAll(projCol,numCol);

    }


}
