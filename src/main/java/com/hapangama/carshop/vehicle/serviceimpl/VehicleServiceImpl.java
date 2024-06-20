package com.hapangama.carshop.vehicle.serviceimpl;

import com.hapangama.carshop.vehicle.infrastructure.repository.VehicleMapper;
import com.hapangama.carshop.vehicle.model.Vehicle;
import com.hapangama.carshop.vehicle.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Vehicle> getVehicles() {
        return vehicleMapper.findAll();
    }

}
