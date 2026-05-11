package br.com.ifba.curso.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import java.io.Serializable;

@Entity
@Table(name = "cursos") 
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;

    @Column(name = "nome", nullable = false) 
    private String nome;

    @Column(name = "codigo_curso", nullable = false, unique = true) 
    private String codigoCurso;

    @Column(name = "ativo")
    private boolean ativo;

  
    public Curso() {}

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCodigoCurso() { return codigoCurso; }
    public void setCodigoCurso(String codigoCurso) { this.codigoCurso = codigoCurso; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
