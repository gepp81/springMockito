package ar.com.gep.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.com.gep.test.dao.GenericDAO;
import ar.com.gep.test.entity.Car;
import ar.com.gep.test.service.CarService;

@Service("carService")
public class CarServiceImpl implements CarService {

    @Autowired
    @Qualifier("carDAO")
    private GenericDAO<Car> dao;

    public List<Car> getAll() {
        return dao.getAll();
    }

    public List<Car> getAllByYear(Integer year) {
        return dao.getAllByProperty("year", year);
    }

    public List<Car> getAllByCompany(String company) {
        return dao.getAllByProperty("company", company);
    }

    @Override
    public List<Car> getAll(List<String> properties, List<Object> values) {
        return dao.getAllByProperty(properties, values);
    }

}
