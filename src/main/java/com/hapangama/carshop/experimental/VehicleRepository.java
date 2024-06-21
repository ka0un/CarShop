package com.hapangama.carshop.experimental;

import com.hapangama.carshop.domian.Vehicle;
import com.hapangama.carshop.util.VehicleBrand;
import org.springframework.data.mybatis.repository.MybatisRepository;


import java.util.List;
@Deprecated
public interface VehicleRepository extends MybatisRepository<Vehicle, Integer> {
    List<Vehicle> findAllByNameAndVehicleBrand(String name, VehicleBrand vehicleBrand);


}
