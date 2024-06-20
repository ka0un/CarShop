package com.hapangama.carshop.vehicle.infrastructure.repository;

import com.hapangama.carshop.vehicle.model.Vehicle;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Mapper
public interface VehicleMapper {
    Vehicle findById(Integer id);
    void insert(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(Integer id);
    List<Vehicle> findAll();

}
