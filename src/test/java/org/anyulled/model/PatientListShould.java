package org.anyulled.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;


@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class PatientListShould {

    Patient patientA;
    Patient patientB;
    List<Patient> patientList;

    @BeforeEach
    void setUp() {
        patientB = Patient.builder().infected(Boolean.TRUE).vaccinated(Boolean.TRUE).name("one").lastname("she").birthdate(Date.from(Instant.now())).gender(Gender.FEMALE).build();
        patientA = Patient.builder().infected(Boolean.TRUE).vaccinated(Boolean.TRUE).name("two").lastname("him").gender(Gender.MALE).build();
        patientList = List.of(patientA, patientB);
    }

    @Test
    void satisfy_several_conditions() {
        assertThat(patientList)
                .allSatisfy(patient -> {
                    assertThat(patient.getInfected()).isTrue();
                    assertThat(patient.getVaccinated()).isTrue();
                })
                .anySatisfy(patient -> assertThat(patient.getBirthdate()).isInSameYearAs(Instant.now()))
                .noneSatisfy(patient -> {
                    assertThat(patient.getGender()).isNull();
                    assertThat(patient.getBirthdate()).isNull();
                });
    }

    @Test
    void contain_one_and_two() {
        assertThat(patientList)
                .extracting("name", String.class)
                .containsExactlyInAnyOrder("one", "two");

        assertThat(patientList)
                .extracting(Patient::getName, Patient::getLastname)
                .contains(
                        tuple("one", "she"),
                        tuple("two", "him"));
    }
}
