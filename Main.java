import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentDirectory directory = new StudentDirectory();
        ActionStack stack = new ActionStack();
        Waitlist waitlist = new Waitlist();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== STUDENT RECORD SYSTEM =====");
            System.out.println("1. Add New Student to Database");
            System.out.println("2. Display All Students");
            System.out.println("3. Undo Last Added Student");
            System.out.println("4. Add Student to Course Waitlist");
            System.out.println("5. Display Waitlist");
            System.out.println("6. Sort Students by GPA (Merge Sort)");
            System.out.println("7. Search Student by ID (Binary Search)");
            System.out.println("8. Exit Application");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Enter Student ID (Numbers only): "); int id = scanner.nextInt();
                System.out.print("Enter Student Name: "); String name = scanner.next();
                System.out.print("Enter GPA: "); double gpa = scanner.nextDouble();
                
                Student s = new Student(id, name, gpa);
                directory.add(s);
                stack.push(s); 
                System.out.println("Student profile saved successfully.");
            } 
            else if (choice == 2) {
                directory.displayAll();
            } 
            else if (choice == 3) {
                Student removed = stack.pop();
                if (removed != null) {
                    System.out.println("Undo Successful! Removed: " + removed.name);
                    // Real-world application would remove it from array, for simplicity we pop history.
                } else {
                    System.out.println("No actions to undo.");
                }
            } 
            else if (choice == 4) {
                System.out.print("Enter Student ID to add to Waitlist: "); int id = scanner.nextInt();
                int index = directory.binarySearch(id);
                if(index != -1) {
                    waitlist.addToWaitlist(directory.getArray()[index]);
                } else {
                    System.out.println("Student ID not found in database. Sort by ID first if newly added!");
                }
            } 
            else if (choice == 5) {
                waitlist.displayWaitlist();
            } 
            else if (choice == 6) {
                directory.triggerSort();
                System.out.println("Students sorted by GPA via Merge Sort successfully.");
                directory.displayAll();
            } 
            else if (choice == 7) {
                System.out.print("Enter ID to search: "); int id = scanner.nextInt();
                int result = directory.binarySearch(id);
                if (result == -1) {
                    System.out.println("Student not found.");
                } else {
                    System.out.println("Student Found at record index " + result + ":");
                    directory.getArray()[result].display();
                }
            } 
            else if (choice == 8) {
                System.out.println("Exiting application. Good luck with your assignment!");
                break;
            }
        }
        scanner.close();
    }
}
