package com.cmp.hotelservice.hotel.hotelservice.repositries;

import com.cmp.hotelservice.hotel.hotelservice.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepo extends JpaRepository<Hotel,String> {
}
