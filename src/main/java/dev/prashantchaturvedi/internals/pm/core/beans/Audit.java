package dev.prashantchaturvedi.internals.pm.core.beans;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

@MappedSuperclass
public class Audit {

    @Builder.Default
    protected LocalDateTime createdAt = LocalDateTime.now();

    @Builder.Default
    protected LocalDateTime modifiedAt = LocalDateTime.now();

    protected UUID createdBy;

    protected UUID modifiedBy;
}
