package org.anyulled.model;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.assertj.core.api.InstanceOfAssertFactory;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.assertj.core.api.BDDSoftAssertions;

import static org.assertj.core.api.Assertions.as;
import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.BDDAssertions.then;

import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.anyulled.service.PatientService;

import java.util.List;

@DisplayNameGeneration(value = DisplayNameGenerator.ReplaceUnderscores.class)
class BDDPatientShould {

    PatientService patientService = Mockito.mock(PatientService.class);
    Patient BDDPatient = Patient.builder()
            .name("BDD")
            .lastname("Patient")
            .gender(Gender.NON_BINARY).build();


    @Test
    void verify_patient_using_bdd() {
        given(patientService.getPatient()).willReturn(BDDPatient.getName());

        //when
        var patientName = patientService.getPatient();

        then(patientName).isNotNull();
        then(patientName).isNotNull().isNotEmpty().isNotBlank();
    }

    @Test
    void softly_verify_patient_using_bdd() {
        given(patientService.patientList()).willReturn(List.of(BDDPatient, BDDPatient));
        BDDSoftAssertions softly = new BDDSoftAssertions();

        var patientList = patientService.patientList();

        softly.then(patientList).allSatisfy(patient -> {
            then(patient).extracting(Patient::getName, as(InstanceOfAssertFactories.STRING)).contains("BDD");
            then(patient.getGender()).isEqualTo(Gender.NON_BINARY);
        })
                .contains(BDDPatient)
                .hasSize(2);
    }
}
