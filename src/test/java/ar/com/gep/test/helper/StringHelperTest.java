package ar.com.gep.test.helper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.com.gep.test.entity.conf.StringHelperConf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { StringHelperConf.class })
public class StringHelperTest {

    @Autowired
    @Qualifier("textoOriginal")
    private String textStatic;

    @Test
    public void simpleTextTest() {
        Assert.assertEquals("Hola Mundo!", StringHelper.getText());
    }

    @Test
    public void simpleTextFailTest() {
        Assert.assertFalse("Chau Mundo!".equals(StringHelper.getText()));
    }

    @Test
    public void paramTextTest() {
        String name = "Juan";
        Assert.assertEquals("Hola ".concat(name).concat("!"), StringHelper.getParamText(name));
    }

    @Test
    public void paramStaticTest() {
        Assert.assertEquals("Hola ".concat(textStatic).concat("!"), StringHelper.getDefaultText());
    }

}
