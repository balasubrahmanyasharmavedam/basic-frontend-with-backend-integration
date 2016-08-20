package com.subbu.happycartfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.subbu.happycartbackend.dao.UserDAO;
import com.subbu.happycartbackend.model.User;

@Controller
public class HomeController {

	@Autowired
	UserDAO userDAO;

	@Autowired
	User user;

	@RequestMapping(value = "/register.html")
	public ModelAndView getUser() {

		ModelAndView mv = new ModelAndView("register");
		mv.addObject("user" , user);

		return mv;
	}

	@RequestMapping(value = "/submituserdetails.html")
	public ModelAndView submitUserdetails(@ModelAttribute User user) {
		userDAO.saveOrUpdate(user);
		ModelAndView mv = new ModelAndView("userhome");
		mv.addObject("user", "u have successfully registered");
		return mv;
	}
		
}