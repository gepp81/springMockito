package ar.com.gep.test.entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.gep.test.configuration.HibernateConfiguration;
import ar.com.gep.test.dao.GenericDAO;
import ar.com.gep.test.entity.conf.CarSpringMockitoTestConf;
import ar.com.gep.test.service.CarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CarSpringMockitoTestConf.class, HibernateConfiguration.class })
public class CarSpringMockitoTest {

    @Autowired
    private CarService carService;

    @Autowired
    @Qualifier("carDAO")
    private GenericDAO<Car> dao;

    @Before
    public void before() {
        Mockito.when(dao.getAll()).thenReturn(new ArrayList<>());
        Mockito.when(dao.getAllByProperty(Mockito.anyString(), Mockito.anyInt())).thenReturn(generateYearList());
    }

    private List<Car> generateYearList() {
        List<Car> cars = new ArrayList<Car>(2);
        Car car = new Car(2016, "FORD");
        cars.add(car);
        car = new Car(2016, "FORD");
        cars.add(car);
        return cars;
    }

    @Test
    public void getAllCarsTest() {
        List<Car> allCars = carService.getAll();
        Assert.assertFalse(allCars.size() > 0);
    }

    @Test
    public void getYearCarsTest() {
        List<Car> allCars = carService.getAllByYear(new Integer(1500));
        Assert.assertNotNull(allCars);
        Assert.assertEquals(2, allCars.size());
    }

    @Test
    public void getCompanyCarsTest() {
        List<Car> allCars = carService.getAllByCompany("HotWheels");
        Assert.assertNotNull(allCars);
        Assert.assertEquals(2, allCars.size());
    }

}
