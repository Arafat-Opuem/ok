
package openendedlab;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Base Doctor Class
abstract class Doctor {
    private String name;
    private String specialization;
    private List<String> availableTimes;

    public Doctor(String name, String specialization, List<String> availableTimes) {
        this.name = name;
        this.specialization = specialization;
        this.availableTimes = availableTimes;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<String> getAvailableTimes() {
        return availableTimes;
    }

    public void setAvailableTimes(List<String> availableTimes) {
        this.availableTimes = availableTimes;
    }

    // Abstract method to display availability (to be overridden)
    public abstract void displayAvailability();
}

// Derived class for General Practitioner
class GeneralPractitioner extends Doctor {
    public GeneralPractitioner(String name, List<String> availableTimes) {
        super(name, "General Practitioner", availableTimes);
    }

    @Override
    public void displayAvailability() {
        System.out.println("Dr. " + getName() + 
                " (General Practitioner) is available for walk-in patients at: "
                + getAvailableTimes());
    }
}

// Derived class for Specialist
class Specialist extends Doctor {
    public Specialist(String name, List<String> availableTimes) {
        super(name, "Specialist", availableTimes);
    }

    @Override
    public void displayAvailability() {
        System.out.println("Dr. " + getName() +
                " (Specialist) requires appointment confirmation. "
                        + "Available times: "
                + getAvailableTimes());
    }
}

// Patient Class
class Patient {
    private String name;
    private String patientId;

    public Patient(String name, String patientId) {
        this.name = name;
        this.patientId = patientId;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }
}

// Appointment Class
class Appointment {
    private Doctor doctor;
    private Patient patient;
    private String appointmentTime;

    public Appointment(Doctor doctor, Patient patient, String appointmentTime) {
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
        
        
    }

    // Save appointment details to a file
    public void saveAppointment() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("appointments.txt", true))) {
            writer.write("Appointment: " + doctor.getName() + " (" + doctor.getSpecialization() + ") with " + patient.getName() +
                    " (ID: " + patient.getPatientId() + ") at " + appointmentTime + "\n");
            System.out.println("Appointment saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving appointment: " + e.getMessage());
        }
    }

    // Static method to view all appointments
    public static void viewAppointments() {
        try (BufferedReader reader = new BufferedReader(new FileReader("appointments.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading appointments: " + e.getMessage());
        }
    }
}