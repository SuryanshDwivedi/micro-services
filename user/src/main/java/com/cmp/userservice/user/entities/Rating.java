package com.cmp.userservice.user.entities;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {
    @Id
    private String id;
    private String hotelID;
    private String userID;
    private Integer rating ;
    private String feedback;
    private Hotel hotel;
}
