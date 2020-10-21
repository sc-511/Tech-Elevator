package com.techelevator.projects.model.jdbc;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Employee;

public class JDBCEmployeeDAOIntegrationTest {
	private  SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	
		@BeforeClass
		public void setupDataSource() {
			SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
			dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
			dataSource.setUsername("postgres");
			dataSource.setPassword("postgres1");
			
			dataSource.setAutoCommit(false);
		}
		
		@Before
		public void setup() {
			dao = new JDBCEmployeeDAO(dataSource);
		}
		
		
		@Test
		public void getEmployeesByDepartmentId_is_empty_for_invalid_department() {
			//Act
			List <Employee> employeesInRD = dao.getEmployeesByDepartmentId(-1L);
			
			//Assert
			Assert.assertNull(employeesInRD);
		}
		
		@Test
		public void changeEmployeeDepartment_moves_employee_to_store_support() {
			//Arrange
			List <Employee> allEmployees = dao.getAllEmployees();
			
			Employee employeeOne = dao.getAllEmployees().get(0);
			Long employeeOneDepartmentId = employeeOne.getDepartmentId();
			Long newDepartmentId = -1L;
			
			
			//Act
			dao.changeEmployeeDepartment(employeeOne.getId(), newDepartmentId);
			
			List <Employee> employeesInNewDepartment = dao.getEmployeesByDepartmentId(newDepartmentId);
			
			//Assert
			Assert.assertNotNull(employeesInNewDepartment);
			Assert.assertEquals(1, employeesInNewDepartment.size());
			
			Employee employeeOneInNewDepartment = employeesInNewDepartment.get(0);
			
			Assert.assertEquals(employeeOne.getFirstName(), employeeOneInNewDepartment.getFirstName());
		}
		
		@Test
		public void getEmployeesByDepartmentId_gets_list_of_employees_for_r_and_d() {
			//Arrange
//			Employee employee = new Employee();
//			employee.setFirstName("Shane");
//			employee.setLastName("Craig");
//			employee.setBirthDay(LocalDate.of(2000, 10, 21));
//			employee.setHireDate(LocalDate.of(2020, 1, 6));
//			employee.setGender('M');
//			employee.setDepartmentId(100L);
			
			//Act
			List <Employee> employeesInRD = dao.getEmployeesByDepartmentId(3L);
			
			//Assert
			Assert.assertNotNull(employeesInRD);
			Assert.assertEquals(10, employeesInRD.size());
		}
		
		
		
		
		
		
		@After
		public void rollback() throws SQLException {
			dataSource.getConnection().rollback();
		}
		
		@AfterClass
		public void destroyDataSource() {
			dataSource.destroy();
		}
}
