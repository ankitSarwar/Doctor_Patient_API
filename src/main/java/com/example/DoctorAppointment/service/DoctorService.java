package com.example.DoctorAppointment.service;

import com.example.DoctorAppointment.model.City;
import com.example.DoctorAppointment.model.Doctor;
import com.example.DoctorAppointment.model.Patient;
import com.example.DoctorAppointment.model.Speciality;
import com.example.DoctorAppointment.repository.DoctorRepository;
import com.example.DoctorAppointment.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

     @Autowired
     DoctorRepository doctorRepository;


    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public void removeDoctor(Long doctorId) {
        doctorRepository.deleteById(doctorId);
    }

    public List<Doctor> getDoctorsByLocationAndSpeciality(City location, Speciality speciality) {
        return doctorRepository.findAllByCityAndSpeciality(location, speciality);
    }

    public Optional<Doctor> findDoctorById(Long doctorId) {
        return doctorRepository.findById(doctorId);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
}