package com.cmp.userservice.user.external.services;

import com.cmp.userservice.user.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/hotel/{id}")
    Hotel getHotel(@PathVariable String id);
}
