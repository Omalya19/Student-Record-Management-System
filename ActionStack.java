public class ActionStack {
    private Student[] stackArray;
    private int top;
    
    public ActionStack() {
        stackArray = new Student[100];
        top = -1;
    }

    public void push(Student s) {
        stackArray[++top] = s;
    }

    public Student pop() {
        if (top == -1) return null;
        return stackArray[top--];
    } 
}
