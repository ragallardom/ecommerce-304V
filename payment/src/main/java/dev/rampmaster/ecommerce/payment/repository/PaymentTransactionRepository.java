package dev.rampmaster.ecommerce.payment.repository;

import dev.rampmaster.ecommerce.payment.model.PaymentTransaction;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PaymentTransactionRepository {

    private final Map<Long, PaymentTransaction> storage = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public PaymentTransactionRepository() {
        save(new PaymentTransaction(null, 1L, new BigDecimal("1499.99"), "APPROVED"));
        save(new PaymentTransaction(null, 2L, new BigDecimal("169.40"), "APPROVED"));
        save(new PaymentTransaction(null, 3L, new BigDecimal("39.50"), "PENDING"));
    }

    public List<PaymentTransaction> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<PaymentTransaction> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public PaymentTransaction save(PaymentTransaction entity) {
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

