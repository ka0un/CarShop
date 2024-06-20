package com.hapangama.carshop.vehicle.serviceimpl;

import com.hapangama.carshop.vehicle.infrastructure.repository.VehicleMapper;
import com.hapangama.carshop.vehicle.model.Vehicle;
import com.hapangama.carshop.vehicle.service.VehicleService;
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

}
