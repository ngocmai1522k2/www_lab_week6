package vn.edu.iuh.fit.convert;

public class UserForm {
    private String userFName;
    private String userLName;
    private String userMName;
    private String mobile;
    private String email;
    private String pass;
    private String passAgain;

    public UserForm(String userFName, String userLName, String userMName, String mobile, String email, String pass, String passAgain) {
        this.userFName = userFName;
        this.userLName = userLName;
        this.userMName = userMName;
        this.mobile = mobile;
        this.email = email;
        this.pass = pass;
        this.passAgain = passAgain;
    }

    public UserForm() {
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getUserMName() {
        return userMName;
    }

    public void setUserMName(String userMName) {
        this.userMName = userMName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPassAgain() {
        return passAgain;
    }

    public void setPassAgain(String passAgain) {
        this.passAgain = passAgain;
    }

    @Override
    public String toString() {
        return "UserForm{" +
                "userFName='" + userFName + '\'' +
                ", userLName='" + userLName + '\'' +
                ", userMName='" + userMName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", passAgain='" + passAgain + '\'' +
                '}';
    }
}
