package com.trimblecars.demo.client;

import com.trimblecars.demo.entity.CarModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "carApiClient", url = "https://www.overdriveonline.com/api")  // Updated to Overdrive API
public interface CarApiClient {

    @GetMapping("/getCarModels")  // Update to the correct endpoint for Overdrive
    List<CarModel> getAvailableCarModels(@RequestParam("cmd") String command);
}
