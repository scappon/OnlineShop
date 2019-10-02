package springxml.beans;

import springxml.services.Logging;

public class CustomerPaymentInfo {
    private long cardNumber;
    private String cardType;
    private short cvv;
    private long customerID;
    private Logging loggingService;

    public CustomerPaymentInfo() {
    }

    public CustomerPaymentInfo(Logging loggingService) {
        this.loggingService = loggingService;
    }

    public void setLogging(Logging loggingService) {
        this.loggingService = loggingService;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public short getCvv() {
        return cvv;
    }

    public void setCvv(short cvv) {
        this.cvv = cvv;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }

    @Override
    public String toString() {
        return "CustomerPaymentInfo{" +
                "cardNumber=" + cardNumber +
                ", cardType='" + cardType + '\'' +
                ", cvv=" + cvv +
                ", customerID=" + customerID +
                ", loggingService=" + loggingService +
                '}';
    }

    public void log(String s){
        loggingService.writeToLog(s);
    }
}