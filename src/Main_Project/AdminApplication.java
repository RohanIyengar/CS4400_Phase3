package Main_Project;

/**
 * Created by ssingh on 12/4/16.
 */
public class AdminApplication {
    private String appMajor;
    private String appYear;
    private String pName;
    private String status;

    public AdminApplication(String appMajor, String appYear, String pName, String status) {
        this.appMajor = appMajor;
        this.appYear = appYear;
        this.pName = pName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdminApplication{" +
                "appMajor='" + appMajor + '\'' +
                ", appYear='" + appYear + '\'' +
                ", pName='" + pName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getAppMajor() {
        return appMajor;
    }

    public void setAppMajor(String appMajor) {
        this.appMajor = appMajor;
    }

    public String getAppYear() {
        return appYear;
    }

    public void setAppYear(String appYear) {
        this.appYear = appYear;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}