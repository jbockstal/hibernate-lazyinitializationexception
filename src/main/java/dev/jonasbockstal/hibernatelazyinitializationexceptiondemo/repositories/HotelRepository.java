package dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.repositories;

import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface HotelRepository extends JpaRepository<Hotel, Long> {}
