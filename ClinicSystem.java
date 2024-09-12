
package openendedlab;
import java.util.*;
public class ClinicSystem {
    public static void main(String[] args) {
        // Creating doctor instances
        List<String> gpTimes = new ArrayList<>();
        gpTimes.add("09:00 AM - 12:00 PM");
        gpTimes.add("02:00 PM - 04:00 PM");
        Doctor gp = new GeneralPractitioner("Alice Smith", gpTimes);

        List<String> specialistTimes = new ArrayList<>();
        specialistTimes.add("11:00 AM - 01:00 PM");
        specialistTimes.add("03:00 PM - 05:00 PM");
        Doctor specialist = new Specialist("Bob Johnson", specialistTimes);

        // Display doctor availability
        gp.displayAvailability();
        specialist.displayAvailability();

        // Creating a patient instance
        Patient patient = new Patient("John Doe", "P001");

        // Booking an appointment
        Appointment appointment = new Appointment(gp, patient, "09:30 AM");
        appointment.saveAppointment();

        // Viewing all appointments
        Appointment.viewAppointments();
    }
}
