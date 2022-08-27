package dev.prashantchaturvedi.internals.pm.entitlements.beans;

import dev.prashantchaturvedi.internals.pm.core.beans.Audit;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class PasswordManagerUser extends Audit {

    @Id
    @Builder.Default
    private UUID userId = UUID.randomUUID();

    private String email;

    private String password;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Set<PasswordManagerRole> roles = new HashSet<>();

    @OneToOne(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @Builder.Default
    private PasswordManagerUserProfile profile = new PasswordManagerUserProfile();

    @Builder.Default
    private boolean accountLocked = Boolean.FALSE;

    @Builder.Default
    private boolean accountExpired = Boolean.FALSE;

    @Builder.Default
    private boolean credentialsExpired = Boolean.FALSE;

    @Builder.Default
    private boolean enabled = Boolean.TRUE;

}
