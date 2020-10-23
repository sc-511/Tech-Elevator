package com.techelevator.city;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
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

import com.techelevator.JDBCIntegrationTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCCityDAOIntegrationTest extends JDBCIntegrationTest {
	
	private JDBCCityDAO cityDAO;
	private static final String TEST_COUNTRY = "XYZ";

	@Before
	public void setup() {
		String sqlInsertCountry = "INSERT INTO country (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);

		
		
		cityDAO = new JDBCCityDAO(getDataSource());
	}
	
	@Test
	public void save_new_city_and_read_it_back() throws SQLException {
		City theCity = getCity("SQL Station", "South Dakota", "USA", 65535);
		cityDAO.save(theCity);

		Assert.assertNotEquals(null, theCity.getId());
		Assert.assertNotNull(theCity.getId());
		

		City savedCity = cityDAO.findCityById(theCity.getId());
		assertCitiesAreEqual(theCity, savedCity);
	}

	@Test
	public void returns_cities_by_country_code() {
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);
		cityDAO.save(theCity);
		
		
		List<City> results = cityDAO.findCityByCountryCode(TEST_COUNTRY);

		Assert.assertNotNull(results);
		Assert.assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}

	@Test
	public void returns_multiple_cities_by_country_code() {

		cityDAO.save(getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535));
		cityDAO.save(getCity("Postgres Point", "North Dakota", TEST_COUNTRY, 65535));

		List<City> results = cityDAO.findCityByCountryCode(TEST_COUNTRY);

		Assert.assertNotNull(results);
		Assert.assertEquals(2, results.size());
	}

	@Test
	public void returns_cities_by_district() {
		String testDistrict = "Tech Elevator";
		City theCity = getCity("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		cityDAO.save(theCity);

		List<City> results = cityDAO.findCityByDistrict(testDistrict);

		Assert.assertNotNull(results);
		Assert.assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}
	
	@Test
	public void update_cities_actually_updates_them() {
		City testCity = getCity("Las Tomsterleans", "Tech Elevator", TEST_COUNTRY, 1);
		cityDAO.save(testCity);
		testCity.setPopulation(1000);
		
		cityDAO.update(testCity); // ACT

		City retrievedCity = cityDAO.findCityById(testCity.getId());
		assertCitiesAreEqual(testCity, retrievedCity);
	}
	
	@Test
	public void delete_city_actually_deletes_it() {
		City testCity = getCity("Las Tomsterleans", "Tech Elevator", TEST_COUNTRY, 1);
		cityDAO.save(testCity);
		
		cityDAO.delete(testCity.getId()); // ACT

		City retrievedCity = cityDAO.findCityById(testCity.getId());
		Assert.assertEquals(null, retrievedCity);
		Assert.assertNull(retrievedCity);
	}
	

	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}

	private void assertCitiesAreEqual(City expected, City actual) {
		Assert.assertEquals(expected.getId(), actual.getId());
		Assert.assertEquals(expected.getName(), actual.getName());
		Assert.assertEquals(expected.getDistrict(), actual.getDistrict());
		Assert.assertEquals(expected.getCountryCode(), actual.getCountryCode());
		Assert.assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
