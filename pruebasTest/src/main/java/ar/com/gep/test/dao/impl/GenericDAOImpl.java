package ar.com.gep.test.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ar.com.gep.test.dao.GenericDAO;
import ar.com.gep.test.dao.impl.GenericDAOImpl.Company;
import ar.com.gep.test.entity.Car;

public class GenericDAOImpl<T> implements GenericDAO<T> {

	public enum Company {

		FIAT("FIAT"), FORD("FORD"), RENAULT("Renault");

		Company(String name) {
		};

		public String getName() {
			return this.name();
		}

	}

	private Class<T> type;

	public GenericDAOImpl(Class<T> type) {
		this.type = type;
	}

	public List<T> getAll() {
		if (this.type.equals(Car.class)) {
			return GenericDAOImpl.getListCars();
		}
		return new ArrayList<>();
	}

	public List<Car> getAllByYear(Integer year) {
		if (this.type.equals(Car.class)) {
			return GenericDAOImpl.getByYearListCars(year);
		}
		return new ArrayList<>();
	}

	public List<Car> getAllByCompany(Company company) {
		if (this.type.equals(Car.class)) {
			return GenericDAOImpl.getByCompanyListCars(company);
		}
		return new ArrayList<>();
	}

	private static <T> List<T> getListCars() {
		return (List<T>) generateListCars();
	}

	private static <T> List<T> getByYearListCars(Integer year) {
		List<Car> generateListCars = generateListCars();
		generateListCars = generateListCars.stream().filter(item -> item.getYear().equals(year))
				.collect(Collectors.toList());
		return (List<T>) generateListCars;
	}

	private static <T> List<T> getByCompanyListCars(Company company) {
		List<Car> generateListCars = generateListCars();
		generateListCars = generateListCars.stream().filter(item -> item.getCompany().equals(company))
				.collect(Collectors.toList());
		return (List<T>) generateListCars;
	}

	private static List<Car> generateListCars() {
		List<Car> cars = new ArrayList<Car>(5);
		Car car = new Car(2016, Company.FIAT);
		cars.add(car);

		car = new Car(2018, Company.FIAT);
		cars.add(car);

		car = new Car(2015, Company.FIAT);
		cars.add(car);

		car = new Car(2016, Company.RENAULT);
		cars.add(car);

		car = new Car(2018, Company.FORD);
		cars.add(car);
		return cars;
	}

}
