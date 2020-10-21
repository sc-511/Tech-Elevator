package com.techelevator.projects.model.jdbc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		List <Project> projects = new ArrayList<>();
		String sqlFindAllProjects = "SELECT project_id, name FROM project WHERE (from_date IS NOT NULL AND from_date < NOW()) AND (NOW() < to_date OR to_date is NULL) ";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllProjects);
		while(results.next()) {
			
			Project theProjects = mapRowToProjects(results);
			projects.add(theProjects);
		}
		return projects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?";
		jdbcTemplate.update(sql, projectId, employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sql = "INSERT INTO project_employee (project_id, employee_id) VALUES (?, ?)";
		jdbcTemplate.update(sql, projectId, employeeId);
	}
	
	private Project mapRowToProjects(SqlRowSet results) {
		Project theProjects;
		theProjects = new Project();
		theProjects.setName(results.getString("name"));
		theProjects.setId(results.getLong("project_id"));
		
		return theProjects;
	}

}
