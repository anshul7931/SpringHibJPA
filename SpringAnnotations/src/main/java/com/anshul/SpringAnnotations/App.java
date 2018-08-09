package com.anshul.SpringAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
        /*For using AnnotationConfigApplicationContext i.e annotation based config,
         * we need to create a class responsible for all the configurations.
         * Here we made appconfig.java
         * 
         * In that class we need to specify @Configuration annotation
         * And in every function we need to add @Bean annotation to define it as a bean.
         * 
         * In order to make the code work without @Bean annotations in config file, 
         * we can follow a simple approach:
         * 1. Instead of defining @Bean in config file we can write @Component on each class
         * 2. In the AppConfig file we need to define @ComponentScan annotation
         * 
         * Now there is a possibility that an interface is implemented by multiple classes(Components)
         * So we can define a primary component so that NoUniqueBean exception does not occur.
         * One more way is to add a qualifier annotation after autowiring.
         * 
         * If both @qualifier and @primary annotations are there, then qualifier will override primary.
        */
        Samsung s7 = factory.getBean(Samsung.class);
        s7.config();
    }
}
