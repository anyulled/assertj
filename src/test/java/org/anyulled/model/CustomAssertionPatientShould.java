package org.anyulled.model;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static java.time.Instant.now;
import static java.util.Date.from;
import static org.anyulled.model.Gender.UNKNOWN;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class CustomAssertionPatientShould {

    Date birthDate = from(now());

    Patient patient = Patient.builder()
            .name("Custom")
            .lastname("Patient")
            .birthdate(birthDate)
            .gender(UNKNOWN)
            .infected(FALSE)
            .vaccinated(TRUE)
            .alive(TRUE)
            .build();

    @Test
    void validate_patient_with_custom_assertion() {
        Assertions.assertThat(patient)
                .isAlive()
                .hasName("Custom")
                .hasLastname("Patient")
                .hasGender(UNKNOWN)
                .hasInfected(FALSE)
                .hasVaccinated(TRUE)
                .hasBirthdate(birthDate)
                .hasName("Custom");
    }
}
