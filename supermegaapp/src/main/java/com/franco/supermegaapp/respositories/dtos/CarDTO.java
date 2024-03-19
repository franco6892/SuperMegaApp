package com.franco.supermegaapp.respositories.dtos;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class CarDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String name;

    public void setName(String name) {
        this.name = name;
    }

    public CarDTO() {
    }

    public CarDTO( String name) {
        this.name = name;
    }
}
