package com.example.DoctorAppointment.service;

import com.example.DoctorAppointment.model.Patient;
import com.example.DoctorAppointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void removePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }

    public Optional<Patient> findPatientById(Long patientId) {
        return patientRepository.findById(patientId);
    }
}