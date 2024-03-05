package com.example.semesterprojektfebruar2024;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.UseCase;

import java.net.URL;
import java.util.ResourceBundle;

public class deleteAppointment implements Initializable {

    @FXML
    private TextField appointmentID;

    @FXML
    private Label appointmentDeleted;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void backButtonLoggedIn(ActionEvent actionEvent){
        DbSql.changeScene(actionEvent,"logged-in.fxml","Back",null);
    }

    @FXML
    protected void deleteAppointmentClick() {
        UseCase u = new UseCase();
        String appIDText = appointmentID.getText();
        int a = Integer.parseInt(appIDText);
        u.deleteAppointmentGUI(a);
        appointmentDeleted.setText("Appointment has been deleted.");
    }
}

