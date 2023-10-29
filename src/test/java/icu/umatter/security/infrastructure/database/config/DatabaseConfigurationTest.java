package icu.umatter.security.infrastructure.database.config;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
@ActiveProfiles("test")
public class DatabaseConfigurationTest {

    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(
                ConnectionFactoryOptions
                        .builder()
                        .option(DRIVER, "h2")
                        .option(PROTOCOL, "mem")
                        .option(USER, "sa")
                        .option(PASSWORD, "password")
                        .option(DATABASE, "db")
                        .build()
        );
    }
}
