package ru.bvkuchin.hibernate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hibernate.models.Buyer;
import ru.bvkuchin.hibernate.models.Product;
import ru.bvkuchin.hibernate.repositories.BuyerDAO;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class BuyerService {

    private BuyerDAO buyerDAO;

    public BuyerService() {
    }

    @Autowired
    public void setDao(BuyerDAO buyerDAO) {
        this.buyerDAO = buyerDAO;
    }

    public void addBuyer(Buyer buyer) {
        buyerDAO.addBuyer(buyer);

    }

    public List<Buyer> getBuyers() {
        return buyerDAO.getBuyers();
    }
}
