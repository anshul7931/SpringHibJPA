package com.anshul.hibernateFetchTechniques;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure("hibernate.cfg.xml")
    			.addAnnotatedClass(Laptop.class)
    			.addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf= con.buildSessionFactory(reg);
        		
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        Alien a1 = (Alien) session.get(Alien.class,1);/*This will not fetch any list of laptops,
         												associated with alien 
         												but if we call a1.getLaps() then it will
         												fetch the list of laptops also.
         												This is known as LAZY fetch technique.
         												
         												If we want to get laptops without getLaps()
         												then we need to change the fetchType to
         												EAGER.
         												It uses left outer join to fetch the values.
         												
         												*/
        System.out.println(a1);
        /*Instead of get method we can also use load,output will be same
         * Main difference: 
         * 1. Everytime you call the get method, it hits the database(fires a query) 
         * even if the object is not used but load does not fire a query unless its called.
         * 2. If data is not there, then get will give null, but load will throw an Exception.
         * 
         * It means get gives the object but load gives the proxy object
        */
        Alien a2 = (Alien) session.load(Alien.class,1);
        System.out.println(a2);
        session.getTransaction().commit();
    }
}


