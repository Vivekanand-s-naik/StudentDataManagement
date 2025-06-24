package com.main.models;

import com.main.controller.UserController;
import com.main.service.OpeartionConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageStudentData {
    private static OpeartionConstant optType;
    private static List<stData> studentData = new ArrayList<>();
    private  static UserController controller = new UserController();

    public ManageStudentData() {
        // some random student details initially
        System.out.println("Get student ...");
        if (studentData.isEmpty()) {
            studentData.add(new stData(1, "Alice", 85, "Mathematics"));
            studentData.add(new stData(2, "Bob", 78, "Physics"));
            studentData.add(new stData(3, "Charlie", 92, "Chemistry"));
            studentData.add(new stData(4, "Diana", 88, "Biology"));
            studentData.add(new stData(5, "Eve", 80, "ComputerScience"));
        }
    }

    public ManageStudentData(OpeartionConstant optType) {
        ManageStudentData.optType = optType;
    }

    public static void setOptType(OpeartionConstant optType) {
        ManageStudentData.optType = optType;
    }

    public static void executeOperation() {
        switch (optType) {
            case AddStudent -> addStudent(studentData);
            case RemoveStudent -> removeStudent(studentData);
            case UpdateStudent -> updateStudent(studentData);
            case DisplayAllStudent -> dispAllStudent(studentData);
            case SearchStudent -> searchStudent(studentData);
        }
    }

    private static void searchStudent(List<stData> studentData) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();
        boolean found = false;
        if(controller.isValidId(id)){

            for (stData s : studentData) {
                if (s.getStId() == id) {
                    System.out.println("Student Found: " + s);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Student not found.");
            }
        }
        else{
            System.out.println("Invalid Id");
        }
    }

    private static void dispAllStudent(List<stData> studentData) {
        if (studentData.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("---- Student List ----");
            for (stData s : studentData) {
                System.out.println(s);
            }
            System.out.println("----------------------");
        }
    }

    private static void updateStudent(List<stData> studentData) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        for (stData s : studentData) {
            if (s.getStId() == id) {
                System.out.print("Enter new name: ");
                String name = sc.next();
                if(controller.isValidName(name))
                    s.setName(name);
                else
                    System.out.println("invalid name");
                    
                System.out.print("Enter new percent: ");
                s.setPercent(sc.nextInt());
                System.out.print("Enter new course: ");
                s.setCource(sc.next());
                System.out.println("Student updated: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void removeStudent(List<stData> studentData) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID to remove: ");
        int id = sc.nextInt();
        if(controller.isValidId(id)){
            stData toRemove = null;
            for (stData s : studentData) {
                if (s.getStId() == id) {
                    toRemove = s;
                    break;
                }
            }
            if (toRemove != null) {
                studentData.remove(toRemove);
                System.out.println("Student removed.");
            } else {
                System.out.println("Student not found.");
            }
        }
        else
            System.out.println("Invlid Id");
       
    }

    private static void addStudent(List<stData> studentData) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        if(controller.isValidId(id)){
            // Check for duplicate ID
            for (stData s : studentData) {
                if (s.getStId() == id) {
                    System.out.println("Student ID already exists. Cannot add duplicate.");
                    return;
                }
            }
            System.out.print("Enter Name: ");
            String name = sc.next();
            System.out.print("Enter Percent: ");
            int percent = sc.nextInt();
            System.out.print("Enter Course: ");
            String course = sc.next();
            stData s = new stData(id, name, percent, course);
            studentData.add(s);
            System.out.println("Student added: " + s);
        }
        else
            System.out.println("Invlid Id");
        
    }
    
}



