package com.example.semesterprojektfebruar2024;

import com.example.semesterprojektfebruar2024.DbSql;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class LoggedInController implements Initializable {

    @FXML
    private Button btn_logout;

    @FXML
    private Label label_welcome;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btn_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DbSql.changeScene(actionEvent, "sample.fxml", "Login", null);
            }
        });
    }

    public void changeToBooking(ActionEvent actionEvent){
        DbSql.changeScene(actionEvent,"appointment.fxml","Book",null);
    }
    public void searchAppointment(ActionEvent actionEvent){
        DbSql.changeScene(actionEvent,"searchAppointment.fxml","Search",null);
    }

    public void deleteAppointment(ActionEvent actionEvent){
        DbSql.changeScene(actionEvent,"deleteAppointment.fxml","Delete",null);
    }
}

