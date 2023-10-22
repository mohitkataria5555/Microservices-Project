package com.hotel.userservice.repository;

import com.hotel.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User ,String> {

}
