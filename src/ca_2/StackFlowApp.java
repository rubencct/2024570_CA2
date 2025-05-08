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
 * This Java console program simulates a tech company managing its employees.
 * It allows for adding, editing, sorting, deleting, and displaying employees
 * using object-oriented programming principles.
 * 
 * Author: Mario Rubén Arturo Vera Rodríguez
 * Student ID: 2024570
 */

import java.util.Scanner;

public class StackFlowApp {

    // Scanner object to capture user input from the console
    private static Scanner keyboardScanner = new Scanner(System.in);

    // Object that represents our tech company StackFlow Systems
    private static TechCompany stackFlowCompany = new TechCompany("StackFlow Systems Ltd.");

    /**
     * This is the main method that gets called when the program runs.
     * It shows the menu, accepts user input, and performs the chosen action.
     */
    public static void main(String[] args) {
        boolean keepRunning = true; // Controls the main loop

        while (keepRunning) {
            showMenu(); // Show available options to the user
            System.out.print("Please select an option (1-8): ");
            String userChoice = keyboardScanner.nextLine();
            System.out.println("\n\n");
            // Decide what to do based on the user's selection
            switch (userChoice) {
                case "1":
                    // Manually add a new employee to the system
                    stackFlowCompany.addEmployeeManually();
                    System.out.println("\n\n"); // Add spacing to improve readability
                    break;
                case "2":
                    // Add a randomly generated employee (name + surname)
                    stackFlowCompany.generateRandomEmployee();
                    System.out.println("\n\n");
                    break;
                case "3":
                    // Search for an employee using part of their name
                    stackFlowCompany.searchEmployeeByName();
                    System.out.println("\n\n");
                    break;
                case "4":
                    // Sort the list of employees in alphabetical order
                    stackFlowCompany.sortEmployeesAlphabetically();
                    System.out.println("\n\n");
                    break;
                case "5":
                    // Show all current employees in the system
                    stackFlowCompany.displayAllEmployees();
                    System.out.println("\n\n");
                    break;
                case "6":
                    // Edit the name of an employee
                    stackFlowCompany.editEmployeeDetails();
                    System.out.println("\n\n");
                    break;
                case "7":
                    // Delete an employee after confirming selection
                    stackFlowCompany.deleteEmployee();
                    System.out.println("\n\n");
                    break;
                case "8":
                    // Exit the program with a goodbye message
                    System.out.print("Are you sure you want to exit the program? (Y/N): ");
                        String confirmExit = keyboardScanner.nextLine().trim().toLowerCase();
                        if (confirmExit.equals("y")) {
                            System.out.println("Thanks for using StackFlow Systems application");
                            System.out.println("StackFlow Systems Ltd. - Developed by Rubén Vera");
                            System.out.println("Goodbye!");
                            keepRunning = false;
                        } else {
                            System.out.println("Exit cancelled. Returning to menu...");
                        }
                        System.out.println(); // just visual space
                        break;
                    
                default:
                    // Invalid input handling
                    System.out.println("Invalid option. Please enter a number between 1 and 8.\n");
            }
        }
    }

    /**
     * This method prints the main menu with all available actions.
     * It's called at the beginning of each loop to guide the user.
     */
    private static void showMenu() {
        System.out.println("===== STACKFLOW SYSTEMS MENU =====");
        System.out.println("1. Add new employee manually");
        System.out.println("2. Generate random employee");
        System.out.println("3. Search for employee by name");
        System.out.println("4. Sort employees alphabetically");
        System.out.println("5. Display all employees");
        System.out.println("6. Edit employee details");
        System.out.println("7. Delete employee");
        System.out.println("8. Exit");
        System.out.println("==================================");
    }
}