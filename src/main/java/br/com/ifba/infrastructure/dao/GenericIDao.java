package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import java.util.List;

/**
 *
 * @author anriu
 */
public interface GenericIDao<Entity extends PersistenceEntity> {

    // Salva uma entidade
    Entity save(Entity entity);

    // Atualiza uma entidade
    Entity update(Entity entity);

    // Remove uma entidade
    void delete(Entity entity);

    // Retorna todas as entidades
    List<Entity> findAll();

    // Busca uma entidade pelo ID
    Entity findById(Long id);
}