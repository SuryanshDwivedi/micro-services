package com.cmp.rating.ratingservice.controller;

import com.cmp.rating.ratingservice.entities.Rating;
import com.cmp.rating.ratingservice.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @GetMapping("/all")
    public ResponseEntity<List<Rating>> getALL() {
        List<Rating> ratingList = ratingService.getALl();
        return ResponseEntity.status(HttpStatus.OK).body(ratingList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Rating>> getById(@PathVariable("id") String id) {
        Optional<Rating> rating = ratingService.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(rating);
    }

    @PostMapping("/create")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating rate = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.OK).body(rate);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable("id") String id) {
        List<Rating> ratingByUserId = ratingService.getRatingByUserId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ratingByUserId);
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable("id") String id) {
        List<Rating> ratingByHotelId = ratingService.getRatingByHotelId(id);
        return ResponseEntity.status(HttpStatus.OK).body(ratingByHotelId);
    }
}
