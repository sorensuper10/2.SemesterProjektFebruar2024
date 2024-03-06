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
        System.out.println("6. Edit Employee");
        System.out.println("7. Edit Customer");
        System.out.println("8. Edit Appointment");
        System.out.println("9. Get all appointments");
        System.out.println("10. Search one appointment");
        System.out.println("11. Delete appointment");
        System.out.println("12. Book appointment");
        System.out.println("13. Delete appointments after 30 seconds");
        System.out.println("14. Search and edit appointment");
        System.out.println("15. Check if appointment is double booked in Database");

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
                case 8:
                    u.editAppointment();
                    System.out.println("Appointment has been changed");
                    break;
                case 9:
                    ArrayList<Appointment> appointments;
                    appointments = u.getAllAppointments();
                    for (int i = 0; i < appointments.size(); i++) {
                        System.out.println(appointments.get(i));
                    }
                    break;
                case 10:
                    System.out.println(u.getOneAppointment(1));
                    break;
                case 11:
                    u.deleteAppointment(3);
                    System.out.println("Appointment has been deleted");
                    break;
                case 12:
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
                case 13:
                    u.expiredAppointments();
                    System.out.println("Appointments older than 5 years has been deleted");
                    break;
                case 14:
                    EditAppointment.main(args);
                    break;
                case 15:
                    db.createAppointment1(a);
                    break;
                default:
                    System.exit(0);
            }
        }
    }
}