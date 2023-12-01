package com.JavaIntermedioUTN.SistemaDeReportes;

import com.JavaIntermedioUTN.Modelos.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ConectorMySQL {

    public ConectorMySQL() {
        // Create Configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Cliente.class);

        // Create Session Factory
       factory = configuration.buildSessionFactory();

    }

    private SessionFactory factory;

    //Este metodo generico me sirve para traer cualquier entidad de la db
    public   <T> List<T> getAll(String tabla){

        // Initialize Session Object
        Session session = factory.openSession();
        List<T> elementos= new ArrayList();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            elementos = session.createQuery("FROM "+tabla).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return elementos;

    }





}
