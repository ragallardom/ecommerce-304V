package dev.rampmaster.ecommerce.orders.service;

import dev.rampmaster.ecommerce.orders.model.SalesOrder;
import dev.rampmaster.ecommerce.orders.repository.SalesOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderService {

    private final SalesOrderRepository repository;

    public SalesOrderService(SalesOrderRepository repository) {
        this.repository = repository;
    }

    public List<SalesOrder> findAll() {
        return repository.findAll();
    }

    public Optional<SalesOrder> findById(Long id) {
        return repository.findById(id);
    }

    public SalesOrder create(SalesOrder entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    public Optional<SalesOrder> update(Long id, SalesOrder entity) {
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

