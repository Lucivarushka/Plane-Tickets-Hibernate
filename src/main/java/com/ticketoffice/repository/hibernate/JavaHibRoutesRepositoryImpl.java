package com.ticketoffice.repository.hibernate;

import com.ticketoffice.model.Routes;
import com.ticketoffice.repository.RoutesRepository;
import com.ticketoffice.util.SessionUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class JavaHibRoutesRepositoryImpl implements RoutesRepository {
    private SessionUtil sessionUtil = new SessionUtil();


    @Override
    public void create(Routes routes) throws Exception {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.save(routes);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void update(Routes routes) throws Exception {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.update(routes);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public void delete(Routes routes) throws SQLException, ClassNotFoundException, InterruptedException, IOException {
        sessionUtil.openTransactionSession();
        Session session = sessionUtil.getSession();
        session.remove(routes);
        sessionUtil.closeTransactionSession();
    }

    @Override
    public List<Routes> getAll() throws IOException, SQLException, ClassNotFoundException, InterruptedException {
        sessionUtil.openTransactionSession();
        String sql = "SELECT * FROM ROUTES";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Routes.class);
        List<Routes> routesList = query.list();
        sessionUtil.closeTransactionSession();
        return routesList;
    }

    @Override
    public Routes getId(Integer id) throws Exception {
        sessionUtil.openTransactionSession();
        String sql = "SELECT * FROM ROUTES WHERE ID = :id";
        Session session = sessionUtil.getSession();
        Query query = session.createNativeQuery(sql).addEntity(Routes.class);
        query.setParameter("id", id);
        Routes routes = (Routes) query.getSingleResult();
        sessionUtil.closeTransactionSession();
        return routes;
    }

}
