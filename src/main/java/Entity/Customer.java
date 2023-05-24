package Entity;

public class Customer extends User{
    public Customer() {
    }

    public Customer(String userId, String firstname, String lastname, String address, String phone) {
        super(userId, firstname, lastname, address, phone);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
