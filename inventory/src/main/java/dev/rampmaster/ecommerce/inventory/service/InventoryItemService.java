package dev.rampmaster.ecommerce.inventory.service;

import dev.rampmaster.ecommerce.inventory.model.InventoryItem;
import dev.rampmaster.ecommerce.inventory.model.InventoryMovement;
import dev.rampmaster.ecommerce.inventory.model.MovementType;
import dev.rampmaster.ecommerce.inventory.repository.InventoryItemRepository;
import dev.rampmaster.ecommerce.inventory.repository.InventoryMovementRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventoryItemService {

    private final InventoryItemRepository repository;
    private final InventoryMovementRepository movementRepository;

    @CircuitBreaker(name = "inventoryService", fallbackMethod = "fallbackFindAll")
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

    @Transactional
    public InventoryMovement registerShrinkage(Long id, Integer quantity, String reason) {
        InventoryItem item = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item no encontrado"));

        if (item.getQuantity() < quantity) {
            throw new RuntimeException("No hay suficiente stock para registrar esta merma");
        }


        item.setQuantity(item.getQuantity() - quantity);
        repository.save(item);


        InventoryMovement movement = new InventoryMovement();
        movement.setInventoryItemId(id);
        movement.setQuantity(quantity);
        movement.setType(MovementType.SHRINKAGE);
        movement.setReason(reason);
        movement.setCreatedAt(LocalDateTime.now());

        return movementRepository.save(movement);
    }

    public List<InventoryMovement> getHistory(Long inventoryItemId) {
        return movementRepository.findByInventoryItemIdOrderByCreatedAtDesc(inventoryItemId);
    }

    public List<InventoryItem> fallbackFindAll(Throwable t) {
        return new ArrayList<>();
    }
}