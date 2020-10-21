package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List <Employee> employees = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT employee_id, department_id, first_name, last_name FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees);
		while(results.next()) {
			
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List <Employee> employees = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT employee_id, department_id, first_name, last_name FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees, "%"+firstNameSearch+"%", "%"+lastNameSearch+"%");
		while(results.next()) {
			
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		
		return employees;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List <Employee> employees = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT first_name, last_name FROM employee WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees, id);
		while(results.next()) {
			
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List <Employee> employees = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT employee_id, department_id, first_name, last_name FROM employee LEFT JOIN project_employee USING (employee_id) WHERE project_id IS NULL ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees);
		while(results.next()) {
			
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		return employees;
	}

	@Override //cannot figure out error.. everything else works -> project/employee
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List <Employee> employees = new ArrayList<>();
		String sqlFindAllEmployees = "SELECT employee_id, first_name,last_name FROM employee LEFT JOIN project_employee USING (employee_id) WHERE project_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees, projectId);
		while(results.next()) {
			
			Employee theEmployee = mapRowToEmployee(results);
			employees.add(theEmployee);
		}
		return employees;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sql = "UPDATE employee SET department_id = ? WHERE employee_id = ?";
		jdbcTemplate.update(sql, departmentId, employeeId);
	}
	
	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee theEmployee;
		theEmployee = new Employee();
		theEmployee.setId(results.getLong("employee_id"));
		theEmployee.setDepartmentId(results.getLong("department_id"));
		theEmployee.setFirstName(results.getString("first_name"));
		theEmployee.setLastName(results.getString("last_name"));
		return theEmployee;
	}

}
