package com.example.DoctorAppointment.controller;

import com.example.DoctorAppointment.model.Patient;
import com.example.DoctorAppointment.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
        return ResponseEntity.ok("Patient added successfully");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> removePatient(@PathVariable Long id) {
        patientService.removePatient(id);
        return ResponseEntity.ok("Patient removed successfully");
    }

}
