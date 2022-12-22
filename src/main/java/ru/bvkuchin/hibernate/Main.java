package ru.bvkuchin.hibernate;

import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bvkuchin.hibernate.models.Product;
import ru.bvkuchin.hibernate.repositories.SessionFactoryUtils;
import ru.bvkuchin.hibernate.services.BuyerService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.bvkuchin.hibernate");

        List<Product> productList = context.getBean(BuyerService.class).findProductByBuyerID(2L);
        System.out.println(productList);


        context.close();
    }
}