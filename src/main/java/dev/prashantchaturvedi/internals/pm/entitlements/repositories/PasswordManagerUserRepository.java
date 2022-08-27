package dev.prashantchaturvedi.internals.pm.entitlements.repositories;

import dev.prashantchaturvedi.internals.pm.entitlements.beans.PasswordManagerUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PasswordManagerUserRepository extends JpaRepository<PasswordManagerUser, UUID> {

}
