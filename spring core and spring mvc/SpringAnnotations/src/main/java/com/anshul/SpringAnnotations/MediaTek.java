package com.anshul.SpringAnnotations;

import org.springframework.stereotype.Component;

@Component
public class MediaTek implements MobileProcessor {

	public void process() {
		System.out.println("In MediaTek process");
	}

}
