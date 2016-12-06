package Main_Project;

/**
 * Created by Rohan on 12/6/2016.
 */
public class DetailedApplicationInfo {

    private String project;
    private int applications;
    private double acceptRate;
    private String topThree;

    public DetailedApplicationInfo(String project, int applications, double acceptRate, String topThree) {
        this.project = project;
        this.applications = applications;
        this.acceptRate = acceptRate;
        this.topThree = topThree;
    }

    @Override
    public String toString() {
        return "DetailedApplicationInfo{" +
                "project='" + project + '\'' +
                ", applications=" + applications +
                ", acceptRate=" + acceptRate +
                ", topThree='" + topThree + '\'' +
                '}';
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getApplications() {
        return applications;
    }

    public void setApplications(int applications) {
        this.applications = applications;
    }

    public double getAcceptRate() {
        return acceptRate;
    }

    public void setAcceptRate(double acceptRate) {
        this.acceptRate = acceptRate;
    }

    public String getTopThree() {
        return topThree;
    }

    public void setTopThree(String topThree) {
        this.topThree = topThree;
    }
}
