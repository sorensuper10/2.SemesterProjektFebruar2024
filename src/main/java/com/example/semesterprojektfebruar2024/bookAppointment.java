package com.example.semesterprojektfebruar2024;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Appointment;
import model.UseCase;
import org.w3c.dom.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class bookAppointment implements Initializable {

    @FXML
    private ComboBox dropdowntime;
    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> dropdowntreatment;

    @FXML
    private ComboBox<String> dropdownemployee;

    @FXML
    private Button book;

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

    public void dateTimePicker() {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (int hour = 10; hour < 16; hour++) {
            for (int minute = 0; minute < 60; minute += 30) {
                String time = String.format("%02d:%02d", hour, minute);
                dropdowntime.getItems().add(time);
            }
        }
        dropdowntreatment.getItems().addAll("Cut hair", "Wash hair", "Shaving");
        dropdownemployee.getItems().addAll("Monika", "Søren", "Morten");
    }


    @FXML
    public void treatment() {
        System.out.println(dropdowntreatment.getValue());
    }

    @FXML
    public void employee() {
        System.out.println(dropdownemployee.getValue());
    }
    /*@FXML
    protected void onOpretBookClickIBook() {
        UseCase u = new UseCase();
        Appointment a = new Appointment();
        String appointmentIDText = appointmentID.getText();
        String appointmentDateText = appointmentDate.getText();
        String appointmentTimeText = appointmentTime.getText();
        String treatmentText = treatment.getText();
        String treatmentTimeText = treatmentTime.getText();
        String appointmentAddressText = appointmentAddress.getText();
        String employeeText = employee.getText();
        String customerText = customer.getText();
        String createdatText = createdat.getText();
        int aID = Integer.parseInt(appointmentIDText);
        u.createAppointmentgrafisk(aID,appointmentDateText,appointmentTimeText,treatmentText,treatmentTimeText,appointmentAddressText,employeeText,customerText,createdatText);
        a.setAppointmentID(aID);
        a.setAppointmentDate(appointmentDateText);
        a.setAppointmentTime(appointmentTimeText);
        a.setTreatment(treatmentText);
        a.setTreatmentTime(treatmentTimeText);
        a.setAppointmentAddress(appointmentAddressText);
        a.setEmployeename(employeeText);
        a.setCustomername(customerText);
        a.setCreatedat(createdatText);
        studerendeOprettet.setText("Studerende er oprettet");
    }*/
}

