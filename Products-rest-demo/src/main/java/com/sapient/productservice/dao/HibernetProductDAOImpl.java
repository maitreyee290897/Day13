package com.sapient.productservice.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sapient.productservice.model.Product;

import java.util.List;

@Repository("hibernateDAOImpl")
public class HibernetProductDAOImpl implements ProductServiceDAO{
	 @Autowired
	    private SessionFactory sessionFactory;

	    @Override
	    public Product save(Product employee) {
	        Session session = sessionFactory.getCurrentSession();
	        session.saveOrUpdate(employee);
	        return employee;
	    }

	    @Override
	    public List<Product> listAll() {
	        Session currentSession = sessionFactory.getCurrentSession();
	        return currentSession.createQuery("from Product ").list();
	    }

	    @Override
	    public Product findById(int id) {
	        return sessionFactory.getCurrentSession().get(Product.class, id);
	    }

	    @Override
	    public void deleteProduct(int id) {
	        Session session = sessionFactory.getCurrentSession();
	        Product employee = session.byId(Product.class).load(id);
	        session.delete(employee);
	    }

		@Override
		public void updateProduct(int id, Product product) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.getCurrentSession();
	        //Product employee = session.byId(Product.class).load(id);
			Product p1=session.byId(Product.class).load(id);
			p1.setName(product.getName());
			p1.setPrice(product.getPrice());
	        session.saveOrUpdate(p1);
		}
	}