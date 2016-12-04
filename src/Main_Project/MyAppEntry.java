package Main_Project;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by AshikaGanesh on 12/4/16.
 */
public class MyAppEntry {
    private final SimpleStringProperty project;
    private final SimpleStringProperty date;
    private final SimpleStringProperty statuss;

    public MyAppEntry(String d, String p, String s) {
        this.project = new SimpleStringProperty(p);
        this.date = new SimpleStringProperty(d);
        this.statuss = new SimpleStringProperty(s);
    }


    public String getProject() {

        return project.get();
    }

    public String getDate() {
        return date.get();
    }

    public String getStatuss() { return statuss.get();}

    public void setProject(String newproj) {

        project.set(newproj);
    }

    public void setDate(String newNum) {
        date.set(newNum);
    }
    public void setStatuss(String newR) {statuss.set(newR);}

}
