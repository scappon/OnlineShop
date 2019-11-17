package hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "CustomerPaymentInfo")
public class CustomerPaymentInfo {
    @Id
    @Column(name = "cardnumber")
    private long cardNumber;
    @Column(name = "cardtype")
    private String cardType;
    @Column(name = "cvv")
    private short cvv;
    /*Cascade leaves out removing customer because if payment info is deleted that does not necessarily mean that
    * the customer should be as well
    * Fetch type is lazy because payment info may be displayed without needing to load customer info as well*/
    @OneToOne(cascade = {CascadeType.DETACH,
                        CascadeType.MERGE,
                        CascadeType.PERSIST,
                        CascadeType.REFRESH},
                        fetch = FetchType.LAZY)
    @JoinColumn(name = "customerID")
    private Customer customer;

    public CustomerPaymentInfo() {
    }

    public CustomerPaymentInfo(long cardNumber, String cardType, short cvv) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cvv = cvv;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "CustomerPaymentInfo{" +
                "cardNumber=" + cardNumber +
                ", cardType='" + cardType + '\'' +
                ", cvv=" + cvv +
                //", customer=" + customer +
                '}';
    }
}