package Main_Project;

/**
 * Created by Rohan on 12/4/2016.
 */
public class ShortApplicationInfo {

    private String date;
    private String pName;
    private String status;

    public ShortApplicationInfo(String date, String pName, String status) {
        this.date = date;
        this.pName = pName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShortApplicationInfo{" +
                "date='" + date + '\'' +
                ", pName='" + pName + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShortApplicationInfo that = (ShortApplicationInfo) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (pName != null ? !pName.equals(that.pName) : that.pName != null) return false;
        return status != null ? status.equals(that.status) : that.status == null;

    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (pName != null ? pName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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
