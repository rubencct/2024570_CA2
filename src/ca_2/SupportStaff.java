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
 * This class represents a type of employee who works in support roles.
 * It extends the Employee class and introduces a new field: area.
 * 
 * While not used directly in the current project, it demonstrates:
 * - Class inheritance
 * - Method overriding
 */
public class SupportStaff extends Employee {

    // The specific area of support the staff works in (e.g. "Facilities", "Reception")
    private String area;

    /**
     * Constructor that creates a new SupportStaff object with the given details.
     * Inherits first name, surname and department from the Employee class.
     * @param firstName   The staff member’s first name
     * @param surname     The staff member’s last name
     * @param department  The department where they work
     * @param area        The specific area they support (not necessarily a department)
     */
    public SupportStaff(String firstName, String surname, String department, String area) {
        super(firstName, surname, department);
        this.area = area;
    }

    /**
     * Returns the specific support area for this staff member.
     * @return A string representing the support area.
     */
    public String getArea() {
        return area;
    }

    /**
     * Overrides the getDetails() method to include support area as well as department.
     * @return A string like: "Jane Smith - Support Area: IT Helpdesk, Dept: Operations"
     */
    @Override
    public String getDetails() {
        return firstName + " " + surname + " - Support Area: " + area + ", Dept: " + department;
    }
}