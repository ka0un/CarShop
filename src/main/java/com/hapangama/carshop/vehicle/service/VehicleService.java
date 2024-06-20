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

    List<Vehicle> getVehiclesByBrand(VehicleBrand vehicleBrand);

    List<Vehicle> getVehiclesByType(VehicleType vehicleType);

    List<Vehicle> getVehiclesByYear(String year);

    List<Vehicle> getVehiclesByBrandAndType(VehicleBrand vehicleBrand, VehicleType vehicleType);

    List<Vehicle> getVehiclesByBrandAndYear(VehicleBrand vehicleBrand, String year);

    List<Vehicle> getVehiclesByTypeAndYear(VehicleType vehicleType, String year);

    List<Vehicle> getVehiclesByBrandAndTypeAndYear(VehicleBrand vehicleBrand, VehicleType vehicleType, String year);
}
