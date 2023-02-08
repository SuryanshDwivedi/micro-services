package com.cmp.userservice.user.repositries;

import com.cmp.userservice.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User,String> {
}
