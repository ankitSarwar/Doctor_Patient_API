package com.example.DoctorAppointment.controller;

import com.example.DoctorAppointment.model.Doctor;
import com.example.DoctorAppointment.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
   DoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.addDoctor(doctor);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDoctor);
    }

    @DeleteMapping("delete/{doctorId}")
    public ResponseEntity<Void> removeDoctor(@PathVariable Long doctorId) {
        doctorService.removeDoctor(doctorId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok().body(doctors);
    }
}