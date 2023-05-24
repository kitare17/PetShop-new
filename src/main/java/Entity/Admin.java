package Entity;

public class Admin extends User{
    public Admin() {
    }

    public Admin(String userId, String firstname, String lastname, String address, String phone) {
        super(userId, firstname, lastname, address, phone);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "userId='" + userId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
