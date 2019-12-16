package hibernate.services;

import hibernate.entity.Customer;
import hibernate.dao.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer){
        customerDAO.saveCustomer(theCustomer);
    }
}
