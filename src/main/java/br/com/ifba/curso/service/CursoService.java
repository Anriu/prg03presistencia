package br.com.ifba.curso.service;

import br.com.ifba.curso.dao.CursoDao;
import br.com.ifba.curso.dao.CursoIDao;
import br.com.ifba.curso.entity.Curso;
import java.util.List;

/**
 *
 * @author anriu
 */
public class CursoService implements CursoIService {

    // Instancia o DAO responsável pelo acesso ao banco
    private final CursoIDao cursoDao = new CursoDao();

    @Override
    public Curso save(Curso curso) {
        // Salva um novo curso
        return cursoDao.save(curso);
    }

    @Override
    public Curso update(Curso curso) {
        // Atualiza os dados do curso
        return cursoDao.update(curso);
    }

    @Override
    public void delete(Curso curso) {
        // Remove um curso
        cursoDao.delete(curso);
    }

    @Override
    public List<Curso> findAll() {
        // Retorna todos os cursos cadastrados
        return cursoDao.findAll();
    }

    @Override
    public Curso findById(Long id) {
        // Busca um curso pelo ID
        return cursoDao.findById(id);
    }
}