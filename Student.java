public class Student {
    public int studentID;
    public String name;
    public double gpa;
    public Student next;

    public Student(int studentID, String name, double gpa) {
        this.studentID = studentID;
        this.name = name;
        this.gpa = gpa;
        this.next = null;
    }
 
    public void display() {
        System.out.println("ID: " + studentID + " | Name: " + name + " | GPA: " + gpa);
    } 
}