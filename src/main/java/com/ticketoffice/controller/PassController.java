package com.ticketoffice.controller;

import com.ticketoffice.model.Passenger;
import com.ticketoffice.repository.PassengerRepository;
import com.ticketoffice.repository.hibernate.JavaHibPassRepositoryImpl;

import java.util.List;

public class PassController {
    private final PassengerRepository passengerRepository = new JavaHibPassRepositoryImpl();

    public void createPass(Passenger passenger) throws Exception {
        passengerRepository.create(passenger);
    }

    public void updatePass(Passenger passenger) throws Exception {
        passengerRepository.update(passenger);
    }

    public void deletePass(Passenger passenger) throws Exception {
        passengerRepository.delete(passenger);
    }

    public List<Passenger> getAllPass() throws Exception {
        return passengerRepository.getAll();
    }

    public Passenger getIdPass(int id) throws Exception {
        return passengerRepository.getId(id);
    }
}
