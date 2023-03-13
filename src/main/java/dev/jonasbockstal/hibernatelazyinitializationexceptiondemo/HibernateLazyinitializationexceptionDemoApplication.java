package dev.jonasbockstal.hibernatelazyinitializationexceptiondemo;

import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain.Hotel;
import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.domain.Room;
import dev.jonasbockstal.hibernatelazyinitializationexceptiondemo.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class HibernateLazyinitializationexceptionDemoApplication implements CommandLineRunner {

	@Autowired
	private HotelRepository hotelRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateLazyinitializationexceptionDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Room firstRoom = new Room("1.001");
		Room secondRoom = new Room("1.002");
		Set<Room> rooms = new HashSet<>(Arrays.asList(firstRoom, secondRoom));

		Hotel hotel = new Hotel("Fancy Hotel", rooms);
		hotelRepository.save(hotel);
	}
}
