package com.hapangama.carshop.vehicle.repositories;

import com.hapangama.carshop.vehicle.model.Vehicle;
import com.hapangama.carshop.vehicle.util.VehicleBrand;
import org.springframework.data.mybatis.repository.MybatisRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
@Deprecated
public interface VehicleRepository extends MybatisRepository<Vehicle, Integer> {
    List<Vehicle> findAllByNameAndVehicleBrand(String name, VehicleBrand vehicleBrand);


}
