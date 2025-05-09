/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ruben_1d
 */

/**
 * Represents a technology company that manages a list of employees.
 * Includes functionality to add, generate, search, sort, display, edit,
 * and delete employees.
 * 
 * Author: Mario Rubén Arturo Vera Rodríguez
 * Student ID: 2024570
 */
public class TechCompany {

    // Name of the tech company (e.g. StackFlow Systems Ltd.)
    private String companyName;

    // Stores all employees added to the system
    private List<Employee> employeeList;

    // Predefined list of roles available in the company
    private final String[] roles = {
        "Computer Technician",
        "Printer Technician",
        "CCTV Installer",
        "Front Desk Assistant",
        "Cashier"
    };
    
    // Predefined list of departments
    private final Department[] departments = {
        new Department("IT"),
        new Department("Repairs"),
        new Department("Sales"),
        new Department("Customer Service"),
        new Department("Finance")
    };

    /**
     * Constructor to initialise the company with a given name.
     * It also prepares an empty list to hold employee records.
     */
    public TechCompany(String companyName) {
        this.companyName = companyName;
        this.employeeList = new ArrayList<>();
    }

    // Method 1: Add a new employee manually
    /**
     * Prompts the user to manually input an employee's first name and surname as well as role and department.
     * Performs validation to ensure the input is not empty and contains only allowed characters.
     * It also checks for duplicates before adding the employee.
     */
    public void addEmployeeManually() {
        Scanner scanner = new Scanner(System.in);

        // Get and validate first name
        String firstName;
        while (true) {
            System.out.print("Enter employee's first name (or type 'CANCEL' to return): ");
            firstName = scanner.nextLine().trim();
            if (firstName.equalsIgnoreCase("cancel")) {
                System.out.println("Action cancelled. Returning to main menu.");
                return;
            }
            if (firstName.isEmpty() || !firstName.matches("^[\\p{L} '-]+$")) {
                System.out.println("First name must only contain letters, spaces, apostrophes or hyphens. Please try again.");
            } else {
                break;
            }
        }

        // Get and validate surname
        String surname;
        while (true) {
            System.out.print("Enter employee's surname (or type 'CANCEL' to return): ");
            surname = scanner.nextLine().trim();
            if (surname.equalsIgnoreCase("cancel")) {
                System.out.println("Action cancelled. Returning to main menu.");
                return;
            }
            if (surname.isEmpty() || !surname.matches("^[\\p{L} '-]+$")) {
                System.out.println("Surname must only contain letters, spaces, apostrophes or hyphens. Please try again.");
            } else {
                break;
            }
        }


        // Select role
        System.out.println("Select a role for this employee:");
        for (int i = 0; i < roles.length; i++) {
            System.out.println((i + 1) + ". " + roles[i]);
        }
        String role;
        while (true) {
            System.out.print("Enter the number of the role: ");
            int roleChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (roleChoice >= 1 && roleChoice <= roles.length) {
                role = roles[roleChoice - 1];
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
        
        System.out.println("Select a department:");
        for (int i = 0; i < departments.length; i++) {
            System.out.println((i + 1) + ". " + departments[i].getDepartmentName());
        }
        Department department;
        while (true) {
            System.out.print("Enter the number of the department: ");
            int deptChoice = scanner.nextInt();
            scanner.nextLine();
            if (deptChoice >= 1 && deptChoice <= departments.length) {
                department = departments[deptChoice - 1];
                break;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }        

        Employee newEmployee = new Employee(firstName, surname, role, department);

        // Check for duplicates before adding
        boolean exists = false;
        for (Employee emp : employeeList) {
            if (emp.getFullName().equalsIgnoreCase(newEmployee.getFullName())) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("This Employee already exists: " + newEmployee.getFullName());
        } else {
            employeeList.add(newEmployee);
            System.out.println("Employee added: " + newEmployee);
        }
    }
    
    
    /**
    * Extra to add Manager manually 
    * Prompts the user to manually input a manager's first name, surname, and department.
    * Uses the predefined department list to select a department.
    */
    public void addManagerManually() {
       Scanner scanner = new Scanner(System.in);

       System.out.print("Enter manager's first name (or type 'CANCEL' to return): ");
       String firstName = scanner.nextLine().trim();
       if (firstName.equalsIgnoreCase("cancel")) {
           System.out.println("Action cancelled. Returning to main menu.");
           return;
       }

       System.out.print("Enter manager's surname (or type 'CANCEL' to return): ");
       String surname = scanner.nextLine().trim();
       if (surname.equalsIgnoreCase("cancel")) {
           System.out.println("Action cancelled. Returning to main menu.");
           return;
       }

       // Display list of departments
       System.out.println("Select a department:");
       for (int i = 0; i < departments.length; i++) {
           System.out.println((i + 1) + ". " + departments[i].getDepartmentName());
       }

       Department selectedDepartment;
       while (true) {
           System.out.print("Enter the number of the department: ");
           String input = scanner.nextLine().trim();

           if (input.equalsIgnoreCase("cancel")) {
               System.out.println("Action cancelled. Returning to main menu.");
               return;
           }

           try {
               int deptChoice = Integer.parseInt(input);
               if (deptChoice >= 1 && deptChoice <= departments.length) {
                   selectedDepartment = departments[deptChoice - 1];
                   break;
               } else {
                   System.out.println("Invalid choice. Please try again.");
               }
           } catch (NumberFormatException e) {
               System.out.println("Invalid input. Please enter a number.");
           }
       }

       Manager newManager = new Manager(firstName, surname, selectedDepartment);
       employeeList.add(newManager);
       System.out.println("Manager added: " + newManager);
   }

    // Method 2: Generate a random employee
    public void generateRandomEmployee() {
        String[] firstNames = {"Alice", "Oisin", "Darragh", "Diana", "Ethan", "Fiona", "Saoirce", "Cian"};
        String[] surnames = {"Murphy", "Kelly", "O'Brien", "Doyle", "Byrne", "Walsh", "Ryan", "Smith"};
        Random rand = new Random();

        String randomFirstName = firstNames[rand.nextInt(firstNames.length)];
        String randomSurname = surnames[rand.nextInt(surnames.length)];
        String randomRole = roles[rand.nextInt(roles.length)];
        Department randomDepartment = departments[rand.nextInt(departments.length)];

        Employee randomEmployee = new Employee(randomFirstName, randomSurname, randomRole, randomDepartment);
        employeeList.add(randomEmployee);

        System.out.println("Random employee generated and added: " + randomEmployee);
    }

    public String getCompanyName() {
        return companyName;
    }

    // Method 3: Search employee by name
    /**
     * Allows the user to search for an employee by typing a part of their name.
     * The search is not case sensitive and supports partial matches.
     */
    public void searchEmployeeByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the employee name to search: ");
        String searchName = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (Employee emp : employeeList) {
            String fullName = emp.getFullName().toLowerCase();
            if (fullName.contains(searchName)) {
                System.out.println("Employee found: " + emp.getFullName());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    // Method 4: Sort employees alphabetically
    /**
     * Sorts the employee list in alphabetical order based on full name.
     * Uses case-insensitive comparison to ensure consistency.
     */
    public void sortEmployeesAlphabetically() {
        employeeList.sort((a, b) -> a.getFullName().compareToIgnoreCase(b.getFullName()));
        System.out.println("Employees sorted alphabetically.");
        displayAllEmployees();
    }

    // Method 5: Display all employees
    /**
     * Displays all employees currently stored in the list.
     * It shows their full names and the total number of employees.
     */
    public void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("There's no employees in the list.");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employeeList) {
                System.out.println("- " + emp);}
            System.out.println("Total employees: " + employeeList.size());
        }
    }

    // Method 6: Edit employee details
    /**
     * Edits the details (first name and/or surname) of an existing employee.
     * Uses a search term to find matching names and allows the user to choose the correct one if multiple matches exist.
     */
    public void editEmployeeDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter part of the employee's name to edit: ");
        String searchQuery = scanner.nextLine().toLowerCase();

        // Find all employees that match the query
        List<Employee> matches = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getFullName().toLowerCase().contains(searchQuery)) {
                matches.add(emp);
            }
        }

