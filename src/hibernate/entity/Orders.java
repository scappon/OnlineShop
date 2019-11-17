package hibernate.entity;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Orders{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID")
    private int orderID;
    /*Cascade leaves out removing the customer because when an order is deleted we do not necessarily want
    * all customer info gone as well
    * Fetch type is lazy because order info may be displayed without customer info as well*/
    @ManyToOne(cascade = {CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH},
                    fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")
    private Customer customer;
    @Column(name = "dateordered")
    private Timestamp dateOrdered;
    @Column(name = "dateShipped")
    private Timestamp dateShipped;
    /*Cascade type is all because if a order is canceled/removed then all order details associated with it
    * should be removed as well
    * Fetch type is lazy because we may not necessarily want order details loaded right away with order info*/
    @OneToMany(mappedBy = "order",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;

    public Orders() {
    }

    public Orders(Timestamp dateOrdered, Timestamp dateShipped) {
        this.dateOrdered = dateOrdered;
        this.dateShipped = dateShipped;
    }

    public void add(OrderDetail tempDetail){
        if(orderDetails == null){
            orderDetails = new ArrayList<>();
        }
        orderDetails.add(tempDetail);
        tempDetail.setOrder(this);
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Timestamp getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(Timestamp dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public Timestamp getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Timestamp dateShipped) {
        this.dateShipped = dateShipped;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderID=" + orderID +
                ", customer=" + customer +
                ", dateOrdered=" + dateOrdered +
                ", dateShipped=" + dateShipped +
                ", orderDetails=" + orderDetails +
                '}';
    }
}
