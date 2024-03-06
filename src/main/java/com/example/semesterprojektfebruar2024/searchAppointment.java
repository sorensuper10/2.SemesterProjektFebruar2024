package com.example.semesterprojektfebruar2024;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.Appointment;
import model.UseCase;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.ResourceBundle;

public class searchAppointment implements Initializable {

    @FXML
    private TextField appointmentID;

    @FXML
    private TextField appointmentDate;

    @FXML
    private TextField appointmentTime;

    @FXML
    private TextField treatment;

    @FXML
    private TextField treatmentTime;

    @FXML
    private TextField appointmentAddress;

    @FXML
    private TextField employee;

    @FXML
    private TextField customer;

    @FXML
    private TextField createdat;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void backButtonLoggedIn(ActionEvent actionEvent) {
        DbSql.changeScene(actionEvent, "logged-in.fxml", "Back", null);
    }

    @FXML
    protected void searchAppointmentGUI() {
        UseCase u = new UseCase();
        Appointment a = new Appointment();
        String appIdText = appointmentID.getText();
        int appID = Integer.parseInt(appIdText);
        a = u.searchAppointmentGUI(appID);
        appointmentDate.setText(a.getAppointmentDate());
        appointmentTime.setText(a.getAppointmentTime());
        treatment.setText(a.getTreatment());
        treatmentTime.setText(a.getTreatmentTime());
        appointmentAddress.setText(a.getAppointmentAddress());
        employee.setText(a.getEmployeename());
        customer.setText(a.getCustomername());
        // Opret et SimpleDateFormat-objekt med det ønskede format
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Formatér timestampen og udskriv resultatet
        String formattedTimestamp = sdf.format(a.getT());
        String t = String.valueOf(formattedTimestamp);
        createdat.setText(t);
    }
}