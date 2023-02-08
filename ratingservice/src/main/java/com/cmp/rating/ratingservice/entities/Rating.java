package com.cmp.rating.ratingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document("ratingService")
public class Rating {
    @Id
    private String id;
    private String hotelID;
    private String userID;
    private Integer rating ;
    private String feedback;
}
