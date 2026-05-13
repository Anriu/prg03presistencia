package br.com.ifba.infrastructure.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 *
 * @author anriu
 */
@MappedSuperclass
public class PersistenceEntity {

    // ID único da entidade
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // Retorna o ID da entidade
    public Long getId() {
        return id;
    }

    // Define o ID da entidade
    public void setId(Long id) {
        this.id = id;
    }
}