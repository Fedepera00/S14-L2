package it.epicode;

import it.epicode.gestioneeventi.dao.EventoDAO;
import it.epicode.gestioneeventi.entity.Evento;
import it.epicode.gestioneeventi.entity.Evento.TipoEvento;
import com.github.javafaker.Faker;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EventoDAO eventoDAO = new EventoDAO();
        Faker faker = new Faker();

        // CREAZIONE NUOVO EVENTO
        Evento evento = new Evento();
        evento.setTitolo(faker.book().title());
        evento.setDataEvento(LocalDate.now());
        evento.setDescrizione(faker.pokemon().name());
        evento.setTipoEvento(TipoEvento.PUBBLICO);
        evento.setNumeroMassimoPartecipanti(50);

        eventoDAO.save(evento);
        System.out.println("Evento salvato: " + evento);

        Evento eventoRecuperato = eventoDAO.getById(evento.getId());
        System.out.println("Evento recuperato: " + eventoRecuperato);

        eventoDAO.delete(evento.getId());
        System.out.println("Evento cancellato con successo.");
    }
}