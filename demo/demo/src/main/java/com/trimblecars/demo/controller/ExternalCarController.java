package com.trimblecars.demo.controller;

import com.trimblecars.demo.entity.CarModel;
import com.trimblecars.demo.service.ExternalCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/external-cars")
public class ExternalCarController {

    @Autowired
    private ExternalCarService externalCarService;

    @GetMapping("/fetch")
    public ResponseEntity<List<CarModel>> fetchCarModels() {
        List<CarModel> models = externalCarService.fetchCarModels();
        return ResponseEntity.ok(models);
    }

    @GetMapping("/view")
    public String viewCarModels(Model model) {
        List<CarModel> carModels = externalCarService.fetchCarModels();
        model.addAttribute("carModels", carModels);
        return "externalCars";
    }

}
