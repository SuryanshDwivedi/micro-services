package com.cmp.hotelservice.hotel.hotelservice.services;

import com.cmp.hotelservice.hotel.hotelservice.entities.Hotel;

import java.util.List;

public interface HotelService {
    Hotel createHotel(Hotel hotel);
    Hotel getHotelById(String id);

    List<Hotel> getAll();

    String deleteById(String id);
}
