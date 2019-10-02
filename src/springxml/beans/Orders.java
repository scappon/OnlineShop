package springxml.beans;

import springxml.services.Logging;

import java.sql.Timestamp;

public class Orders{
    private long orderID;
    private long customerID;
    private Timestamp dateOrdered;
    private Timestamp dateShipped;
    private Logging loggingService;

    public Orders() {
    }

    public Orders(Logging loggingService) {
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

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
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
                ", customerID=" + customerID +
                ", dateOrdered=" + dateOrdered +
                ", dateShipped=" + dateShipped +
                ", loggingService=" + loggingService +
                '}';
    }

    public void log(String s){
        loggingService.writeToLog(s);
    }
}
