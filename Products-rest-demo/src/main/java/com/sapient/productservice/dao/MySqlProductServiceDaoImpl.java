package com.sapient.productservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sapient.productservice.model.Product;

@Repository(value = "mysqlDAOImpl")
public class MySqlProductServiceDaoImpl implements ProductServiceDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	 public MySqlProductServiceDaoImpl(JdbcTemplate jdbcTemplate){
	        this.jdbcTemplate = jdbcTemplate;
	    }

	 public Product save(Product product) {
	        System.out.println("Came inside the save method of MySQLEmployeeDAOImpl");
	        jdbcTemplate.execute("insert into product values (" + product.getId() +", '"+product.getName()+"'," + product.getPrice() +")");
	        return product;
	    }
	 
	 
	 public List<Product> listAll() {
		 System.out.println("Came inside the listAll method of MySQLEmployeeDAOImpl");
	       List<Product> product = jdbcTemplate.query("select * from product",
	               ( rs, rowNum)-> new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
	       return product;
	    }

	    public Product findById(int id) {
	        return jdbcTemplate.queryForObject("select * from product where id = " + id,
	                (rs, rowNum) -> {
	                   Product product =  new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3));
	                           return product;
	                });

	    }

	    public void deleteProduct(int id) {
	    	
	    	String s="delete from product where id = " + id;
	    	
	    	jdbcTemplate.execute(s);

	    }
	    
	    public void updateProduct(int id, Product product) {
	    	
	    	String query = "update product set name='" + product.getName() +"', price =" + product.getPrice() + "where id=" + id;
	    	jdbcTemplate.update(query);

	    }
		
}
