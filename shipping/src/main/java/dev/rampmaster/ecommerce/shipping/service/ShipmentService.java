package dev.rampmaster.ecommerce.shipping.service;

import dev.rampmaster.ecommerce.shipping.model.Shipment;
import dev.rampmaster.ecommerce.shipping.repository.ShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    private final ShipmentRepository repository;

    public ShipmentService(ShipmentRepository repository) {
        this.repository = repository;
    }

    public List<Shipment> findAll() {
        return repository.findAll();
    }

    public Optional<Shipment> findById(Long id) {
        return repository.findById(id);
    }

    public Shipment create(Shipment entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    public Optional<Shipment> update(Long id, Shipment entity) {
        if (!repository.existsById(id)) {
            return Optional.empty();
        }
        entity.setId(id);
        return Optional.of(repository.save(entity));
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }
}

