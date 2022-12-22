package ru.bvkuchin.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.bvkuchin.hibernate.models.Buyer;
import ru.bvkuchin.hibernate.models.Product;
import ru.bvkuchin.hibernate.services.BuyerService;
import ru.bvkuchin.hibernate.services.OrderService;
import ru.bvkuchin.hibernate.services.ProductService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("ru.bvkuchin.hibernate");

        OrderService orderService = context.getBean(OrderService.class);
        ProductService productService = context.getBean(ProductService.class);
        BuyerService buyerService = context.getBean(BuyerService.class);


        Product product1 = productService.getProducts().get(0);
        Product product2 = productService.getProducts().get(1);
        Product product3 = productService.getProducts().get(3);
        Buyer buyer1 = buyerService.getBuyers().get(0);

        Buyer buyer2 = buyerService.getBuyers().get(1);
        Buyer buyer3 = buyerService.getBuyers().get(2);



        orderService.addOrder(product1, buyer1);
        orderService.addOrder(product1, buyer2);
        orderService.addOrder(product2, buyer1);
        orderService.addOrder(product3, buyer1);

        orderService.getAllOrders().forEach(System.out::println);

        System.out.println("========Orders by buyer==========");
        orderService.getOrdersByBuyer(buyer2).forEach(System.out::println);
        System.out.println("========Orders by buyer==========");

        System.out.println("========Orders by product==========");
        orderService.getOrdersByProduct(product2).forEach(System.out::println);
        System.out.println("========Orders by product==========");


        context.close();
    }
}