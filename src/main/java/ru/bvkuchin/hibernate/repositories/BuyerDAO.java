package ru.bvkuchin.hibernate.repositories;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hibernate.models.Buyer;
import ru.bvkuchin.hibernate.models.Order;
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

    public void addBuyer (Buyer buyer) {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            session.save(buyer);
            session.getTransaction().commit();
        }
    }


    public List<Buyer> getBuyers() {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            List<Buyer> buyerList = session.createQuery("select b from Buyer b").getResultList();
            session.getTransaction().commit();
            return buyerList;
        }
    }


}
