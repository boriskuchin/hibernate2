package ru.bvkuchin.hibernate;

import org.hibernate.Session;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bvkuchin.hibernate.models.Buyer;
import ru.bvkuchin.hibernate.models.Product;
import ru.bvkuchin.hibernate.repositories.SessionFactoryUtils;
import ru.bvkuchin.hibernate.services.BuyerService;
import ru.bvkuchin.hibernate.services.ProductService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.bvkuchin.hibernate");

        System.out.println("===========Find product by user id=========");
        List<Product> productList = context.getBean(BuyerService.class).findProductByBuyerID(3L);
        System.out.println(productList);
        System.out.println("===========Find product by user id=========");

        System.out.println("===========Find user by product id=========");
        List<Buyer> buyerList = context.getBean(ProductService.class).findBuyerByProductId(2L);
        System.out.println(buyerList);
        System.out.println("===========Find user by product id=========");


        context.close();
    }
}