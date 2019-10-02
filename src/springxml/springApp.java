package springxml;

import springxml.beans.Customer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class springApp {
    public static void main(String[] args) {

        // Set context
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // get bean
        Customer c = context.getBean("myCustomer", Customer.class);

        // test getters
        System.out.println(c.getCustomerID());
        System.out.println(c.getFirstName());
        System.out.println(c.getLastName());
        System.out.println(c.getStreetAddress());
        System.out.println(c.getCity());
        System.out.println(c.getState());
        System.out.println(c.getCountry());
        System.out.println(c.getZipcode());

        // test service
        c.log(c.toString());

        // close context
        context.close();
    }
}
