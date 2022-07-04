package com.dh.concessionariadeveiculos.repository;

import com.dh.concessionariadeveiculos.model.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository {
    private final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public List<Vehicle> all() {
        return vehicles;
    }

    public Vehicle findById(UUID id) {
        return vehicles.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
    }

    public List<Vehicle> findByPrices(int min, int max) {
        return vehicles.stream().filter(v -> v.getPrice() >= min && v.getPrice() <= max).collect(Collectors.toList());
    }

    public List<Vehicle> findByDates(Date since, Date to) {
        return vehicles.stream()
                .filter(v -> v.getManufacturingDate().compareTo(since) >= 0 && v.getManufacturingDate().compareTo(to) <= 0)
                .collect(Collectors.toList());
    }

    public void save(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
}
