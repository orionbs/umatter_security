package icu.umatter.security.infrastructure.database.config;

import icu.umatter.security.infrastructure.database.property.SourceDatabaseProperty;
import icu.umatter.security.infrastructure.database.property.VersionDatabaseProperty;
import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.validation.annotation.Validated;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@EnableR2dbcRepositories
@EnableR2dbcAuditing
@Profile("!test")
public class DatabaseConfiguration {

    @Bean
    @Validated
    @ConfigurationProperties(prefix = "database.source")
    public SourceDatabaseProperty sourceDatabaseProperty() {
        return new SourceDatabaseProperty();
    }

    @Bean
    @Validated
    @ConfigurationProperties(prefix = "database.version")
    public VersionDatabaseProperty versionDatabaseProperty() {
        return new VersionDatabaseProperty();
    }

    @Bean
    public ConnectionFactory connectionFactory(SourceDatabaseProperty sourceDatabaseProperty) {
        return ConnectionFactories.get(
                ConnectionFactoryOptions
                        .builder()
                        .option(DRIVER, sourceDatabaseProperty.getDriver())
                        .option(HOST, sourceDatabaseProperty.getHost())
                        .option(PORT, sourceDatabaseProperty.getPort())
                        .option(USER, sourceDatabaseProperty.getUser())
                        .option(PASSWORD, sourceDatabaseProperty.getPassword())
                        .option(DATABASE, sourceDatabaseProperty.getDatabase())
                        .build()
        );
    }

}
