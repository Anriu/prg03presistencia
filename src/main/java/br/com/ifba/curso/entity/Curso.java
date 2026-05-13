package br.com.ifba.curso.entity;

import br.com.ifba.infrastructure.entity.PersistenceEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import java.io.Serializable;

/**
 *
 * @author anriu
 */
@Entity
public class Curso extends PersistenceEntity implements Serializable {

    // Nome do curso
    @Column(name = "nome", nullable = false)
    private String nome;

    // Código identificador do curso
    @Column(name = "codigo_curso", nullable = false)
    private String codigoCurso;

    // Define se o curso está ativo
    @Column(name = "ativo")
    private boolean ativo;

    // Retorna o nome do curso
    public String getNome() {
        return nome;
    }

    // Define o nome do curso
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retorna o código do curso
    public String getCodigoCurso() {
        return codigoCurso;
    }

    // Define o código do curso
    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    // Retorna se o curso está ativo
    public boolean isAtivo() {
        return ativo;
    }

    // Define se o curso está ativo
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}