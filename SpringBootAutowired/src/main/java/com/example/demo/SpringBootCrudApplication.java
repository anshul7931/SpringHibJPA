package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootCrudApplication {

	public static void main(String[] args) {
		
		/*This run method returns the object of ConfigurableApplicationContext,
		 * so we can use this Spring container to get the bean of alien class
		*/
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootCrudApplication.class, args);
		/*After this line Spring container will contain all the beans,
		 * By default spring works on singleton design pattern so the objects will be created 
		 * even if getBean is not called.
		 * 
		 * But if we call getBean multiple times then, spring container will use the same object again
		 * i.e. object wont be created multiple times.This is singleton nature of spring.
		 * 
		 * If we specify @Scope(value="prototype") on Alien, then object wont be created by default,
		 * when we run the project.Now getBean will generate the object.
		 * If it gets called multiple times then multiple objects will be created.
		 * 
		 * 
		 * In order to connect 2 objects in Spring container, we use @Autowired, 
		 * by default autowire searches by type
		*/
		Alien a = context.getBean(Alien.class);
		a.show();
		Alien a1 = context.getBean(Alien.class);
		a1.show();
		
	}
}
