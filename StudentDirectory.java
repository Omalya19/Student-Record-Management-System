public class StudentDirectory {
    private Student[] array;
    private int size;
    private int capacity;
    
    public StudentDirectory() {
        capacity = 2;
        array = new Student[capacity];
        size = 0;
    }

    public void add (Student student) {
        if (size == capacity) {
            growArray();
        }
        array[size++] = student;
    }

    private void growArray() {
        capacity = capacity * 2;
        Student[] newArray = new Student[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public void displayAll() {
        if (size == 0) {
            System.out.println("No records found.");
            return;
        }
        for (int i = 0; i < size; i++) {
            array[i].display();
        }
    }

    public int binarySearch(int id) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j].studentID > array[j + 1].studentID) {
                    // මාරු කිරීම (Swap)
                    Student temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        int l = 0, r = size - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (array[m].studentID == id) return m;
            if (array[m].studentID < id) l = m + 1;
            else r = m - 1;
        }
        return -1; 
    }

    public void triggerSort() {
        sortStudents(array,0, size -1);
    }

    private void sortStudents(Student[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sortStudents(arr, l, m);
            sortStudents(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    private void merge(Student[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        Student[] L = new Student[n1];
        Student[] R = new Student[n2];
        for (int i = 0; i < n1; ++i) L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) R[j] = arr[m + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i].gpa >= R[j].gpa) { 
                arr[k] = L[i]; i++;
            } else {
                arr[k] = R[j]; j++;
            }
            k++;
        }
        while (i < n1) { arr[k] = L[i]; i++; k++; }
        while (j < n2) { arr[k] = R[j]; j++; k++; }
    }

    public Student[] getArray() { return array; }
    public int getSize() { return size; }


}
