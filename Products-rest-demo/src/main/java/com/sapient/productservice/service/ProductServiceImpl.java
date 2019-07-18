package com.sapient.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.productservice.dao.ProductServiceDAO;
import com.sapient.productservice.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Service(value="productService")
public class ProductServiceImpl implements ProductService {
	@Autowired( required = true)
    //@Qualifier(value = "mysqlDAOImpl")
	@Qualifier(value= "hibernateDAOImpl")
    private ProductServiceDAO productServiceDAO;
//
//	 public ProductServiceImpl(ProductServiceDAO employeeDAO){
//	        this.productServiceDAO = employeeDAO;
//	    }
	
	//hibernet
	 public ProductServiceImpl(@Qualifier(value= "hibernateDAOImpl") ProductServiceDAO employeeDAO){
	        this.productServiceDAO = employeeDAO;
	    }
	@Transactional
    public Product saveProduct(Product employee) {
        System.out.println("Inside the save employee method of Employee service class ....");
        return productServiceDAO.save(employee);
    }

	@Transactional
    public List<Product> fetchAllProduct() {
        return productServiceDAO.listAll();
    }

	@Transactional
    public Product findById(int id) {
        return productServiceDAO.findById(id);
    }

	@Transactional
    public void deleteProduct(int id) {
    	productServiceDAO.deleteProduct(id);

    }
    
	@Transactional
    public void updateProduct(int id,Product product) {
    	productServiceDAO.updateProduct(id,product);
    }
    
}