package com.sapient.springdemo.dao;

import com.sapient.springdemo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



@Repository(value = "mysqlDAOImpl")
public class MySQLEmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public MySQLEmployeeDAOImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee save(Employee employee) {
        System.out.println("Came inside the save method of MySQLEmployeeDAOImpl");
        jdbcTemplate.execute("insert into employee_table(id,emp_name) values (" + employee.getId() + ",'"+employee.getName()+"')");
        return employee;
    }

    public List<Employee> listAll() {
    	List<Employee> employeeList =jdbcTemplate.query("select * from employee_table", new RowMapper<Employee>() {
    		
    		public Employee mapRow(ResultSet rs,int rowNum)throws SQLException {
    			int empId = rs.getInt(1);
    			String name = rs.getString(2);
    			Employee employee = new Employee(empId,name);
    			return employee;
    		}
    		
    	});
    	
        return employeeList;
    	
//    	List<Employee> employeeList = jdbcTemplate.query("select * from emloyee_table", 
//    			(rs,rowNum)->new Employee(rs.getInt(1),rs.getString(2)));
//    	return employeeList;
    }

    public Employee findById(long id) {
//    	String query = "select * from employee_table where id=?"; 
//        Object[] inputs = new Object[] {id};
//        System.out.println(query);
//        Employee empName = jdbcTemplate.queryForObject(query, inputs, (rs, rowCounr) -> new Employee(rs.getInt(1), rs.getString(2)));
//        return empName;
    	return jdbcTemplate.queryForObject("select * from employee_table where id=" + id,
    			(rs, rowNum)->{
    				System.out.println(rowNum);
    				Employee employee = new Employee(rs.getInt(1),rs.getString(2));
    				employee.setAge(33);
    				return employee;
    			});
    }

    public void deleteEmployee(long id) {
    	String sql = "delete from employee_table where id=" + id;
    	jdbcTemplate.update(sql);
    }
}