package dev.prashantchaturvedi.internals.pm.core.support;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Optional;

public abstract class AbstractCrudServiceSupport<T, ID extends Serializable> {

    protected abstract JpaRepository<T, ID> repository();

    public T save(T entity) {
        return Optional.ofNullable(entity)
                .map(repository()::save)
                .orElse(null);
    }

    public Optional<T> findById(ID id) {
        return Optional.ofNullable(id)
                .flatMap(repository()::findById);
    }
}
