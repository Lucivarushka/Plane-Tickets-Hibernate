package com.ticketoffice.controller;

import com.ticketoffice.model.Ticket;
import com.ticketoffice.repository.TicketRepository;
import com.ticketoffice.repository.hibernate.JavaHibTicketRepositoryImpl;

import java.util.List;

public class TicketController {
    private final TicketRepository ticketRepository = new JavaHibTicketRepositoryImpl();

    public void createTicket(Ticket ticket) throws Exception {
        ticketRepository.create(ticket);
    }

    public void updateTicket(Ticket ticket) throws Exception {
        ticketRepository.update(ticket);
    }

    public void deleteTicket(Ticket ticket) throws Exception {
        ticketRepository.delete(ticket);
    }

    public List<Ticket> getAllTicket() throws Exception {
        return ticketRepository.getAll();
    }

    public Ticket getIdTicket(int id) throws Exception {
        return ticketRepository.getId(id);
    }

    public List<Ticket> getIdTicketPass(int id) throws Exception {
        return ticketRepository.getIdTicketPass(id);
    }
}
