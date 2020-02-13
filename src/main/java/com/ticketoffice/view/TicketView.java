package com.ticketoffice.view;

import com.ticketoffice.controller.PassController;
import com.ticketoffice.controller.PlaneController;
import com.ticketoffice.controller.RouteController;
import com.ticketoffice.controller.TicketController;
import com.ticketoffice.model.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class TicketView {
    public static final String ACTIONS_ROUTE = "Введите действие:\n" +
            "1.Создать новый билет\n" +
            "2.Изменить билет\n" +
            "3.Возврат билета\n" +
            "4.Найти билет по айди\n" +
            "5.Найти билет по айди пассажира\n" +
            "6.Список всех билетов\n";

    TicketController ticketController = new TicketController();
    PassController passController = new PassController();
    PlaneController planeController = new PlaneController();
    RouteController routeController = new RouteController();

    public void createTicket() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите дату (в формате:01/12/1987):");
        String dateEnter = scanner.next();
        Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dateEnter);
        System.out.println("Введите тип места:");
        TypeSeat type = TypeSeat.valueOf(scanner.next());
        System.out.println("Введите цену:");
        int price = Integer.parseInt(scanner.next());
        System.out.println("Введите айди самолета:");
        int idPlane = Integer.parseInt(scanner.next());
        Plane plane = planeController.getIdPlane(idPlane);
        System.out.println("Введите айди пассажира:");
        int idPass = Integer.parseInt(scanner.next());
        Passenger passenger = passController.getIdPass(idPass);
        System.out.println("Введите айди маршрута:");
        int idRoutes = Integer.parseInt(scanner.next());
        Routes routes = routeController.getIdRoute(idRoutes);
        Ticket ticket = new Ticket(date, type, price, plane, passenger, routes);
        ticketController.createTicket(ticket);
    }

    public void updateTicket() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите айди билета для его изменения:");
        int index = Integer.parseInt(scanner.next());
        System.out.println("Введите дату (в формате:01/12/1987):");
        String dateEnter = scanner.next();
        Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dateEnter);
        System.out.println("Введите тип места:");
        TypeSeat type = TypeSeat.valueOf(scanner.next());
        System.out.println("Введите цену:");
        int price = Integer.parseInt(scanner.next());
        System.out.println("Введите айди самолета:");
        int idPlane = Integer.parseInt(scanner.next());
        Plane plane = planeController.getIdPlane(idPlane);
        System.out.println("Введите айди пассажира:");
        int idPass = Integer.parseInt(scanner.next());
        Passenger passenger = passController.getIdPass(idPass);
        System.out.println("Введите айди маршрута:");
        int idRoutes = Integer.parseInt(scanner.next());
        Routes routes = routeController.getIdRoute(idRoutes);
        Ticket ticket = new Ticket(index, date, type, price, plane, passenger, routes);
        ticketController.updateTicket(ticket);
    }

    public void deleteTicket() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите айди билета для его удаления:");
        int index = Integer.parseInt(scanner.next());
        Ticket ticket = ticketController.getIdTicket(index);
        ticketController.deleteTicket(ticket);
    }

    public void getIdTicket() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите айди билета для поиска:");
        int index = Integer.parseInt(scanner.next());
        System.out.println(ticketController.getIdTicket(index));
    }

    public void getIdByPass() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите айди пассажира для поиска:");
        int index = Integer.parseInt(scanner.next());
        List<Ticket> tickets = ticketController.getIdTicketPass(index);
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
    }

    public void printTicket() throws Exception {
        System.out.println("Список всех билетов:");
        for (Ticket item : ticketController.getAllTicket()) {
            System.out.println(item);
        }
    }
}
