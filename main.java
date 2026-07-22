import java.util.ArrayList;
import java.util.Scanner;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Main {

    static ArrayList<Course> courses = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n=================================================");
            System.out.println("         STUDENT COURSE MANAGEMENT SYSTEM");
            System.out.println("=================================================");
            System.out.println("1. Add Course");
            System.out.println("2. View All Courses");
            System.out.println("3. Search Course");
            System.out.println("4. Compute Total Units");
            System.out.println("5. Save To File");
            System.out.println("6. Load From File");
            System.out.println("7. Exit");
            System.out.println("=================================================");

            System.out.print("Enter Choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    addCourse();
                    break;

                case 2:
                    viewCourses();
                    break;

                case 3:
                    searchCourse();
                    break;
                    
                case 4:
    computeTotalUnits();
    break;
    
                 case 5:
    saveToFile();
    break;
    
                 case 6:
    loadFromFile();
    break;          
                case 7:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Option not yet implemented.");
            }

        } while (choice != 7);
    }

    public static void addCourse() {

        System.out.println("\n========== ADD NEW COURSE ==========");

        System.out.print("Course Code : ");
        String code = input.nextLine();
        
        for (Course c : courses) {
    if (c.getCode().equalsIgnoreCase(code)) {
        System.out.println("\nCourse already exists!");
        return;
    }
}
       
        System.out.print("Course Title: ");
        String title = input.nextLine();

        System.out.print("Course Unit : ");
        int unit = input.nextInt();
        input.nextLine();

        Course course = new Course(code, title, unit);
        courses.add(course);

        System.out.println("\nCourse added successfully!");
    }

    public static void viewCourses() {

        System.out.println("\n========== ALL COURSES ==========");

        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course c : courses) {
            c.display();
        }
    }

    public static void searchCourse() {

        System.out.println("\n========== SEARCH COURSE ==========");

        System.out.print("Enter Course Code: ");
        String code = input.nextLine();

        boolean found = false;

        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                System.out.println("\nCourse Found!");
                c.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Course not found.");
        }
    }
public static void computeTotalUnits() {

    int total = 0;

    for (Course c : courses) {
        total += c.getUnit();
    }

    System.out.println("\n========== TOTAL COURSE UNITS ==========");
    System.out.println("Total Units = " + total);
System.out.println("Number of Courses = " + countCourses(0));}

 public static void saveToFile() {

    try {

        PrintWriter writer = new PrintWriter(new FileWriter("courses.txt"));

        for (Course c : courses) {
            writer.println(c.getCode() + "," + c.getTitle() + "," + c.getUnit());
        }

        writer.close();

        System.out.println("\nCourses saved successfully!");

    } catch (IOException e) {
    System.out.println("Error saving file.");
}
}   // <-- Add this closing brace

public static void loadFromFile() {

    try {

        BufferedReader reader = new BufferedReader(new FileReader("courses.txt"));

        courses.clear();

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            String code = data[0];
            String title = data[1];
            int unit = Integer.parseInt(data[2]);

            Course course = new Course(code, title, unit);
            courses.add(course);
        }

        reader.close();

        System.out.println("\nCourses loaded successfully!");

    } catch (IOException e) {
        System.out.println("Error loading file.");
    }
}

public static int countCourses(int index) {

    if (index == courses.size()) {
        return 0;
    }

    return 1 + countCourses(index + 1);
}
}
