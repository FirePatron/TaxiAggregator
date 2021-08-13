/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moduls;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author WSR
 */
public class Hiber {

    public static Session sess;
    private static Transaction tr;

    private static SessionFactory sessionFactory = buildSessionFactory();

    protected static SessionFactory buildSessionFactory() {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );

            throw new ExceptionInInitializerError("Initial SessionFactory failed" + e);
        }
        return sessionFactory;
    }


    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void start(){
        sess=sessionFactory.openSession();
    }
    
    public static void close(){
        sess.close();
        sessionFactory.close();
    }

    public static void save(Object o){
        try {
            tr=sess.beginTransaction();
            sess.save(o);
            tr.commit();
            System.out.println("Всё хорошо");
        } catch (Exception e) {
            tr.rollback();
            System.out.println("Всё плохо");
        }
    }
    public static void delete(Object o){
        try {
            tr=sess.beginTransaction();
            sess.delete(o);
            tr.commit();
            System.out.println("Всё хорошо");
        } catch (Exception e) {
            tr.rollback();
            System.out.println("Всё плохо");
        }
    }

    
}
