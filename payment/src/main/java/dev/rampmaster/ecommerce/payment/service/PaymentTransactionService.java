package dev.rampmaster.ecommerce.payment.service;

import dev.rampmaster.ecommerce.payment.model.PaymentTransaction;
import dev.rampmaster.ecommerce.payment.repository.PaymentTransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentTransactionService {

    private final PaymentTransactionRepository repository;

    public PaymentTransactionService(PaymentTransactionRepository repository) {
        this.repository = repository;
    }

    public List<PaymentTransaction> findAll() {
        return repository.findAll();
    }

    public Optional<PaymentTransaction> findById(Long id) {
        return repository.findById(id);
    }

    public PaymentTransaction create(PaymentTransaction entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    public Optional<PaymentTransaction> update(Long id, PaymentTransaction entity) {
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

