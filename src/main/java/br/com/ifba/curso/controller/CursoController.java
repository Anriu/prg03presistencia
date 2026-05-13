package br.com.ifba.curso.controller;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.curso.service.CursoIService;
import br.com.ifba.curso.service.CursoService;
import java.util.List;

/**
 *
 * @author anriu
 */
public class CursoController implements CursoIController {

    // Instancia o service responsável pelas regras de negócio
    private final CursoIService cursoService = new CursoService();

    @Override
    public Curso save(Curso curso) {
        // Salva um novo curso
        return cursoService.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        // Atualiza os dados do curso
        return cursoService.update(curso);
    }

    @Override
    public void delete(Curso curso) {
        // Remove um curso
        cursoService.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
        // Retorna todos os cursos cadastrados
        return cursoService.findAll();
    }

    @Override
    public Curso findById(Long id) {
        // Busca um curso pelo ID
        return cursoService.findById(id);
    }
}