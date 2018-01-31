package ar.com.gep.test.entity;

import java.io.Serializable;

import ar.com.gep.test.dao.impl.GenericDAOImpl.Company;

public class Car implements Serializable {

	private static final long serialVersionUID = 4850561970178844269L;

	private Integer year;
	private Company company;

	public Car(Integer year, Company company) {
		this.year = year;
		this.company = company;
	}

	public Car() {
		this.year = null;
		this.company = null;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
