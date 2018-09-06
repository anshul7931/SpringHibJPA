package com.example.demo.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Path("/test")
public class UserController {
	
	public UserController() {
		System.out.println("&&&&&&&&&&&&&#####################Constructor");
	}
	
	@GET
	@Path("/getUser")
	@Produces(MediaType.TEXT_PLAIN)
	public Object getJson() {
		try {
			System.out.println("a");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
