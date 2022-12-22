package ru.bvkuchin.hibernate.models;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "buyerId")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column (name = "cost")
    private Double productCost;

    public Order(Buyer buyer, Product product, Double productCost) {

        this.id = id;
        this.buyer = buyer;
        this.product = product;
        this.productCost = productCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getProductCost() {
        return productCost;
    }

    public void setProductCost(Double productCost) {
        this.productCost = productCost;
    }

    public Order() {
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", product=" + product +
                ", productCost=" + productCost +
                '}';
    }
}
