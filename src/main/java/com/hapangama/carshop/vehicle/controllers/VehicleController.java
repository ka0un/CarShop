package com.hapangama.carshop.vehicle.controllers;

import com.hapangama.carshop.vehicle.model.Vehicle;
import com.hapangama.carshop.vehicle.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Integer id) {
        return vehicleService.getVehicle(id);
    }

    @PostMapping
    public void createVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
    }

    @PutMapping("/{id}")
    public void updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle) {
        vehicle.setId(id);
        vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Integer id) {
        vehicleService.deleteVehicle(id);
    }




}
