package springxml.beans;

import springxml.services.Logging;

public class orderDetails {
    private long orderID;
    private long productID;
    private long quantity;
    private Logging loggingService;

    public orderDetails() {
    }

    public orderDetails(Logging loggingService) {
        this.loggingService = loggingService;
    }

    public void setLogging(Logging loggingService) {
        this.loggingService = loggingService;
    }

    public long getOrderID() {
        return orderID;
    }

    public void setOrderID(long orderID) {
        this.orderID = orderID;
    }

    public long getProductID() {
        return productID;
    }

    public void setProductID(long productID) {
        this.productID = productID;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "orderDetails{" +
                "orderID=" + orderID +
                ", productID=" + productID +
                ", quantity=" + quantity +
                ", loggingService=" + loggingService +
                '}';
    }

    public void log(String s){
        loggingService.writeToLog(s);
    }
}
