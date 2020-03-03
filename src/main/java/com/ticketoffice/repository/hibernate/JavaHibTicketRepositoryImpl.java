package com.ticketoffice.repository.hibernate;

import com.ticketoffice.model.Ticket;
import com.ticketoffice.repository.TicketRepository;
import com.ticketoffice.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class JavaHibTicketRepositoryImpl implements TicketRepository {
    private final SessionUtil sessionUtil = new SessionUtil();

    //   private static final String SELECT_BY_ID_PASS = SELECT_ALL + " where id_passenger = ?";

    @Override
    public void create(Ticket ticket) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(ticket);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void update(Ticket ticket) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.update(ticket);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void delete(Ticket ticket) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.remove(ticket);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Ticket> getAll() {
        sessionUtil.openTransactionSession();
        String hql = "SELECT * FROM Ticket";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(hql).addEntity(Ticket.class);
        List<Ticket> ticketsList = query.list();
        sessionUtil.closeTransactionSession();
        return ticketsList;
    }

    @Override
    public Ticket getId(Integer id) {
        sessionUtil.openTransactionSession();
        String hql = "SELECT * FROM Ticket WHERE id = :id";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(hql).addEntity(Ticket.class);
        query.setParameter("id", id);
        Ticket ticket = (Ticket) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return ticket;
    }

    @Override
    public List<Ticket> getIdTicketPass(Integer id) {
        sessionUtil.openTransactionSession();
        String hql = "SELECT * FROM Ticket WHERE passenger = :id";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(hql).addEntity(Ticket.class);
        query.setParameter("id", id);
        List<Ticket> ticketsList = query.list();
        sessionUtil.closeTransactionSession();
        return ticketsList;
    }
}
