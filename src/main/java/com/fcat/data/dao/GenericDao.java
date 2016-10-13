package com.fcat.data.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import java.util.Collection;
import java.util.List;

public interface GenericDao<T, PK> {
    public void initialize(Object proxy);

    public void rollback();

    public void save(T newInstance);

    public void saveAll(Collection<T> instances);

    public void merge(T object);

    public void mergeAll(Collection<T> instances);

    public T getById(PK id);

    public void update(T object);

    public void delete(T persistentObject);

    public long count();

    public List<T> list();

    public void flush();

    public void deleteAll();

    public List<T> findByExpressions(Criterion... criterion);

    public T findUniqueByExpressions(Criterion... criterions);

    public T findUniqueByExpressions(Order order, Criterion... criterions);

    public List<T> findByExpressions(Order order, Criterion... criterion);

    public Long countByExpressions(Criterion... criterion);

    public List<T> findByExpressionsWithLimit(Order order, int limit, Criterion... criterion);

    public List<T> findByExpressionsPaged(Order order, int limit, int page, Criterion... criterion);

    public List<T> findByExpressionsPaged(int limit, int page, Criterion... criterion);

    public List<T> findByExpressionsWithLimit(int limit, Criterion... criterion);

    public List<T> findByExpressions(Order[] orders, Criterion[] criterion);

    public List<T> findByExpressions(Order[] orders, int limit, Criterion[] criterion);

    public Session getSession();
}
