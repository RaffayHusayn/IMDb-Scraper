package com.fclass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.awt.print.Book;
import java.util.concurrent.Flow;

public class DatabaseWriter {
    public Session startHibernateSession(){
        Configuration conf = new Configuration().configure().addAnnotatedClass(Movie.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        SessionFactory factory = conf.buildSessionFactory(serviceRegistry);
        Session session = factory.openSession();
        return session;

    }

    public void persistMovie(Session session, Movie movie ){
        Transaction tx = session.beginTransaction();
        session.save(movie);
        tx.commit();
    }

    public void closeHibernateSession(Session session){
        session.close();
    }
}
