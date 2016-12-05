package Main_Project;

/**
 * Created by Rohan on 12/4/2016.
 */
public class PopularProject {

    private String projectName;
    private int apps;

    public PopularProject(String projectName, int apps) {
        this.projectName = projectName;
        this.apps = apps;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getApps() {
        return apps;
    }

    public void setApps(int apps) {
        this.apps = apps;
    }

    @Override
    public String toString() {
        return "PopularProject{" +
                "projectName='" + projectName + '\'' +
                ", apps=" + apps +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PopularProject that = (PopularProject) o;

        if (apps != that.apps) return false;
        return projectName != null ? projectName.equals(that.projectName) : that.projectName == null;

    }

    @Override
    public int hashCode() {
        int result = projectName != null ? projectName.hashCode() : 0;
        result = 31 * result + apps;
        return result;
    }
}
