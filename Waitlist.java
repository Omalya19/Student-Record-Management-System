public class Waitlist {
    private Student head;

    public void addToWaitlist(Student s) {
        Student newStudent = new Student(s.studentID, s.name, s.gpa);
        if (head == null) {
            head = newStudent;
        } else {
            Student temp = head;
            while (temp.next !=null) {
                temp = temp.next;
            }
            temp.next = newStudent;
        }
        System.out.println(s.name + " successfully added to the course waitlist.");
    }

    public void displayWaitlist() {
        if (head == null) {
            System.out.println("Waitlist is empty.");
            return;
        }
        Student temp = head;
        System.out.println("--- Current Waitlist ---");
        while (temp != null) {
            temp.display();
            temp = temp.next;    
        }
    }
}
