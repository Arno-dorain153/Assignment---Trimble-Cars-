
package com.trimblecars.demo.service;

import com.trimblecars.demo.client.CarApiClient;
import com.trimblecars.demo.entity.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExternalCarService {

    @Autowired
    private CarApiClient carApiClient;

//    public List<CarModel> fetchCarModels() {
//        // Fetch car models from the API client
//        List<CarModel> carModels = carApiClient.getAvailableCarModels("getMakes");

    public List<CarModel> fetchCarModels() {
        // Call Overdrive's API to fetch the car models
        return carApiClient.getAvailableCarModels("getAllMakes");  // Update based on Overdrive's API command parameters
    }

        // Add error handling here if needed
//        if (carModels == null || carModels.isEmpty()) {
//            // Handle error or return a default list
//            return List.of();  // Return an empty list in case of no data
//        }
//
//        return carModels;
//    }
}

