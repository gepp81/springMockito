package ar.com.gep.test.dao;

import java.util.List;

public interface GenericDAO<T> {

    List<T> getAll();

    List<T> getAllByProperty(String property, Object value);

    List<T> getAllByProperty(List<String> property, List<Object> value);

}
