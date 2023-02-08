package com.cmp.rating.ratingservice.services;

import com.cmp.rating.ratingservice.entities.Rating;
import com.cmp.rating.ratingservice.respositries.RatingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class RatingServiceImpl implements RatingService{
    @Autowired
    RatingRepo ratingRepo;
    @Override
    public List<Rating> getALl() {
        return ratingRepo.findAll();
    }

    @Override
    public Rating create(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public Optional<Rating> get(String id) {
        return ratingRepo.findById(id);
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return ratingRepo.findByHotelID(id);
    }

    @Override
    public List<Rating> getRatingByUserId(String id) {
        return ratingRepo.findByUserID(id);
    }
}
