package br.com.ifba.turma.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.io.Serializable;

/**
 *
 * @author anriu
 */
@Entity
public class Turma extends PersistenceEntity implements Serializable {

    // Nome da turma
    @Column(name = "nome", nullable = false)
    private String nome;

    // Retorna o nome da turma
    public String getNome() {
        return nome;
    }

    // Define o nome da turma
    public void setNome(String nome) {
        this.nome = nome;
    }

}