package dev.rampmaster.ecommerce.inventory.controller;

import dev.rampmaster.ecommerce.inventory.dto.MovementRequest;
import dev.rampmaster.ecommerce.inventory.model.InventoryItem;
import dev.rampmaster.ecommerce.inventory.model.InventoryMovement;
import dev.rampmaster.ecommerce.inventory.service.InventoryItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventories")
public class InventoryItemController {

    private final InventoryItemService service;

    public InventoryItemController(InventoryItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<InventoryItem> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryItem> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InventoryItem> create(@RequestBody InventoryItem entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventoryItem> update(@PathVariable Long id, @RequestBody InventoryItem entity) {
        return service.update(id, entity)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!service.delete(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/shrinkage")
    public ResponseEntity<InventoryMovement> registerShrinkage(
            @PathVariable Long id,
            @RequestBody MovementRequest request) {
        return ResponseEntity.ok(service.registerShrinkage(id, request.getQuantity(), request.getReason()));
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<List<InventoryMovement>> getHistory(@PathVariable Long id) {
        return ResponseEntity.ok(service.getHistory(id));
    }
}

