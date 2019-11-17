package hibernate.entity;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Customers")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerid")
    private int customerID;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "streetaddress")
    private String streetAddress;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "country")
    private String country;
    @Column(name = "zipcode")
    private String zipcode;
    /*Cascade type of all because if a customer is deleted then surely we would not want customer payment info
    * sticking around
    * Fetch type is lazy because there may be instances when customer info is displayed but payment info is
    * not needed*/
    @OneToOne(mappedBy = "customer",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private CustomerPaymentInfo customerinfo;
    /*Cascade type is all because if a customer is deleted then we want their orders gone as well
    * Fetch type is lazy because we may not want the orders available always when displaying customer
    * info*/
    @OneToMany(mappedBy = "customer",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<Orders> orders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String streetAddress, String city, String state, String country, String zipcode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipcode = zipcode;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public void add(Orders tempOrder){
        if(orders == null){
            orders = new ArrayList<>();
        }
        orders.add(tempOrder);
        tempOrder.setCustomer(this);
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public CustomerPaymentInfo getCustomerinfo() {
        return customerinfo;
    }

    public void setCustomerinfo(CustomerPaymentInfo customerinfo) {
        this.customerinfo = customerinfo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", customerinfo=" + customerinfo +
                '}';
    }
}
