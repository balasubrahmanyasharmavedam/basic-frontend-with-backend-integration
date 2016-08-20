package com.subbu.happycartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.subbu.happycartbackend.dao.ProductDAO;
import com.subbu.happycartbackend.model.Product;



public class ProductTest {
	public static void main(String[]args){
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.subbu.happycartbackend");
		context.refresh();
		
		ProductDAO productDAO =(ProductDAO) context.getBean("productDAO");
		Product product= (Product) context.getBean("product");
		product.setId("Pr001");
		product.setBrand("Sony");
		product.setModel("Xperia Z3");
		product.setRam("3gb");
		product.setStorage("16gb");
		product.setSoc("SnapDragon 801");
		product.setCamera("Sony IMX220 20.7mp");
		product.setPrice("52,990");
		
		
		
		productDAO.saveOrUpdate(product);
		System.out.println("No.of products available"+productDAO.list().size());
		
		if(productDAO.get("sdfsf")==null)
		{
			System.out.println("Products available..the stock is shown in database..");
			System.out.println();
		}
		
	}


}
