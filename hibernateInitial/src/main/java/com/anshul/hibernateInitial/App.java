package com.anshul.hibernateInitial;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 		 * Hibernate is ORM i.e. Object relational mapping tool.
         * If we want to connect to database then we have to provide configuration.
         * you can provide configuration in hibernate configuration file where you 
         * have to provide  database dialect ,driver class, connection url, username and 
         * password in hibernate.cfg.xml file.you also need to specify that this class is 
         * allowed to store its object in database using @Entity annotation and @Id is used 
         * for specifying primary key.Whenever you have to make changes in database at that 
         * time you need to follow acid properties.
         * 
         * Right click on project and select new->others
         * search for hibernate configuration file(cfg.xml)
         * Here its hibernate.cfg.xml(In java folder, not in package)
         * 
         * After defining this file we need to configure this file using configuration object
         * 
 */
public class App 
{
    public static void main( String[] args )
    {
        Alien alien = new Alien();
        
        /*We can use embeddable annotation in AlienName.java to embed the values in Alien table,
         * without creation of new table.
        */
        AlienName aname = new AlienName();
        aname.setFname("Anshul");
        aname.setLname("Goel");
        
        alien.setAid(4);
       // alien.setAname("Ankush");
        alien.setAname(aname);
        alien.setColor("White");
        
        /*In order to persist these values, we need to use Session interface's save method.
         * But session interface is part of hibernate framework.So we need to add libraries 
         * of hibernate.Along with it we need to add sql dependencies also.
         * 
         * After this we have to add hibernate plugin in eclipse(hibernate tools under jboss tools)
         * 
         * Now Session is an interface so we cant make its object.So we can use SessionFactory
         * to initialise session. SessionFactory is also a interface now. So we make a call to
         * Configuration class in order to initialise it.
         * 
         * 
         * In order to deal with tables we need to use Transaction, to sustain the ACID properties.
         * 
         * Now we can either create a table manually or we can automate the table creation by:
         * Adding a property in hibernate.cfg.xml
         * <property name="hbm2ddl.auto">update</property> -> Update the changes
         * <property name="hbm2ddl.auto">Create</property> -> creates the entity everytime
        */
        
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf= con.buildSessionFactory(reg);
        		
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        session.save(alien);//Persisting values in table.
        
        /*Here alien is in persistent state now till session is destroyed,
         * or transaction is commited. If we add  alien.setColor("Grey"); after session.save
         * then also this value will be added in the database. 
         * 
         * We can remove the persistent state using session.detach(alien); after the commit
        */
        
        
        tx.commit();
        
        /*In order to fetch value from db, we need to use get method.
         * get accepts 2 params: class name and serialisable key
        */
        
        Alien gettingAnAlien = (Alien)session.get(Alien.class, alien.getAid());
        System.out.println(gettingAnAlien);
    }
}
