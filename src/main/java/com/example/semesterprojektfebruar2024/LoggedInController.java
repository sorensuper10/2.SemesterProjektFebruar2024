package com.example.semesterprojektfebruar2024;

import dal.DbSql;
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
    public void initialize(URL location, ResourceBundle resources) {
        btn_logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DbSql.changeScene(event, "sample.fxml","Log in!",null);
            }
        });
    }

    public void setUserInformation(String username) {
        label_welcome.setText("Welcome " + username + "!");
    }
}
