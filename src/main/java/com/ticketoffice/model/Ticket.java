package com.ticketoffice.model;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DATE")
    private Date date;

    @Enumerated(EnumType.STRING)
    private TypeSeat typeSeat;

    @Column(name = "PRICE")
    private int price;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Plane plane;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Passenger passenger;

    @OneToOne(cascade = CascadeType.ALL)
    private Routes routes;

    public Ticket() {
    }

    public Ticket(Integer id, Date date, TypeSeat typeSeat, int price, Plane plane, Passenger passenger, Routes routes) {
        this.id = id;
        this.date = date;
        this.typeSeat = typeSeat;
        this.price = price;
        this.plane = plane;
        this.passenger = passenger;
        this.routes = routes;
    }

    public Ticket(Date date, TypeSeat type, int price, Plane plane, Passenger passenger, Routes routes) {
        this.date = date;
        this.typeSeat = typeSeat;
        this.price = price;
        this.plane = plane;
        this.passenger = passenger;
        this.routes = routes;
    }

    public Integer getIdTicket() {
        return id;
    }

    public void setIdTicket(Integer idTicket) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TypeSeat getTypeSeat() {
        return typeSeat;
    }

    public void setTypeSeat(TypeSeat typeSeat) {
        this.typeSeat = typeSeat;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Routes getRoutes() {
        return routes;
    }

    public void setRoutes(Routes routes) {
        this.routes = routes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (price != ticket.price) return false;
        if (id != null ? !id.equals(ticket.id) : ticket.id != null) return false;
        if (date != null ? !date.equals(ticket.date) : ticket.date != null) return false;
        if (typeSeat != ticket.typeSeat) return false;
        if (plane != null ? !plane.equals(ticket.plane) : ticket.plane != null) return false;
        if (passenger != null ? !passenger.equals(ticket.passenger) : ticket.passenger != null) return false;
        return routes != null ? routes.equals(ticket.routes) : ticket.routes == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (typeSeat != null ? typeSeat.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (plane != null ? plane.hashCode() : 0);
        result = 31 * result + (passenger != null ? passenger.hashCode() : 0);
        result = 31 * result + (routes != null ? routes.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", date=" + date +
                ", typeSeat=" + typeSeat +
                ", price=" + price +
                ", plane=" + plane +
                ", passenger=" + passenger +
                ", routes=" + routes +
                '}';
    }
}


