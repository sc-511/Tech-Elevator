package com.techelevator.countrylanguage;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.country.Country;

public class JDBCCountryLanguageDAO implements CountryLanguageDAO {

	private JdbcTemplate jdbc;
	
	public JDBCCountryLanguageDAO(DataSource dataSource) {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public void save(CountryLanguage newCountryLanguage) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Country> getCountriesByLanguage(String language) {
		List<Country> countries = new ArrayList<>();
		
		String sql = "SELECT country.name " + 
					 "FROM country " + 
				     "INNER JOIN countrylanguage ON country.code = countrylanguage.countrycode " + 
				     "WHERE countrylanguage.language = ? "; 
		
		SqlRowSet results = jdbc.queryForRowSet(sql, language);

		while(results.next()) {
			
			// Get the data out of the SqlRowSet <-- SQL does us no good in Java
			String thisCountrysName = results.getString("name");   // <-- put the data into a Java datatype
			
			Country newCountryForOldMen = new Country();   // Create empty Java "holder" object
			newCountryForOldMen.setName(thisCountrysName); // Set the instance variable of that Java object to our data
			
			countries.add(newCountryForOldMen);
		}
		
		return countries;
	}

	@Override
	public void update(CountryLanguage updatedCountryLanguage) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(CountryLanguage countryLanguageToBeDeleted) {
		// TODO Auto-generated method stub

	}

}
