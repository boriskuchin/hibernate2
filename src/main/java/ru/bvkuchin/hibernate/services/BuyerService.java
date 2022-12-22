package ru.bvkuchin.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hibernate.models.Product;
import ru.bvkuchin.hibernate.repositories.BuyerDAO;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class BuyerService {

    private BuyerDAO dao;

    public BuyerService() {
    }

    @Autowired
    public void setDao(BuyerDAO dao) {
        this.dao = dao;
    }

    public List<Product> findProductByBuyerID(Long id) {
        return dao.findProductByBuyerID(id);
    }
}
