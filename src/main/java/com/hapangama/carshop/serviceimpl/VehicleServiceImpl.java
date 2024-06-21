package com.hapangama.carshop.serviceimpl;

import com.hapangama.carshop.repository.VehicleMapper;
import com.hapangama.carshop.domian.Vehicle;
import com.hapangama.carshop.service.VehicleService;
import com.hapangama.carshop.util.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VehicleServiceImpl implements VehicleService {


    private final VehicleMapper vehicleMapper;

    @Autowired
    public VehicleServiceImpl(VehicleMapper vehicleMapper) {
        this.vehicleMapper = vehicleMapper;
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicleMapper.insert(vehicle);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        vehicleMapper.update(vehicle);
    }

    @Override
    public void deleteVehicle(Integer id) {
        vehicleMapper.delete(id);
    }

    @Override
    public Vehicle getVehicle(Integer id) {
        return vehicleMapper.findById(id);
    }

    @Override
    public Page<Vehicle> getVehicles(Pageable pageable) {
        List<Vehicle> vehicles = vehicleMapper.findAll();
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), vehicles.size());
        return new PageImpl<>(vehicles.subList(start, end), pageable, vehicles.size());
    }

//    @Override
//    public Page<Vehicle> findVehiclesByNameAndBrand(String name, VehicleBrand vehicleBrand, Pageable pageable) {
//        List<Vehicle> vehicles = vehicleRepository.findAllByNameAndVehicleBrand(name, vehicleBrand);
//        int start = (int) pageable.getOffset();
//        int end = Math.min((start + pageable.getPageSize()), vehicles.size());
//        return new PageImpl<>(vehicles.subList(start, end), pageable, vehicles.size());
//    }

    @Override
    public Page<Vehicle> getVehiclesWithSorting(String field, SortOrder sortOrder, Pageable pageable) {
        List<Vehicle> vehicles = vehicleMapper.findAllWithSorting(field, sortOrder.toString());
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()), vehicles.size());
        return new PageImpl<>(vehicles.subList(start, end), pageable, vehicles.size());
    }

}
