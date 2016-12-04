package Main_Project;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitMenuButton;

/**
 * Created by AshikaGanesh on 12/3/16.
 */
public class MainPageController {

      /* ===============================================================
                             MAIN PAGE SCREEN FUNCTIONS
       ===============================================================
    * */

    @FXML
    private SplitMenuButton yearMP;


    @FXML
    private SplitMenuButton designationMP;

    @FXML
    private SplitMenuButton categoryMP;

    @FXML
    private SplitMenuButton majorMP;


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
    private void setResetFilter() {
        projectRadio.setSelected(false);
        courseRadio.setSelected(false);
        bothRadio.setSelected(false);

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
}
