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
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class bookAppointment implements Initializable {

    @FXML
    private ComboBox dropdowntime;
    @FXML
    private DatePicker datePicker;

    @FXML
    private ComboBox<String> dropdowntreatment;

    @FXML
    private ComboBox<String> dropdowntreatmenttime;

    @FXML
    private ComboBox<String> dropdownemployee;

    @FXML
    private TextField costumer;

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

    @FXML
    private Label appointmentCreated;

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
        dropdownemployee.getItems().addAll("Monika", "SuperSøren", "Morten");
        dropdowntreatmenttime.getItems().addAll("10 min", "15 min", "20 min", "30 min");
    }

    @FXML
    public void date() {
        System.out.println(datePicker.getValue());
    }

    @FXML
    public void time() {
        System.out.println(dropdowntime.getValue());
    }

    @FXML
    public void treatment() {
        System.out.println(dropdowntreatment.getValue());
    }

    @FXML
    public void treatmentTime() {
        System.out.println(dropdowntreatmenttime.getValue());
    }

    @FXML
    public void employee() {
        System.out.println(dropdownemployee.getValue());
    }

    @FXML
    public void customer() {
        System.out.println(costumer.getText());

    }
    @FXML
    protected void onOpretBookClickIBook() {
        //UseCase u = new UseCase();
        /*LocalDate l = (LocalDate) datePicker.getValue();
        LocalTime lt = LocalTime.parse((CharSequence) dropdowntime.getValue());
        String treatment = dropdowntreatment.getValue();
        String employee = dropdownemployee.getValue();
        System.out.println(l);
        System.out.println(lt);
        System.out.println(treatment);
        System.out.println(employee);
        Appointment a = new Appointment(l,lt,treatment,employee);
        u.createAppointmentGUI(a);


      */
        UseCase u = new UseCase();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Definerer formatter med det ønskede format
        LocalDate l = datePicker.getValue(); // Casting er ikke nødvendig her
        String formattedDate = l.format(formatter); // Anvender formatter til at formatere datoen
        LocalTime lt = LocalTime.parse(dropdowntime.getValue().toString()); // Antager at dropdowntime.getValue() returnerer en String, casting til CharSequence er ikke nødvendig
        String treatment = dropdowntreatment.getValue();
        String treatmenttime = dropdowntreatmenttime.getValue();
        String employee = dropdownemployee.getValue();
        String customer = costumer.getText();
        System.out.println(formattedDate); // Udskriver den formaterede dato
        System.out.println(lt);
        System.out.println(treatment);
        System.out.println(treatmenttime);
        System.out.println(employee);
        System.out.println(formattedDate);
        System.out.println(customer);
        Appointment a = new Appointment(formattedDate, String.valueOf(lt), treatment, treatmenttime, employee,customer);
        //System.out.println(a);
        u.createAppointmentGUI(a);













        /*//String appointmentIDText = appointmentID.getText();
        String appointmentDateText = datePicker.getAccessibleText();
        String appointmentTimeText = dropdowntime.getAccessibleText();
        String treatmentText = dropdowntreatment.getAccessibleText();
        //String treatmentTimeText = treatmentTime.getText();
        //String appointmentAddressText = appointmentAddress.getText();
        String employeeText = dropdownemployee.getAccessibleText();
        //String customerText = customer.getText();
        //String createdatText = createdat.getText();
        //int aID = Integer.parseInt(appointmentIDText);
        u.createAppointmentGUI(appointmentDateText,appointmentTimeText,treatmentText,employeeText);
        //a.setAppointmentID(aID);
        a.setAppointmentDate(appointmentDateText);
        a.setAppointmentTime(appointmentTimeText);
        a.setTreatment(treatmentText);
        //a.setTreatmentTime(treatmentTimeText);
        //a.setAppointmentAddress(appointmentAddressText);
        a.setEmployeename(employeeText);
        //a.setCustomername(customerText);
        appointmentCreated.setText("Appointment has been booked.");*/
    }
    public void backButtonLoggedIn(ActionEvent actionEvent){
        DbSql.changeScene(actionEvent,"logged-in.fxml","Back",null);
    }
}

