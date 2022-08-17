package com.codinglevel.spring_relationship.users.service;

import com.codinglevel.spring_relationship.users.dto.UserRequest;
import com.codinglevel.spring_relationship.users.entities.User;
import com.codinglevel.spring_relationship.users.exceptions.UserNotFoundException;
import com.codinglevel.spring_relationship.users.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User saveUser(UserRequest userRequest) throws UserNotFoundException {
        Optional<User> userByEmail = userRepository.findByEmail(userRequest.getEmail());
        if(userByEmail.isPresent()) {
            throw new UserNotFoundException("User with this email: "
                    + userRequest.getEmail() + " already exist");
        } else  {
            User user = User.build(0L, userRequest.getName(), userRequest.getEmail(),
                    userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(),
                        userRequest.getNationality());
            return userRepository.save(user);
        }
    }
    
    public List<User> fetchUsers() {
        return userRepository.findAll();
    }

    public User fetchUser(Long userId) throws UserNotFoundException {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            return user;
        }
        else {
            throw new UserNotFoundException("User with id: " + userId + " not found");
        }
    }

    public void deleteUser(Long userId) throws UserNotFoundException {
        boolean isUserExist = userRepository.existsById(userId);
        if(!isUserExist) {
            throw new UserNotFoundException("User with id: " + userId + " not found");
        } else{
            userRepository.deleteById(userId);
        }
    }
}
