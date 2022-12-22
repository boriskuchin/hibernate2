package ru.bvkuchin.hibernate.repositories;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hibernate.models.Buyer;
import ru.bvkuchin.hibernate.models.Product;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class BuyerDAO {

    private SessionFactoryUtils factoryUtils;

    public BuyerDAO() {
    }

    @Autowired
    public void setFactoryUtils(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    public List<Product> findProductByBuyerID (Long id) {
        List<Product> productList = null;
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            productList = session.get(Buyer.class, id).getProductList();
            Hibernate.initialize(productList);
            session.getTransaction().commit();
            return productList;
        }

    }


}
