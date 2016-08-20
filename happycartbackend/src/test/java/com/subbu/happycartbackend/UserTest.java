package com.subbu.happycartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.subbu.happycartbackend.dao.UserDAO;
import com.subbu.happycartbackend.model.User;



public class UserTest {
	
	public static void main(String[]args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.subbu.happycartbackend");
		context.refresh();
		
		UserDAO userDAO =(UserDAO) context.getBean("userDAO");
		User user= (User) context.getBean("user");
		user.setId("Cat002");
		user.setUsername("Ranbir");
		user.setPassword("katrina");
		user.setEmail("ranbirkapoor@happycart.com");
		user.setMobilenumber("+91 9012345678");
		user.setCart("2 items");
		
		userDAO.saveOrUpdate(user);
		
		if(userDAO.get("sdfsf")==null)
		{
			System.out.println("SignedUp users are displayed on h2 database...");
			System.out.println();
		}
		
	}

}
