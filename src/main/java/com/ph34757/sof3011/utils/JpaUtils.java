package com.ph34757.sof3011.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class JpaUtils {
    private static EntityManagerFactory factory;
    static public EntityManager getEntityManager(){
        if (factory == null || !factory.isOpen()){
            factory = Persistence.createEntityManagerFactory("java4");
        }
        return factory.createEntityManager();
    }
    static public void shutdown(){
        if (factory != null && factory.isOpen()){
            factory.close();
        }
        factory = null;
    }
}
