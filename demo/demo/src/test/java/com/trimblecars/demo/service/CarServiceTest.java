package com.trimblecars.demo.service;

import com.trimblecars.demo.entity.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    public void testGetAvailableCars() {
        List<Car> cars = carService.getAllAvailableCars();
        assertNotNull(cars, "The list of available cars should not be null");
    }
}

