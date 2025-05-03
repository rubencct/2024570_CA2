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
 * Includes functionality to add employees manually, generate random ones,
 * and perform searches.
 */
public class TechCompany {

    // Field to store the company name
    private String companyName;

    // List to store Employee objects instead of just names
    private List<Employee> employeeList;

    // Constructor that accepts a company name and initialises the employee list
    public TechCompany(String companyName) {
        this.companyName = companyName;
        this.employeeList = new ArrayList<>();
    }

    /**
     * Adds a new employee to the list based on user input.
     * Now includes first name and surname input separately.
     */
    public void addEmployeeManually() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee's first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter employee's surname: ");
        String surname = scanner.nextLine();

        Employee newEmployee = new Employee(firstName, surname);
        employeeList.add(newEmployee);

        System.out.println("Employee added: " + newEmployee.getFullName());
    }

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

    // Method 1: Search Employee by Name and Surname    
    /**
    * Prompts the user to enter a name and checks if it exists in the employee list.
    * The comparison ignores case and matches even if it's a partial name (e.g. "rubén", "vera", "ru").
    */
    public void searchEmployeeByName() {
       Scanner scanner = new Scanner(System.in);
       System.out.print("Enter the employee name to search: ");
       String searchName = scanner.nextLine().toLowerCase(); // Convert input to lowercase

       boolean found = false;

       for (Employee emp : employeeList) {
           String fullName = emp.getFullName().toLowerCase(); // Convert stored name to lowercase
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
    

    // Method 2: Sort Employees Alphabetically
    /**
     * Sorts the employee list alphabetically and displays the result.
     * Sorting is done by full name in a case-insensitive manner.
     */
    public void sortEmployeesAlphabetically() {
        employeeList.sort((a, b) -> a.getFullName().compareToIgnoreCase(b.getFullName()));
        System.out.println("Employees sorted alphabetically.");
        displayAllEmployees();
    }

    // Method 3: Display All Employees
    /**
     * Displays all employee full names in the list.
     * Also shows the total count of employees.
     */
    public void displayAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees in the list.");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employeeList) {
                System.out.println("- " + emp.getFullName());
            }
            System.out.println("Total employees: " + employeeList.size());
        }
    }
} 
