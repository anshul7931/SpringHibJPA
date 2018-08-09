package com.anshul.hibernateRelationships;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    	
    	Laptop laptop= new Laptop();
    	laptop.setLid(101);
    	laptop.setLname("Dell");
    	
    	Student s = new Student(); 
    	s.setName("Anshul");
    	s.setRollno(1);
    	s.setMarks(50);
    //	s.setLaptop(laptop); //-> one to one in student
    	
    	/*s.getLaptop().add(laptop); //-> one to many
    	  laptop.setStud(s);		1. one to many in student 
    								*-> junction table student_laptop will be created
    								*
    								*2.one to many in student + many to one in laptop
    								*->create foreign key column in laptop table 
    								*     +  junction table student_laptop
    								*     
    								*3.one to many in student(mappedBy="stud")
    								*    + many to one in laptop as Student stud
    								*->create foreign key column in laptop table 
    								*     
    	                           
    	*/
    	
    	s.getLaptop().add(laptop);
    	laptop.getStud().add(s);
    							//-> many to many
								/*
								 * 1. many to many in student 
								 *     +  many to many in laptop
								 * -> two junction tables Laptop_Student and Student_Laptop created 
								 * 
								 * 2. many to many in student (mappedBy="stud")
								 *     +  many to many in laptop
								 * -> junction table Laptop_Student is created
								*   */  
    	
    	Configuration con = new Configuration().configure()
    			.addAnnotatedClass(Laptop.class)
    			.addAnnotatedClass(Student.class);
        
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
        SessionFactory sf= con.buildSessionFactory(reg);
        		
        Session session = sf.openSession();
        
        session.beginTransaction();
        
        session.save(laptop);
        session.save(s);
        
        session.getTransaction().commit();
    }
}
