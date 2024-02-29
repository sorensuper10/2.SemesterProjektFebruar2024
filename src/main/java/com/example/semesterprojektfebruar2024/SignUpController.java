package com.example.semesterprojektfebruar2024;

import dal.DbSql;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    @FXML
    private Button btn_signup;
    @FXML
    private Button btn_login;
    @FXML
    private TextField tf_username;
    @FXML
    private TextField tf_password;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup toggleGroup = new ToggleGroup();
        btn_signup.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String toggleName = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
                if (!tf_username.getText().trim().isEmpty() && !tf_password.getText().trim().isEmpty()){
                    DbSql.signUpUser(event, tf_username.getText(), tf_password.getText());
                } else {
                    System.out.println("Please fill in all information.");
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Please fill in all information to sign up.");
                    alert.show();

                }
            }
        });

        btn_login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                DbSql.changeScene(event, "sample.fxml","Log in",null);
            }
        });
    }
}
