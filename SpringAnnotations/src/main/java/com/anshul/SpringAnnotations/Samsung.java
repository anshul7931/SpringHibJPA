package com.anshul.SpringAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Samsung {

	@Autowired//Will check for bean in App config
	//@Qualifier("mediaTek")
	MobileProcessor	cpu;
	
	public MobileProcessor getCpu() {
		return cpu;
	}

	public void setCpu(MobileProcessor cpu) {
		this.cpu = cpu;
	}

	public void config() {
		
		//logging
		//security
		//begin transaction
		
		System.out.println("Config method of Samsung Class");//Business Logic will come here
		cpu.process();
		
		//end transaction
		
		/*For all the method these logging,security,transactions will be common
		 * so instead of calling them everytime, we can create an aspect by 
		 * downloading necessary jars 
		 * 
		 * Aspect class is helper.java
		*/
		
		
	}
}
