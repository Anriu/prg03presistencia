package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 *
 * @author anriu
 */
@SuppressWarnings("unchecked")
public class GenericDao<Entity extends PersistenceEntity>
        implements GenericIDao<Entity> {

    // Gerencia as operações com o banco de dados
    protected static EntityManager entityManager;

    static {

        // Cria a fábrica de conexão com o banco
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("prg03persistencia");

        // Cria o EntityManager
        entityManager = factory.createEntityManager();
    }

    @Override
    public Entity save(Entity entity) {

        // Inicia a transação
        entityManager.getTransaction().begin();

        // Salva a entidade
        entityManager.persist(entity);

        // Finaliza a transação
        entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public Entity update(Entity entity) {

        // Inicia a transação
        entityManager.getTransaction().begin();

        // Atualiza a entidade
        entityManager.merge(entity);

        // Finaliza a transação
        entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public void delete(Entity entity) {

        // Busca a entidade pelo ID
        entity = findById(entity.getId());

        // Inicia a transação
        entityManager.getTransaction().begin();

        // Remove a entidade
        entityManager.remove(entity);

        // Finaliza a transação
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Entity> findAll() {

        // Retorna todas as entidades do banco
        return entityManager
                .createQuery("from " + getTypeClass().getSimpleName())
                .getResultList();
    }

    @Override
    public Entity findById(Long id) {

        // Busca uma entidade pelo ID
        return (Entity) entityManager.find(getTypeClass(), id);
    }

    protected Class<?> getTypeClass() {

        // Obtém a classe da entidade genérica
        Class<?> clazz = (Class<?>)
                ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];

        return clazz;
    }
}