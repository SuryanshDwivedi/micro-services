package com.cmp.hotelservice.hotel.hotelservice.services;

import com.cmp.hotelservice.hotel.hotelservice.entities.Hotel;
import com.cmp.hotelservice.hotel.hotelservice.exceptions.ResourceNotFoundException;
import com.cmp.hotelservice.hotel.hotelservice.repositries.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    HotelRepo hotelRepo;
    @Override
    public Hotel createHotel(Hotel hotel) {
        return hotelRepo.save(hotel);
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No resource is found with id "+id));
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepo.findAll();
    }

    @Override
    public String deleteById(String id) {
        hotelRepo.deleteById(id);
        return "Entity Deleted Successfully";
    }
}
