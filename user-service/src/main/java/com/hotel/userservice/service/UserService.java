package com.hotel.userservice.service;


import com.hotel.userservice.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUser(String userId);

}
