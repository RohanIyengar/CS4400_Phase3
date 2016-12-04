package Main_Project;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by AshikaGanesh on 12/4/16.
 */
public class PopularTableEntry {
    private final SimpleStringProperty project;
    private final SimpleStringProperty number;


    public PopularTableEntry(String p, String n) {
        this.project = new SimpleStringProperty(p);
        this.number = new SimpleStringProperty(n);
    }


    public String getProject() {

        return project.get();
    }

    public String getNumber() {
        return number.get();
    }



    public void setProject(String newproj) {

        project.set(newproj);
    }

    public void setNumber(String newNum) {
        number.set(newNum);
    }

}
