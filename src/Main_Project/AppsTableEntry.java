package Main_Project;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by AshikaGanesh on 12/4/16.
 */
public class AppsTableEntry {
    private final SimpleStringProperty project;
    private final SimpleStringProperty major;

    private final SimpleStringProperty year;
    private final SimpleStringProperty statuss;

    public AppsTableEntry(String p, String m, String y, String s) {
        this.project = new SimpleStringProperty(p);
        this.major =new SimpleStringProperty(m);
        this.year = new SimpleStringProperty(y);
        this.statuss = new SimpleStringProperty(s);
    }

    public String getProject() {

        return project.get();
    }

    public String getMajor() {
        return major.get();
    }

   public String getYear() {
    return year.get();
   }

    public String getStatuss() {
        return statuss.get();
    }

    public void setProject(String newproj) {

        project.set(newproj);
    }

    public void setMajor(String newMajor) {
        major.set(newMajor);
    }

    public void setYear(String newYear) {
        year.set(newYear);
    }

    public void setStatuss(String newStat) {
        statuss.set(newStat);
    }
}
