package ar.com.gep.test.dao;

import java.util.List;

import ar.com.gep.test.dao.impl.GenericDAOImpl.Company;
import ar.com.gep.test.entity.Car;

public interface GenericDAO<T> {

	List<T> getAll();

	List<Car> getAllByYear(Integer year);

	List<Car> getAllByCompany(Company company);

}
