package model;

import java.util.Scanner;

public class EditAppointment {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Salon salon = new Salon();

        System.out.println("Indtast ID for aftalen, du vil redigere:");
        int appointmentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Udskriv detaljer om den valgte aftale
        salon.printAppointmentDetails(appointmentID);

        // Spørg brugeren om de ønsker at ændre alle informationer eller kun én information?
        System.out.println("Ønsker du at ændre alle informationer eller kun én information?");
        System.out.println("1. Jeg vil ændre alle informationer");
        System.out.println("2. Jeg vil kun ændre én information");
        int editChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (editChoice == 1) {
            System.out.println("Indtast ny dato:");
            String newDate = scanner.nextLine();

            System.out.println("Indtast nyt tidspunkt:");
            String newTime = scanner.nextLine();

            System.out.println("Indtast ny behandling:");
            String newTreatment = scanner.nextLine();

            System.out.println("Indtast ny medarbejder:");
            String newEmployee = scanner.nextLine();

            salon.editAppointment(appointmentID, newDate, newTime, newTreatment, newEmployee);
        } else if (editChoice == 2) {
            System.out.println("Vælg hvad du vil ændre:");
            System.out.println("1. Dato");
            System.out.println("2. Tidspunkt");
            System.out.println("3. Behandling");
            System.out.println("4. Medarbejder");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            String newDate = null;
            String newTime = null;
            String newTreatment = null;
            String newEmployee = null;

            switch (option) {
                case 1:
                    System.out.println("Indtast ny dato:");
                    newDate = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Indtast nyt tidspunkt:");
                    newTime = scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Indtast ny behandling:");
                    newTreatment = scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Indtast ny medarbejder:");
                    newEmployee = scanner.nextLine();
                    break;
                default:
                    System.out.println("Ugyldigt valg. Lukker programmet.");
                    return;
            }

            salon.editAppointment(appointmentID, newDate, newTime, newTreatment, newEmployee);
        } else {
            System.out.println("Ugyldigt valg. Lukker programmet.");
        }
    }
}
