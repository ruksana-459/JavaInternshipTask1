import java.util.List;
import java.util.Scanner;

public class EmployeeControl {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Employee Database App ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    sc.nextLine(); // clear buffer
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Salary: ");
                    double salary = sc.nextDouble();
                    if (dao.addEmployee(new Employee(name, dept, salary)))
                        System.out.println("Employee added!");
                    else
                        System.out.println("Failed to add employee.");
                }
                case 2 -> {
                    List<Employee> employees = dao.getAllEmployees();
                    System.out.println("\nID\tName\tDepartment\tSalary");
                    for (Employee emp : employees) {
                        System.out.println(emp);
                    }
                }
                case 3 -> {
                    System.out.print("Enter Employee ID to update: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("New Department: ");
                    String dept = sc.nextLine();
                    System.out.print("New Salary: ");
                    double salary = sc.nextDouble();
                    if (dao.updateEmployee(new Employee(id, "", dept, salary)))
                        System.out.println("Employee updated!");
                    else
                        System.out.println("Update failed.");
                }
                case 4 -> {
                    System.out.print("Enter Employee ID to delete: ");
                    int id = sc.nextInt();
                    if (dao.deleteEmployee(id))
                        System.out.println("Employee deleted!");
                    else
                        System.out.println("Delete failed.");
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);

        sc.close();
    }
}
