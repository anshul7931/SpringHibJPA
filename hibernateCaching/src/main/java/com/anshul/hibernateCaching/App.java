package com.anshul.hibernateCaching;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 		 * Hibernate caching decreases the number of database hits thereby 
 		 * reducing the time that will be consumed to serve the request.
 		 * we have 1st level caching  which will be in the particular session 
 		 * i.e. every session will have its own first level cache and 
 		 * second level caching is used for multiple sessions to share data.
         * 
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien alien = new Alien();
        
        Configuration con = new Configuration().configure("hibernate.cfg.xml")
        		.addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf= con.buildSessionFactory(reg);       		
        Session session = sf.openSession(); 
         
        Transaction tx = session.beginTransaction();
        
        alien=(Alien)session.get(Alien.class, 1);
        System.out.println(alien);
        alien=(Alien)session.get(Alien.class, 1);
        System.out.println(alien);
        
        tx.commit();
        

        /*Here query will be same both the times. So it will be fired only once
         * as hibernate checks the query in its first level cache(for same session)
         * ,and directly provides the values. First level cache is there by default. 
         * 
         * Now we will try by creating one more session.
        */
        
        session.close();
        
        
        Session session2 = sf.openSession(); 
        
        Transaction tx2 = session2.beginTransaction();
        
        alien=(Alien)session2.get(Alien.class, 1);
        System.out.println(alien);
        
        tx2.commit();
        session2.close();
        
        /*The query is fired twice now, that means its hitting the database twice
         * even if the query is same but session is different. To solve this problem,
         * we need to use the 2nd level cache.
         * We need to configure it manually, it wont be provided by default.
         * 
         * One of the 2nd level cache that we can use is eh cache.For that we need to
         * download eh cache jar files, eh cache hibernate integration jar files and then 
         * we need to update our configuration file.After all this, we need to add
         * @Cacheable,@Cache with read only/read write stratergy in entity.
         * Now for multiple sessions also, single query is fired.
        */
        
        /*We used hibernate's get method here. but if we use our own query, then
         * by default 2nd level cache is for get method only so once again the query
         * will be fired.For this we need to specify one more property in cfg.xml file
         * as hibernate.cache.use_query_cache and set q1.cacheable(true) in java code.
         * 
         * All over 2 queries will be generated, one for get method and one for direct query.
         * 
        */
        
        Session session3 = sf.openSession(); 
        
        Transaction tx3 = session3.beginTransaction();
        
        Query q1 = session3.createQuery("from Alien where aid=1");
        q1.setCacheable(true);
        alien = (Alien)q1.uniqueResult();
        System.out.println(alien);
        
        tx3.commit();
        
        Session session4 = sf.openSession(); 
        
        Transaction tx4 = session4.beginTransaction();
        
        Query q2 = session4.createQuery("from Alien where aid=1");
        q2.setCacheable(true);
        alien = (Alien)q2.uniqueResult();
        System.out.println(alien);
        
        tx4.commit();
        session3.close();
    }
}
