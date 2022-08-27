package dev.prashantchaturvedi.internals.pm;

import org.springframework.context.annotation.Profile;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
public abstract class AbstractIntegrationTest {

    @Container
    protected final static PostgreSQLContainer<?> DB_CONTAINER = new PostgreSQLContainer<>("postgres")
            .withReuse(Boolean.TRUE)
            .withExposedPorts(5432);

    @DynamicPropertySource
    protected static void postgresTestContainerPropertiesSupplier(DynamicPropertyRegistry r) {
        r.add("spring.datasource.url", DB_CONTAINER::getJdbcUrl);
        r.add("spring.datasource.username", DB_CONTAINER::getUsername);
        r.add("spring.datasource.password", DB_CONTAINER::getPassword);
    }

}
