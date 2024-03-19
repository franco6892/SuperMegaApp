package com.franco.supermegaapp.controllers;

import com.franco.supermegaapp.models.Car;
import com.franco.supermegaapp.respositories.CarsRepository;
import com.franco.supermegaapp.respositories.dtos.CarDTO;
import com.franco.supermegaapp.services.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarsService carsService;

    @PostMapping("")
    public String createNewCar(@RequestBody Car car){
        return carsService.createNewCar(car);
    }

    @GetMapping("dummy")
    public String dummy() {
        return "hola";
    }

    @GetMapping("")
    public List<Car> listAllCars() {
        return carsService.listAllCars();
    }

    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable int id){
        return carsService.deleteCar(id);
    }

    @GetMapping("/{id}")
    public Car car(@PathVariable int id){
        return carsService.findCarById(id);
    }

    @PutMapping("/{id}")
    public String updateCar(@PathVariable int id, @RequestBody Car updatedCar) {
        return carsService.updateCar(id, updatedCar);
    }
}
