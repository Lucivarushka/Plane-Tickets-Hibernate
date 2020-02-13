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
    private SessionUtil sessionUtil = new SessionUtil();

    @Override
    public void create(Plane plane) throws Exception {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(plane);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void update(Plane plane) throws Exception {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.update(plane);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void delete(Plane plane) throws SQLException, ClassNotFoundException, InterruptedException, IOException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.remove(plane);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Plane> getAll() throws IOException, SQLException, ClassNotFoundException, InterruptedException {
        sessionUtil.openTransactionSession();
        String sql = "SELECT * FROM PLANE";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Plane.class);
        List<Plane> planeList = query.list();
        sessionUtil.closeTransactionSession();
        return planeList;
    }

    @Override
    public Plane getId(Integer id) throws Exception {
        sessionUtil.openTransactionSession();
        String sql = "SELECT * FROM PLANE WHERE ID = :id";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Plane.class);
        query.setParameter("id", id);
        Plane plane = (Plane) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return plane;
    }
}
