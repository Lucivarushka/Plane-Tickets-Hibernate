package com.ticketoffice.model;

import javax.persistence.*;

@Entity
@Table(name = "PLANE")
public class Plane {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    public Plane() {
    }

    public Plane(String name) {
        this.name = name;
    }

    public Plane(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getIdPlane() {
        return id;
    }

    public void setIdPlane(int idPlane) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plane plane = (Plane) o;

        if (id != null ? !id.equals(plane.id) : plane.id != null) return false;
        return name != null ? name.equals(plane.name) : plane.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
