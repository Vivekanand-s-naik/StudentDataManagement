package com.main;
import com.main.models.ManageStudentData;
import com.main.service.OpeartionConstant;

public class Main{
    public static void main(String[] args){
        new ManageStudentData();
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("--STUDENT MANAGEMENT PLATFORM--");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("Menu");
        System.out.println("-----------------------");
        System.out.println("1. Add a student \n2. Remove a student    \n3. Search for a student   \n4. Update Student Details. \n5. Display all students");

        try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
            while (true) {
                System.out.print("Enter your choice (1-5, 0 to exit): ");
                int choice = sc.nextInt();
                if (choice == 0) break;
                switch (choice) {
                    case 1 -> ManageStudentData.setOptType(OpeartionConstant.AddStudent);
                    case 2 -> ManageStudentData.setOptType(OpeartionConstant.RemoveStudent);
                    case 3 -> ManageStudentData.setOptType(OpeartionConstant.SearchStudent);
                    case 4 -> ManageStudentData.setOptType(OpeartionConstant.UpdateStudent);
                    case 5 -> ManageStudentData.setOptType(OpeartionConstant.DisplayAllStudent);
                    default -> {
                        System.out.println("Invalid choice.");
                        continue;
                    }
                }
                ManageStudentData.executeOperation();
            }
        }
        System.out.println("Exiting...");
    }
}