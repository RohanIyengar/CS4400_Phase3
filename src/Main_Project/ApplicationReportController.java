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
public class ApplicationReportController {
     /* ===============================================================
                            ADMIN VIEW: APPLICATION REPORT SCREEN FUNCTIONS
       ===============================================================
    * */
SQLController sContr = new SQLController();
    @FXML
    private TableView appList;

    @FXML
    private void loadAppReport()
    {
        ObservableList<MyAppEntry> populateTable = getPopTable();
        appList.setItems(populateTable);
    }

    @FXML
    private ObservableList getPopTable() {

        ObservableList temp = FXCollections
                .observableArrayList();
        try {
            List<DetailedApplicationInfo> data = sContr
                    .getDetailedApplicationInfo();
            for(DetailedApplicationInfo x: data){
                temp.add(new AppReportEntry(x.getProject(), String.valueOf(x
                        .getApplications()), Double.toString(x.getAcceptRate
                        ()), x
                        .getTopThree()));
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong in getting your " +
                    "applications");
        }
        return temp;
    }

//    @FXML
//    private final ObservableList<AppReportEntry> populateTable =
//            FXCollections.observableArrayList(
//                    new AppReportEntry("Project1",
//                            "10","72%","CS/MATH"),
//                    new AppReportEntry("Project1",
//                            "10","72%","CS/MATH"),
//                    new AppReportEntry("Project1",
//                            "10","72%","CS/MATH"),
//                    new AppReportEntry("Project1",
//                            "10","72%","CS/MATH")
//            );



    @FXML
    private void setBackAdmin() {
        MasterController.getInstance().loadChooseFunctionalityScene();
    }
    public final void initialize() throws IOException {

        TableColumn projCol = new TableColumn("Project");
        TableColumn numCol = new TableColumn("# of Applicants");
        TableColumn rateCol = new TableColumn("Accept Rate");
        TableColumn topCol = new TableColumn("Top 3 Majors");


        appList.setEditable(false);
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


        rateCol.setCellValueFactory(
                new PropertyValueFactory<AppsTableEntry,String>
                        ("rate")
        );
        rateCol.setCellFactory(cellFactory);
        rateCol.setMaxWidth(200);

        topCol.setCellValueFactory(
                new PropertyValueFactory<AppsTableEntry,String>
                        ("top")
        );
        topCol.setCellFactory(cellFactory);
        topCol.setMaxWidth(200);

        appList.getColumns().clear();
        appList.getColumns().addAll(projCol,numCol, rateCol, topCol);

    }
}
