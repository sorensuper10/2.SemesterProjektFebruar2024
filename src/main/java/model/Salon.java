package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Salon {

    private static final String url = "jdbc:mysql://mysql35.unoeuro.com:3306/krudtraeven_dk_db_BookingSystem";
    private static final String username = "krudtraeven_dk";
    private static final String password = "w5F4be2mGrpnxk3BytDH";

    public void printAppointmentDetails(int appointmentID) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM AppointmentGUI WHERE appointmentID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, appointmentID);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                System.out.println("Aftale ID: " + result.getInt("appointmentID"));
                System.out.println("Dato: " + result.getString("appointmentDate"));
                System.out.println("Tidspunkt: " + result.getString("appointmentTime"));
                System.out.println("Behandling: " + result.getString("treatment"));
                System.out.println("Medarbejder: " + result.getString("employee"));
            } else {
                System.out.println("Aftalen blev ikke fundet.");
            }
        } catch (SQLException e) {
            System.err.println("Fejl ved udskrivning af aftaledetaljer: " + e.getMessage());
        }
    }

    public void editAppointment(int appointmentID, String newDate, String newTime, String newTreatment, String newEmployee) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            StringBuilder sqlBuilder = new StringBuilder("UPDATE AppointmentGUI SET ");
            List<String> updates = new ArrayList<>();
            if (newDate != null && !newDate.isEmpty()) {
                updates.add("appointmentDate = ?");
            }
            if (newTime != null && !newTime.isEmpty()) {
                updates.add("appointmentTime = ?");
            }
            if (newTreatment != null && !newTreatment.isEmpty()) {
                updates.add("treatment = ?");
            }
            if (newEmployee != null && !newEmployee.isEmpty()) {
                updates.add("employee = ?");
            }
            sqlBuilder.append(String.join(", ", updates));
            sqlBuilder.append(" WHERE appointmentID = ?");

            PreparedStatement statement = connection.prepareStatement(sqlBuilder.toString());
            int parameterIndex = 1;
            if (newDate != null && !newDate.isEmpty()) {
                statement.setString(parameterIndex++, newDate);
            }
            if (newTime != null && !newTime.isEmpty()) {
                statement.setString(parameterIndex++, newTime);
            }
            if (newTreatment != null && !newTreatment.isEmpty()) {
                statement.setString(parameterIndex++, newTreatment);
            }
            if (newEmployee != null && !newEmployee.isEmpty()) {
                statement.setString(parameterIndex++, newEmployee);
            }
            statement.setInt(parameterIndex, appointmentID);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Aftalen er opdateret.");
            }
        } catch (SQLException e) {
            System.err.println("Fejl ved opdatering af aftalen: " + e.getMessage());
        }
    }
}
