package com.springboot.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping("/all")
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        hotelRepository.deleteById(id);
    }

    @PostMapping
    public void save(@RequestBody Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @PutMapping
    public void update(@RequestBody Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @GetMapping("/price/{max}")
    public List<Hotel> findByPrice(@PathVariable int max) {
        return hotelRepository.findByPricePerNightLessThan(max);
    }

    @GetMapping("/{id}")
    public Optional<Hotel> findById(@PathVariable String id) {
        return hotelRepository.findById(id);
    }

}
