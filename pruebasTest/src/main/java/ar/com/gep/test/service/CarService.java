package ar.com.gep.test.service;

import java.util.List;

import ar.com.gep.test.dao.impl.GenericDAOImpl.Company;
import ar.com.gep.test.entity.Car;

public interface CarService {

	List<Car> getAll();

	List<Car> getAllByYear(Integer year);

	List<Car> getAllByCompany(Company company);

}
