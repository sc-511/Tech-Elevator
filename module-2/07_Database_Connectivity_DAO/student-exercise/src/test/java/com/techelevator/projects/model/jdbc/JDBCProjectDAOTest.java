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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.Project;

public class JDBCProjectDAOTest {
	
	private static SingleConnectionDataSource dataSource;
	private JDBCProjectDAO dao;
	private JDBCEmployeeDAO employeeDao;
	private JdbcTemplate jdbc;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projects");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}
	@Before
	public void setup() {
		this.dao = new JDBCProjectDAO(dataSource);
		this.employeeDao = new JDBCEmployeeDAO(dataSource);
		this.jdbc = new JdbcTemplate(dataSource);
	}
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}
	@Test
	public void get_all_active_projects_returns_active_project() {
		List<Project> before = dao.getAllActiveProjects();
		int beforeSize = before.size();
		// ARRANGE
		String sql = "INSERT INTO project (name, from_date, to_date) VALUES (?, ?, ?)";
		LocalDate from = LocalDate.of(2010, 1, 1);
		LocalDate to = LocalDate.of(2021, 1, 1);
		jdbc.update(sql, "Dept of SQL", from, to);
		List<Project> after = dao.getAllActiveProjects(); // ACT
		int afterSize = after.size();
		Assert.assertEquals(beforeSize + 1, afterSize);
	}
	@Test
	public void add_employee_to_project() {
		// ARRANGE:
		//   1. Create dummy employee (and get resulting employee_id)
		String sqlInsertDummy = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) VALUES (DEFAULT, null, 'Dumb', 'Ass', '1/1/2000', 'M', '1/2/2000') RETURNING employee_id";
		SqlRowSet returningId = jdbc.queryForRowSet(sqlInsertDummy);
		returningId.next();
		long dummyId = returningId.getLong("employee_id");
		//   2. Create dummy ACTIVE project (and get resulting project_id)
		String sqlInsertProj = "INSERT INTO project (project_id, name, from_date, to_date) VALUES (DEFAULT, 'Dummy Project', '1/1/2020', '1/1/2021') RETURNING project_id";
		SqlRowSet returningProjId = jdbc.queryForRowSet(sqlInsertProj);
		returningProjId.next();
		long dumbProjId = returningProjId.getLong(1);		
		// ACT: Associate Dummy Employee with Dummy Project
		dao.addEmployeeToProject(dumbProjId, dummyId);
		// ASSERT: make sure dummy project has exactly one employee (the dummy)
		List<Employee> listOfEmployees = employeeDao.getEmployeesByProjectId(dumbProjId);
		Assert.assertNotNull(listOfEmployees);
		Assert.assertEquals(1, listOfEmployees.size());		
	}
	@Test
	public void remove_employee_from_project() {
		// ARRANGE:
		//   1. Create dummy employee (and get resulting employee_id)
		String sqlInsertDummy = "INSERT INTO employee (employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) VALUES (DEFAULT, null, 'Dumb', 'Ass', '1/1/2000', 'M', '1/2/2000') RETURNING employee_id";
		SqlRowSet returningId = jdbc.queryForRowSet(sqlInsertDummy);
		returningId.next();
		long dummyId = returningId.getLong("employee_id");
		//   2. Create dummy ACTIVE project (and get resulting project_id)
		String sqlInsertProj = "INSERT INTO project (project_id, name, from_date, to_date) VALUES (DEFAULT, 'Dummy Project', '1/1/2020', '1/1/2021') RETURNING project_id";
		SqlRowSet returningProjId = jdbc.queryForRowSet(sqlInsertProj);
		returningProjId.next();
		long dumbProjId = returningProjId.getLong(1);		
		//   3. Associate Dummy Employee with Dummy Project
		dao.addEmployeeToProject(dumbProjId, dummyId);
		// ACT:
		dao.removeEmployeeFromProject(dumbProjId, dummyId);
		// ASSERT: dummy employee is no longer on dummy project
		List<Employee> listOfEmployees = employeeDao.getEmployeesByProjectId(dumbProjId);
		Assert.assertEquals(0, listOfEmployees.size());
	}
}
