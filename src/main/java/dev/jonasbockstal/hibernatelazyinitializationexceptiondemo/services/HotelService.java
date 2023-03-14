package dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.services;

import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain.Hotel;
import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.repositories.HotelRepository;
import jakarta.transaction.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Transactional
    public Hotel findHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
        Hibernate.initialize(hotel.getRooms());

        return hotel;
    }
}
