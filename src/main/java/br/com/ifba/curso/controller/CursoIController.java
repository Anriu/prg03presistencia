package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 *
 * @author anriu
 */
public interface CursoIController {

    // Salva um novo curso
    Curso save(Curso curso);

    // Atualiza os dados de um curso
    Curso update(Curso curso);

    // Remove um curso
    void delete(Curso curso);

    // Retorna todos os cursos cadastrados
    List<Curso> findAll();

    // Busca um curso pelo ID
    Curso findById(Long id);
}