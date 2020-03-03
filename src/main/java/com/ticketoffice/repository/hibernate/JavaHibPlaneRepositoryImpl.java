package com.ticketoffice.repository.hibernate;

import com.ticketoffice.model.Plane;
import com.ticketoffice.repository.PlaneRepository;
import com.ticketoffice.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class JavaHibPlaneRepositoryImpl implements PlaneRepository {
    private final SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void create(Plane plane) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(plane);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void update(Plane plane) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.update(plane);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void delete(Plane plane) {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.remove(plane);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Plane> getAll() {
        sessionUtil.openTransactionSession();
        String hql = "SELECT * FROM Plane";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(hql).addEntity(Plane.class);
        List<Plane> planeList = query.list();
        sessionUtil.closeTransactionSession();
        return planeList;
    }

    @Override
    public Plane getId(Integer id) {
        sessionUtil.openTransactionSession();
        String hql = "SELECT * FROM Plane WHERE id = :id";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(hql).addEntity(Plane.class);
        query.setParameter("id", id);
        Plane plane = (Plane) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return plane;
    }
}
