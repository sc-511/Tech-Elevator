package com.techelevator.projects.model.jdbc;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
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
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;

public class JDBCDepartmentDAOTest {

	private static SingleConnectionDataSource dataSource;
	private JDBCDepartmentDAO dao;
	private JdbcTemplate jdbc;

	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	
	@Before
	public void setup() {
		this.dao = new JDBCDepartmentDAO(dataSource);
		this.jdbc = new JdbcTemplate(dataSource);
	}
	
	@Test
	public void getAllDepartments_in_current_databse() {
		List <Department> before = dao.getAllDepartments();
		int beforeSize = before.size();
		
		String sql = "INSERT INTO department (name) VALUES (?)";
		jdbc.update(sql,"CheeseBurger Division");
		List <Department> after = dao.getAllDepartments();
		int afterSize = after.size();
		Assert.assertEquals(beforeSize + 1, afterSize);
	}
	
	@Test
	public void searchDepartmentByName_using_dummy_input() {
		String sql = "INSERT INTO department (name) VALUES (?)";
		jdbc.update(sql, "CheeseBurger Division");
		String search = "SELECT department_id FROM department  WHERE name ILIKE ?";
		String nameSearchParam = "%cheesebur%";
		SqlRowSet returnId = jdbc.queryForRowSet(search, nameSearchParam);
		returnId.next();
		long cheeseBurgId = returnId.getLong(1);
		List <Department> listOfDeps = dao.searchDepartmentsByName(nameSearchParam);
		Assert.assertNotNull(listOfDeps);
		Assert.assertEquals(1, listOfDeps.size());
	}
	
	@Test
	public void checkDepartmentName_change() {
		Department coding = new Department();
		coding.setName("Jazz");
		dao.createDepartment(coding);
		coding.setName("Punk");
		dao.saveDepartment(coding);
		List<Department> totalDeparts = dao.searchDepartmentsByName("Punk");
		Assert.assertEquals(1, totalDeparts.size() );
		
		
	}
	
	
	@Test
	public void createNewDepartment() {
		List<Department> beforeList = dao.getAllDepartments();
		Department coding = new Department();
		coding.setName("Housing");
		dao.createDepartment(coding);
		List<Department> newList = dao.getAllDepartments();
		Assert.assertEquals(beforeList.size() + 1 , newList.size());
	}
	
	@Test
	public void grabRecentlyCreatedDepartment() {
		List<Department> beforeList = dao.getAllDepartments();
		Department coding = new Department();
		coding.setName("Housing");
		List<Department> totalDeparts = dao.getAllDepartments();
		totalDeparts.add(dao.getDepartmentById(coding.getId()));
		Assert.assertNotEquals(beforeList.size(), totalDeparts.size() );
		Assert.assertEquals(beforeList.size() + 1, totalDeparts.size());
	}
	
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	
	@AfterClass
	public static void destroyDataSource() throws SQLException {
		dataSource.destroy();
	}
	
	
	
}
