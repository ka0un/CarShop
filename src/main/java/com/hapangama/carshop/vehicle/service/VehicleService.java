package com.hapangama.carshop.vehicle.service;

import com.hapangama.carshop.vehicle.model.Vehicle;
import com.hapangama.carshop.vehicle.util.VehicleBrand;
import com.hapangama.carshop.vehicle.util.VehicleType;

import java.util.List;

public interface VehicleService {

    void addVehicle(Vehicle vehicle);

    void updateVehicle(Vehicle vehicle);

    void deleteVehicle(Integer id);

    Vehicle getVehicle(Integer id);

    List<Vehicle> getVehicles();

}
