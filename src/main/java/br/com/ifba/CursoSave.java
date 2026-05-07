package br.com.ifba;

import br.com.ifba.curso.entity.Curso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CursoSave {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gerenciamento_curso");
        EntityManager em = emf.createEntityManager();

        try {
            Curso curso = new Curso();
            curso.setNome("Analise e Desenvolvimento de Sistemas");
            curso.setCodigoCurso("ADS");
            curso.setAtivo(true);

            em.getTransaction().begin();
            em.persist(curso); // Salva o objeto no banco [cite: 123]
            em.getTransaction().commit();

            System.out.println("Curso salvo com sucesso!");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}