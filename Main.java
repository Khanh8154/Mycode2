import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentManagement management = new StudentManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Choose an option:");
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student");
                System.out.println("3. Delete Student");
                System.out.println("4. Search Student by ID");
                System.out.println("5. Display All Students");
                System.out.println("6. Display Student sort Score");
                System.out.println("7. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        management.addStudent();
                        break;
                    case 2:
                        management.editStudent();
                        break;
                    case 3:
                        management.deleteStudent();
                        break;
                    case 4:
                        management.searchStudent();
                        break;
                    case 5:
                        management.displayStudents();
                        break;
                    case 6:
                        management.displayStudentsSortedByScore();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.nextLine();
            }
        }
    }
}