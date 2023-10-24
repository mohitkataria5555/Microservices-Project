package com.hotel.userservice.service;

import com.hotel.userservice.exception.ResourceNotFoundException;
import com.hotel.userservice.model.Rating;
import com.hotel.userservice.model.User;
import com.hotel.userservice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class UserServiceImpl implements  UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUUID = UUID.randomUUID().toString();
        user.setUserId(randomUUID);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User not found with this id!!"));
        ArrayList<Rating> ratingsforUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(),ArrayList.class);
        logger.info("{} ",ratingsforUser);
        user.setRatings(ratingsforUser);
        return user;

    }
}
