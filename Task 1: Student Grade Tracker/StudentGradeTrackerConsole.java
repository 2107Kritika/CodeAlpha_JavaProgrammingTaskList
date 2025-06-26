import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int grade;

    Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }
}

public class StudentGradeTrackerConsole {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n==== Student Grade Tracker ====");
            System.out.println("1. Add Student");
            System.out.println("2. Show Summary");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = getIntInput();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    showSummary();
                    break;
                case 3:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose 1–3.");
            }
        } while (choice != 3);
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student grade (0–100): ");
        int grade = getIntInput();

        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade. Please enter a number between 0 and 100.");
            return;
        }

        studentList.add(new Student(name, grade));
        System.out.println("Student added successfully.");
    }

    private static void showSummary() {
        if (studentList.isEmpty()) {
            System.out.println("No student data available.");
            return;
        }

        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;

        System.out.println("\n--- Student Report ---");
        for (Student s : studentList) {
            System.out.println(s.name + " - " + s.grade);
            total += s.grade;
            if (s.grade > highest) highest = s.grade;
            if (s.grade < lowest) lowest = s.grade;
        }

        double average = total / (double) studentList.size();

        System.out.printf("\nAverage Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
    }

    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input.trim());
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
    }
}
