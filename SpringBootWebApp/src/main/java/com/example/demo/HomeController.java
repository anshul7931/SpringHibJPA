package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping("home")
	public String home(HttpServletRequest req) {
		System.out.println("In home");
		//Path of view should be src/main/webapp always, else we need to do some configurations
		
		/*If we want to fetch value from from client to server -> HttpServletRequest
		 * If we want to show the values from server to client, we can use HttpSession.
		*/
		
		String name = req.getParameter("name");//we are passing the name as localhost:8080/home?name=anshul
		HttpSession session = req.getSession();
		session.setAttribute("name",name);//passing this name in session to fetch it on home.jsp
		
		return "home";// It will download this file if jsp support dependency 
		                  // is not added in the pom(tomcat jasper)
		
		/*If home.jsp is not present in webapp folder directly,
		 * then we need to manually do some configuration in application.properties file
		*/
	}
	
	/*Now Spring internally provides the HttpSession that we can use 
	 * without any http servlet request
*/
	
	@RequestMapping("newhome")//localhost:8080/newhome?name=anshul
	public String newhome(@RequestParam("name") String name, HttpSession session) {
		System.out.println("In new home");
		
		session.setAttribute("name",name);//model(data)
		return "home";//view
	}
	
	/*Now we dont want to use session as well,we can use ModelAndView .
	 * 
	 */
	
	@RequestMapping("newhomeWithoutSession")//localhost:8080/newhomeWithoutSession?name=anshul
	public ModelAndView newhomeWithoutSession(@RequestParam("name") String name) {
		System.out.println("In newhomeWithoutSession");
		ModelAndView mv = new ModelAndView();
		mv.addObject("name", name);//model(data)
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("getAlien")//localhost:8080/getAlien?aid=1&aname=anshul&language=Java
	public ModelAndView getAlien(Alien alien) {
		System.out.println("In getAlien");
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);//model(data)
		mv.setViewName("home");
		return mv;
	}
}
