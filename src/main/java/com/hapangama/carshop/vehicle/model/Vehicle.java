package com.hapangama.carshop.vehicle.model;

import com.hapangama.carshop.vehicle.util.VehicleBrand;
import com.hapangama.carshop.vehicle.util.VehicleType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Vehicle {
    private Integer id;
    private String name;
    private VehicleBrand vehicleBrand;
    private VehicleType vehicleType;
    private String vehicleYear;
}
