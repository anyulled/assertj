package org.anyulled.service;

import org.anyulled.exceptions.MyPatientException;
import org.anyulled.model.Patient;

import java.util.Collections;
import java.util.List;

public class PatientService {

    public void businessLogic() {
        throw new MyPatientException("Business Logic should be implemented in the model");
    }

    public String getPatient() {
        return "some patient";
    }

    public List<Patient> patientList() {
        return Collections.emptyList();
    }
}
