package com.anshul.mavenSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Configured a maven project with quickstart option in archtype
 * Added spring dependency from maven repository(spring context) in pom.xml
 * Created 2 classes: bike and car, and one common interface as Vehicle
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	Car obj=new Car();
//    	Bike obj1= new Bike();
    	/*In order to make this general we made an interface
    	  Now we Dont need to change LHS everytime*/ 
//        Vehicle obj = new Car();
    	
//    	BEAN FACTORY AND APPLICATION CONTEXT
    	
    	
		/*        But Here we need to change RHS
		        In order to make that general we will talk to spring framework
		        We can either use BeanFactory or ApplicationContext and make call to getBean method
		    	  For small applications we can use BeanFactory
		    	  For enterprise/large applications we use Application context
		    	  Application context provides all the features that bean factory does*/
    	
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/anshul/mavenSpring/Spring.xml");
//    	Vehicle obj = (Vehicle) context.getBean("vehicle");
//    	obj.drive();
    	
//    	XML AND ANNOTATION BASED CONFIGURATION
    	
		/*    	In order to access the vehicle bean, it needs to be present in the XML file
		    	Create an XML named spring.xml
		    	If we change in java file we have to recompile our code
		    	But if we change xml we just need to save
		    	In actual there are 3 ways in spring
		    	1.Xml based configuration
		    	2.Annotation based configuration
		    	3.Java configuration
		    	For using annotation based Configurations we need to remove the bean from xml file
		    	and add @Component to individual classes and instead of vehicle and
		    	add context:component-scan tag in xml, we can directly use the 
		    	class name now. 
		*/
    	
    	Vehicle obj = (Vehicle) context.getBean("car");
    	obj.drive();
    	
    	
//    	DEPENDENCY INJECTION
    	
    	/*Now we will create one more class as tyre in order to study about dependency injection
    	 * There are 2 types of dependency injections i.e 
    	 * 1. Constructor injection 
    	 * 2. Setter injection
    	 * When we use property tag , with value attribute then we call setter dependency injection
    	 * In order to use setter injection, constructor of the class should not be defined
    	 * Because constructor dependency injection has high priority as compared to setter injection.
    	 * 
    	 * In order to use constructor dependency injection,we need to use constructor-arg tag
    	 * with value attribute
    	*/
    	
//    	AUTOWIRED ANNOTATION
    	
    	/*
    	 * Now after removing the constructor dependency injection
    	 * we will create a tyre dependency for car
    	 * Calling the drive method of car will return 
    	 * in car drive method [tyre=null](acc to print statement)
    	 * if tyre is not autowired.
    	 * 
    	 * What happens here is after using the @Autowired annotation on tyre,
    	 * under the car class, it checks the annotation based configuration
    	 * i.e. it will also work if @Component is there on Tyre or not.
    	 * 
    	 * If annotation is not ther, then we check the xml file for the class reference.
    	 * Here XML have more priority then annotation i.e if we define in both classes,
    	 * then class bean will be overriden with xml bean
    	 * 
    	 * After adding th annotation response is changed to
    	 * in car drive method [tyre=Tyre is coming]
    	*/
    	
    	Car car = (Car) context.getBean("car");
    	car.drive();
    	
    	
    	
    }
}
