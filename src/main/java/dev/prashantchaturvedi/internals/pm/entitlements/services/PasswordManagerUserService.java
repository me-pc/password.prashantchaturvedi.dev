package dev.prashantchaturvedi.internals.pm.entitlements.services;

import dev.prashantchaturvedi.internals.pm.core.support.AbstractCrudServiceSupport;
import dev.prashantchaturvedi.internals.pm.entitlements.beans.PasswordManagerUser;
import dev.prashantchaturvedi.internals.pm.entitlements.repositories.PasswordManagerUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PasswordManagerUserService extends AbstractCrudServiceSupport<PasswordManagerUser, UUID> {

    private final PasswordManagerUserRepository repository;

     @Override
    protected JpaRepository<PasswordManagerUser, UUID> repository() {
        return repository;
    }
}
