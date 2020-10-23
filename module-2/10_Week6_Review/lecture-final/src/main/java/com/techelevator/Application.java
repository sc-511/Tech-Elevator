package com.techelevator;

import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.country.Country;
import com.techelevator.countrylanguage.CountryLanguage;
import com.techelevator.countrylanguage.CountryLanguageDAO;
import com.techelevator.countrylanguage.JDBCCountryLanguageDAO;

public class Application {
	
	public static void main(String[] args) {
	
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		CountryLanguageDAO dao = new JDBCCountryLanguageDAO(worldDataSource);
		
		
		Scanner keyboard = new Scanner(System.in);
		System.out.println(" Search for Countries by Language! Enter Language >>> ");
		String language = keyboard.nextLine();
		
		for(Country c : dao.getCountriesByLanguage(language)) {
			System.out.println(c.getName());
		}
		
	}
}
