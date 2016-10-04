package com.fcat.data.dao.impl;

import com.fcat.data.dao.GenericDao;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
abstract public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
    private static final Logger logger = Logger.getLogger(GenericDaoImpl.class);

    protected Class<T> clazz;

    @PersistenceContext
    EntityManager entityManager;

    public GenericDaoImpl(Class<T> type) {
        this.clazz = type;
    }

    public void rollback() {
        getSession().getTransaction().rollback();
    }

    public void initialize(Object proxy) {
        Hibernate.initialize(proxy);
    }

    public void save(T newInstance) {
        getSession().saveOrUpdate(newInstance);
    }

    public void saveAll(Collection<T> instances) {
        for (T instance : instances) {
            save(instance);
        }
    }

    public void mergeAll(Collection<T> instances) {
        for (T instance : instances) {
            getSession().merge(instance);
        }
    }

    @SuppressWarnings("unchecked")
    public T getById(PK id) {
        return (T) getSession().get(clazz, id);
    }

    public void update(T object) {
        getSession().update(object);
    }

    public void delete(T persistentObject) {
        getSession().delete(persistentObject);
    }

    public long count() {
        return (Long) getSession().createQuery(String.format("select count(*) from %s", clazz.getName()))
                .uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<T> list() {
        return getSession().createQuery(String.format("from %s", clazz.getName()))
                .list();
    }

    public void flush() {
        getSession().flush();
    }

    public void deleteAll() {
        getSession().createQuery(String.format("delete from %s", clazz.getName()))
                .executeUpdate();
    }

    public List<T> findByExpressions(Criterion... criterion) {
        Criteria crit = buildCriteria(criterion);
        return findUsingCriteria(crit);
    }

    public Long countByExpressions(Criterion... criterion) {
        Criteria crit = buildCriteria(criterion);
        crit.setProjection(Projections.rowCount());
        crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (Long) crit.uniqueResult();
    }

    public T findUniqueByExpressions(Criterion... criterions) {
        Criteria crit = buildCriteria(criterions);
        List<T> list = findUsingCriteria(crit);
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public T findUniqueByExpressions(Order order, Criterion... criterions) {
        Criteria crit = buildCriteria(criterions);
        crit.addOrder(order);
        List<T> list = findUsingCriteria(crit);
        if (!list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public List<T> findByExpressions(Order order, Criterion... criterion) {
        Criteria crit = buildCriteria(criterion);
        crit.addOrder(order);
        return findUsingCriteria(crit);
    }

    public List<T> findByExpressionsWithLimit(Order order, int limit, Criterion... criterion) {
        Criteria crit = buildCriteria(criterion);
        crit.addOrder(order);
        crit.setMaxResults(limit);
        return findUsingCriteria(crit);
    }

    public List<T> findByExpressionsWithLimit(int limit, Criterion... criterion) {
        Criteria crit = buildCriteria(criterion);
        crit.setMaxResults(limit);
        return findUsingCriteria(crit);
    }

    public List<T> findByExpressions(Order[] orders, Criterion... criterion) {
        Criteria crit = buildCriteria(criterion);
        for (Order ordr : orders) {
            crit.addOrder(ordr);
        }
        return findUsingCriteria(crit);
    }

    public List<T> findByExpressions(Order[] orders, int limit, Criterion... criterion) {
        Criteria crit = buildCriteria(criterion);
        for (Order ordr : orders) {
            crit.addOrder(ordr);
        }
        crit.setMaxResults(limit);
        return findUsingCriteria(crit);
    }

    public List<T> findByExpressionsPaged(Order order, int limit, int page, Criterion... criterion) {
        Criteria crit = buildCriteria(criterion);
        crit.addOrder(order);
        crit.setMaxResults(limit);
        crit.setFirstResult((page - 1) * limit);
        return findUsingCriteria(crit);
    }

    public List<T> findByExpressionsPaged(int limit, int page, Criterion... criterion) {
        Criteria crit = buildCriteria(criterion);
        crit.setMaxResults(limit);
        crit.setFirstResult((page - 1) * limit);
        return findUsingCriteria(crit);
    }

    protected Criteria buildCriteria(Criterion... criterions) {
        Criteria criteria = getSession().createCriteria(clazz);
        if (criterions != null) {
            for (Criterion c : criterions) {
                criteria.add(c);
            }
        }
        return criteria;
    }

    @SuppressWarnings("unchecked")
    protected List<T> findUsingCriteria(Criteria criteria) {
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    @Override
    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }

}
