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
    private SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void create(Passenger passenger) throws Exception {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(passenger);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void update(Passenger passenger) throws Exception {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.update(passenger);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void delete(Passenger passenger) throws SQLException, ClassNotFoundException, InterruptedException, IOException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.remove(passenger);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Passenger> getAll() throws IOException, SQLException, ClassNotFoundException, InterruptedException {
        sessionUtil.openTransactionSession();
        String sql = "SELECT * FROM PASSENGER";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Passenger.class);
        List<Passenger> passengersList = query.list();
        sessionUtil.closeTransactionSession();
        return passengersList;
    }

    @Override
    public Passenger getId(Integer id) throws Exception {
        sessionUtil.openTransactionSession();
        String sql = "SELECT * FROM PASSENGER WHERE ID = :id";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Passenger.class);
        query.setParameter("id", id);
        Passenger passenger = (Passenger) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return passenger;
    }
}
