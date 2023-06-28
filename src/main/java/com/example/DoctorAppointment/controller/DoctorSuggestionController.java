package com.example.DoctorAppointment.controller;

import com.example.DoctorAppointment.model.*;
import com.example.DoctorAppointment.service.DoctorService;
import com.example.DoctorAppointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DoctorSuggestionController {

    @Autowired
    PatientService patientService;

     @Autowired
     DoctorService doctorService;


    @GetMapping("/suggestions/{patientId}")
    public ResponseEntity<List<Doctor>> suggestDoctorsForPatient(@PathVariable Long patientId) {
        Optional<Patient> patientOptional = patientService.findPatientById(patientId);
        if (patientOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        Patient patient = patientOptional.get();
        List<Doctor> suggestedDoctors = doctorService.getDoctorsByLocationAndSpeciality(City.valueOf(patient.getCity()), getSpecialityBySymptom(patient.getSymptom()));
        if (suggestedDoctors.isEmpty()) {
            return ResponseEntity.ok().body(List.of());
        } else {
            return ResponseEntity.ok().body(suggestedDoctors);
        }
    }

    private Speciality getSpecialityBySymptom(Symptom symptom) {
        if (symptom == Symptom.ARTHRITIS || symptom == Symptom.BACK_PAIN || symptom == Symptom.TISSUE_INJURIES) {
            return Speciality.ORTHOPEDIC;
        } else if (symptom == Symptom.DYSMENORRHEA) {
            return Speciality.GYNECOLOGY;
        } else if (symptom == Symptom.SKIN_INFECTION || symptom == Symptom.SKIN_BURN) {
            return Speciality.DERMATOLOGY;
        } else if (symptom == Symptom.EAR_PAIN) {
            return Speciality.ENT_SPECIALIST;
        } else {
            return null;
        }
    }
}
