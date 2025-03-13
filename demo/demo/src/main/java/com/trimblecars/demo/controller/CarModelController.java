//package com.trimblecars.demo.controller;
//
//import com.trimblecars.demo.entity.CarModel;
//import com.trimblecars.demo.service.CarModelService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import java.util.List;
//
//@Controller
//@RequestMapping("/car-models")
//public class CarModelController {
//
//    @Autowired
//    private CarModelService carModelService;  //  Injecting the service correctly
//
//    //  API to render home page with car models
//    @GetMapping("/home")
//    public String viewHome(Model model) {
//        List<CarModel> carModels = carModelService.getAllModels();
//        model.addAttribute("carModels", carModels);
//        return "index";  // Thymeleaf template: src/main/resources/templates/index.html
//    }
//}


package com.trimblecars.demo.controller;

import com.trimblecars.demo.entity.CarModel;
import com.trimblecars.demo.service.CarModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car-models")
public class CarModelController {

    @Autowired
    private CarModelService carModelService;

    // CREATE - Add a new car model
    @PostMapping
    public ResponseEntity<CarModel> createCarModel(@RequestBody CarModel carModel) {
        CarModel createdCarModel = carModelService.addCarModel(carModel);
        return new ResponseEntity<>(createdCarModel, HttpStatus.CREATED);
    }

    // READ - Get all car models
    @GetMapping
    public ResponseEntity<List<CarModel>> getAllCarModels() {
        List<CarModel> carModels = carModelService.getAllCarModels();
        return new ResponseEntity<>(carModels, HttpStatus.OK);
    }

    // READ - Get a car model by ID
    @GetMapping("/{id}")
    public ResponseEntity<CarModel> getCarModelById(@PathVariable Long id) {
        Optional<CarModel> carModel = carModelService.getCarModelById(id);
        return carModel.map(model -> new ResponseEntity<>(model, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // UPDATE - Update an existing car model
    @PutMapping("/{id}")
    public ResponseEntity<CarModel> updateCarModel(@PathVariable Long id, @RequestBody CarModel carModel) {
        Optional<CarModel> existingCarModel = carModelService.getCarModelById(id);
        if (existingCarModel.isPresent()) {
            CarModel updatedCarModel = carModelService.updateCarModel(id, carModel);
            return new ResponseEntity<>(updatedCarModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE - Delete a car model by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarModel(@PathVariable Long id) {
        Optional<CarModel> carModel = carModelService.getCarModelById(id);
        if (carModel.isPresent()) {
            carModelService.deleteCarModel(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
