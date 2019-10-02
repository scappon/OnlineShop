package springxml.beans;

import springxml.services.Logging;

public class Products {
    private long productID;
    private String name;
    private String description;
    private long quantityInStock;
    private String image;
    private Logging logging;

    public Products() {
    }

    public Products(Logging logging) {
        this.logging = logging;
    }

    public void setLogging(Logging logging) {
        this.logging = logging;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
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

    public void setQuantityInStock(long quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", quantityInStock=" + quantityInStock +
                ", image='" + image + '\'' +
                ", logging=" + logging +
                '}';
    }

    public void log(String s){
        logging.writeToLog(s);
    }
}
