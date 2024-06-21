package com.hapangama.carshop.vehicle.controllers;

import com.hapangama.carshop.vehicle.model.Vehicle;
import com.hapangama.carshop.vehicle.service.VehicleService;
import com.hapangama.carshop.vehicle.util.SortOrder;
import com.hapangama.carshop.vehicle.util.VehicleBrand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping
    public ResponseEntity<Page<Vehicle>>  getAllVehicles(Pageable pageable) {
        Page<Vehicle> vehicles = vehicleService.getVehicles(pageable);

        if (vehicles == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        if (vehicles.isEmpty() || vehicles.getSize() == 0) {
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

//    @GetMapping("/search")
//    public ResponseEntity<Page<Vehicle>> findVehiclesByNameAndBrand(@RequestParam String name, @RequestParam String brand, Pageable pageable) {
//
//        if (name == null || brand == null) {
//            return ResponseEntity.badRequest().build();
//        }
//
//        VehicleBrand vehicleBrand = VehicleBrand.valueOf(brand);
//
//        Page<Vehicle> vehicles = vehicleService.findVehiclesByNameAndBrand(name, vehicleBrand, pageable);
//
//        if (vehicles == null) {
//            return ResponseEntity.status(404).build();
//        }
//
//        if (vehicles.isEmpty() || vehicles.getSize() == 0) {
//            return ResponseEntity.status(404).build();
//        }
//
//        return ResponseEntity.ok(vehicles);
//    }

    //sort
    @GetMapping("/sort/{field}/{order}")
    public ResponseEntity<Page<Vehicle>> getVehiclesWithSorting(@PathVariable String field, @PathVariable String order, Pageable pageable) {

        SortOrder sortOrder;

        try {

            if (field == null) {
                return ResponseEntity.badRequest().build();
            }

            if (order == null || order.isEmpty()) {
                sortOrder = SortOrder.ASC;
            } else {
                sortOrder = SortOrder.valueOf(order);
            }

        }catch (NullPointerException e) {
            return ResponseEntity.badRequest().build();
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        Page<Vehicle> vehicles = vehicleService.getVehiclesWithSorting(field, sortOrder, pageable);


        if (vehicles == null || vehicles.isEmpty() || vehicles.getSize() == 0) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(vehicles);
    }






}
