package hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orderDetails")
public class OrderDetail implements Serializable {
    @Id
    /*Cascade leaves out removing because just because one order detail is removed from an order that does not
    * mean we want the entire order removed as well
    * Fetch type is lazy because we may not want the entire order all of the time*/
    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},
            fetch = FetchType.LAZY)
    @JoinColumn(name = "orderID")
    private Orders order;
    @Id
    /*Cascade leaves out remove because a product should not be removed when an order detail is deleted
    * Fetch type is lazy because we may not want the product information loaded every time*/
    @ManyToOne(cascade = {CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH},
                        fetch = FetchType.LAZY)
    @JoinColumn(name = "productID")
    private Product product;
    @Column(name = "quantity")
    private int quantity;


    public OrderDetail(){}

    public OrderDetail(Orders order, Product product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order=" + order.getOrderID() +
                ", product=" + product.getProductID() +
                ", quantity=" + quantity +
                '}';
    }
}