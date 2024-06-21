package com.hapangama.carshop.repository;

import com.hapangama.carshop.domian.Vehicle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface VehicleMapper {
    Vehicle findById(Integer id);
    void insert(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(Integer id);
    List<Vehicle> findAll();
    List<Vehicle> findAllWithSorting(String field, String order);

}
