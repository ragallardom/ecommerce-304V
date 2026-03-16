package dev.rampmaster.ecommerce.orders.repository;

import dev.rampmaster.ecommerce.orders.model.SalesOrder;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class SalesOrderRepository {

    private final Map<Long, SalesOrder> storage = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public SalesOrderRepository() {
        save(new SalesOrder(null, 2L, "CREATED", new BigDecimal("1499.99")));
        save(new SalesOrder(null, 1L, "PAID", new BigDecimal("169.40")));
        save(new SalesOrder(null, 2L, "SHIPPED", new BigDecimal("39.50")));
    }

    public List<SalesOrder> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<SalesOrder> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public SalesOrder save(SalesOrder entity) {
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

