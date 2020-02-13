package com.ticketoffice.view;

import com.ticketoffice.controller.PassController;
import com.ticketoffice.model.Passenger;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class PassengerView {
    public static final String ACTIONS_PASS = "Введите действие:\n" +
            "1.Зарегистрировать нового пассажира\n" +
            "2.Изменить пассажира\n" +
            "3.Удалить пассажира\n" +
            "4.Получить информацию о пассажире по айди\n" +
            "5.Список всех пассажиров\n";

    PassController passController = new PassController();

    public void createPass() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пассажира:");
        String name = scanner.next();
        System.out.println("Введите фамилию пассажира:");
        String surname = scanner.next();
        System.out.println("Введите дату рождения(в формате:01/12/1987):");
        String birthdate = scanner.next();
        Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
        Passenger passenger = new Passenger(name, surname, date);
        passController.createPass(passenger);
    }

    public void updatePass() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите айди пассажира для его изменения:");
        int index = Integer.parseInt(scanner.next());
        System.out.println("Введите имя пассажира:");
        String name = scanner.next();
        System.out.println("Введите фамилию пассажира:");
        String surname = scanner.next();
        System.out.println("Введите дату рождения(в формате:01/12/1987):");
        String birthdate = scanner.next();
        Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(birthdate);
        Passenger passenger = new Passenger(index, name, surname, date);
        passController.updatePass(passenger);
    }

    public void deletePass() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите айди пассажира для его удаления:");
        int index = Integer.parseInt(scanner.next());
        Passenger passenger = passController.getIdPass(index);
        passController.deletePass(passenger);
    }

    public void getIdPass() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите айди пассажира:");
        int index = Integer.parseInt(scanner.next());
        System.out.println(passController.getIdPass(index));
    }

    public void printPass() throws Exception {
        System.out.println("Список всех пассажиров:");
        for (Passenger item : passController.getAllPass()) {
            System.out.println(item);
        }
    }
}
