package ar.com.gep.test.dao.impl;

import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ar.com.gep.test.dao.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> type;

    public GenericDAOImpl(Class<T> type) {
        this.type = type;
    }

    public List<T> getAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from " + this.type.getName()).list();
    }

    /*
     * (non-Javadoc)
     * 
     * @see ar.com.gep.test.dao.GenericDAO#getAllByProperty(java.lang.String, java.lang.Object)
     */
    @Override
    public List<T> getAllByProperty(String property, Object value) {
        if (property == null)
            throw new PersistenceException("Property cant be null");
        CriteriaBuilder builder = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        Root<T> from = criteria.from(type);
        criteria.select(from);
        criteria.where(builder.equal(from.get(property), value));
        return this.sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }

    @Override
    public List<T> getAllByProperty(List<String> properties, List<Object> values) {
        if (properties == null)
            throw new PersistenceException("Properties cant be null");
        if (properties.size() == 0)
            throw new PersistenceException("Properties is empty");
        if (values == null)
            throw new PersistenceException("Values list cant be null");
        if (properties.size() != values.size())
            throw new PersistenceException("Lists sizes are differents");
        CriteriaBuilder builder = this.sessionFactory.getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<T> criteria = builder.createQuery(type);
        Root<T> from = criteria.from(type);
        criteria.select(from);
        for (int i = 0; i < properties.size(); i++) {
            criteria.where(builder.equal(from.get(properties.get(i)), values.get(i)));
        }

        return this.sessionFactory.getCurrentSession().createQuery(criteria).getResultList();
    }

}
