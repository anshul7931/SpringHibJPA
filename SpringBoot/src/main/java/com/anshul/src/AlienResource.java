package com.anshul.src;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlienResource {
	
	private AlienRepository alienRepository;
	
	public AlienResource(AlienRepository alienRepository) {
		this.alienRepository = alienRepository;
	}
	
	@GetMapping("aliens")
	public List<Alien> getAliens(){
		return  (List<Alien>) alienRepository.findAll();
	}
	
	

}
