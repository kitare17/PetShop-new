package Entity;

public class Employee extends User{
    public Employee() {
    }

    public Employee(String userId, String firstname, String lastname, String address, String phone) {
        super(userId, firstname, lastname, address, phone);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "userId='" + userId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
