package com.franco.supermegaapp.services;

import com.franco.supermegaapp.models.Car;
import com.franco.supermegaapp.respositories.CarsRepository;
import com.franco.supermegaapp.respositories.dtos.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CarsService {

    @Autowired
    private CarsRepository carsRepository;

    public String createNewCar(Car car){

        CarDTO carDTO = new CarDTO(car.name);
        carsRepository.save(carDTO);
        return ("car saved");
    }

    public String deleteCar(int id){
        carsRepository.deleteById(id);
        return "deleteeeedd";
    }


    public List<Car> listAllCars() {
        List<Car> cars = new LinkedList<>();
        List<CarDTO> carDTOs = carsRepository.findAll();
        for (CarDTO carDTO: carDTOs) {
            Car car = new Car(carDTO.id, carDTO.name);
            cars.add(car);
        }
        return cars;
//        return carsRepository.findAll()
//                .stream()
//                .map(carDTO -> new Car(carDTO.id, carDTO.name))
//                .collect(Collectors.toList());
    }


    public Car findCarById(int id) {
        Optional<CarDTO> carDTOs = carsRepository.findById(id);

        if (carDTOs.isPresent()) {
            CarDTO cars = carDTOs.get();
            return convertToCar(cars);
        } else {
            return null;
        }
    }



    public String updateCar(int id, Car updatedCar){
        Optional<CarDTO> carDTOs = carsRepository.findById(id);

        if (carDTOs.isPresent()) {
            CarDTO cars = carDTOs.get();
            cars.setName(updatedCar.name);
            carsRepository.save(cars);
            return "Car updated";
        } else {
            return "Cannot find the car with that id";
        }
    }


    private Car convertToCar(CarDTO carDTO) {
        Car car = new Car(carDTO.id, carDTO.name);
        return car;
    }
}
