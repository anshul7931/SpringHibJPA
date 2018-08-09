package com.anshul.mavenSpring;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle{

	public void drive() {
		System.out.println("in bike drive method");
	}
}
