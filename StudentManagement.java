import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    private BinarySearchTree bst = new BinarySearchTree();
    private Scanner scanner = new Scanner(System.in);
    public void addStudent() {
        while (true)
        try
        {
            Integer studentID = null;
            String fullName = null;
            Double score = null;

            while (studentID == null)
            try {
                System.out.print("Enter Student ID: ");
                studentID = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format. Please enter a numeric value.");
            }

            while (fullName == null)
            try {
                System.out.print("Enter Full Name: ");
                fullName = scanner.nextLine();
                if (fullName.matches("[a-zA-Z]+"))
                {
                    System.out.println("Success");
                }
                else
                {
                    System.out.println("Invalid Name format. Please enter only alphabets.");
                    fullName = null;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Name format. Please  re-enter.");
            }

            while (score == null || score < 0 || score > 10)
            try {
                System.out.print("Enter Score: ");
                score = Double.parseDouble(scanner.nextLine());
                if(score < 0 || score > 10)
                {
                    System.out.println("Pleas re-enter Score!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid score format. Please enter a numeric value.");
            }

            Student student = new Student(studentID, fullName, score);
            bst.add(student);
            System.out.println("Student added successfully.");
            break;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input format. Please enter a numeric value for ID and Score.");
            break;
        }
        catch (Exception e)
        {
            System.out.println("An error occurred while adding the student: " + e.getMessage());
            break;
        }
    }
    public void editStudent() {
        try {
            System.out.print("Enter Student ID to edit: ");
            Integer studentID = scanner.nextInt();
            Student student = bst.search(studentID);
            if (student != null) {
                System.out.print("Enter new Full Name: ");
                student.updateFullName(scanner.nextLine());
                System.out.print("Enter new Score: ");
                double newScore = Double.parseDouble(scanner.nextLine());
                student.updateScore(newScore);
                System.out.println("Student information updated.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid score format. Please enter a numeric value.");
        } catch (Exception e) {
            System.out.println("An error occurred while editing the student: " + e.getMessage());
        }
    }
    public void deleteStudent() {
        try {
            System.out.print("Enter Student ID to delete: ");
            Integer studentID = scanner.nextInt();
            bst.delete(studentID);
            System.out.println("Student deleted if ID matched.");
        }
        catch (Exception e) {
            System.out.println("An error occurred while deleting the student: " + e.getMessage());
        }
    }
    public void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        Integer studentID = scanner.nextInt();
        Student student = bst.search(studentID);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayStudents() {
        System.out.println("Student List (In-Order Traversal):");
        bst.inOrderTraversal();
    }
    public void displayStudentsSortedByScore() {
        System.out.println("Student List (Sorted by Score):");
        ArrayList<Student> students = bst.toArrayList();
        bubbleSortByScore(students);
        for (Student student : students) {
            System.out.println(student);
        }
    }
    private void bubbleSortByScore(ArrayList<Student> students) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getScore() > students.get(j + 1).getScore()) {

                    Student temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
    }
}
