package ru.bvkuchin.hibernate.repositories;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hibernate.models.Buyer;
import ru.bvkuchin.hibernate.models.Product;

import java.util.List;

@Component
public class ProductDAO {

    private SessionFactoryUtils factoryUtils;

    public ProductDAO() {
    }

    @Autowired
    public void setFactoryUtils(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    public void addProduct (Product product) {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            session.save(product);
        }
    }

    public void updatePriceById(Long id, Double newPrice) {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            product.setCost(newPrice);
            session.getTransaction().commit();
        }
    }

    public List<Product> getProducts() {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            List<Product> productList = session.createQuery("select p from Product p").getResultList();
            session.getTransaction().commit();
            return productList;
        }
    }
}
