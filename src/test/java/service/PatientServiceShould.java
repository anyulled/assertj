package service;

import org.anyulled.exceptions.MyPatientException;
import org.anyulled.service.PatientService;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class PatientServiceShould {

    PatientService patientService = new PatientService();

    @Test
    void throw_a_custom_exception() {
        assertThatExceptionOfType(MyPatientException.class)
                .isThrownBy(() -> patientService.businessLogic())
                .withMessageContaining("Business Logic")
                .withMessageNotContaining("anemic model")
                .withMessageEndingWith("model");
    }

    @Test
    void not_throw_any_exceptions() {
        assertThatNoException().isThrownBy(() -> patientService.getPatient());
    }
}