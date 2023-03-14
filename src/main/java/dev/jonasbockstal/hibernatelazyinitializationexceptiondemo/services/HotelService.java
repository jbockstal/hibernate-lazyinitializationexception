package dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.services;

import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain.Hotel;
import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain.Room;
import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.dto.HotelDTO;
import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.repositories.HotelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    public HotelDTO findHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
        Set<Room> rooms = new HashSet<>(hotel.getRooms());
        return new HotelDTO(hotel.getName(), rooms);
    }
}
