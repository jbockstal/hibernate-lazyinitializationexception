package dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;

    public Room(String code) {
        this.code = code;
    }

    public Room() {
    }

    public String getCode() {
        return code;
    }
}
