package com.poject.hotel.hotelservice.service;

import com.poject.hotel.hotelservice.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelService {
    Hotel create(Hotel hotel);
    List<Hotel> getAll();
    Hotel getHotel(String id);

}