        // Handle no matches
        if (matches.isEmpty()) {
            System.out.println("No matching employees found.");
            return;
        }

        // Handle multiple matches
        Employee selectedEmployee = null;
        if (matches.size() == 1) {
            selectedEmployee = matches.get(0);
            System.out.println("Match found: " + selectedEmployee.getFullName());
        } else {
            System.out.println("Multiple matches found:");
            for (int i = 0; i < matches.size(); i++) {
                System.out.println((i + 1) + ". " + matches.get(i).getFullName());
            }
            System.out.print("Select the number of the employee to edit: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            if (choice >= 1 && choice <= matches.size()) {
                selectedEmployee = matches.get(choice - 1);
            } else {
                System.out.println("Invalid choice. Edit cancelled.");
                return;
            }
        }

        // Get new details from the user    
        System.out.print("Enter new first name (or type 'cancel' to return): ");
        String newFirstName = scanner.nextLine().trim();
        if (newFirstName.equalsIgnoreCase("cancel")) {
            System.out.println("Edit operation cancelled.");
            return;
        }

        
        System.out.print("Enter new surname (or type 'cancel' to return): ");
        String newSurname = scanner.nextLine().trim();
        if (newSurname.equalsIgnoreCase("cancel")) {
            System.out.println("Edit operation cancelled.");
            return;
        }

        selectedEmployee.setFirstName(newFirstName);
        selectedEmployee.setSurname(newSurname);

        System.out.println("Employee information updated: " + selectedEmployee.getFullName());
        System.out.println();
    }

    // Method 7: Delete an Employee
    /**
     * Deletes an employee based on partial name search.
     * Confirms the action before deleting.
     * Handles both single and multiple matches to avoid deleting the wrong person.
     */
    public void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter part of the employee's name to delete: ");
        String searchQuery = scanner.nextLine().toLowerCase();

        // Find all matches
        List<Employee> matches = new ArrayList<>();
        for (Employee emp : employeeList) {
            if (emp.getFullName().toLowerCase().contains(searchQuery)) {
                matches.add(emp);
            }
        }

        // No match found
        if (matches.isEmpty()) {
            System.out.println("No matching employees found.");
            return;
        }

        // Only one match found
        Employee employeeToDelete = null;
        if (matches.size() == 1) {
            employeeToDelete = matches.get(0);
            System.out.println("Match found: " + employeeToDelete.getFullName());
            System.out.print("Are you sure you want to delete this employee? (Y/N): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();
            if (!confirmation.equals("y")) {
                System.out.println("Deletion cancelled.");
                return;
            }
        } else {
            // Multiple matches
            System.out.println("Multiple matches found:");
            for (int i = 0; i < matches.size(); i++) {
                System.out.println((i + 1) + ". " + matches.get(i).getFullName());
            }
            System.out.print("Select the number of the employee to delete: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice >= 1 && choice <= matches.size()) {
                employeeToDelete = matches.get(choice - 1);
            } else {
                System.out.println("Invalid choice. Deletion cancelled.");
                return;
            }
        }

        // Confirm and delete
        System.out.println("Employee deleted: " + employeeToDelete.getFullName());
        employeeList.remove(employeeToDelete);
        System.out.println(); // Visual space
    }
}
