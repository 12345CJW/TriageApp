import java.util.ArrayList;
import java.util.Scanner;

public class EarthquakeTriageApp {
    private static Scanner scanner = new Scanner(System.in);
    private static TriageSystem system = new TriageSystem();

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Earthquake Triage System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. Show Patients in Priority Order");
            System.out.println("3. Treat Next Patient");
            System.out.println("4. Update Patient");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = readInt();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    showPatients();
                    break;
                case 3:
                    treatPatient();
                    break;
                case 4:
                    updatePatient();
                    break;
                case 5:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    public static void addPatient() {
        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        System.out.print("Enter patient age: ");
        int age = readInt();
        while (age < 0) {
            System.out.print("Invalid age. Enter a valid age: ");
            age = readInt();
        }

        System.out.print("Enter complaint/injury: ");
        String complaint = scanner.nextLine();

        System.out.print("Enter priority (1 = Immediate, 2 = Urgent, 3 = Delayed, 4 = Lowest): ");
        int priority = readInt();

        while (priority < 1 || priority > 4) {
            System.out.print("Invalid priority. Enter a number from 1 to 4: ");
            priority = readInt();
        }

        system.addPatient(name, age, complaint, priority);
        System.out.println("Patient added successfully.");
    }

    public static void showPatients() {
        if (system.isEmpty()) {
            System.out.println("No patients in the waiting list.");
            return;
        }

        ArrayList<Patient> patients = system.getAllPatients();

        System.out.println("\nPatients in Priority Order:");
        for (Patient patient : patients) {
            System.out.println(patient);
        }

        System.out.println("Total patients waiting: " + system.getWaitingCount());
    }

    public static void treatPatient() {
        if (system.isEmpty()) {
            System.out.println("No patients to treat.");
            return;
        }

        Patient treatedPatient = system.treatAndRemovePatient();

        System.out.println("Patient successfully treated and removed from the waiting list:");
        System.out.println(treatedPatient);
        System.out.println("Remaining patients waiting: " + system.getWaitingCount());
    }

    public static void updatePatient() {
        if (system.isEmpty()) {
            System.out.println("No patients in the waiting list.");
            return;
        }

        System.out.print("Enter the name of the patient to update: ");
        String name = scanner.nextLine();

        System.out.print("Enter new age: ");
        int newAge = readInt();
        while (newAge < 0) {
            System.out.print("Invalid age. Enter a valid age: ");
            newAge = readInt();
        }

        System.out.print("Enter new complaint/injury: ");
        String newComplaint = scanner.nextLine();

        System.out.print("Enter new priority (1-4): ");
        int newPriority = readInt();

        while (newPriority < 1 || newPriority > 4) {
            System.out.print("Invalid priority. Enter a number from 1 to 4: ");
            newPriority = readInt();
        }

        boolean updated = system.updatePatient(name, newAge, newComplaint, newPriority);

        if (updated) {
            System.out.println("Patient updated successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    public static int readInt() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Enter a number: ");
            scanner.next();
        }
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}