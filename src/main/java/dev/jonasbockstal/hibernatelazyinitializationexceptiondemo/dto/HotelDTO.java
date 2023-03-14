package dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.dto;

import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain.Room;

import java.util.Set;

public class HotelDTO {
    private final String name;
    private final Set<Room> rooms;

    public HotelDTO(String name, Set<Room> rooms) {
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
