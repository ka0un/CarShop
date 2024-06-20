package com.hapangama.carshop.vehicle.service;

import com.hapangama.carshop.vehicle.model.Vehicle;
import com.hapangama.carshop.vehicle.util.VehicleBrand;
import com.hapangama.carshop.vehicle.util.VehicleType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VehicleService {

    void addVehicle(Vehicle vehicle);

    void updateVehicle(Vehicle vehicle);

    void deleteVehicle(Integer id);

    Vehicle getVehicle(Integer id);

    Page<Vehicle> getVehicles(Pageable pageable);

}
