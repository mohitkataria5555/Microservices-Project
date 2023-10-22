package com.poject.hotel.hotelservice.service;

import com.poject.hotel.hotelservice.exception.ResourceNotFoundException;
import com.poject.hotel.hotelservice.model.Hotel;
import com.poject.hotel.hotelservice.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        String randaomUUID = UUID.randomUUID().toString();
        hotel.setId(randaomUUID);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel not found with this id"));
    }
}
