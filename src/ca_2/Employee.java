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

    /**
     * Constructor that creates a new employee using the given first name and surname.
     * 
     * @param firstName The employee's first name
     * @param surname The employee's surname
     */
    public Employee(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    /**
     * Gets the employee's first name.
     * 
     * @return The first name of the employee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the employee's surname.
     * 
     * @return The surname of the employee
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Sets a new first name for the employee.
     * 
     * @param firstName The new first name to assign
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Sets a new surname for the employee.
     * 
     * @param surname The new surname to assign
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns the full name of the employee in the format: "FirstName Surname".
     * 
     * @return A string representing the full name
     */
    public String getFullName() {
        return firstName + " " + surname;
    }

    /**
     * Overrides the default toString() method to return the employee's full name.
     * 
     * @return The full name of the employee as a string
     */
    @Override
    public String toString() {
        return getFullName();
    }
}