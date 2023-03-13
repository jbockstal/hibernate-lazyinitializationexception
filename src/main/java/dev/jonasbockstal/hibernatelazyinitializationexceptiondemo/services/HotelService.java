package dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.services;

import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain.Hotel;
import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel findHotelById(Long id) {
        return hotelRepository.findById(id).orElseThrow();
    }
}
