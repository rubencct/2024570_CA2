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
 * Represents an individual employee with a first name and surname.
 */
public class Employee {

    // Field to store the employee's first name
    private String firstName;

    // Field to store the employee's surname
    private String surname;

    /**
     * Constructor to initialise a new Employee with first name and surname
     * @param firstName The employee's first name
     * @param surname The employee's surname
     */
    public Employee(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
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
     * Returns the full name of the employee
     */
    public String getFullName() {
        return firstName + " " + surname;
    }

    /**
     * Overrides toString() to return the full name directly
     */
    @Override
    public String toString() {
        return getFullName();
    }
} 