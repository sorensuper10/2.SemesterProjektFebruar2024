package model;

import java.util.ArrayList;
import java.util.HashMap;

public class SalonBookingSystem {

    private static final int TOTAL_SLOTS = 24 * 2; // Totalt antal halve timer på dagen
    private static final int MINIMUM_INTERVAL = 30; // Minimum interval mellem bookinger i minutter
    private HashMap<String, ArrayList<Appointment>> appointmentsByDate;

    public SalonBookingSystem() {
        appointmentsByDate = new HashMap<>();
    }

    public void bookAppointment(int appointmentID, String appointmentDate, String appointmentTime, String treatment, String treatmentTime, String appointmentAddress, String employeename, String customername) {
        if (!appointmentsByDate.containsKey(appointmentDate)) {
            appointmentsByDate.put(appointmentDate, new ArrayList<>());
        }

        if (isTimeAvailable(appointmentDate, appointmentTime)) {
            if (isMinimumIntervalFulfilled(appointmentDate, appointmentDate)) {
                appointmentsByDate.get(appointmentDate).add(new Appointment(appointmentID,appointmentDate, appointmentTime, treatment,treatmentTime,appointmentAddress,employeename,customername));
                System.out.println("Aftalen er booket for " + Customer.getCustomerName() + " på " + appointmentDate + " kl. " + appointmentTime);
            } else {
                System.out.println("Beklager, mindst 30 minutters interval kræves mellem bookinger. Vælg en anden tid.");
            }
        } else {
            System.out.println("Beklager, tiden er allerede booket. Vælg en anden tid.");
        }
    }

    private boolean isTimeAvailable(String date, String time) {
        if (!appointmentsByDate.containsKey(date)) {
            return true; // Der er ingen bookinger på den pågældende dato
        }

        for (Appointment appointment : appointmentsByDate.get(date)) {
            if (appointment.getAppointmentTime().equals(time)) {
                return false; // Tiden er allerede booket
            }
        }
        return true; // Tiden er ledig
    }

    private boolean isMinimumIntervalFulfilled(String date, String time) {
        if (!appointmentsByDate.containsKey(date)) {
            return true; // Der er ingen bookinger på den pågældende dato
        }

        int newTimeInMinutes = convertToMinutes(time);

        for (Appointment appointment : appointmentsByDate.get(date)) {
            int appointmentTimeInMinutes = convertToMinutes(appointment.getAppointmentTime());

            if (Math.abs(newTimeInMinutes - appointmentTimeInMinutes) < MINIMUM_INTERVAL) {
                return false; // Mindre end minimumsintervallet
            }
        }
        return true; // Minimumsintervallet er opfyldt
    }

    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    public void displayAppointments() {
        System.out.println("Bookede aftaler:");
        for (String date : appointmentsByDate.keySet()) {
            System.out.println("Dato: " + date);
            for (Appointment appointment : appointmentsByDate.get(date)) {
                System.out.println("Tid: " + appointment.getAppointmentTime() + " - " + appointment.getC().getCustomerName());
            }
            System.out.println();
        }
    }
}

