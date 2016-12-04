package Main_Project;

/**
 * Created by Rohan on 12/3/2016.
 */
public class User {
    private String username;
    private String password;
    private String email;
    private int year;
    private String major;
    private String userType;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getYear() {
        return year;
    }

    public String getMajor() {
        return major;
    }

    public String getUserType() {
        return userType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;
        if (!password.equals(user.password)) return false;
        return userType.equals(user.userType);

    }

    public User(String username, String password, String email, int year, String major, String userType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.year = year;
        this.major = major;
        this.userType = userType;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + userType.hashCode();
        return result;
    }

    public User(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }
}
