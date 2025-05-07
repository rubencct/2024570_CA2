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
 * Represents an individual employee with a first name and a surname.
 * This class includes methods to access and modify these values, 
 * as well as to retrieve the full name.
 * 
 * Author: Mario Rubén Arturo Vera Rodríguez
 * Student ID: 2024570
 */
public class Employee {

    // Field to store the employee's first name
    private String firstName;

    // Field to store the employee's surname
    private String surname;

    // Field to store the employee's role
    private String role;

    /**
     * Constructor to initialise a new Employee with first name, surname, and role
     * @param firstName The employee's first name
     * @param surname The employee's surname
     * @param role The employee's role in the company
     */
    public Employee(String firstName, String surname, String role) {
        this.firstName = firstName;
        this.surname = surname;
        this.role = role;
    }

    /**
     * Returns the employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the employee's surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Returns the employee's role
     */
    public String getRole() {
        return role;
    }

    /**
     * Updates the employee's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Updates the employee's surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Updates the employee's role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Returns the full name of the employee
     */
    public String getFullName() {
        return firstName + " " + surname;
    }

    /**
     * Overrides toString() to return the full name and role
     */
    @Override
    public String toString() {
        return getFullName() + " - Role: " + role;
    }
}
