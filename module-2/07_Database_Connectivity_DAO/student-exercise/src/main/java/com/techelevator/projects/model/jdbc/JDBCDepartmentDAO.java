package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import com.techelevator.projects.model.Employee;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		List <Department> department = new ArrayList<>();
		String sqlFindAllDepartments = "SELECT  department_id, name FROM department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllDepartments);
		while(results.next()) {
			
			Department theDepartment= mapRowToDepartment(results);
			department.add(theDepartment);
		}
		return department;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List <Department> department = new ArrayList<>();
		String sqlFindAllDepartments = "SELECT  department_id, name FROM department WHERE name ILIKE ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllDepartments, "%" + nameSearch + "%");
		while(results.next()) {
			
			Department theDepartment= mapRowToDepartment(results);
			department.add(theDepartment);
		}
		return department;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sql = "UPDATE department SET name = ?  WHERE department_id = ?";
		jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());
	}
	
	private long getNextDepartmentId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong while getting an id for the new department");
		}
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sql = "INSERT INTO department (department_id, name) VALUES (?, ?)";
		newDepartment.setId(getNextDepartmentId());
		jdbcTemplate.update(sql, newDepartment.getId(), newDepartment.getName());
		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		String sqlFindAllDepartments = "SELECT name FROM department WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllDepartments, id);
		Department theDepartment = new Department();
		while (results.next()) {
			
		 theDepartment = mapRowToDepartment(results);
			
		}
		return theDepartment;
	}
	
	private Department mapRowToDepartment(SqlRowSet results) {
		Department theDepartment;
		theDepartment = new Department();
		theDepartment.setName(results.getString("name"));
		theDepartment.setId(results.getLong("department_id"));
		return theDepartment;
	}

}
