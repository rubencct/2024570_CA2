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
 */
public class TechCompany {

    // Field to store the company name
    private String companyName;

    // List to store Employee objects
    private List<Employee> employeeList;

    // Constructor that accepts a company name and initialises the employee list
    public TechCompany(String companyName) {
        this.companyName = companyName;
        this.employeeList = new ArrayList<>();
    }

    // Method 1: Add a new employee manually
    /**
     * Adds a new employee to the list based on user input.
     * Now includes first name and surname input separately.
     * Also validates that input is not empty or contains invalid characters.
     */
    public void addEmployeeManually() {
        Scanner scanner = new Scanner(System.in);

        String firstName;
        while (true) {
            System.out.print("Enter employee's first name: ");
            firstName = scanner.nextLine().trim();
            if (firstName.isEmpty() || !firstName.matches("^[\\p{L} '-]+$")) {
                System.out.println("First name must only contain letters, spaces, apostrophes or hyphens. Please try again.");
            } else {
                break;
            }
        }

        String surname;
        while (true) {
            System.out.print("Enter employee's surname: ");
            surname = scanner.nextLine().trim();
            if (surname.isEmpty() || !surname.matches("^[\\p{L} '-]+$")) {
                System.out.println("Surname must only contain letters, spaces, apostrophes or hyphens. Please try again.");
            } else {
                break;
            }
        }

        Employee newEmployee = new Employee(firstName, surname);

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
            System.out.println("Employee added: " + newEmployee.getFullName());
        }
    }

    // Method 2: Generate a random employee
    /**
     * Generates a random employee with a first name and surname.
     * Uses two separate arrays to pick each part of the name.
     */
    public void generateRandomEmployee() {
        String[] firstNames = {"Alice", "Oisin", "Darragh", "Diana", "Ethan", "Fiona", "Saoirce", "Cian"};
        String[] surnames = {"Murphy", "Kelly", "O'Brien", "Doyle", "Byrne", "Walsh", "Ryan", "Smith"};

        Random rand = new Random();
        String randomFirstName = firstNames[rand.nextInt(firstNames.length)];
        String randomSurname = surnames[rand.nextInt(surnames.length)];

        Employee randomEmployee = new Employee(randomFirstName, randomSurname);
        employeeList.add(randomEmployee);

        System.out.println("Random employee generated and added: " + randomEmployee.getFullName());
    }

    /**
     * Returns the company name.
     */
    public String getCompanyName() {
        return companyName;
    }

    // Method 3: Search employee by name
    /**
     * Prompts the user to enter a name and checks if it exists in the employee list.
     * The comparison ignores case and matches even if it's a partial name.
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
     * Sorts the employee list alphabetically and displays the result.
     * Sorting is done by full name in a case-insensitive manner.
     */
    public void sortEmployeesAlphabetically() {
        employeeList.sort((a, b) -> a.getFullName().compareToIgnoreCase(b.getFullName()));
        System.out.println("Employees sorted alphabetically.");
        displayAllEmployees();
    }

    // Method 5: Display all employees
    /**
     * Displays all employee full names in the list.
     * Also shows the total count of employees.
     */
    public void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("There's no employees in the list.");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employeeList) {
                System.out.println("- " + emp.getFullName());
            }
            System.out.println("Total employees: " + employeeList.size());
        }
    }

    // Method 6: Edit employee details
    /**
     * Allows editing an existing employee's first name and/or surname.
     * Supports partial name search and lets the user choose the correct employee.
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

        // Get new details
        System.out.print("Enter new first name: ");
        String newFirstName = scanner.nextLine().trim();
        System.out.print("Enter new surname: ");
        String newSurname = scanner.nextLine().trim();

        selectedEmployee.setFirstName(newFirstName);
        selectedEmployee.setSurname(newSurname);

        System.out.println("Employee information updated: " + selectedEmployee.getFullName());
        System.out.println();
    }
    // Method 7: Delete an Employee
    /**
     * Deletes an employee based on a partial or full name match.
     * If multiple matches are found, the user selects the correct one to delete.
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
