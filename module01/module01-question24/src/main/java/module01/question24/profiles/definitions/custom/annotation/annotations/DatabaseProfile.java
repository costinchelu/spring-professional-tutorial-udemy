package module01.question24.profiles.definitions.custom.annotation.annotations;

import org.springframework.context.annotation.Profile;

@Profile("database")
public @interface DatabaseProfile {
}
