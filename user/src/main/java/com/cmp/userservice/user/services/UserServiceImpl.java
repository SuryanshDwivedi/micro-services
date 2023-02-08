package com.cmp.userservice.user.services;

import com.cmp.userservice.user.entities.Hotel;
import com.cmp.userservice.user.entities.Rating;
import com.cmp.userservice.user.entities.User;
import com.cmp.userservice.user.exceptions.ResourceNotFoundException;
import com.cmp.userservice.user.external.services.HotelService;
import com.cmp.userservice.user.repositries.UserRepo;
import com.netflix.discovery.converters.Auto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    //RestTemplate to call other microservice
    @Autowired
    RestTemplate restTemplate;

    //Another way of calling microservice using FeignClient
    @Autowired
    HotelService hotelService;

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getALlUser() {
        List<User> userList = userRepo.findAll();
        List<User> users = userList.stream().map(user -> getUserById(user.getId())).collect(Collectors.toList());
        return users;
    }

    @Override
    public User getUserById(String id) {
        User user =  userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("No User is found with id "+id));

        Rating[] rating = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getId(), Rating[].class);

        List<Rating> ratings = Arrays.stream(rating).toList();

        List<Rating> collectedRatings = ratings.stream().map(rating1 -> {
            logger.info("{}", rating1.getId());
            Hotel hotel = hotelService.getHotel(rating1.getHotelID());
            //restTemplate.getForObject("http://HOTEL-SERVICE/hotel/" + rating1.getHotelID(), Hotel.class);
            rating1.setHotel(hotel);
            return rating1;

        }).collect(Collectors.toList());

        user.setRating(collectedRatings);
        return user;

    }
}
