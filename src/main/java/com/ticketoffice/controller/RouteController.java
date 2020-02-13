package com.ticketoffice.controller;

import com.ticketoffice.model.Routes;
import com.ticketoffice.repository.RoutesRepository;
import com.ticketoffice.repository.hibernate.JavaHibRoutesRepositoryImpl;

import java.util.List;

public class RouteController {
    RoutesRepository routesRepository = new JavaHibRoutesRepositoryImpl();

    public void createRoute(Routes routes) throws Exception {
        routesRepository.create(routes);
    }

    public void updateRoute(Routes routes) throws Exception {
        routesRepository.update(routes);
    }

    public void deleteRoute(Routes routes) throws Exception {
        routesRepository.delete(routes);
    }

    public List<Routes> getAllRoute() throws Exception {
        return routesRepository.getAll();
    }

    public Routes getIdRoute(int id) throws Exception {
        return routesRepository.getId(id);
    }
}
