package entity;

public class User {
    private String userName, userPass, userFullName;
    private int userAge;
    private String userEmail, userPhone, userAdress, userRole;

    public User() {
    }

    public User(String userName, String userPass, String userFullName, int userAge,
                String userEmail, String userPhone, String userAdress) {
        this.userName = userName;
        this.userPass = userPass;
        this.userFullName = userFullName;
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userAdress = userAdress;
        this.userRole = "user";
    }
    public User(String userName, String userPass, String userFullName, int userAge, String userEmail, String userPhone, String userAdress, String userRole) {
        this.userName = userName;
        this.userPass = userPass;
        this.userFullName = userFullName;
        this.userAge = userAge;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userAdress = userAdress;
        this.userRole = userRole;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + userName + ", userPass=" + userPass + ", userFullName=" + userFullName + ", userAge=" + userAge + ", userEmail=" + userEmail + ", userPhone=" + userPhone + ", userAdress=" + userAdress + ", userRole=" + userRole + '}';
    }

}
