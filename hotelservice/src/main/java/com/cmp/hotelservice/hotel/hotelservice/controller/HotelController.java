package com.cmp.hotelservice.hotel.hotelservice.controller;

import com.cmp.hotelservice.hotel.hotelservice.entities.Hotel;
import com.cmp.hotelservice.hotel.hotelservice.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping("/save")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        String msg = UUID.randomUUID().toString();
        hotel.setId(msg);
        Hotel serviceHotel = hotelService.createHotel(hotel);
        return ResponseEntity.status(HttpStatus.OK).body(serviceHotel);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable("id") String id) {
        Hotel hotelById = hotelService.getHotelById(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotelById);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotel() {
        List<Hotel> hotelList = hotelService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(hotelList);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id)
    {
        String deleteById = hotelService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(deleteById);
    }
}
