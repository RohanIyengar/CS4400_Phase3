package Main_Project;

/**
 * Created by ssingh on 12/4/16.
 */
public class AdminApplication {
    private String appMajor;
    private String appYear;
    private String pName;
    private String status;

    public AdminApplication(String date, String pName, String status) {
        this.appMajor = appMajor;
        this.appYear = appYear;
        this.pName = pName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "AdminApplication{" +
                "date='" + appMajor + '\'' +
                "appYear='" + appYear + '\'' +
                ", pName='" + pName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminApplication that = (AdminApplication) o;

        if (appMajor != null ? !appMajor.equals(that.appMajor) : that.appMajor != null) return false;
        if (pName != null ? !pName.equals(that.pName) : that.pName != null) return false;
        if (appYear != null ? !appYear.equals(that.appYear) : that.appYear != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

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