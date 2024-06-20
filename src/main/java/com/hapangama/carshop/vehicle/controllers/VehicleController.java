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
    public ResponseEntity<List<Vehicle>>  getAllVehicles() {

        //handle exceptions
        if (vehicleService.getVehicles().isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.ok(vehicleService.getVehicles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable Integer id) {

        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        //if request id is not found
        if (vehicleService.getVehicle(id) == null) {
            return ResponseEntity.notFound().build();
        }


        return ResponseEntity.ok(vehicleService.getVehicle(id));
    }

    @PostMapping
    public ResponseEntity<Void> addVehicle(@RequestBody Vehicle vehicle) {

        if (vehicle == null) {
            return ResponseEntity.badRequest().build();
        }

        vehicleService.addVehicle(vehicle);
        return ResponseEntity.status(201).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateVehicle(@PathVariable Integer id, @RequestBody Vehicle vehicle) {

        if (id == null || vehicle == null) {
            return ResponseEntity.badRequest().build();
        }

        //if update id is not found
        if (vehicleService.getVehicle(id) == null) {
            return ResponseEntity.notFound().build();
        }

        vehicleService.updateVehicle(vehicle);
        return ResponseEntity.status(204).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Integer id) {

        if (id == null) {
            return ResponseEntity.badRequest().build();
        }

        //if delete id is not found
        if (vehicleService.getVehicle(id) == null) {
            return ResponseEntity.notFound().build();
        }

        vehicleService.deleteVehicle(id);
        return ResponseEntity.status(204).build();
    }




}
