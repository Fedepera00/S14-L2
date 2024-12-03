package it.epicode.gestioneeventi.dao;

import it.epicode.gestioneeventi.entity.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    private EntityManager em = emf.createEntityManager();


    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento getById(Long id) {
        return em.find(Evento.class, id);
    }


    public void delete(Long id) {
        Evento evento = getById(id);
        if (evento != null) {
            em.getTransaction().begin();
            em.remove(evento);
            em.getTransaction().commit();
        }
    }
}