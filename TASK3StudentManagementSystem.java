import java.io.*;
import java.util.*;

class Student implements Serializable {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters & Setters
    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // To display student info
    public String toString() {
        return "Name: " + name + ", Roll No: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;
    private final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        students = new ArrayList<>();
        loadFromFile();
    }

    // Add student
    public void addStudent(Student s) {
        students.add(s);
        saveToFile();
        System.out.println("✅ Student added successfully!");
    }

    public void removeStudent(int rollNo) {
        boolean found = false;
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getRollNumber() == rollNo) {
                it.remove();
                saveToFile();
                System.out.println(" Student removed successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student not found!");
        }
    }

    public void searchStudent(int rollNo) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNo) {
                System.out.println("Student found: " + s);
                return;
            }
        }
        System.out.println("Student not found!");
    }

    // Display all students
    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("⚠ No students to display.");
        } else {
            System.out.println("\n===== Student List =====");
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Edit student info
    public void editStudent(int rollNo, String newName, String newGrade) {
        for (Student s : students) {
            if (s.getRollNumber() == rollNo) {
                s.setName(newName);
                s.setGrade(newGrade);
                saveToFile();
                System.out.println("✏ Student details updated successfully!");
                return;
            }
        }
        System.out.println("Student not found!");
    }


    private void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(students);
        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) in.readObject();
        } catch (FileNotFoundException e) {
            students = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
}

public class StudentManagmentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem sms = new StudentManagementSystem();
        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println(" 🎓 STUDENT MANAGEMENT SYSTEM ");
            System.out.println("==============================");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Edit Student Info");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume newline
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter roll number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter grade: ");
                    String grade = sc.nextLine();

                    // Step 6: Input validation
                    if (name.isEmpty() || grade.isEmpty()) {
                        System.out.println(" Name and Grade cannot be empty!");
                    } else {
                        Student s = new Student(name, roll, grade);
                        sms.addStudent(s);
                    }
                    break;

                case 2:
                    System.out.print("Enter roll number to remove: ");
                    int removeRoll = sc.nextInt();
                    sms.removeStudent(removeRoll);
                    break;

                case 3:
                    System.out.print("Enter roll number to search: ");
                    int searchRoll = sc.nextInt();
                    sms.searchStudent(searchRoll);
                    break;

                case 4:
                    sms.displayAll();
                    break;

                case 5:
                    System.out.print("Enter roll number to edit: ");
                    int editRoll = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = sc.nextLine();
                    if (newName.isEmpty() || newGrade.isEmpty()) {
                        System.out.println(" Fields cannot be empty!");
                    } else {
                        sms.editStudent(editRoll, newName, newGrade);
                    }
                    break;

                case 6:
                    System.out.println(" Exiting... Have a nice day!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
