package ar.com.gep.test.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.PersistenceException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.gep.test.configuration.HibernateConfiguration;
import ar.com.gep.test.entity.conf.CarSpringTestConf;
import ar.com.gep.test.service.CarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CarSpringTestConf.class, HibernateConfiguration.class })
public class CarSpringTest {

    @Autowired
    private CarService carService;

    @Test
    public void getAllCarsTest() {
        List<Car> allCars = carService.getAll();
        Assert.assertTrue(allCars.size() > 4);
    }

    @Test
    public void getYearCarsTest() {
        List<Car> allCars = carService.getAllByYear(new Integer(2016));
        Assert.assertTrue(allCars.size() > 0);
    }

    @Test
    public void getCompanyCarsTest() {
        List<Car> allCars = carService.getAllByCompany("FORD");
        Assert.assertNotNull(allCars);
        Assert.assertTrue(allCars.size() > 1);
    }

    @Test
    public void getByPropertiesTest() {
        List<Object> values = new ArrayList<>();
        values.add(Integer.valueOf(2013));
        values.add(new String("FORD"));
        List<Car> allCars = carService.getAll(Arrays.asList("year", "company"), values);
        Assert.assertTrue(allCars.size() > 0);
        Assert.assertEquals(Integer.valueOf(1), allCars.get(0).getId());
        Assert.assertEquals(Integer.valueOf(2013), allCars.get(0).getYear());
        Assert.assertEquals("FORD", allCars.get(0).getCompany());
    }

    @Test(expected = PersistenceException.class)
    public void getByPropertiesNullPropsTest() {
        carService.getAll(null, null);
    }

    @Test(expected = PersistenceException.class)
    public void getByPropertiesEmptyPropsTest() {
        carService.getAll(new ArrayList<>(), null);
    }

    @Test(expected = PersistenceException.class)
    public void getByPropertiesValuesNullTest() {
        carService.getAll(Arrays.asList("year", "company"), null);
    }

    @Test(expected = PersistenceException.class)
    public void getByPropertiesDiffSizePropsTest() {
        carService.getAll(Arrays.asList("year", "company"), new ArrayList<>());
    }
}
