package dev.prashantchaturvedi.internals.pm.entitlements.configurations;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "dev.prashantchaturvedi.internals.pm.entitlements.beans")
@EnableJpaRepositories(basePackages = "dev.prashantchaturvedi.internals.pm.entitlements.repositories")
public class EntitlementConfigurations {
    
}
