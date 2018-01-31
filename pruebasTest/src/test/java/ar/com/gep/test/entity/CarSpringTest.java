package ar.com.gep.test.entity;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.gep.test.dao.impl.GenericDAOImpl.Company;
import ar.com.gep.test.entity.conf.CarSpringTestConf;
import ar.com.gep.test.service.CarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CarSpringTestConf.class })
public class CarSpringTest {

	@Autowired
	private CarService carService;

	@Test
	public void getAllCarsTest() {
		List<Car> allCars = carService.getAll();
		Assert.assertNotNull(allCars);
		Assert.assertEquals(5, allCars.size());
	}

	@Test
	public void getYearCarsTest() {
		List<Car> allCars = carService.getAllByYear(new Integer(2016));
		Assert.assertNotNull(allCars);
		Assert.assertEquals(2, allCars.size());
	}

	@Test
	public void getCompanyCarsTest() {
		List<Car> allCars = carService.getAllByCompany(Company.FORD);
		Assert.assertNotNull(allCars);
		Assert.assertEquals(1, allCars.size());
	}

	@Test
	public void getCompanyNotEqualCarsTest() {
		List<Car> allCars = carService.getAllByCompany(Company.FIAT);
		Assert.assertNotNull(allCars);
		Assert.assertNotEquals(1, allCars.size());
	}

}
