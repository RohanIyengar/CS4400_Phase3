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
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javafx.scene.input.MouseEvent;
/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class ApplicationController {
    SQLController sCont = new SQLController();
    @FXML
    private Button rejectBtn;

    @FXML
    private Button acceptBtn;

    @FXML
    private TableView apps;

    @FXML
    private void setAcceptBtn() {
        System.out.println("Okay, accepting this project!");
    }

    @FXML
    private void setRejectBtn() {
        System.out.println("Okay, denying this project.");
    }
    @FXML
    private void setBackAdmin() {
        MasterController.getInstance().loadChooseFunctionalityScene();
    }

    @FXML
    private final ObservableList<AppsTableEntry> populateTable = getPopTable();

    @FXML
    private Button loadBtn;

    @FXML
    private void setLoadBtn() {
        apps.setItems(populateTable);
    }

    @FXML
    private ObservableList<AppsTableEntry> getPopTable() {
        ObservableList toRet = FXCollections.observableArrayList();
        try {
            List<AdminApplication> data = sCont.getAdminApplicationInfo();
            for(AdminApplication x: data){
                toRet.add(new AppsTableEntry(x.getpName(),x.getAppMajor(),x
                        .getAppYear(), x.getStatus()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toRet;
    }

    public final void initialize() throws IOException {

        final TableColumn projCol = new TableColumn("Project");
        TableColumn majorCol = new TableColumn("Applicant Major");
        TableColumn yearCol = new TableColumn("Applicant Year");
        TableColumn statCol = new TableColumn("Status");

        apps.setEditable(false);
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
//                                    System.out.println(c.getText());
                                    int index = c.getTableRow().getIndex();
                                    if (populateTable.get(index).getStatuss()
                                            .equals("pending")) {
                                        acceptBtn.setVisible(true);
                                        rejectBtn.setVisible(true);
                                    } else if (populateTable.get(index)
                                            .getStatuss()
                                                .equals("Pending")) {
                                        acceptBtn.setVisible(true);
                                        rejectBtn.setVisible(true);
                                    } else {
                                        System.out.println("This project  " +
                                                "is completed is organization" +
                                                ".");
                                        acceptBtn.setVisible(false);
                                        rejectBtn.setVisible(false);
                                    }


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

        majorCol.setCellValueFactory(
                new PropertyValueFactory<AppsTableEntry,String>
                        ("major")
        );
        majorCol.setCellFactory(cellFactory);
        majorCol.setMaxWidth(200);

        yearCol.setCellValueFactory(
                new PropertyValueFactory<AppsTableEntry,String>
                        ("year")
        );
        yearCol.setMaxWidth(200);
        yearCol.setCellFactory(cellFactory);

        statCol.setCellValueFactory(
                new PropertyValueFactory<AppsTableEntry,String>
                        ("statuss")
        );
        statCol.setCellFactory(cellFactory);
        statCol.setMaxWidth(200);


        apps.getColumns().clear();
        apps.getColumns().addAll(projCol,majorCol,yearCol,statCol);

    }


}
