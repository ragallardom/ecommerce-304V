package dev.rampmaster.ecommerce.reviews.repository;

import dev.rampmaster.ecommerce.reviews.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ReviewRepository {

    private final Map<Long, Review> storage = new ConcurrentHashMap<>();
    private final AtomicLong sequence = new AtomicLong(0);

    public ReviewRepository() {
        save(new Review(null, 1L, 5, "Excelente rendimiento y bateria"));
        save(new Review(null, 2L, 4, "Buen sonido, pero almohadillas ajustadas"));
        save(new Review(null, 3L, 5, "Muy comodo para uso prolongado"));
    }

    public List<Review> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Review> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Review save(Review entity) {
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

