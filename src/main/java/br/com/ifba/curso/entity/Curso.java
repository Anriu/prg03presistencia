package br.com.ifba.curso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name = "cursos") // Define o nome da tabela como 'cursos' [cite: 331]
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Chave primária gerada pelo banco [cite: 261]
    private Long id;

    @Column(name = "nome", nullable = false) // Campo obrigatório [cite: 335]
    private String nome;

    @Column(name = "codigo_curso", nullable = false, unique = true) // Campo único [cite: 336, 337]
    private String codigoCurso;

    @Column(name = "ativo")
    private boolean ativo;

    // Construtor padrão exigido pela JPA
    public Curso() {}

    // Getters e Setters [cite: 216-230]
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodigoCurso() { return codigoCurso; }
    public void setCodigoCurso(String codigoCurso) { this.codigoCurso = codigoCurso; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
