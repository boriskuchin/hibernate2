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

    public List<Buyer> findBuyerByProductID (Long id) {
        List<Buyer> buyerList = null;
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            buyerList = session.get(Product.class, id).getBuyerList();
            Hibernate.initialize(buyerList);
            session.getTransaction().commit();
            return buyerList;
        }
    }

}
