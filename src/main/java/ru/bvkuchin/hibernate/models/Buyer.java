package ru.bvkuchin.hibernate.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "BUYERS")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "buyer")
    private List<Order> orderList;

    @Override
    public String toString() {
        return name;
    }

    public Buyer(String name) {
        this.name = name;
    }

    public Buyer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
