package com.echolead.repository;
import com.echolead.model.Appointment; import org.springframework.data.jpa.repository.JpaRepository;
public interface AppointmentRepository extends JpaRepository<Appointment,Long>{}
