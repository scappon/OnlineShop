package hibernate.dao;

import hibernate.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class customerDAOimpl implements CustomerDAO{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCustomer(Customer theCustomer){
        Session session = sessionFactory.getCurrentSession();

        session.save(theCustomer);
    }
}
