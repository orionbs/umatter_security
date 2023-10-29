package icu.umatter.security.infrastructure.database.property;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class VersionDatabaseProperty {
    @NotNull(message = "Database version enabled can't be null.")
    private boolean enabled;
}
