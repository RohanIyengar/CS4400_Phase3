package Main_Project;

import java.util.List;

/**
 * Created by Rohan on 12/4/2016.
 */
public class ProjectInfo {
    private String advisorName;
    private String advisorEmail;
    private String description;

    public ProjectInfo(String advisorName, String advisorEmail, String description, String designation, int students, List<String> categories, List<String> requirements) {
        this.advisorName = advisorName;
        this.advisorEmail = advisorEmail;
        this.description = description;
        this.designation = designation;
        this.students = students;
        this.categories = categories;
        this.requirements = requirements;
    }

    private String designation;
    private int students;
    private List<String> categories;
    private List<String> requirements;

    public String getAdvisorName() {
        return advisorName;
    }

    public void setAdvisorName(String advisorName) {
        this.advisorName = advisorName;
    }

    public String getAdvisorEmail() {
        return advisorEmail;
    }

    public void setAdvisorEmail(String advisorEmail) {
        this.advisorEmail = advisorEmail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<String> getRequirements() {
        return requirements;
    }

    public void setRequirements(List<String> requirements) {
        this.requirements = requirements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectInfo that = (ProjectInfo) o;

        if (students != that.students) return false;
        if (advisorName != null ? !advisorName.equals(that.advisorName) : that.advisorName != null) return false;
        if (advisorEmail != null ? !advisorEmail.equals(that.advisorEmail) : that.advisorEmail != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (designation != null ? !designation.equals(that.designation) : that.designation != null) return false;
        if (categories != null ? !categories.equals(that.categories) : that.categories != null) return false;
        return requirements != null ? requirements.equals(that.requirements) : that.requirements == null;

    }

    @Override
    public int hashCode() {
        int result = advisorName != null ? advisorName.hashCode() : 0;
        result = 31 * result + (advisorEmail != null ? advisorEmail.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (designation != null ? designation.hashCode() : 0);
        result = 31 * result + students;
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (requirements != null ? requirements.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "advisorName='" + advisorName + '\'' +
                ", advisorEmail='" + advisorEmail + '\'' +
                ", description='" + description + '\'' +
                ", designation='" + designation + '\'' +
                ", students=" + students +
                ", categories=" + categories +
                ", requirements=" + requirements +
                '}';
    }
}
