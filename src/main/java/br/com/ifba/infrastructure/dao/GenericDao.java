package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public abstract class GenericDao<T extends PersistenceEntity> implements IGenericDao<T> {
    protected static EntityManager entityManager;

    static {
        // Nome definido no persistence-unit do persistence.xml [cite: 385, 392]
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("gerenciamento_curso");
        entityManager = factory.createEntityManager();
    }

    private final Class<T> persistenceClass;

    public GenericDao(Class<T> persistenceClass) {
        this.persistenceClass = persistenceClass;
    }

    @Override
    public T save(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity); [cite: 123]
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public T update(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.merge(entity));
        entityManager.getTransaction().commit();
    }

    @Override
    public List<T> findAll() {
        return entityManager.createQuery("from " + persistenceClass.getName()).getResultList();
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(persistenceClass, id);
    }
}