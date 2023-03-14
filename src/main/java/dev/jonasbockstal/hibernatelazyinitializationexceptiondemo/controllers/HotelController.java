package dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.controllers;

import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.dto.HotelDTO;
import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hotels/{id}")
    public HotelDTO getHotel(@PathVariable Long id) {
        HotelDTO hotelDTO = this.hotelService.findHotelById(id);

        // The next line will no longer trigger a LazyInitializationException
        hotelDTO.getRooms().forEach(room -> System.out.println(room.getCode()));

        return hotelDTO;
    }
}
