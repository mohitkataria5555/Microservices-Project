package com.poject.hotel.hotelservice.repository;

import com.poject.hotel.hotelservice.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {

}
