package com.anshul.SpringAnnotations;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


//Aspect Oriented Programming
//Cross Cutting Concerns -> Aspect
//Aspect should also be a bean, so we write @Component
//There are advices in AOP like before, after etc..
//By default AOP wont be enabled, so we can enable it by @EnableAspectJAutoProxy
//here execution(public void show()) is known as point cut

@Component
@Aspect
@EnableAspectJAutoProxy
public class Helper {

	@Before("execution(public void config())")
	public void log() {
		System.out.println("Logger called -> AOP");
	}
}
