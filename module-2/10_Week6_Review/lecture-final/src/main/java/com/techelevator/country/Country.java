package com.techelevator.country;

public class Country {
    private String code ;
    private String name ;
    private String continent ;
    private String region ;
    private Double surfaceArea ;
    private Integer independenceYear ;
    private Integer population ;
    private Double lifeExpectancy; //<-- nullable property, it can have a value that is a double or NULL if there is no value
    private Double gnp ; //<-- nullable property, it can have a value that is a decimal or NULL if there is no value
    private String localName ;
    private String governmentForm ;
    private String headOfState ;
    private Integer capitalId ; //<-- nullable property, it can have a value that is a int or NULL if there is no value
    private String code2 ;
    
    
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Double getSurfaceArea() {
		return surfaceArea;
	}
	public void setSurfaceArea(Double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}
	public Integer getIndependenceYear() {
		return independenceYear;
	}
	public void setIndependenceYear(Integer independenceYear) {
		this.independenceYear = independenceYear;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Double getLifeExpectancy() {
		return lifeExpectancy;
	}
	public void setLifeExpectancy(Double lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}
	public Double getGnp() {
		return gnp;
	}
	public void setGnp(Double gnp) {
		this.gnp = gnp;
	}
	public String getLocalName() {
		return localName;
	}
	public void setLocalName(String localName) {
		this.localName = localName;
	}
	public String getGovernmentForm() {
		return governmentForm;
	}
	public void setGovernmentForm(String governmentForm) {
		this.governmentForm = governmentForm;
	}
	public String getHeadOfState() {
		return headOfState;
	}
	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}
	public Integer getCapitalId() {
		return capitalId;
	}
	public void setCapitalId(Integer capitalId) {
		this.capitalId = capitalId;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}

}
