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
 * Represents an individual employee who is a person with a specific role in the company.
 * Inherits basic personal information from the Person class.
 *
 * 
 * Author: Mario Rubén Arturo Vera Rodríguez
 * Student ID: 2024570
 */
public class Employee extends Person {

    // Role of the employee within the company
    private String role;
    
    // Department to which the employee is assigned
    private Department department;

    /**
     * Constructor to initialise a new Employee with first name, surname and role.
     * @param firstName The employee's first name.
     * @param surname The employee's surname.
     * @param role The role of the employee in the company.
     */
    public Employee(String firstName, String surname, String role, Department department) {
        super(firstName, surname); // Call constructor of Person
        this.role = role;
        this.department = department;
    }

    /**
     * Returns the role of the employee.
     */
    public String getRole() {
        return role;
    }

    /**
     * Updates the role of the employee.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns the department of the employee.
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Updates the department of the employee.
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Returns the employee's full name, role and department as a formatted string.
     */
    @Override
    public String toString() {
        return getFullName() + " (" + role + ", Dept: " + department + ")";
    }
}