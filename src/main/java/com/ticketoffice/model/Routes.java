package com.ticketoffice.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROUTES")
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "DEPARTURE")
    private String departure;

    @Column(name = "ARRIVAL")
    private String arrival;

    public Routes() {
    }

    public Routes(String departure, String arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public Routes(int id, String departure, String arrival) {
        this.id = id;
        this.departure = departure;
        this.arrival = arrival;
    }

    public Integer getIdRoutes() {
        return id;
    }

    public void setIdRoutes(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Routes routes = (Routes) o;

        if (!Objects.equals(id, routes.id)) return false;
        if (!Objects.equals(departure, routes.departure)) return false;
        return Objects.equals(arrival, routes.arrival);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (departure != null ? departure.hashCode() : 0);
        result = 31 * result + (arrival != null ? arrival.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Routes{" +
                "id=" + id +
                ", departure='" + departure + '\'' +
                ", arrival='" + arrival + '\'' +
                '}';
    }
}
