package com.hapangama.carshop.vehicle.model;

import com.hapangama.carshop.vehicle.util.VehicleBrand;
import com.hapangama.carshop.vehicle.util.VehicleType;
import lombok.Data;

@Data
public class Vehicle {
    private Integer id;
    private String name;
    private VehicleBrand vehicleBrand;
    private VehicleType vehicleType;
    private String year;
}
