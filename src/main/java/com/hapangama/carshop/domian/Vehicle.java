package com.hapangama.carshop.domian;

import com.hapangama.carshop.util.VehicleBrand;
import com.hapangama.carshop.util.VehicleType;
import lombok.Data;


@Data
public class Vehicle  {
    private Integer id;
    private String name;
    private VehicleBrand vehicleBrand;
    private VehicleType vehicleType;
    private String vehicleYear;
}
