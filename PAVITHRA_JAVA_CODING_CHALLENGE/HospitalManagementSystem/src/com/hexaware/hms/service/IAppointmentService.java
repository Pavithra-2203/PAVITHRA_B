package com.hexaware.hms.service;

import java.util.List;

import com.hexaware.hms.entity.Appointment;

public interface IAppointmentService {
	
	Appointment getAppointmentById(int appointmentId);
    List<Appointment> getAppointmentsForPatient(int patientId);
    List<Appointment> getAppointmentsForDoctor(int doctorId);
    boolean scheduleAppointment(Appointment appointment);
    boolean updateAppointment(Appointment appointment);
    boolean cancelAppointment(int appointmentId);

}
