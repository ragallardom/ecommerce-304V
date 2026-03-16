package dev.rampmaster.ecommerce.campaigns.repository;

import dev.rampmaster.ecommerce.campaigns.model.Campaign;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CampaignRepository {

    private final Map<Long, Campaign> storage = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public CampaignRepository() {
        save(new Campaign(null, "WELCOME10", 10, true));
        save(new Campaign(null, "FREESHIP", 5, true));
        save(new Campaign(null, "FLASH25", 25, false));
    }

    public List<Campaign> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Campaign> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Campaign save(Campaign entity) {
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

