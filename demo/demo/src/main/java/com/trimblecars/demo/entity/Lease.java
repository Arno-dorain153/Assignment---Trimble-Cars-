package com.trimblecars.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "leases")
@Data
@AllArgsConstructor

public class Lease {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private User customer;

    private LocalDateTime leaseStart;
    private LocalDateTime leaseEnd;

    // ✅ Default Constructor (Required by JPA)
    public Lease() {}

    // ✅ Parameterized Constructor (Optional)
    public Lease(Car car, User customer, LocalDateTime leaseStart, LocalDateTime leaseEnd) {
        this.car = car;
        this.customer = customer;
        this.leaseStart = leaseStart;
        this.leaseEnd = leaseEnd;
    }

    // ✅ Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public LocalDateTime getLeaseStart() {
        return leaseStart;
    }

    public void setLeaseStart(LocalDateTime leaseStart) {
        this.leaseStart = leaseStart;
    }

    public LocalDateTime getLeaseEnd() {
        return leaseEnd;
    }

    public void setLeaseEnd(LocalDateTime leaseEnd) {
        this.leaseEnd = leaseEnd;
    }
}
