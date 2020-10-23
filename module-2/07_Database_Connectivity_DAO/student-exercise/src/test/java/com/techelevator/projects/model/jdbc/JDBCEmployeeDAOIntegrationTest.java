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
	private static final Long TEST_EMPLOYEEID = 100L;
	private static  SingleConnectionDataSource dataSource;
	private JDBCEmployeeDAO dao;
	
		@BeforeClass
		public static void setupDataSource() {
			dataSource = new SingleConnectionDataSource();
			dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
			dataSource.setUsername("postgres");
			dataSource.setPassword("postgres1");
			
			dataSource.setAutoCommit(false);
		}
		
		@Before
		public  void setup() {
			String sqlInsertEmployee = "INSERT INTO employee (employee_id, department_id, first_name, last_name, gender, birth_date, hire_date) VALUES (?, '4', 'Shane', 'Craig',  'M', '1999-06-05', '2020-09-14')"; 
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(sqlInsertEmployee, TEST_EMPLOYEEID);
			dao = new JDBCEmployeeDAO(dataSource);
		}
		
		
		@Test
		public void getEmployeesByDepartmentId_is_empty_for_invalid_department() {
			//Act
			List <Employee> employeesInRD = dao.getEmployeesByDepartmentId(1L);
			
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
		public void getEmployeesByDepartmentId() {
//			Employee theEmployee = getEmployee(TEST_EMPLOYEEID, 2L, "Jerome", "Bettis",  'M', LocalDate.of(1979, 8, 24), LocalDate.of(1990, 02, 19));
//			List<Employee> results = dao.getEmployeesByDepartmentId(TEST_EMPLOYEEID);
//			Assert.assertNotNull(results);
//			Assert.assertEquals(1, results.size());
//			assertEmployeeIdAreEqual(theEmployee, results.get(0));
			
		}
		
		@Test 
		public void getEmployeesByProjectId_gets_list_of_employees_on_project() {
			List <Employee> employeesOnProject = dao.getEmployeesByProjectId(2L);
			
		}
		
		@Test
		public void getEmployeesByNoProjectId () {
			 
		}

		
		@After
		public void rollback() throws SQLException {
			dataSource.getConnection().rollback();
		}
		
		@AfterClass
		public static void destroyDataSource() {
			dataSource.destroy();
		}
		
		private Employee getDepartment(Long employee_id, Long departmentid, String firstName, String lastName, char gender, LocalDate birthday, LocalDate hireDate) {
			Employee theEmployee = new Employee();
			theEmployee.setId(employee_id);
			theEmployee.setDepartmentId(departmentid);
			theEmployee.setFirstName(firstName);
			theEmployee.setLastName(lastName);
			theEmployee.setGender(gender);
			theEmployee.setBirthDay(birthday);
			theEmployee.setHireDate(hireDate);
			return theEmployee;
		}
		
		private void assertDepartmentIdAreEqual(Employee expected, Employee actual) {
			Assert.assertEquals(expected.getId(), actual.getId());
			Assert.assertEquals(expected.getDepartmentId(), actual.getDepartmentId());
			Assert.assertEquals(expected.getFirstName(), actual.getFirstName());
			Assert.assertEquals(expected.getLastName(), actual.getLastName());
			Assert.assertEquals(expected.getGender(), actual.getGender());
			Assert.assertEquals(expected.getBirthDay(), actual.getBirthDay());
			Assert.assertEquals(expected.getHireDate(), actual.getHireDate());

		}
}
