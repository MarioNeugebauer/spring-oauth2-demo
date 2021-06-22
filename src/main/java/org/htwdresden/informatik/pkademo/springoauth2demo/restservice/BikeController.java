package org.htwdresden.informatik.pkademo.springoauth2demo.restservice;

import org.htwdresden.informatik.pkademo.springoauth2demo.model.Bike;
import org.htwdresden.informatik.pkademo.springoauth2demo.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BikeController {

    @Autowired
    BikeRepository bikeRepository;

    @GetMapping("/bikes")
    Iterable<Bike> bikes(){
        return this.bikeRepository.findAll();
    }


    @GetMapping("/bikes/{id}")
    Bike bikeById(@PathVariable long id){
        Optional<Bike> bikeOptional = this.bikeRepository.findById(id);
        if(bikeOptional.isPresent()) {
            return bikeOptional.get();
        }
        return null;
    }

    @PostMapping("/bike")
    Bike newBike(@RequestBody Bike newBike) {
        return this.bikeRepository.save(newBike);
    }

    @DeleteMapping("/bikes/{id}")
    void deleteBike(@PathVariable Long id) {
        bikeRepository.deleteById(id);
    }

}
