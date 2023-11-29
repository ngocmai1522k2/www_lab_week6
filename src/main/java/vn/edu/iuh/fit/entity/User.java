package vn.edu.iuh.fit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "UID")
    private long uid;
    @Column(name = "FirstName", columnDefinition = "varchar(50)")
    private String firstName;
    @Column(name = "MidName", columnDefinition = "varchar(50)")
    private String midName;
    @Column(name = "LastName", columnDefinition = "varchar(50)")
    private String lastName;
    @Column(name = "Mobile", columnDefinition = "varchar(15)")
    private String mobile;
    @Column(name = "Email", columnDefinition = "varchar(50)")
    private String email;
    @Column(name = "Password", columnDefinition = "varchar(35)")
    private String password;
    @Column(name="RegisteredAt")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime registeredAt;
    @Column(name="LastLogin")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime lastLogin;
    @Column(name = "Intro")
    private String intro;
    @Column(name = "Profile")
    private String profile;

    public User(long uid, String firstName, String midName, String lastName, String mobile, String email, String password) {
        this.uid = uid;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public User(long uid, String firstName, String midName, String lastName, String mobile, String email, String password, LocalDateTime registeredAt, LocalDateTime lastLogin, String intro, String profile) {
        this.uid = uid;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.registeredAt = registeredAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
    }

    public User(long uid) {
        this.uid = uid;
    }

    public User(String firstName, String midName, String lastName, String mobile, String email, String password) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", midName='" + midName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", registeredAt=" + registeredAt +
                ", lastLogin=" + lastLogin +
                ", intro='" + intro + '\'' +
                ", profile='" + profile + '\'' +
                '}';
    }
}
