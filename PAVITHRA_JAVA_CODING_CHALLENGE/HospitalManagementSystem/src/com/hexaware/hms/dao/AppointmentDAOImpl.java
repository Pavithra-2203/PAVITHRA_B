package com.hexaware.hms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.util.DBConnUtil;

public class AppointmentDAOImpl implements IAppointmentDAO {
	
	 @Override
	    public Appointment getAppointmentById(int appointmentId) {
	        Appointment appt = null;
	        try (Connection con = DBConnUtil.getConnection()) {
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM appointment WHERE appointmentId = ?");
	            ps.setInt(1, appointmentId);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                appt = new Appointment(
	                        rs.getInt("appointmentId"),
	                        rs.getInt("patientId"),
	                        rs.getInt("doctorId"),
	                        rs.getString("appointmentDate"),
	                        rs.getString("description")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return appt;
	    }

	    @Override
	    public List<Appointment> getAppointmentsForPatient(int patientId) {
	        List<Appointment> list = new ArrayList<>();
	        try (Connection con = DBConnUtil.getConnection()) {
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM appointment WHERE patientId = ?");
	            ps.setInt(1, patientId);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new Appointment(
	                        rs.getInt("appointmentId"),
	                        rs.getInt("patientId"),
	                        rs.getInt("doctorId"),
	                        rs.getString("appointmentDate"),
	                        rs.getString("description")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    @Override
	    public List<Appointment> getAppointmentsForDoctor(int doctorId) {
	        List<Appointment> list = new ArrayList<>();
	        try (Connection con = DBConnUtil.getConnection()) {
	            PreparedStatement ps = con.prepareStatement("SELECT * FROM appointment WHERE doctorId = ?");
	            ps.setInt(1, doctorId);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                list.add(new Appointment(
	                        rs.getInt("appointmentId"),
	                        rs.getInt("patientId"),
	                        rs.getInt("doctorId"),
	                        rs.getString("appointmentDate"),
	                        rs.getString("description")
	                ));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }

	    @Override
	    public boolean scheduleAppointment(Appointment appointment) {
	        try (Connection con = DBConnUtil.getConnection()) {
	            PreparedStatement ps = con.prepareStatement("INSERT INTO appointment VALUES (?, ?, ?, ?, ?)");
	            ps.setInt(1, appointment.getAppointmentId());
	            ps.setInt(2, appointment.getPatientId());
	            ps.setInt(3, appointment.getDoctorId());
	            ps.setString(4, appointment.getAppointmentDate());
	            ps.setString(5, appointment.getDescription());
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public boolean updateAppointment(Appointment appointment) {
	        try (Connection con = DBConnUtil.getConnection()) {
	            PreparedStatement ps = con.prepareStatement("UPDATE appointment SET patientId=?, doctorId=?, appointmentDate=?, description=? WHERE appointmentId=?");
	            ps.setInt(1, appointment.getPatientId());
	            ps.setInt(2, appointment.getDoctorId());
	            ps.setString(3, appointment.getAppointmentDate());
	            ps.setString(4, appointment.getDescription());
	            ps.setInt(5, appointment.getAppointmentId());
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

	    @Override
	    public boolean cancelAppointment(int appointmentId) {
	        try (Connection con = DBConnUtil.getConnection()) {
	            PreparedStatement ps = con.prepareStatement("DELETE FROM appointment WHERE appointmentId = ?");
	            ps.setInt(1, appointmentId);
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }

}
