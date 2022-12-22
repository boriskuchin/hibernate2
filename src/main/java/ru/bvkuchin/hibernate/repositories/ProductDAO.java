package ru.bvkuchin.hibernate.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO {

    private SessionFactoryUtils factory;

    public ProductDAO() {
    }

    @Autowired
    public void setFactory(SessionFactoryUtils factory) {
        this.factory = factory;
    }

}
