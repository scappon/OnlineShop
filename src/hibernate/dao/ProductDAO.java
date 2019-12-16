package hibernate.dao;

import hibernate.entity.Product;
import java.util.List;

public interface ProductDAO {
    List<Product> getProducts();

    Product getProduct(int theId);

    void saveProduct(Product theProduct);

    void deleteProduct(int theId);

    List<Product> getProductsByName(String theSearchTerm);
}
