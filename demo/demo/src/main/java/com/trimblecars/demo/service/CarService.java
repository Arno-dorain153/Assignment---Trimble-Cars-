package com.trimblecars.demo.service;

import com.trimblecars.demo.entity.Car;
import com.trimblecars.demo.entity.CarStatus;
import com.trimblecars.demo.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllAvailableCars() {
        return carRepository.findByStatus(CarStatus.IDLE);
    }

    public void registerCar(Car car) {
        carRepository.save(car);
    }
}

