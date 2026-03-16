package dev.rampmaster.ecommerce.users.service;

import dev.rampmaster.ecommerce.users.model.UserAccount;
import dev.rampmaster.ecommerce.users.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {

    private final UserAccountRepository repository;

    public UserAccountService(UserAccountRepository repository) {
        this.repository = repository;
    }

    public List<UserAccount> findAll() {
        return repository.findAll();
    }

    public Optional<UserAccount> findById(Long id) {
        return repository.findById(id);
    }

    public UserAccount create(UserAccount entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    public Optional<UserAccount> update(Long id, UserAccount entity) {
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

