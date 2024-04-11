import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class Student {
    private int id;
    private String name;
    private String grade;

    public Student(int id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Grade: " + grade;
    }
}
 class StudentManagementSystem {

    private List<Student> students = new ArrayList<>();

    // Create (Add) a student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Read (View) all students
    public void viewStudents() {
        students.forEach(System.out::println);
    }

    // Update a student's details
    public void updateStudent(int id, String newName, String newGrade) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setName(newName);
                s.setGrade(newGrade);
                break;
            }
        }
    }

    // Delete a student by ID
    public void deleteStudent(int id) {
        students.removeIf(s -> s.getId() == id);
    }

    // Search student by name
    public Student searchStudentByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                return s;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Student\n2. View Students\n3. Update Student\n4. Delete Student\n5. Search Student\n6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Grade: ");
                    String grade = scanner.next();
                    sms.addStudent(new Student(id, name, grade));
                    break;
                case 2:
                    System.out.println("Students List:");
                    sms.viewStudents();
                    break;
                case 3:
                    System.out.print("Enter ID to Update: ");
                    int updateId = scanner.nextInt();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.next();
                    System.out.print("Enter New Grade: ");
                    String newGrade = scanner.next();
                    sms.updateStudent(updateId, newName, newGrade);
                    break;
                case 4:
                    System.out.print("Enter ID to Delete: ");
                    int deleteId = scanner.nextInt();
                    sms.deleteStudent(deleteId);
                    break;
                case 5:
                    System.out.print("Enter Name to Search: ");
                    String searchName = scanner.next();
                    Student foundStudent = sms.searchStudentByName(searchName);
                    System.out.println(foundStudent != null ? foundStudent : "Student not found.");
                    break;
                case 6:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }
}

