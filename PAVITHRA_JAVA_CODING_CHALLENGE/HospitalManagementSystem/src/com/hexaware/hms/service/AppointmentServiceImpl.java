package com.hexaware.hms.service;

import java.util.List;
import com.hexaware.hms.dao.*;

import com.hexaware.hms.entity.Appointment;

public class AppointmentServiceImpl implements IAppointmentService {

	private IAppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    @Override
    public Appointment getAppointmentById(int appointmentId) {
        return appointmentDAO.getAppointmentById(appointmentId);
    }

    @Override
    public List<Appointment> getAppointmentsForPatient(int patientId) {
        return appointmentDAO.getAppointmentsForPatient(patientId);
    }

    @Override
    public List<Appointment> getAppointmentsForDoctor(int doctorId) {
        return appointmentDAO.getAppointmentsForDoctor(doctorId);
    }

    @Override
    public boolean scheduleAppointment(Appointment appointment) {
        return appointmentDAO.scheduleAppointment(appointment);
    }

    @Override
    public boolean updateAppointment(Appointment appointment) {
        return appointmentDAO.updateAppointment(appointment);
    }

    @Override
    public boolean cancelAppointment(int appointmentId) {
        return appointmentDAO.cancelAppointment(appointmentId);
    }
}
