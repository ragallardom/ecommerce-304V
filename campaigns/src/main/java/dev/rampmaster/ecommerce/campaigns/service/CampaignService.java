package dev.rampmaster.ecommerce.campaigns.service;

import dev.rampmaster.ecommerce.campaigns.model.Campaign;
import dev.rampmaster.ecommerce.campaigns.repository.CampaignRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampaignService {

    private final CampaignRepository repository;

    public CampaignService(CampaignRepository repository) {
        this.repository = repository;
    }

    public List<Campaign> findAll() {
        return repository.findAll();
    }

    public Optional<Campaign> findById(Long id) {
        return repository.findById(id);
    }

    public Campaign create(Campaign entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    public Optional<Campaign> update(Long id, Campaign entity) {
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

