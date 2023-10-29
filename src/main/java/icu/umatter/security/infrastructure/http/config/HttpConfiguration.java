package icu.umatter.security.infrastructure.http.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class HttpConfiguration {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity serverHttpSecurity) {

        serverHttpSecurity.cors(ServerHttpSecurity.CorsSpec::disable);
        serverHttpSecurity.csrf(ServerHttpSecurity.CsrfSpec::disable);
        serverHttpSecurity.authorizeExchange(authorizeExchangeSpec -> {
            authorizeExchangeSpec.pathMatchers(HttpMethod.GET, "/actuator/**").permitAll();
            authorizeExchangeSpec.anyExchange().authenticated();
        });

        return serverHttpSecurity.build();
    }

}
