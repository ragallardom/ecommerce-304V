package dev.rampmaster.ecommerce.shipping.repository;

import dev.rampmaster.ecommerce.shipping.model.Shipment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ShipmentRepository {

    private final Map<Long, Shipment> storage = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public ShipmentRepository() {
        save(new Shipment(null, 1L, "DHL", "PICKED_UP"));
        save(new Shipment(null, 2L, "FedEx", "IN_TRANSIT"));
        save(new Shipment(null, 3L, "LocalExpress", "DELIVERED"));
    }

    public List<Shipment> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Shipment> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Shipment save(Shipment entity) {
        if (entity.getId() == null) {
            entity.setId(sequence.incrementAndGet());
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    public boolean existsById(Long id) {
        return storage.containsKey(id);
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}

