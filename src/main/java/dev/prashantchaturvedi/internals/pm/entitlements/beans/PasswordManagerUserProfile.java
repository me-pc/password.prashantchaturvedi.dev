package dev.prashantchaturvedi.internals.pm.entitlements.beans;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class PasswordManagerUserProfile {

    @Id
    @Builder.Default
    private UUID profileId = UUID.randomUUID();

    private String email;

    private String firstName;

    private String lastName;

    @OneToOne
    @JoinColumn(name = "password_manager_user_id")
    private PasswordManagerUser user;
}
