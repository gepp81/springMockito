package ar.com.gep.test.entity.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ar.com.gep.test.dao.impl.GenericDAOImpl;
import ar.com.gep.test.entity.Car;

@Configuration
@ComponentScan(basePackages = { "ar.com.gep.test.service.impl", "ar.com.gep.test.dao.impl" })
public class CarSpringTestConf {
	
	@Bean(name = "carDAO")
	public GenericDAOImpl<Car> getCarDAO() {
		return new GenericDAOImpl<Car>(Car.class);
	}

}