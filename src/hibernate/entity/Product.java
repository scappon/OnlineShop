package hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productID")
    private int productID;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "quantityinstock")
    private int quantityInStock;
    @Column(name = "unitprice")
    private double price;
    @Column(name = "imagefilename")
    private String imageFileName;
    /*Cascade type is all because if a product is removed then all order details associated with the product
    * are invalid and would not be able to be delivered. They should be removed as well and reflect any product
    * changes
    * Fetch type is lazy because we will have times when we want product information without all orderDetails
    * loaded as well*/
    @OneToMany(mappedBy = "product",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<OrderDetail> orderDetails;

    public Product() {
    }

    public Product(String name, String description, int quantityInStock, double price, String imageFileName) {
        this.name = name;
        this.description = description;
        this.quantityInStock = quantityInStock;
        this.price = price;
        this.imageFileName = imageFileName;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public void add(OrderDetail tempDetail){
        if(orderDetails == null){
            orderDetails = new ArrayList<>();
        }
        orderDetails.add(tempDetail);
        tempDetail.setProduct(this);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", price=" + price +
                ", imageFileName='" + imageFileName + '\'' +
                ", orderDetails=" + orderDetails +
                '}';
    }
}