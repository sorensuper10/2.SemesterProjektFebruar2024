package model;

import com.example.semesterprojektfebruar2024.DbSql;

import java.sql.Timestamp;
import java.util.ArrayList;

public class UseCase {

    public void createLogin(Login l){
        DbSql db = new DbSql();
        db.createLogin(l);
    }

    public void createEmployee(Employee e) {
        DbSql db = new DbSql();
        db.createEmployee(e);
    }
    public void createCustomer(Customer c) {
        DbSql db = new DbSql();
        db.createCustomer(c);
    }

    public void createAppointment(Appointment a) {
        DbSql db = new DbSql();
        db.createAppointment(a);
    }

    public void editLogin() {
        DbSql db = new DbSql();
        db.editLogin();
    }

    public void editAppointment() {
        DbSql db = new DbSql();
        db.editAppointment();
    }
    public ArrayList getAllAppointments(){
        ArrayList<Appointment> appointments;
        DbSql db = new DbSql();
        appointments = db.getAllAppointments();
        return appointments;
    }
    public Appointment getOneAppointment(int appointmentID){
        Appointment a;
        DbSql db = new DbSql();
        a = db.getOneAppointment(appointmentID);
        return a;
    }

    public void deleteAppointment(int appointmentID) {
        DbSql db = new DbSql();
        db.deleteAppointment(appointmentID);
    }

    public void bookAppointment(int appointmentID, String appointmentDate, String appointmentTime, String treatment, String treatmentTime, String appointmentAddress, String employeename, String customername) {
        DbSql db = new DbSql();
        db.bookAppointment(appointmentID,appointmentDate,appointmentTime,treatment,treatmentTime,appointmentAddress,employeename,customername);
    }

    public void expiredAppointments() {
        DbSql db = new DbSql();
        db.expiredAppointments();
    }

    /*public void createAppointmentgrafisk(int appointmentID, String appointmentdate,String appointmenttime, String treatment, String treatmentTime, String appointmentAddress, String employee, String customer, Timestamp createdat ) {
        Appointment a = new Appointment(appointmentID,appointmentdate,appointmenttime,treatment,treatmentTime,appointmentAddress,employee,customer,createdat);
        DbSql db = new DbSql();
        db.bookAppointment(a);
    }*/
}
