package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;

public interface GenericIDao<T extends PersistenceEntity> {
    T save(T entity);
    T update(T entity);
    void delete(T entity);
    List<T> findAll();
    T findById(Long id);
}