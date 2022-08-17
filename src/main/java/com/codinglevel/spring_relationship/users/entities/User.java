package com.codinglevel.spring_relationship.users.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data @AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String nationality;


}
