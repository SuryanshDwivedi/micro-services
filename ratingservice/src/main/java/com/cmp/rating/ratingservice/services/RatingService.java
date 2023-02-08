package com.cmp.rating.ratingservice.services;

import com.cmp.rating.ratingservice.entities.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    List<Rating> getALl();

    Rating create(Rating rating);

    Optional<Rating> get(String id);

    List<Rating> getRatingByHotelId(String id);

    List<Rating> getRatingByUserId(String id);
}
