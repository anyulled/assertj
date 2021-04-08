package org.anyulled.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class RecursivePatientShould {

    Patient EnglishPatient = Patient.builder()
            .name("English")
            .lastname("Patient")
            .gender(Gender.MALE)
            .infected(Boolean.FALSE)
            .build();

    Patient AsianPatient = Patient.builder()
            .name("English")
            .lastname("Patient")
            .gender(Gender.MALE)
            .infected(Boolean.FALSE)
            .build();

    @Test
    void be_equal_comparing_some_fields() {
        assertThat(EnglishPatient)
                .usingRecursiveComparison()
                .ignoringFields("name")
                .ignoringFieldsOfTypes(Date.class)
                .ignoringActualNullFields()
                .isEqualTo(AsianPatient);
    }
}
