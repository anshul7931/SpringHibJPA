package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller
public class AlienController {
	
	/*h2 database can be tested on http://localhost:8070/h2-console
	 * Now in order to create a table we need to enable jpa by including dependencies.
	*/
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
		
	}
	
	@RequestMapping("/addAlien")//This method is called in home.jsp
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
		
	}
	
	
	/*In enterprise world, service layer is also needed as processing needs to be done on the
	 * service layer, not in the controller.
	*/
	
	@RequestMapping("/getAlien")//This method is called in home.jsp
	public ModelAndView getAlien(@RequestParam int aid) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(aid).orElse(new Alien());
		System.out.println("Java tech aliens are:"+repo.findByTechSorted("Java"));
		mv.addObject(alien);
		return mv;
		
	}
	
	@RequestMapping(path="/getAllAliens", produces={"application/xml"}, method=RequestMethod.GET)//This method is called in home.jsp
	@ResponseBody//By default it expects a view name in jsp, so in order to show data we use this annotation 
	public List<Alien> getAllAliens() {
		List<Alien> alienList = repo.findAll();
		return alienList;
	}
	
	@PutMapping("/updateAlien")//This method is called in home.jsp
	public String updateAlien(Alien alien) {
		repo.delete(alien);
		repo.save(alien);
		return "home.jsp";
		
	}
	
	/*Custom queries can be made with the help of CRUDRepository by using the naming convension.
	 * Check the AlienRepo for more clarifications
	*/
	
	
	//CONTENT NEGOTIATION
	
	/*A client can ask/request data for multiple formats like JSON , XML etc.
	 * Server can sent the data in specified format.
	 * We can also restrict some formats.
	 * By default spring boot provides json.
	 * For xml jackckson dataformat xml needs to be added in pom
	 * 
	 * In order to request we need to pass header as:
	 * Accept:application/xml
	 * 
	 * In order to restrict to particular format, we can modify RequestMapping as
	 * @RequestMapping(path="/getAllAliens", produces={"application/xml"})
	*/
	
	@PostMapping("/alienFormData")//POST call from postman
	@ResponseBody
	public Alien createAlienFormData(Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	@PostMapping("/alien")//POST call from postman
	@ResponseBody
	public Alien createAlienRawData(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
	}
	
	/*By default RequestMapping is get, 
	 * we can either use PostMapping or Method attribute of request mapping,
	 * to specify the type of request method=RequestMethod.POST
	 * 
	 * We have
	 * @GetMapping
	 * @PostMapping
	 * @DeleteMapping
	 * @PutMapping
	*/
	
	
	/*
	 * If we are not using the jsp pages, than instead of @controller we could have used
	 * @RestController, then we dont even need to write @ResponseBody
	 * 
	 * 
	 * We dont even need this class, we can use Spring data rest, that is in different project
	*/
}
