package com.example.DoctorAppointment.repository;

import com.example.DoctorAppointment.model.City;
import com.example.DoctorAppointment.model.Doctor;
import com.example.DoctorAppointment.model.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAllByCityAndSpeciality(City city, Speciality speciality);
}