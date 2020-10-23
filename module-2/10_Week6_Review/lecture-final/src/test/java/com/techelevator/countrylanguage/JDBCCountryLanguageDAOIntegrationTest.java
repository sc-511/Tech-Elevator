package com.techelevator.countrylanguage;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.JDBCIntegrationTest;
import com.techelevator.country.Country;


public class JDBCCountryLanguageDAOIntegrationTest extends JDBCIntegrationTest {

	private JDBCCountryLanguageDAO objectToTest;
	private JdbcTemplate jdbc;
	
	private static final String TEST_COUNTRY = "XYZ";
	private static final String TEST_COUNTRY_NAME = "West Xylophone";
	private static final String TEST_LANGUAGE = "Tomish";


	@Before
	public void setup() {
		objectToTest = new JDBCCountryLanguageDAO(getDataSource());
		jdbc = new JdbcTemplate(getDataSource());
	}
	
	@Test
	public void get_one_country_by_language() {
		// ARRANGE:
		//   Insert dummy country
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES (?, ?, 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		jdbc.update(sqlInsertCountry, TEST_COUNTRY, TEST_COUNTRY_NAME);
		
		//   Insert dummy association
		String sqlInsertCL = "INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES (?, ?, false, 50)";
		jdbc.update(sqlInsertCL, TEST_COUNTRY, TEST_LANGUAGE);
		
				
		List<Country> output = objectToTest.getCountriesByLanguage(TEST_LANGUAGE); // ACT
	
		// ASSERT
		Assert.assertEquals(1, output.size());
		Assert.assertEquals(TEST_COUNTRY_NAME, output.get(0).getName());
	}
	
	@Test
	public void get_multiple_countries_by_language() {
		// ARRANGE:
		//   Insert 3 dummy countries
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES (?, ?, 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		jdbc.update(sqlInsertCountry, TEST_COUNTRY, TEST_COUNTRY_NAME + "1");		
		jdbc.update(sqlInsertCountry, TEST_COUNTRY.replace("X", "Y"), TEST_COUNTRY_NAME + "2");
		jdbc.update(sqlInsertCountry, TEST_COUNTRY.replace("Y", "Z"), TEST_COUNTRY_NAME + "3");

		//   Insert dummy associations
		String sqlInsertCL = "INSERT INTO countrylanguage (countrycode, language, isofficial, percentage) VALUES (?, ?, false, 50)";
		jdbc.update(sqlInsertCL, TEST_COUNTRY, TEST_LANGUAGE);
		jdbc.update(sqlInsertCL, TEST_COUNTRY.replace("X", "Y"), TEST_LANGUAGE);
		jdbc.update(sqlInsertCL, TEST_COUNTRY.replace("Y", "Z"), TEST_LANGUAGE);
		

		List<Country> output = objectToTest.getCountriesByLanguage(TEST_LANGUAGE); // ACT
	
		// ASSERT
		Assert.assertEquals(3, output.size());
		for(Country c : output) {			
			Assert.assertTrue(c.getName().startsWith(TEST_COUNTRY_NAME));
		}
	}
}
