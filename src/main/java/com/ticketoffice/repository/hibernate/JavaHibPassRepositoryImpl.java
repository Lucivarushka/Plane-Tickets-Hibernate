package com.ticketoffice.repository.hibernate;

import com.ticketoffice.model.Passenger;
import com.ticketoffice.repository.PassengerRepository;
import com.ticketoffice.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class JavaHibPassRepositoryImpl implements PassengerRepository {
    private final SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void create(Passenger passenger) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(passenger);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void update(Passenger passenger) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.update(passenger);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void delete(Passenger passenger) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.remove(passenger);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Passenger> getAll() {
        sessionUtil.openTransactionSession();
        String hql = "SELECT * FROM Passenger";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(hql).addEntity(Passenger.class);
        List<Passenger> passengersList = query.list();
        sessionUtil.closeTransactionSession();
        return passengersList;
    }

    @Override
    public Passenger getId(Integer id) {
        sessionUtil.openTransactionSession();
        String hql = "SELECT * FROM Passenger WHERE id = :id";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(hql).addEntity(Passenger.class);
        query.setParameter("id", id);
        Passenger passenger = (Passenger) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return passenger;
    }
}
