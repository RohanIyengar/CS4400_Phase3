package Main_Project;

import javafx.beans.property.SimpleStringProperty;

/**
 * Created by AshikaGanesh on 12/4/16.
 */
public class MainPageTableEntry {
    private final SimpleStringProperty name;
    private final SimpleStringProperty course;

    public MainPageTableEntry(String n, String c) {
        this.name = new SimpleStringProperty(n);
        this.course =new SimpleStringProperty(c);
    }

    public String getName() {
        return course.get();
    }

    public String getCourse() {
        return course.get();
    }

    public void setName(String fname) {
        name.set(fname);
    }

    public void setCourse(String cname) {
        course.set(cname);
    }


}
