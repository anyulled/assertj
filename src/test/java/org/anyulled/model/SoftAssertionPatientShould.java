package org.anyulled.model;

import org.assertj.core.api.SoftAssertions;
import org.assertj.core.api.junit.jupiter.InjectSoftAssertions;
import org.assertj.core.api.junit.jupiter.SoftAssertionsExtension;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SoftAssertionsExtension.class)
@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
public class SoftAssertionPatientShould {

    Patient patient = Patient.builder().build();

    @InjectSoftAssertions
    private SoftAssertions softly;

    @Test
    void soft_assert_patient_list() {
        softly.assertThat(patient).as("Patient cannot be null").withFailMessage("but is null").isNull();
        softly.assertThat(patient.getName()).as("Patient's name cannot be null").withFailMessage("but is null").isNotNull();
        softly.assertThat(patient.getLastname()).as("Patient's lastname cannot be null").withFailMessage("but is null").isNotNull();
        softly.assertThat(patient.getBirthdate()).as("Patient's birthdate cannot be null").withFailMessage("but is null").isNotNull();
        softly.assertThat(patient.getGender()).as("Patient's gender cannot be null").withFailMessage("but is null").isNotNull();
    }
}
