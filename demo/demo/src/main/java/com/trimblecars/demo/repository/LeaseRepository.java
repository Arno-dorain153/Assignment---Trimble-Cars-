package com.trimblecars.demo.repository;

import com.trimblecars.demo.entity.Lease;
import com.trimblecars.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {
    List<Lease> findByCustomer(User customer);
}

