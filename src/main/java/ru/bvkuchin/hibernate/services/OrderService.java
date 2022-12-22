package ru.bvkuchin.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hibernate.models.Buyer;
import ru.bvkuchin.hibernate.models.Order;
import ru.bvkuchin.hibernate.models.Product;
import ru.bvkuchin.hibernate.repositories.OrderDAO;

import java.util.List;

@Component
public class OrderService {

    private OrderDAO orderDAO;

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void addOrder(Product product, Buyer buyer) {
        orderDAO.addNewOrder(new Order(buyer, product, product.getCost()));
    }

    public List<Order> getAllOrders() {
        return orderDAO.getOrders();
    }

    public List<Order> getOrdersByBuyer(Buyer buyer) {
        return orderDAO.getOrdersByBuyer(buyer);
    }

    public List<Order> getOrdersByProduct(Product product) {
        return orderDAO.getOrdersByProduct(product);
    }

}
