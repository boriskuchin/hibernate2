package ru.bvkuchin.hibernate.services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hibernate.models.Buyer;
import ru.bvkuchin.hibernate.repositories.ProductDAO;

import java.util.List;

@Component
public class ProductService {

    private ProductDAO productDAO;
    @Autowired
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public ProductService() {

    }

    public List<Buyer> findBuyerByProductId(Long id) {
        return productDAO.findBuyerByProductID(id);
    }
}
