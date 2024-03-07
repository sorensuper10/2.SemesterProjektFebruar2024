package model;

import com.example.semesterprojektfebruar2024.DbSql;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("To close the program press 0");
        System.out.println("1. Create Login");
        System.out.println("2. Create Employee");
        System.out.println("3. Create Customer");
        System.out.println("4. Create Appointment");
        System.out.println("5. Edit Login");
        System.out.println("6. Edit Appointment");
        System.out.println("7. Get all appointments");
        System.out.println("8. Search one appointment");
        System.out.println("9. Delete appointment");
        System.out.println("10. Book appointment");
        System.out.println("11. Delete appointments after 5 years");
        System.out.println("12. Search and edit appointment");
        System.out.println("13. Check if appointment is double booked in Database");

        //System.out.println("6. Edit Employee");
        //System.out.println("7. Edit Customer");

        DbSql db = new DbSql();
        UseCase u = new UseCase();

        Login l = new Login(1,"Soren","1234");
        Employee e = new Employee(1, "Søren", "Hansen", "12345678", "sorenhansen@gmail.com");
        Customer c = new Customer(1, "Morten", "Andersen", "11111111", "mail@mail.dk");
        Appointment a = new Appointment(1,"2024-03-08","10:00","Barbering","15 min","Vej 2","Soren","Morten", Timestamp.from(Instant.now()));

        boolean exit = false;

        Scanner input = new Scanner(System.in);

        while (!exit) {
            int valg = input.nextInt();

            switch (valg) {
                case 1:
                    u.createLogin(l);
                    System.out.println("Login has been created!");
                    break;
                case 2:
                    u.createEmployee(e);
                    System.out.println("Employee has been created!");
                    break;
                case 3:
                    u.createCustomer(c);
                    System.out.println("Customer has been created!");
                    break;
                case 4:
                    u.createAppointment(a);
                    System.out.println("Appointment has been created!");
                    break;
                case 5:
                    u.editLogin();
                    System.out.println("Login has been changed");
                    break;
                case 6:
                    u.editAppointment();
                    System.out.println("Appointment has been changed");
                    break;
                case 7:
                    ArrayList<Appointment> appointments;
                    appointments = u.getAllAppointments();
                    for (int i = 0; i < appointments.size(); i++) {
                        System.out.println(appointments.get(i));
                    }
                    break;
                case 8:
                    System.out.println(u.getOneAppointment(1));
                    break;
                case 9:
                    u.deleteAppointment(3);
                    System.out.println("Appointment has been deleted");
                    break;
                case 10:
                    System.out.print("Submit ID");
                    int appointmentID = input.nextInt();
                    input.nextLine();
                    System.out.print("Submit Date");
                    String appointmentDate = input.nextLine();
                    System.out.print("Submit Time:");
                    String appointmentTime = input.nextLine();
                    System.out.print("Submit treatment");
                    String treatment = input.nextLine();
                    System.out.print("Submit treatment time");
                    String treatmentTime = input.nextLine();
                    System.out.print("Submit Address");
                    String appointmentAddress = input.nextLine();
                    System.out.println("Submit employeename");
                    String employeeName = input.nextLine();
                    System.out.println("Submit customername");
                    String customername = input.nextLine();
                    u.bookAppointment(appointmentID,appointmentDate,appointmentTime, treatment,treatmentTime,appointmentAddress,employeeName,customername);
                    break;
                case 11:
                    u.expiredAppointments();
                    System.out.println("Appointments older than 5 years has been deleted");
                    break;
                case 12:
                    EditAppointment.main(args);
                    break;
                case 13:
                    db.createAppointmentConsole(a);
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}