package com.anshul;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.anshul.service.AddService;

@Controller
public class AddController {
	
	@Autowired
	AddService adService;

	@RequestMapping("/add")
	public ModelAndView add(@RequestParam("t1") int a,@RequestParam("t2") int b) {
//	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) {
//		int a= Integer.parseInt(request.getParameter("t1"));
//		int b= Integer.parseInt(request.getParameter("t2"));
		
		int sum= adService.add(a, b);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("display.jsp");
		mv.addObject("result",sum);
		return mv;
	}
}
