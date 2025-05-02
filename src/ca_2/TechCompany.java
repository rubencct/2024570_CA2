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

    // List to store names of employees
    private List<String> employeeList;

    // Constructor that accepts a company name and initialises the employee list
    public TechCompany(String companyName) {
        this.companyName = companyName;
        this.employeeList = new ArrayList<>();
    }

    /**
     * Adds a new employee to the list based on user input.
     */
    public void addEmployeeManually() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        employeeList.add(name);
        System.out.println("Employee added: " + name);
    }

    /**
     * Generates a random employee name and adds it to the list.
     * The name is chosen from a predefined pool of first names.
     */
    public void generateRandomEmployee() {
        String[] names = {"Alice", "Oisin", "Darragh", "Diana", "Ethan", "Fiona", "Saoirce", "Cian",};
        Random rand = new Random();
        String randomName = names[rand.nextInt(names.length)];
        employeeList.add(randomName);
        System.out.println("Random employee generated and added: " + randomName);
    }

    /**
     * Returns the company name.
     */
    public String getCompanyName() {
        return companyName;
    }
    
    //Method 1: Search Employee by Name
/**
 * Prompts the user to enter a name and checks if it exists in the employee list.
 */
public void searchEmployeeByName() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the employee name to search: ");
    String searchName = scanner.nextLine();

    if (employeeList.contains(searchName)) {
        System.out.println("Employee found: " + searchName);
    } else {
        System.out.println("Employee not found.");
    }
}

// Method 2: Sort Employees Alphabetically
/**
 * Sorts the employee list alphabetically and displays the result.
 */
public void sortEmployeesAlphabetically() {
    Collections.sort(employeeList);
    System.out.println("Employees sorted alphabetically.");
    displayAllEmployees(); // Call this method to show the sorted list
}

// Method 3: Display All Employees
/**
 * Displays all employee names in the list.
 */
public void displayAllEmployees() {
    if (employeeList.isEmpty()) {
        System.out.println("No employees in the list.");
    } else {
        System.out.println("Employee List:");
        for (String name : employeeList) {
            System.out.println("- " + name);
        }
    }
}

}
