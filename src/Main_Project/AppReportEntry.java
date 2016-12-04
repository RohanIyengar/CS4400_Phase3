package Main_Project;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by AshikaGanesh on 12/4/16.
 */
public class AppReportEntry {
    private final SimpleStringProperty project;
    private final SimpleStringProperty number;
    private final SimpleStringProperty rate;
    private final SimpleStringProperty top;

    public AppReportEntry(String p, String n,String r, String t) {
        this.project = new SimpleStringProperty(p);
        this.number = new SimpleStringProperty(n);
        this.rate = new SimpleStringProperty(r);
        this.top = new SimpleStringProperty(t);
    }


    public String getProject() {

        return project.get();
    }

    public String getNumber() {
        return number.get();
    }

    public String getRate() { return rate.get();}

    public String getTop() {return top.get();}
    public void setProject(String newproj) {

        project.set(newproj);
    }

    public void setNumber(String newNum) {
        number.set(newNum);
    }
    public void setRate(String newR) {rate.set(newR);}
    public void setTop(String newT) {top.set(newT);}

}
