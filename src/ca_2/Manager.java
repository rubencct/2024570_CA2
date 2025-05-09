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
 * Represents a Manager, which is a specialised type of Employee.
 * In addition to standard employee details, a Manager has a department.
 */
public class Manager extends Employee {

    // The department this manager oversees
    private Department department;

    /**
     * Constructs a new Manager with first name, surname, role and department.
     * @param firstName The manager's first name
     * @param surname The manager's surname
     * @param role The manager's job role
     * @param department The department the manager is responsible for
     */
    public Manager(String firstName, String surname, Department department) {
        super(firstName, surname, "Manager", department);
        this.department = department;
    }

    /**
     * Gets the manager's department.
     * @return The department name
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Updates the manager's department.
     * @param department New department name
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Returns the manager's full information.
     */
    @Override
    public String toString() {
        return getFullName() + " (" + getRole() + ", Dept: " + department + ")";
    }
}
