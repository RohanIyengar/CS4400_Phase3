package Main_Project;

import java.util.List;

/**
 * Created by Rohan on 12/4/2016.
 */
public class CourseInfo {

    private String courseNum;
    private String instructor;
    private String designation;
    private int students;
    private List<String> categories;

    public CourseInfo(String courseNum, String instructor, String designation, int students, List<String> categories) {
        this.courseNum = courseNum;
        this.instructor = instructor;
        this.designation = designation;
        this.students = students;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "CourseInfo{" +
                "courseNum='" + courseNum + '\'' +
                ", instructor='" + instructor + '\'' +
                ", designation='" + designation + '\'' +
                ", students=" + students +
                ", categories=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseInfo that = (CourseInfo) o;

        if (students != that.students) return false;
        if (courseNum != null ? !courseNum.equals(that.courseNum) : that.courseNum != null) return false;
        if (instructor != null ? !instructor.equals(that.instructor) : that.instructor != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;
        return categories != null ? categories.equals(that.categories) : that.categories == null;

    }

    @Override
    public int hashCode() {
        int result = courseNum != null ? courseNum.hashCode() : 0;
        result = 31 * result + (instructor != null ? instructor.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + students;
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        return result;
    }

    public String getCourseNun() {
        return courseNum;
    }

    public void setCourseNun(String courseNun) {
        this.courseNum = courseNun;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
