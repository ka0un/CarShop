package com.hapangama.carshop.service;

import com.hapangama.carshop.domian.Vehicle;
import com.hapangama.carshop.util.SortOrder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VehicleService {

    void addVehicle(Vehicle vehicle);

    void updateVehicle(Vehicle vehicle);

    void deleteVehicle(Integer id);

    Vehicle getVehicle(Integer id);

    Page<Vehicle> getVehicles(Pageable pageable) throws IllegalArgumentException;

    Page<Vehicle> getVehiclesWithSorting(String field, SortOrder sortOrder, Pageable pageable) throws IllegalArgumentException;

//    Page<Vehicle> findVehiclesByNameAndBrand(String name, VehicleBrand brand, Pageable pageable);

}
