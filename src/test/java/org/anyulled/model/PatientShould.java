package org.anyulled.model;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.Instant;

import static org.anyulled.model.Gender.NON_BINARY;
import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class PatientShould {
    Patient patient;

    @BeforeEach
    void setUp() {
        patient = Patient.builder()
                .name("Patient A")
                .lastname("Test")
                .birthdate(Date.from(Instant.now()))
                .gender(NON_BINARY)
                .infected(Boolean.FALSE)
                .vaccinated(Boolean.TRUE)
                .alive(true)
                .build();
    }

    @Test
    void have_all_fields_set() {
        assertThat(patient.getName()).isNotNull();
        assertThat(patient.getLastname()).isNotNull();
        assertThat(patient.getBirthdate()).isNotNull();
        assertThat(patient.getInfected()).isNotNull();
        assertThat(patient.getVaccinated()).isNotNull();

        assertThat(patient).hasNoNullFieldsOrProperties();

    }

    @Test
    void have_complete_personal_data() {

        assertThat(patient).extracting("name", "lastname").containsExactly("Patient A", "Test");

        assertThat(patient).
                extracting(Patient::getName)
                .as("Patient's Name should not be null").isNotNull();//Note that since the value is extracted as an Object, only Object assertions can be chained after extracting.

        assertThat(patient)
                .extracting(Patient::getName, as(InstanceOfAssertFactories.STRING))
                .isNotNull().isNotBlank().isNotEmpty()
                .startsWith("Patient").endsWith("A");

        assertThat(patient)
                .extracting(Patient::getBirthdate, as(InstanceOfAssertFactories.DATE)).isBefore(Instant.now());
    }

    @Test
    void be_an_adult() {
        assertThat(patient)
                .as("The patient: %s %s should be an adult!", patient.getName(), patient.getLastname()) //Always call the description before the assertion
                .extracting(Patient::getBirthdate, as(InstanceOfAssertFactories.DATE))
                .isBeforeYear(2003);
    }
}