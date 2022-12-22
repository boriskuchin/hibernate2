package ru.bvkuchin.hibernate.services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.bvkuchin.hibernate.models.Buyer;
import ru.bvkuchin.hibernate.models.Product;
import ru.bvkuchin.hibernate.repositories.ProductDAO;

import java.security.PublicKey;
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

    public void addProduct(Product product) {
        productDAO.addProduct(product);

    }

    public void updatePriceById(Long id, Double newPrice) {
        productDAO.updatePriceById(id,newPrice);
    }

    public List<Product> getProducts() {
        return productDAO.getProducts();
    }

}
