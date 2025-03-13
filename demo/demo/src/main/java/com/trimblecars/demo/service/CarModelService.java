//package com.trimblecars.demo.service;
//
//import com.trimblecars.demo.entity.CarModel;
//import com.trimblecars.demo.repository.CarModelRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//public class CarModelService {
//
//    @Autowired
//    private CarModelRepository repository;
//
//    public List<CarModel> getAllModels() {
//        return repository.findAll();
//    }
//
//    public CarModel saveCarModel(CarModel carModel) {
//        return repository.save(carModel);
//    }
//}

package com.trimblecars.demo.service;

import com.trimblecars.demo.entity.CarModel;
import com.trimblecars.demo.repository.CarModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarModelService {

    @Autowired
    private CarModelRepository carModelRepository;

    // CREATE - Add a new car model
    public CarModel addCarModel(CarModel carModel) {
        return carModelRepository.save(carModel);
    }

    // READ - Get all car models
    public List<CarModel> getAllCarModels() {
        return carModelRepository.findAll();
    }

    // READ - Get car model by id
    public Optional<CarModel> getCarModelById(Long id) {
        return carModelRepository.findById(id);
    }

    // UPDATE - Update an existing car model
    public CarModel updateCarModel(Long id, CarModel carModel) {
        carModel.setId(id);  // Make sure the ID is set correctly
        return carModelRepository.save(carModel);
    }

    // DELETE - Delete car model by id
    public void deleteCarModel(Long id) {
        carModelRepository.deleteById(id);
    }
}

