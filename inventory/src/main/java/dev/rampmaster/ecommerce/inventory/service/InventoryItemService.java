package dev.rampmaster.ecommerce.inventory.service;

import dev.rampmaster.ecommerce.inventory.model.InventoryItem;
import dev.rampmaster.ecommerce.inventory.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryItemService {

    private final InventoryItemRepository repository;

    public InventoryItemService(InventoryItemRepository repository) {
        this.repository = repository;
    }

    public List<InventoryItem> findAll() {
        return repository.findAll();
    }

    public Optional<InventoryItem> findById(Long id) {
        return repository.findById(id);
    }

    public InventoryItem create(InventoryItem entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    public Optional<InventoryItem> update(Long id, InventoryItem entity) {
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

