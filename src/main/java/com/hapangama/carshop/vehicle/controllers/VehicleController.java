package com.hapangama.carshop.vehicle.controllers;

import com.hapangama.carshop.vehicle.model.Vehicle;
import com.hapangama.carshop.vehicle.service.VehicleService;
import org.springframework.http.ResponseEntity;
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

        //handle exceptions
        if (vehicleService.getVehicles().isEmpty()) {
            ResponseEntity.notFound().build();
        }

        return vehicleService.getVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Integer id) {

        if (id == null) {
            ResponseEntity.badRequest().build();
        }

        //if request id is not found
        if (vehicleService.getVehicle(id) == null) {
            ResponseEntity.notFound().build();
        }


        return vehicleService.getVehicle(id);
    }

    @PostMapping
    public void createVehicle(@RequestBody Vehicle vehicle) {

        if (vehicle == null) {
            ResponseEntity.badRequest().build();
        }


        vehicleService.addVehicle(vehicle);
    }

    @PutMapping("/{id}")
    public void updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle) {

        if (id == null || vehicle == null) {
            ResponseEntity.badRequest().build();
        }

        //if update id is not found
        if (vehicleService.getVehicle(id) == null) {
            ResponseEntity.notFound().build();
        }

        vehicle.setId(id);
        vehicleService.updateVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Integer id) {

        if (id == null) {
            ResponseEntity.badRequest().build();
        }

        //if delete id is not found
        if (vehicleService.getVehicle(id) == null) {
            ResponseEntity.notFound().build();
        }

        vehicleService.deleteVehicle(id);
    }




}
