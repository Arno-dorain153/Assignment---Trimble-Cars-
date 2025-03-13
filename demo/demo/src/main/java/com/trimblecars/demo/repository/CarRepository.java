package com.trimblecars.demo.repository;

import com.trimblecars.demo.entity.Car;
import com.trimblecars.demo.entity.CarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findByStatus(CarStatus status);
}

