package icu.umatter.security.infrastructure.database.property;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SourceDatabaseProperty {
    @NotBlank(message = "Database source driver can't be empty.")
    private String driver;
    @NotBlank(message = "Database source host can't be empty.")
    private String host;
    @NotNull(message = "Database source port can't be null.")
    private Integer port;
    @NotBlank(message = "Database source user can't be empty.")
    private String user;
    @NotBlank(message = "Database source password can't be empty.")
    private String password;
    @NotBlank(message = "Database source database can't be empty.")
    private String database;
}
