package com.cmp.userservice.user.services;

import com.cmp.userservice.user.entities.User;

import java.util.List;

public interface UserService {
     User createUser(User user);

     List<User> getALlUser();

     User getUserById(String id);


}
