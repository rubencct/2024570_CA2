/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

/**
 *
 * @author ruben_1d
 */
    
    /**
 * Main entry point for StackFlow Systems application.
 * This program simulates a tech company managing employees and departments using Java OOP principles.
 * Author: Mario Rubén Arturo Vera Rodríguez
 * Student ID: 2024570
 */

import java.util.Scanner;

public class StackFlowApp {

    // Scanner object to capture user input from the keyboard
    private static Scanner keyboardScanner = new Scanner(System.in);

    // Object that represents the tech company (StackFlow Systems)
    private static TechCompany stackFlowCompany = new TechCompany("StackFlow Systems Ltd.");

    /**
     * Main method that launches the program and displays the user menu.
     */
    public static void main(String[] args) {
        boolean keepRunning = true;

        while (keepRunning) {
            showMenu();
            System.out.print("Please select an option (1-6): ");
            String userChoice = keyboardScanner.nextLine();

            switch (userChoice) {
                case "1":
                    stackFlowCompany.addEmployeeManually();
                    break;
                case "2":
                    stackFlowCompany.generateRandomEmployee();
                    break;
                case "3":
                    stackFlowCompany.searchEmployeeByName();
                    break;
                case "4":
                    stackFlowCompany.sortEmployeesAlphabetically();
                    break;
                case "5":
                    stackFlowCompany.displayAllEmployees();
                    break;
                case "6":
                    System.out.println("Thanks for using StackFlow Systems application. Goodbye!");
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 6.\n");
            }
        }
    }

    /**
     * Displays the main user menu with available options.
     */
    private static void showMenu() {
        System.out.println("\n===== STACKFLOW SYSTEMS MENU =====");
        System.out.println("1. Add new employee manually");
        System.out.println("2. Generate random employee");
        System.out.println("3. Search for employee by name");
        System.out.println("4. Sort employees alphabetically");
        System.out.println("5. Display all employees");
        System.out.println("6. Exit");
        System.out.println("==================================");
    }
}


