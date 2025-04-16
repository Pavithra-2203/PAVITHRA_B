package com.hexaware.hms.main;

import java.util.List;
import java.util.Scanner;

import com.hexaware.hms.entity.Appointment;
import com.hexaware.hms.service.*;
import com.hexaware.hms.exception.*;
public class Main {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IAppointmentService service = new AppointmentServiceImpl();

        while (true) {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Get Appointment by ID");
            System.out.println("2. Get Appointments for Patient");
            System.out.println("3. Get Appointments for Doctor");
            System.out.println("4. Schedule New Appointment");
            System.out.println("5. Update Appointment");
            System.out.println("6. Cancel Appointment");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Appointment ID: ");
                        int appId = scanner.nextInt();
                        Appointment app = service.getAppointmentById(appId);
                        if (app != null) {
                            System.out.println("Appointment Details: " + app);
                        } else {
                            System.out.println("No appointment found with ID: " + appId);
                        }
                        break;

                    case 2:
                        System.out.print("Enter Patient ID: ");
                        int patientId = scanner.nextInt();
                        List<Appointment> patientAppointments = service.getAppointmentsForPatient(patientId);
                        if (patientAppointments.isEmpty()) {
                            throw new PatientNumberNotFoundException("No appointments found for Patient ID: " + patientId);
                        }
                        patientAppointments.forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("Enter Doctor ID: ");
                        int doctorId = scanner.nextInt();
                        List<Appointment> doctorAppointments = service.getAppointmentsForDoctor(doctorId);
                        if (doctorAppointments.isEmpty()) {
                            System.out.println("No appointments found for Doctor ID: " + doctorId);
                        } else {
                            doctorAppointments.forEach(System.out::println);
                        }
                        break;

                    case 4:
                        System.out.print("Enter Appointment ID: ");
                        int newAppId = scanner.nextInt();
                        System.out.print("Enter Patient ID: ");
                        int newPatId = scanner.nextInt();
                        System.out.print("Enter Doctor ID: ");
                        int newDocId = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
                        String date = scanner.nextLine();
                        System.out.print("Enter Description: ");
                        String desc = scanner.nextLine();

                        Appointment newApp = new Appointment(newAppId, newPatId, newDocId, date, desc);
                        if (service.scheduleAppointment(newApp)) {
                            System.out.println("Appointment scheduled successfully.");
                        } else {
                            System.out.println("Failed to schedule appointment.");
                        }
                        break;

                    case 5:
                        System.out.print("Enter Appointment ID to Update: ");
                        int updId = scanner.nextInt();
                        System.out.print("Enter New Patient ID: ");
                        int updPat = scanner.nextInt();
                        System.out.print("Enter New Doctor ID: ");
                        int updDoc = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter New Appointment Date (yyyy-mm-dd): ");
                        String updDate = scanner.nextLine();
                        System.out.print("Enter New Description: ");
                        String updDesc = scanner.nextLine();

                        Appointment updApp = new Appointment(updId, updPat, updDoc, updDate, updDesc);
                        if (service.updateAppointment(updApp)) {
                            System.out.println("Appointment updated successfully.");
                        } else {
                            System.out.println("Failed to update appointment.");
                        }
                        break;

                    case 6:
                        System.out.print("Enter Appointment ID to Cancel: ");
                        int cancelId = scanner.nextInt();
                        if (service.cancelAppointment(cancelId)) {
                            System.out.println("Appointment cancelled successfully.");
                        } else {
                            System.out.println("Failed to cancel appointment.");
                        }
                        break;

                    case 7:
                        System.out.println("Exiting... Thank you!");
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid option. Please try again.");
                }

            } catch (PatientNumberNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

}
