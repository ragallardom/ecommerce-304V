package dev.rampmaster.ecommerce.products.repository;

import dev.rampmaster.ecommerce.products.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {

    private final Map<Long, Product> storage = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public ProductRepository() {
        save(new Product(null, "Laptop Pro 14", "Computing", new BigDecimal("1499.99"), true));
        save(new Product(null, "Auriculares Wireless", "Audio", new BigDecimal("129.90"), true));
        save(new Product(null, "Mouse Ergonomico", "Accessories", new BigDecimal("39.50"), true));
    }

    public List<Product> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Product save(Product entity) {
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

