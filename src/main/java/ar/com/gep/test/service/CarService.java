package ar.com.gep.test.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ar.com.gep.test.entity.Car;

public interface CarService {

    @Transactional
    List<Car> getAll();

    @Transactional
    List<Car> getAllByYear(Integer year);

    @Transactional
    List<Car> getAllByCompany(String company);

    @Transactional
    List<Car> getAll(List<String> properties, List<Object> values);

}
