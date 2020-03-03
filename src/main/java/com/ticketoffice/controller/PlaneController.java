package com.ticketoffice.controller;

import com.ticketoffice.model.Plane;
import com.ticketoffice.repository.PlaneRepository;
import com.ticketoffice.repository.hibernate.JavaHibPlaneRepositoryImpl;

import java.util.List;

public class PlaneController {
    private final PlaneRepository planeRepository = new JavaHibPlaneRepositoryImpl();

    public void createPlane(Plane plane) throws Exception {
        planeRepository.create(plane);
    }

    public void updatePlane(Plane plane) throws Exception {
        planeRepository.update(plane);
    }

    public void deletePlane(Plane plane) throws Exception {
        planeRepository.delete(plane);
    }

    public List<Plane> getAllPlane() throws Exception {
        return planeRepository.getAll();
    }

    public Plane getIdPlane(int id) throws Exception {
        return planeRepository.getId(id);
    }
}
