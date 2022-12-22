package ru.bvkuchin.hibernate.repositories;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hibernate.models.Buyer;
import ru.bvkuchin.hibernate.models.Order;
import ru.bvkuchin.hibernate.models.Product;

import java.util.List;

@Component
public class OrderDAO {
    SessionFactoryUtils factoryUtils;

    @Autowired
    public void setFactoryUtils(SessionFactoryUtils factoryUtils) {
        this.factoryUtils = factoryUtils;
    }

    public OrderDAO() {
    }

    public void addNewOrder(Order order) {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();

        }
    }

    public List<Order> getOrdersByBuyer(Buyer buyer) {
        List<Order> orderList = null;
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            orderList = session.createQuery("select o from Order o where o.buyer = :buyer")
                    .setParameter("buyer", buyer)
                    .getResultList();
            Hibernate.initialize(orderList);
            session.getTransaction().commit();
            return orderList;
        }
    }

    public List<Order> getOrders() {
        List<Order> orderList = null;
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            orderList = session.createQuery("select o from Order o ").getResultList();
            Hibernate.initialize(orderList);
            session.getTransaction().commit();
            return orderList;
        }
    }

    public List<Order> getOrdersByProduct(Product product) {
        try (Session session = factoryUtils.getSession()) {
            session.beginTransaction();
            List<Order> orderList = session.createQuery("select o from Order o where o.product = :product")
                    .setParameter("product", product)
                    .getResultList();
            session.getTransaction().commit();
            return orderList;
        }

    }
}
