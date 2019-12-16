package hibernate.dao;

import hibernate.entity.Customer;

import java.util.List;

public interface CustomerDAO {
    void saveCustomer(Customer theCustomer);
}
