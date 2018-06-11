package ar.com.gep.test.entity.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import ar.com.gep.test.helper.StringHelper;

@Configuration
public class StringHelperConf {

    @Bean(name = "textoOriginal")
    @Order(value = 1)
    public String getTextoOriginal() {
        return new String("Guillermo");
    }

    @Bean(name = "stringHelper")
    @Order(value = 2)
    public StringHelper getStringHelper() {
        return new StringHelper();
    }

}
