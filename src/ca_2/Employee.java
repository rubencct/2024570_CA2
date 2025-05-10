/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca_2;

/**
 *
 * @author ruben_1d
 * Mario Rubén Arturo Vera Rodriguez
 * Student number: 2024570
 */

/**
 * This class represents an Employee.
 * It extends the Person class and adds a new field: department.
 * This class acts as a middle layer between Person and Applicant.
 */
public class Employee extends Person {

    // The department this employee belongs to (e.g. "Finance", "HR")
    protected String department;

    /**
     * Constructor for an Employee.
     * It uses the super keyword to call the constructor from the Person class
     * and sets the department for the employee.
     *
     * @param firstName  The employee’s first name
     * @param surname    The employee’s last name
     * @param department The department they work in
     */
    public Employee(String firstName, String surname, String department) {
        super(firstName, surname); // Call constructor of Person
        this.department = department;
    }

    /**
     * Getter method to access the department of the employee.
     * @return A string with the department name
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Overrides the getDetails() method from Person to also include department.
     * Useful for displaying complete employee information.
     * @return A string like: "John Murphy - Dept: Marketing"
     */
    @Override
    public String getDetails() {
        return super.getDetails() + " - Dept: " + department;
    }
}