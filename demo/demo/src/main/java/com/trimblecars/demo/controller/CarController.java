
package com.trimblecars.demo.controller;

import com.trimblecars.demo.client.CarApiClient;
import com.trimblecars.demo.entity.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarApiClient carApiClient;

    @GetMapping("/available")
    public String getAvailableCars(Model model) {
        // Fetch the car models from Overdrive API
        List<CarModel> availableCars = carApiClient.getAvailableCarModels("getAllMakes");  // Use the correct command for Overdrive

        // Add the car models to the model to be rendered by Thymeleaf
        model.addAttribute("carModels", availableCars);

        // Return the Thymeleaf template name (e.g., "carModels")
        return "carModels";  // This refers to src/main/resources/templates/carModels.html
    }

}
