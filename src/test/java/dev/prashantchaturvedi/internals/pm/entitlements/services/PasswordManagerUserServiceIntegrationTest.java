package dev.prashantchaturvedi.internals.pm.entitlements.services;

import dev.prashantchaturvedi.internals.pm.AbstractIntegrationTest;
import dev.prashantchaturvedi.internals.pm.entitlements.beans.PasswordManagerRole;
import dev.prashantchaturvedi.internals.pm.entitlements.beans.PasswordManagerUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.jdbc.Sql;

import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PasswordManagerUserServiceIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    PasswordManagerUserService sut;

    @Test
    void save() {
        UUID userId = UUID.randomUUID();
        PasswordManagerUser pmUser1 = PasswordManagerUser.builder()
                .userId(userId)
                .roles(Set.of(PasswordManagerRole.USER, PasswordManagerRole.ADMIN))
                .email("pmuser1@testpm.dev")
                .build();
        PasswordManagerUser savedPmUser1 = sut.save(pmUser1);
        assertThat(savedPmUser1).isNotNull();
        assertThat(savedPmUser1.getEmail()).isEqualTo("pmuser1@testpm.dev");
        assertThat(savedPmUser1.getRoles()).hasSize(2);
        assertThat(savedPmUser1.getRoles()).hasSameElementsAs(Set.of(PasswordManagerRole.USER,
                PasswordManagerRole.ADMIN));
        assertThat(savedPmUser1.getUserId()).isNotNull();
    }

    void findById() {
    }
}