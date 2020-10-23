package com.techelevator.countrylanguage;

public class CountryLanguage {
	private String countrycode;
	private String language;
	private Boolean isOfficial;
	private Double percentage;
	
	
	public String getCountrycode() {
		return countrycode;
	}
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Boolean getIsOfficial() {
		return isOfficial;
	}
	public void setIsOfficial(Boolean isOfficial) {
		this.isOfficial = isOfficial;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
}
