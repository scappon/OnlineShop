package hibernate;

import hibernate.entity.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;


import java.util.List;
import java.sql.Timestamp;
import java.util.Date;

public class HibernateApp {
    private SessionFactory factory;

    public HibernateApp(){
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(CustomerPaymentInfo.class)
                .addAnnotatedClass(Orders.class)
                .addAnnotatedClass(OrderDetail.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    public static void main(String[] args){
        HibernateApp app = new HibernateApp();

        try {
            app.getOrderDetail(1,1);
            System.out.println("\n");
            app.updateOrderDetail(1,1);
            System.out.println("\n");
            app.getOrderDetail(1,1);
            System.out.println("\n");


            int id = app.createOrderandOrderDetail();
            System.out.println("\n");
            app.getOrder(id);
            System.out.println("\n");
            app.updateOrder(id);
            System.out.println("\n");
            app.getOrder(id);
            System.out.println("\n");
            app.deleteOrderandOrderDetail(id);
            System.out.println("\n");

            id = app.createCustomer();
            System.out.println("\n");
            app.getCustomer(id);
            System.out.println("\n");
            app.updateCustomer(id);
            System.out.println("\n");
            app.getCustomer(id);
            System.out.println("\n");
            app.deleteCustomer(id);
            System.out.println("\n");

            id = app.createProduct();
            System.out.println("\n");
            app.getProduct(id);
            System.out.println("\n");
            app.updateProduct(id);
            System.out.println("\n");
            app.getProduct(id);
            System.out.println("\n");
            app.deleteProduct(id);
            System.out.println("\n");

            long cpiId = app.createCustomerPaymentInfo();
            System.out.println("\n");
            app.getCustomerPaymentInfo(cpiId);
            System.out.println("\n");
            app.updateCustomerPaymentInfo(cpiId);
            System.out.println("\n");
            app.getCustomerPaymentInfo(cpiId);
            System.out.println("\n");
            app.deleteCustomerPaymentInfo(cpiId);

        }
        finally{
            app.close();
        }

    }

    private void getOrderDetail(int orderID, int productID){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        OrderDetail od = (OrderDetail) session.createQuery("from OrderDetail where order.orderID=orderID and product.productID = productID").getSingleResult();

        System.out.println(od);


        session.getTransaction().commit();
    }

    private void getProduct(int id){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Product p = session.get(Product.class, id);

        System.out.println(p);

        session.getTransaction().commit();
    }

    private void getCustomer(int id){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Customer c = session.get(Customer.class, id);

        System.out.println(c);

        session.getTransaction().commit();
    }

    private void getOrder(int id){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Orders o = session.get(Orders.class, id);

        System.out.println(o);

        session.getTransaction().commit();
    }
    private void getCustomerPaymentInfo(long cardNumber){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        CustomerPaymentInfo cpi = session.get(CustomerPaymentInfo.class, cardNumber);

        System.out.println(cpi);

        session.getTransaction().commit();
    }

    private int createCustomer(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Customer c = new Customer("Test", "Customer", "1234 N. Test St.", "Pewaukee", "WI", "USA", "54321");

        session.save(c);

        int id = (int)c.getCustomerID();

        session.getTransaction().commit();

        return id;
    }

    private long createCustomerPaymentInfo(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        CustomerPaymentInfo cpi = new CustomerPaymentInfo(9999999999909999L, "Mastercard", (short) 853);

        session.save(cpi);

        long id = cpi.getCardNumber();

        session.getTransaction().commit();

        return id;
    }

    private int createOrderandOrderDetail(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();


        Date d = new Date();
        Long now = d.getTime();
        Timestamp shipped = new Timestamp(now);
        Timestamp ordered = new Timestamp(now-100000);

        Orders o = new Orders(ordered, shipped);
        Product p = session.get(Product.class, 1);

        OrderDetail od = new OrderDetail(o,p,1);
        o.add(od);

        session.save(o);

        int id = (int) o.getOrderID();


        session.getTransaction().commit();

        return id;
    }

    private int createProduct(){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Product p = new Product("Test Product", "A Product entry for testing", 1000, 100.00, "test.jpg");

        session.save(p);

        int id = (int)p.getProductID();

        session.getTransaction().commit();

        return id;
    }

    private void deleteOrderandOrderDetail(int orderID){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Orders o = session.get(Orders.class, orderID);

        if(o != null){
            session.delete(o);
        }

        session.getTransaction().commit();
    }

    private void deleteCustomer(int id){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Customer c = session.get(Customer.class, id);

        if(c != null){
            session.delete(c);
        }

        session.getTransaction().commit();
    }

    private void deleteProduct(int id){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Product p = session.get(Product.class, id);

        if(p != null){
            session.delete(p);
        }

        session.getTransaction().commit();
    }

    private void deleteCustomerPaymentInfo(long id){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        CustomerPaymentInfo c = session.get(CustomerPaymentInfo.class, id);

        if(c != null){
            session.delete(c);
        }

        session.getTransaction().commit();
    }

    private void updateCustomer(int id){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Customer c = session.get(Customer.class, id);
        c.setFirstName("Updated Name!");

        session.getTransaction().commit();
    }

    private void updateCustomerPaymentInfo(long id){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        CustomerPaymentInfo cpi = session.get(CustomerPaymentInfo.class, id);
        cpi.setCvv((short) 023);

        session.getTransaction().commit();
    }

    private void updateOrder(int id){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Orders o = session.get(Orders.class, id);
        Date d = new Date();
        Timestamp ts = new Timestamp(d.getTime()-10000000000L);
        o.setDateOrdered(ts);

        session.getTransaction().commit();
    }

    private void updateProduct(int id){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        Product p = session.get(Product.class, id);
        p.setPrice(107.99);

        session.getTransaction().commit();
    }

    private void updateOrderDetail(int orderID, int productID){
        Session session = factory.getCurrentSession();

        session.beginTransaction();

        OrderDetail od = (OrderDetail) session.createQuery("from OrderDetail where order.orderID = orderID and product.productID = 1").getSingleResult();
        od.setQuantity((int)od.getQuantity() + 1);

        session.getTransaction().commit();
    }

    private void close(){
        factory.close();
    }
}
