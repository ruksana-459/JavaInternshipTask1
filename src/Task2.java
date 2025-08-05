import java.util.ArrayList;
import java.util.Scanner;

    class Student {
        int id;
        String name;
        double marks;

        Student(int id, String name, double marks) {
            this.id = id;
            this.name = name;
            this.marks = marks;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
        }
    }

    public class Task2 {
        static ArrayList<Student> studentList = new ArrayList<>();
        static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            int choice;

            do {
                System.out.println("\n===== Student Record Management System =====");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1: addStudent(); break;
                    case 2: viewStudents(); break;
                    case 3: updateStudent(); break;
                    case 4: deleteStudent(); break;
                    case 5: System.out.println("Exiting..."); break;
                    default: System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 5);
        }

        // Add a new student
        public static void addStudent() {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // consume newline
            System.out.print("Enter Student Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Student Marks: ");
            double marks = scanner.nextDouble();

            studentList.add(new Student(id, name, marks));
            System.out.println("Student added successfully!");
        }

        // View all students
        public static void viewStudents() {
            if (studentList.isEmpty()) {
                System.out.println("No students found.");
            } else {
                System.out.println("\nStudent Records:");
                for (Student s : studentList) {
                    System.out.println(s);
                }
            }
        }

        // Update a student's details
        public static void updateStudent() {
            System.out.print("Enter Student ID to update: ");
            int id = scanner.nextInt();
            boolean found = false;

            for (Student s : studentList) {
                if (s.id == id) {
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new name: ");
                    s.name = scanner.nextLine();
                    System.out.print("Enter new marks: ");
                    s.marks = scanner.nextDouble();
                    System.out.println("Student updated successfully!");
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found with ID: " + id);
            }
        }

        // Delete a student
        public static void deleteStudent() {
            System.out.print("Enter Student ID to delete: ");
            int id = scanner.nextInt();
            boolean removed = studentList.removeIf(s -> s.id == id);

            if (removed) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student not found with ID: " + id);
            }
        }
    }


