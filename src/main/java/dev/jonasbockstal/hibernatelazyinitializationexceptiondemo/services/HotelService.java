package dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.services;

import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain.Hotel;
import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.repositories.HotelRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private EntityManager entityManager;

    public Hotel findHotelById(Long id) {
        return hotelRepository.findById(id).orElseThrow();
    }

    public Hotel findHotelByIdUsingEntityGraph(Long id) {
        EntityGraph<?> entityGraph = this.entityManager.getEntityGraph("graph.hotel.rooms");

        Map<String, Object> hints = new HashMap<>();
        hints.put("javax.persistence.fetchgraph", entityGraph);

        return this.entityManager.find(Hotel.class, id, hints);
    }
}
