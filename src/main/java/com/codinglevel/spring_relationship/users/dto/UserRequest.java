package com.codinglevel.spring_relationship.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {

    @NotBlank(message = "Name is required!")
    @Size(min = 5, message = "Name is 5 characters long")
    private String name;
    @Email(message = "Please enter a valid email")
    private String email;
    @NotBlank(message = "Mobile is required!")
    @Pattern(regexp = "^\\d{12}", message = "Mobile is 12 digit long")
    private String mobile;
    @NotBlank(message = "Gender is required!")
    private String gender;
    @Min(value = 18, message = "You are young no have access")
    @Max(value = 60, message = "You are very old no have access")
    private int age;
    @NotBlank(message = "Nationality is required!")
    private String nationality;
}
