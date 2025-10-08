
package com.modelo;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
        
public class HibernateUtilSingle {
    private static SessionFactory sessionFactory;
    
    static {
        try {
            Configuration config = new Configuration().configure();
            sessionFactory = config.buildSessionFactory();
            System.out.println(" SessionFactory creada correctamente.");
        } catch (Exception e) {
            System.err.println(" Falló la creación del SessionFactory: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
    
    public static SessionFactory obtenerSessionFactory(){
        return HibernateUtilSingle.sessionFactory;
    }
    
    public static void cerrarFactory(){
        if(sessionFactory != null){
            sessionFactory.close();
        }
    }
}
