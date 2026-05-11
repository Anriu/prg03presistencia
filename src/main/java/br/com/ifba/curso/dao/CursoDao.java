package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import jakarta.persistence.*;

public class CursoDao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gerenciamento_curso");
    private EntityManager em = emf.createEntityManager();

    public void save(Curso curso) {
        em.getTransaction().begin();
        em.persist(curso);
        em.getTransaction().commit();
    }

    public void update(Curso curso) {
        em.getTransaction().begin();
        em.merge(curso);
        em.getTransaction().commit();
    }
}