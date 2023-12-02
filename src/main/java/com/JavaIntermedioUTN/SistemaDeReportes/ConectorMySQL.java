package com.JavaIntermedioUTN.SistemaDeReportes;

import com.JavaIntermedioUTN.Modelos.Cliente;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
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
    public <T> List<T> getAll(String tabla) {

        // Initialize Session Object
        Session session = factory.openSession();
        List<T> elementos = new ArrayList();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            elementos = session.createQuery("FROM " + tabla).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return elementos;

    }


    public <T> void insertar(T elemento) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(elemento);
        tx.commit();
        session.close();

    }

    public <T> void eliminar(T elemento) {

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(elemento);
        tx.commit();
        session.close();
    }

    public <T> T get(String id, String tabla, String campoId) {

        // Initialize Session Object
        Session session = factory.openSession();
        List<T> elementos = new ArrayList();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            String  query=MessageFormat.format("FROM {0} WHERE {1} = {2}", tabla,campoId,id);
            elementos = session.createQuery(query).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return elementos.get(0);


    }
}
