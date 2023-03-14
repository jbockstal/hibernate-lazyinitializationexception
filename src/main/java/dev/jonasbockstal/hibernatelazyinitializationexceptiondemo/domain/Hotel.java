package dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.OneToMany;

import java.util.Set;

@Entity
@NamedEntityGraph(name = "graph.hotel.rooms", attributeNodes = @NamedAttributeNode("rooms"))
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Set<Room> rooms;

    public Hotel() {
    }

    public Hotel(String name, Set<Room> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public String getName() {
        return name;
    }

    public Set<Room> getRooms() {
        return rooms;
    }
}
