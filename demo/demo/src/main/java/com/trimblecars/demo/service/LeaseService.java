package com.trimblecars.demo.service;

import com.trimblecars.demo.entity.Car;
import com.trimblecars.demo.entity.Lease;
import com.trimblecars.demo.entity.User;
import com.trimblecars.demo.repository.CarRepository;
import com.trimblecars.demo.repository.LeaseRepository;
import com.trimblecars.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LeaseService {

    @Autowired
    private LeaseRepository leaseRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    // Start a new lease
    public Lease startLease(Long carId, Long userId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));

        User customer = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Lease lease = new Lease();
        lease.setCar(car);
        lease.setCustomer(customer);
        lease.setLeaseStart(LocalDateTime.now());

        // Save Lease
        return leaseRepository.save(lease);
    }

    // Get all leases
    public List<Lease> getAllLeases() {
        return leaseRepository.findAll(); // Fetch all leases from the database
    }
}
