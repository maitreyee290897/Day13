package com.sapient.productservice.controller;

import java.util.List;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.hibernate.mapping.Array;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

import com.sapient.productservice.model.Product;
import com.sapient.productservice.service.ProductService;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	
	public ProductController(ProductService productService) {
		this.productservice = productService;
	}

	@GetMapping(value = "/", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public List<Product> ListAll(){
		/*
		List<Product> products = Arrays.asList(new Product(), new Product(), new Product());
		return products;
		*/
		
		List<Product> e1 = this.productservice.fetchAllProduct();
	       for(Product e : e1 ) {
	     	System.out.println(e);
	     }    
	       
	     return e1;
    
	}
	
	@GetMapping(value = "/{id}", produces = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public Product findById(@PathVariable("id") int id) {
		//return new Product();
		Product p = this.productservice.findById(id);
		return p;
		
	}
	
	@PutMapping(value= "/{id}", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void updateProduct(@PathVariable("id")int id,@RequestBody Product product) {
		System.out.println("came in update prod");
		this.productservice.updateProduct(id, product);
	}
	
	@PostMapping(value= "/", consumes = {APPLICATION_JSON_VALUE, APPLICATION_XML_VALUE})
	public void saveProduct(@Valid @RequestBody Product product) {
		System.out.println("came in save pro");
		this.productservice.saveProduct(product);
	}
	
	@PostMapping(value= "/{id}")
	public void deleteProduct(@Valid @RequestBody int id) {
		System.out.println("came in save pro");
		this.productservice.deleteProduct(id);
	}
	
}
