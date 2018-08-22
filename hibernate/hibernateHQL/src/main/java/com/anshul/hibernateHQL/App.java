package com.anshul.hibernateHQL;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Configuration con = new Configuration().configure("hibernate.cfg.xml")
    			.addAnnotatedClass(Student.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf= con.buildSessionFactory(reg);
        		
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        //Fetching a list
        Query q = session.createQuery("from Student where marks>50");
        List<Student> students = q.list();
        
        for(Student student:students) {
        	System.out.println(student);
        }
        
        //Fetching single record
        Query q2 = session.createQuery("from Student where sid=5");
        Student student = (Student) q2.uniqueResult();
        
        System.out.println("q2 "+student);
        
        
        //Fetching specific columns for single tupple
        
        /*It will fetch the object array because some fields are integer, some are varchar etc
        */
        
        Query q3 = session.createQuery("select rollno,name,marks from Student s where s.sid=:id");
        q3.setParameter("id", 30);
        Object[] Details = (Object[]) q3.uniqueResult();
        
        for(Object obj:Details) {
        	System.out.print("q3 "+obj+" ");
        }
        
        //Fetching specific columns for multiple tupples
        
        Query q4 = session.createQuery("select rollno,name,marks from Student");
        List<Object[]> listOfStudentDetails = (List<Object[]>) q4.list();
        
        for(Object[] obj:listOfStudentDetails) {
        	System.out.println("q4");
        	for(Object studentDetails:obj) {
        		System.out.print(studentDetails+" ");
        	}
        }
        
        //SQL Query example instead of HQL
        
        SQLQuery sqlquery = session.createSQLQuery("select * from student where marks>60");
        sqlquery.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);//Convert result to map
        List<Object> studentsList = sqlquery.list();
        System.out.println("q5");
        for(Object studentSQL: studentsList) {
        	Map m = (Map)studentSQL;
        	System.out.println(m.get("name")+" : "+m.get("marks"));
        }
        
        
        session.getTransaction().commit();
        
        
    }
}
