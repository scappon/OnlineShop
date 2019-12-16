package hibernate.dao;

import hibernate.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOimpl implements ProductDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Product> getProducts(){
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    public Product getProduct(int theId){
        Session session = sessionFactory.getCurrentSession();

        return session.get(Product.class, theId);
    }

    @Override
    public void saveProduct(Product theProduct){
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(theProduct);
    }

    @Override
    public List<Product> getProductsByName(String theSearchTerm){
        Session session = sessionFactory.getCurrentSession();

        Query<Product> query = session.createQuery("from Product where lower(name) like :searchTerm");

        theSearchTerm = "%" + theSearchTerm.toLowerCase() + "%";

        query.setParameter("searchTerm", theSearchTerm);

        return query.getResultList();
    }

    @Override
    public void deleteProduct(int theId){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Product where id = :doomedProductId");

        query.setParameter("doomedProductId", theId);

        query.executeUpdate();
    }
}
