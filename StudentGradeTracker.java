import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double marks;

    Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentGradeTracker {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n================================");
            System.out.println("      STUDENT GRADE TRACKER");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Show Grade Statistics");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    showStatistics();
                    break;

                case 4:
                    System.out.println("\nThank you for using Student Grade Tracker!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to add a student
    static void addStudent() {

        System.out.print("\nEnter student name: ");
        String name = scanner.nextLine();

        double marks;

        while (true) {
            System.out.print("Enter marks (0-100): ");
            marks = scanner.nextDouble();

            if (marks >= 0 && marks <= 100) {
                break;
            }

            System.out.println("Invalid marks! Please enter marks between 0 and 100.");
        }

        scanner.nextLine();

        students.add(new Student(name, marks));

        System.out.println("Student added successfully!");
    }

    // Method to display all students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records available.");
            return;
        }

        System.out.println("\n========== STUDENT RECORDS ==========");

        for (int i = 0; i < students.size(); i++) {

            Student student = students.get(i);

            System.out.printf(
                    "%d. %-20s %.2f%n",
                    i + 1,
                    student.name,
                    student.marks
            );
        }
    }

    // Method to calculate and display statistics
    static void showStatistics() {

        if (students.isEmpty()) {
            System.out.println("\nNo student records available.");
            return;
        }

        double total = 0;
        double highest = students.get(0).marks;
        double lowest = students.get(0).marks;

        String highestStudent = students.get(0).name;
        String lowestStudent = students.get(0).name;

        for (Student student : students) {

            total += student.marks;

            if (student.marks > highest) {
                highest = student.marks;
                highestStudent = student.name;
            }

            if (student.marks < lowest) {
                lowest = student.marks;
                lowestStudent = student.name;
            }
        }

        double average = total / students.size();

        System.out.println("\n========== GRADE SUMMARY ==========");
        System.out.printf("Total Students : %d%n", students.size());
        System.out.printf("Average Marks  : %.2f%n", average);
        System.out.printf("Highest Marks  : %.2f (%s)%n",
                highest, highestStudent);
        System.out.printf("Lowest Marks   : %.2f (%s)%n",
                lowest, lowestStudent);
    }
}