package model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private int appointmentID;
    private String appointmentDate, appointmentTime, appointmentAddress, treatment, treatmentTime;
    private Customer c;

    private Employee e;

    private String employeename;

    private String customername;

    private Timestamp t;

    private LocalDate date;

    private LocalTime time;

    public Appointment(int appointmentID, String appointmentDate, String appointmentTime, String treatment, String treatmentTime, String appointmentAddress, String employeename, String customername, Timestamp t) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.treatment = treatment;
        this.treatmentTime = treatmentTime;
        this.appointmentAddress = appointmentAddress;
        this.employeename = employeename;
        this.customername = customername;
        this.t = t;
    }

    public Appointment(int appointmentID, String appointmentDate, String appointmentTime, String treatment, String treatmentTime, String appointmentAddress, String employeename, String customername) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.treatment = treatment;
        this.treatmentTime = treatmentTime;
        this.appointmentAddress = appointmentAddress;
        this.employeename = employeename;
        this.customername = customername;
    }

    public Appointment(String appointmentDate, String appointmentTime, String treatment, String employeename) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.treatment = treatment;
        this.employeename = employeename;
    }

    public Appointment(LocalDate date, LocalTime time, String treatment, String employeename) {
        this.date = date;
        this.time = time;
        this.treatment = treatment;
        this.employeename = employeename;
    }

    public Appointment(int appointmentID, String appointmentDate, String appointmentTime, String treatment, String treatmentTime, String appointmentAddress, Customer c, Employee e) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.treatment = treatment;
        this.treatmentTime = treatmentTime;
        this.appointmentAddress = appointmentAddress;
        this.c = c;
        this.e = e;
    }

    public Appointment(int appointmentID, String appointmentDate, String appointmentTime, String treatment, String treatmentTime, String appointmentAddress) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.treatment = treatment;
        this.treatmentTime = treatmentTime;
        this.appointmentAddress = appointmentAddress;
    }

    public Appointment(String appointmentDate, String appointmentTime, String treatment, String treatmentTime, String employeename, String customername) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.treatment = treatment;
        this.treatmentTime = treatmentTime;
        this.employeename = employeename;
        this.customername = customername;
    }

    public Appointment(String appointmentDate, String appointmentTime, String treatment, String employeename, String customername) {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.treatment = treatment;
        this.employeename = employeename;
        this.customername = customername;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public Appointment() {
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getTreatmentTime() {
        return treatmentTime;
    }

    public void setTreatmentTime(String treatmentTime) {
        this.treatmentTime = treatmentTime;
    }

    public int getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentAddress() {
        return appointmentAddress;
    }

    public Timestamp getT() {
        return t;
    }

    public void setT(Timestamp t) {
        this.t = t;
    }

    public void setAppointmentAddress(String appointmentAddress) {
        this.appointmentAddress = appointmentAddress;
    }

    public Employee getE() {
        return e;
    }

    public void setE(Employee e) {
        this.e = e;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentID=" + appointmentID +
                ", appointmentDate='" + appointmentDate + '\'' +
                ", appointmentTime='" + appointmentTime + '\'' +
                ", treatment='" + treatment + '\'' +
                ", treatmentTime='" + treatmentTime + '\'' +
                ", appointmentAddress='" + appointmentAddress + '\'' +
                ", employeename='" + employeename + '\'' +
                ", customername='" + customername + '\'' +
                ", t=" + t +
                '}';
    }
}