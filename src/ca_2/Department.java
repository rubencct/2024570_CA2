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
 * Represents a department within the tech company.
 * A department can be associated with employees or managers.
 */
public class Department {

    // The name of the department (e.g. IT, Repairs)
    private String departmentName;

    /**
     * Constructs a department with a given name.
     * @param departmentName The name of the department
     */
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * Returns the department's name.
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * Updates the department's name.
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * String representation of the department.
     */
    @Override
    public String toString() {
        return departmentName;
    }
}
