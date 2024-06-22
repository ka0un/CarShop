package com.hapangama.carshop.controllers;

import com.hapangama.carshop.domian.Vehicle;
import com.hapangama.carshop.service.VehicleService;
import com.hapangama.carshop.util.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;


    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping
    public ResponseEntity<Page<Vehicle>> getAllVehicles(
            @RequestParam(required = false) String field,
            @RequestParam(required = false) String order,
            Pageable pageable) {

        Page<Vehicle> vehicles;

        try {

            if (field != null && order != null) {
                SortOrder sortOrder = SortOrder.valueOf(order);
                vehicles = vehicleService.getVehiclesWithSorting(field, sortOrder, pageable);
            } else {
                vehicles = vehicleService.getVehicles(pageable);
            }

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }


        if (vehicles == null || vehicles.isEmpty() || vehicles.getSize() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(vehicles);
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
        return ResponseEntity.status(HttpStatus.CREATED).build();

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
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

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
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).build();
    }








}
