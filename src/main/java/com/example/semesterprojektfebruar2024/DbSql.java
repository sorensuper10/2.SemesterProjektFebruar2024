package com.example.semesterprojektfebruar2024;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class DbSql {
    public static Connection connection;
    private Statement stmt;
    private Statement stmt1;

    public DbSql() {
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:mysql://mysql35.unoeuro.com:3306/krudtraeven_dk_db_BookingSystem";
            String user = "krudtraeven_dk";
            String password = "w5F4be2mGrpnxk3BytDH";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createLogin(Login l) {
        try {
            String sql = "insert into Login (ID, Username, Password)";
            sql += "values (" + String.valueOf(l.getLoginID()) + ",'" + l.getUsername() + "','" + l.getPassword() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void createEmployee(Employee e) {
        try {
            String sql = "insert into Employee (employeeID, employeeName, employeeSurname, employeePhone, employeeMail)";
            sql += "values (" + String.valueOf(e.getEmployeeID()) + ",'" + e.getEmployeeName() + "','" + e.getEmployeeSurname();
            sql += "','" + e.getEmployeePhone() + "','" + e.getEmployeeMail() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createCustomer(Customer c) {
        try {
            String sql = "insert into Customer (costumerID, customerName, customerSurname, customerPhone, customerMail)";
            sql += "values (" + String.valueOf(c.getCustomerID()) + ",'" + c.getCustomerName() + "','" + c.getCustomerSurname();
            sql += "','" + c.getCustomerPhone() + "','" + c.getCustomerMail() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createAppointment(Appointment a) {
        try {
            String sql = "insert into Appointment (appointmentID , appointmentDate, appointmentTime, treatment, treatmentTime, appointmentAddress,employee,customer,createdat)";
            sql += "values (" + String.valueOf(a.getAppointmentID()) + ",'" + a.getAppointmentDate() + "','" + a.getAppointmentTime();
            sql += "','" + a.getTreatment() + "','" + a.getTreatmentTime() + "','" + a.getAppointmentAddress() + "','";
            sql += a.getCustomername() + "','" + a.getEmployeename() + "','" + a.getT() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public void createAppointment1(Appointment a) {
        try {
            if (!checkForDoubleBooking(a.getAppointmentDate(), a.getAppointmentTime(), a.getEmployeename())) {
                String sql = "insert into AppointmentGUI (appointmentID , appointmentDate, appointmentTime, treatment, treatmentTime,employee,customer)";
                sql += "values (" + String.valueOf(a.getAppointmentID()) + ",'" + a.getAppointmentDate() + "','" + a.getAppointmentTime();
                sql += "','" + a.getTreatment() + "','" + a.getTreatmentTime() + "','";
                sql += a.getEmployeename() + "','" + a.getCustomername() + "')";
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                stmt.close();
                System.out.println("Appointment created successfully.");
            } else {
                System.out.println("Double booking detected. Appointment creation failed.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static boolean checkForDoubleBooking(String appointmentDate, String appointmentTime, String employee) {
        try {
            String sql = "SELECT * FROM AppointmentGUI WHERE appointmentDate = ? AND appointmentTime = ? AND employee = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, appointmentDate);
            preparedStatement.setString(2, appointmentTime);
            preparedStatement.setString(3, employee);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }

    public void editLogin() {
        try {
            System.out.println("Enter the login ID to be updated: ");
            int loginID;
            Scanner scan = new Scanner(System.in);
            loginID = scan.nextInt();

            System.out.println("Do you want to change 'username' or 'password'? ");
            String choice = scan.next().toLowerCase();

            if (choice.equals("username")) {
                System.out.println("Enter the new username: ");
                String newUsername = scan.next();
                String sql = "UPDATE Login SET Username = '" + newUsername + "' WHERE ID = " + String.valueOf(loginID);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Username updated successfully.");
            } else if (choice.equals("password")) {
                System.out.println("Enter the new password: ");
                String newPassword = scan.next();
                String sql = "UPDATE Login SET Password = '" + newPassword + "' WHERE ID = " + String.valueOf(loginID);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Password updated successfully.");
            } else {
                System.out.println("Invalid choice. Please select either 'username' or 'password'.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void editAppointment() {
        try {
            System.out.println("Enter the Appointment ID to be updated: ");
            int appointmentID;
            Scanner scan = new Scanner(System.in);
            appointmentID = scan.nextInt();

            System.out.println("Do you want to change 'date', 'time' ,'treatment' or 'treatmenttime'? ");
            String choice = scan.next().toLowerCase();

            if (choice.equals("date")) {
                System.out.println("Enter the new appointmentdate: ");
                String newDate = scan.next();
                String sql = "UPDATE Appointment SET appointmentDate = '" + newDate + "' WHERE appointmentID = " + String.valueOf(appointmentID);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Appointment updated successfully.");
            } else if (choice.equals("time")) {
                System.out.println("Enter the new time: ");
                String newTime = scan.next();
                String sql = "UPDATE Appointment SET appointmentTime = '" + newTime + "' WHERE appointmentID = " + String.valueOf(appointmentID);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Time updated successfully.");
            } else if (choice.equals("treatment")) {
                System.out.println("Enter the new treatment: ");
                String treatment = scan.next();
                String sql = "UPDATE Appointment SET treatment = '" + treatment + "' WHERE appointmentID = " + String.valueOf(appointmentID);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Treatment has been updated");
            } else if (choice.equals("treatmenttime")) {
                System.out.println("Enter the new treatmenttime: ");
                String treatmenttime = scan.next();
                String sql = "UPDATE Appointment SET treatmentTime = '" + treatmenttime + "' WHERE appointmentID = " + String.valueOf(appointmentID);
                Statement stmt = connection.createStatement();
                stmt.execute(sql);
                System.out.println("Treatment time has been updated");
            } else {
                System.out.println("Invalid choice. Please select either 'appointmentdate' , 'appointmenttime', 'treatment' or 'treatmenttime'.");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList getAllAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        try {
            String sql = "select * from Appointment";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Appointment a = new Appointment();
                a.setAppointmentID(rs.getInt("appointmentID"));
                a.setAppointmentDate(rs.getString("appointmentDate"));
                a.setAppointmentTime(rs.getString("appointmentTime"));
                a.setTreatment(rs.getString("treatment"));
                a.setTreatmentTime(rs.getString("treatmentTime"));
                a.setAppointmentAddress(rs.getString("appointmentAddress"));
                a.setCustomername(rs.getString("employee"));
                a.setEmployeename(rs.getString("customer"));
                appointments.add(a);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return appointments;
    }

    public Appointment getOneAppointment(int appointmentID) {
        Appointment a = new Appointment();
        a.setAppointmentID(appointmentID);
        try {
            String sql = "select * from Appointment where appointmentID=" + String.valueOf(appointmentID);
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            if (rs.next()) {
                a.setAppointmentID(rs.getInt("appointmentID"));
                a.setAppointmentDate(rs.getString("appointmentDate"));
                a.setAppointmentTime(rs.getString("appointmentTime"));
                a.setTreatment(rs.getString("treatment"));
                a.setTreatmentTime(rs.getString("treatmentTime"));
                a.setAppointmentAddress(rs.getString("appointmentAddress"));
                a.setEmployeename(rs.getString("employee"));
                a.setCustomername(rs.getString("customer"));
                a.setT(rs.getTimestamp("createdat"));
                return a;

            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteAppointment(int appointmentID) {
        try {
            String sql = "delete from Appointment where appointmentID=" + String.valueOf(appointmentID);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void bookAppointment(int appointmentID, String appointmentDate, String appointmentTime, String treatment, String treatmentTime, String appointmentAddress, String employeename, String customername) {
        /* // Opret kunde
         String insertCustomerQuery = "INSERT INTO customers (name) VALUES (?)";
         try (PreparedStatement customerStmt = connection.prepareStatement(insertCustomerQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
             customerStmt.setString(1, customer.getCustomerName());
             customerStmt.executeUpdate();

             // Hent den tildelte customer_id
             int customerId;
             try (var generatedKeys = customerStmt.getGeneratedKeys()) {
                 if (generatedKeys.next()) {
                     customerId = generatedKeys.getInt(1);
                 } else {
                     throw new SQLException("Oprettelse af kunde mislykkedes, ingen ID opnået.");
                 }
             }*/

        // Book aftale
        String insertAppointmentQuery = "INSERT INTO Appointment (appointmentID, appointmentDate, appointmentTime,treatment,treatmentTime,appointmentAddress,employee,customer) VALUES (?, ?, ?, ?, ?, ? ,?, ?)";
        try (PreparedStatement appointmentStmt = connection.prepareStatement(insertAppointmentQuery)) {
            appointmentStmt.setInt(1, appointmentID);
            appointmentStmt.setString(2, appointmentDate);
            appointmentStmt.setString(3, appointmentTime);
            appointmentStmt.setString(4, treatment);
            appointmentStmt.setString(5, treatmentTime);
            appointmentStmt.setString(6, appointmentAddress);
            appointmentStmt.setString(7, employeename);
            appointmentStmt.setString(8, customername);
            appointmentStmt.executeUpdate();
            System.out.println("Aftale oprettet!");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /*public void bookAppointmentGUI(Appointment a) {
        try {
            String sql = "INSERT INTO AppointmentGUI (appointmentDate, appointmentTime,treatment,employee)";
            sql += "values (" + (a.getDate()) + ",'" + a.getTime() + "','" + a.getTreatment();
            sql += "','" + a.getEmployeename() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

    public void bookAppointmentGUI(Appointment a) {
        // Antager at a.getDate() returnerer en dato i formatet "yyyy-MM-dd"
        String sql = "INSERT INTO AppointmentGUI (appointmentDate, appointmentTime, treatment, treatmentTime, employee, customer) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Konverterer den modtagne dato til en java.sql.Date
            java.sql.Date sqlDate = java.sql.Date.valueOf(a.getAppointmentDate());
            stmt.setDate(1, sqlDate);
            stmt.setString(2, a.getAppointmentTime());
            stmt.setString(3, a.getTreatment());
            stmt.setString(4, a.getTreatmentTime());
            stmt.setString(5, a.getEmployeename());
            stmt.setString(6, a.getCustomername());
            stmt.executeUpdate();
            System.out.println("Appointment has been created!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void expiredAppointments() {
        String query = "SELECT * FROM Appointment";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                // Get the creation date for each row as an integer (assuming the date field is named "creation_date")
                int creationDate = rs.getInt("appointmentID");

                // Check if the creation date is older than 5 years
                if (isOlderThanSeconds(creationDate, 157784630)) {
                    // Delete the row
                    int id = rs.getInt("appointmentID"); // assuming ID is a unique identifier
                    deleteRow(connection);
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    // Method to check if an integer date is older than the specified number of seconds
    private static boolean isOlderThanSeconds(int dateInSeconds, int seconds) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, -seconds);
        int boundaryDateInSeconds = (int) (calendar.getTimeInMillis() / 1000); // Convert milliseconds to seconds
        return dateInSeconds < boundaryDateInSeconds;
    }

    // Method to delete a row from the database based on its ID
    private static void deleteRow(Connection conn) throws SQLException {
        String deleteQuery = "DELETE FROM Appointment WHERE TIMESTAMPDIFF (SECOND,createdat, NOW()) >= ?";
        try (PreparedStatement stmt = conn.prepareStatement(deleteQuery)) {
            stmt.setInt(1, 30);
            stmt.executeUpdate();
        }
    }

    public static void changeScene(ActionEvent event, String fxmlFile, String title, String userName) {
        Parent root = null;

        if ((userName != null)) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(DbSql.class.getResource(fxmlFile));
                root = fxmlLoader.load();
                LoggedInController loggedInController = fxmlLoader.getController();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }else {
            try{
                FXMLLoader fxmlLoader = new FXMLLoader(DbSql.class.getResource(fxmlFile));
                root = fxmlLoader.load();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle(title);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }

    public static void signUpUser(ActionEvent event, String username, String password){
        Connection connection = null;
        PreparedStatement psinsert = null;
        PreparedStatement pscheckUserExists = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://mysql35.unoeuro.com:3306/krudtraeven_dk_db_BookingSystem", "krudtraeven_dk", "w5F4be2mGrpnxk3BytDH");
            pscheckUserExists = connection.prepareStatement("SELECT * FROM Login WHERE Username = ?");
            pscheckUserExists.setString(1, username);
            resultSet = pscheckUserExists.executeQuery();

            if (resultSet.isBeforeFirst()){
                System.out.println("Username already taken.");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("This username is taken!");
                alert.show();
            }else {
                psinsert = connection.prepareStatement("INSERT INTO Login (Username, Password) VALUES (?, ?)");
                psinsert.setString(1, username);
                psinsert.setString(2, password);
                psinsert.executeUpdate();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("User Registration Successful!");
                alert.show();

                //changeScene(event, "loggedin-view.fxml", "Welcome!", username);
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (pscheckUserExists != null){
                try {
                    pscheckUserExists.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (psinsert != null){
                try {
                    psinsert.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void logInUser(ActionEvent event, String username, String password){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://mysql35.unoeuro.com:3306/krudtraeven_dk_db_BookingSystem", "krudtraeven_dk", "w5F4be2mGrpnxk3BytDH");
            preparedStatement = connection.prepareStatement("SELECT password FROM Login WHERE Username = ?");
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();

            if (!resultSet.isBeforeFirst()){
                System.out.println("User not found in the database!");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Provided credentials are incorrect!");
                alert.show();
            }else {
                while (resultSet.next()){
                    String retrievedPassword = resultSet.getString("password");
                    if (retrievedPassword.equals(password)){
                        changeScene(event, "logged-in.fxml", "Welcome!", username);
                    }else {
                        System.out.println("Password did not match!");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setContentText("Provided credentials are incorrect!");
                        alert.show();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (resultSet != null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null){
                try {
                    preparedStatement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if (connection != null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}