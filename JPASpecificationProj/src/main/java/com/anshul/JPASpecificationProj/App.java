package com.anshul.JPASpecificationProj;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	/*WE need to make resources/META-INF under src/main folder.
    	 * We will create one xml file (persistence.xml) in which we define a persistence unit pu
    	*/
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
    	EntityManager em = emf.createEntityManager();
    	
        Alien a = em.find(Alien.class, 1);//get
        System.out.println(a);
        
        Alien a2 = new Alien();
        a2.setAid(6);
        a2.setAname("Ansh");
        a2.setTech("Scala");
        
        em.getTransaction().begin();
        em.persist(a2);
        em.getTransaction().commit();
    }
}
