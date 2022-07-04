package com.dh.concessionariadeveiculos.controller;

import com.dh.concessionariadeveiculos.model.Vehicle;
import com.dh.concessionariadeveiculos.repository.VehicleRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/api/veiculos")
public class VehicleController {
    private final VehicleRepository repository;

    public VehicleController(VehicleRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> index() {
        return ResponseEntity.ok(repository.all());
    }

    @GetMapping("dates")
    public ResponseEntity<List<Vehicle>> allByDates(@RequestParam String since, @RequestParam String to) throws ParseException {
        var format = new SimpleDateFormat("yyyy-MM-dd");
        return ResponseEntity.ok(repository.findByDates(format.parse(since), format.parse(to)));
    }

    @GetMapping("prices")
    public ResponseEntity<List<Vehicle>> allByPrices(@RequestParam int min, @RequestParam int max) {
        return ResponseEntity.ok(repository.findByPrices(min, max));
    }

    @GetMapping("{id}")
    public ResponseEntity<Vehicle> show(@PathVariable UUID id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @PostMapping
    public void store(@RequestBody Vehicle vehicle) {
        vehicle.setId(UUID.randomUUID());
        repository.save(vehicle);
    }
}
