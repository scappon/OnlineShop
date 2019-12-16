package hibernate.services;

import hibernate.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProduct(int theId);

    void saveProduct(Product theProduct, MultipartFile file, String applicationPath);

    void deleteProduct(int theId);

    List<Product> getProductsByName(String theSearchTerm);
}
