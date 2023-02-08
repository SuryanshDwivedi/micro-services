package com.cmp.userservice.user.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "ID")
    private String id;
    private String name;
    private String email;

    private String description;
    private Integer contact;
    @Transient
    private List<Rating> rating = new ArrayList<>();
}
