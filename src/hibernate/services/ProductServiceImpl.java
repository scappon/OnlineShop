package hibernate.services;

import hibernate.entity.Product;
import hibernate.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    ImageFileService imageFileService;

    @Override
    @Transactional
    public List<Product> getProducts(){
        return productDAO.getProducts();
    }

    @Override
    @Transactional
    public Product getProduct(int theId){
        return productDAO.getProduct(theId);
    }

    @Override
    @Transactional
    public void saveProduct(Product theProduct, MultipartFile file, String applicationPath){
        String filename = imageFileService.saveFile(
                file,
                applicationPath);

        if(filename!=null){
            theProduct.setImageFileName(filename);
        }

        productDAO.saveProduct(theProduct);
    }

    @Override
    @Transactional
    public void deleteProduct(int theId){
        productDAO.deleteProduct(theId);
    }

    @Override
    @Transactional
    public List<Product> getProductsByName(String theSearchTerm){
       return productDAO.getProductsByName(theSearchTerm);
    }
}
