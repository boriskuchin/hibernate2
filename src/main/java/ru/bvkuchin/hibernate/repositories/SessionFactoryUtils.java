package ru.bvkuchin.hibernate.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionFactoryUtils {

    private SessionFactory factory;

    @PostConstruct
    public void init() {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public SessionFactory getFactory() {
        return  factory;
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

    public void shutDowm() {
        factory.close();

    }
}
