import java.util.*;

// Custom checked exception for invalid name
class NameException extends Exception {
    public NameException(String message) {
        super(message);
    }
}

// Custom checked exception for invalid age
class AgeException extends Exception {
    public AgeException(String message) {
        super(message);
    }
}

// Employee class
class Employee {
    String name;
    int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Employee Created Successfully!");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class EmployeeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Input employee details
            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Employee Age: ");
            int age = sc.nextInt();

            // Check if name contains digits
            if (name.matches(".*\\d.*")) {
                throw new NameException("Invalid Name! Name should not contain numbers.");
            }

            // Check if age is greater than 50
            if (age > 50) {
                throw new AgeException("Invalid Age! Age should not be greater than 50.");
            }

            // Otherwise, create employee object
            Employee emp = new Employee(name, age);
            emp.display();

        } catch (NameException | AgeException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
