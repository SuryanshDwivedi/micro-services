package com.cmp.rating.ratingservice.respositries;

import com.cmp.rating.ratingservice.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepo extends MongoRepository<Rating,String> {

    List<Rating> findByUserID(String id);
    List<Rating> findByHotelID(String id);
}
