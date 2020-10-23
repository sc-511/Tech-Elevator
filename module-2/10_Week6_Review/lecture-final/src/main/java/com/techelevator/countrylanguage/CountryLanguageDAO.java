package com.techelevator.countrylanguage;

import java.util.List;

import com.techelevator.country.Country;

public interface CountryLanguageDAO {

	// Create
	public void save(CountryLanguage newCountryLanguage);

	// Read
	public List<Country> getCountriesByLanguage(String language);
	
	
	// Update
	public void update(CountryLanguage updatedCountryLanguage);

	// Delete
	public void delete(CountryLanguage countryLanguageToBeDeleted);
}
