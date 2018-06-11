package ar.com.gep.test.helper;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 
 * @author Guillermo Pi Dote
 *
 */
public class StringHelper {

    private static String text = "Prueba";

    @Autowired
    @Qualifier("textoOriginal")
    private String textStatic;

    @PostConstruct
    public void init() {
        StringHelper.text = textStatic;
    }

    public static String getText() {
        StringBuilder builder = new StringBuilder();
        builder.append("Hola").append(" ").append("Mundo!");
        return builder.toString();
    }

    public static Object getParamText(String name) {
        StringBuilder builder = new StringBuilder();
        builder.append("Hola").append(" ").append(name).append("!");
        return builder.toString();
    }

    public static Object getDefaultText() {
        StringBuilder builder = new StringBuilder();
        builder.append("Hola").append(" ").append(text).append("!");
        return builder.toString();
    }

}
