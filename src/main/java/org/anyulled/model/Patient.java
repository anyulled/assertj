package org.anyulled.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public
class Patient {
    private final String name;
    private final String lastname;
    private final Date birthdate;
    private final Gender gender;
    private final Boolean vaccinated;
    private final Boolean infected;
    private final boolean alive;
}
