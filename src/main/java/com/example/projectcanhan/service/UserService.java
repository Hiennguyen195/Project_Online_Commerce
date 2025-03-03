package com.example.projectcanhan.service;

import com.example.projectcanhan.dto.request.UserCreationRequest;
import com.example.projectcanhan.dto.request.UserUpdateRequest;
import com.example.projectcanhan.entity.User;
import com.example.projectcanhan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();

        user.setUserName(request.getUserName());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBirthDate(request.getBirthDate());

        return userRepository.save(user);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String userID) {
        return userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User Not Found"));
    }

    public User updateUser(String userId, UserUpdateRequest request){
        User user = getUser(userId);

        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBirthDate(request.getBirthDate());
        return userRepository.save(user);
    }

    public void deleteUser(String userID){
        userRepository.deleteById(userID);
    }
}
