# Student Record Management System

A Java-based command-line application designed to manage student records efficiently using custom Data Structures and Algorithms (DSA), without relying on built-in Java Collections.

## Features
* **Dynamic Directory:** Add and store student profiles using a custom Dynamic Array.
* **History Recovery:** "Undo" the last added student instantly using a custom Stack (LIFO).
* **Course Waitlist:** Manage overflow course registrations using a custom Singly Linked List.
* **Fast Search:** Find any student by their ID instantly using Binary Search.
* **Grade Ranking:** Sort and rank students by their GPA using Merge Sort.

## How to Run the Application
Follow these simple steps to run the project on your local machine:

### 1. Prerequisites
Make sure you have Java Development Kit (JDK) installed on your computer.

### 2. Compilation
Open your terminal/command prompt inside the project folder and type the following command to compile the Java files:
```bash
javac Main.java

### 3. Execution 
After compiling, run the program using this command:
java Main

### Data Structures Used
1. Dynamic Array: Used for primary student storage with auto-resizing.
2. Singly Linked List: Used to handle the queue for course waitlists.
3. Stack: Used to track administrative actions for the undo functionality.



