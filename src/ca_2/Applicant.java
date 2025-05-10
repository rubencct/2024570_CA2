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
 * This class represents an Applicant in the company.
 * It extends the Employee class, meaning it inherits all the attributes of an employee
 * and adds a specific attribute for their job title (e.g. "Manager", "QA", etc.).
 */
public class Applicant extends Employee {

    // The specific role or job title of this applicant
    private String jobTitle;

    /**
     * Constructor to create an Applicant with all necessary details.
     * It uses the constructor of the Employee class to set first name, surname and department.
     * Then it sets the job title for this particular applicant.
     *
     * @param firstName  The applicant's first name
     * @param surname    The applicant's last name
     * @param jobTitle   The position this applicant is applying for (e.g. "Backend Developer")
     * @param department The department related to that job (e.g. "IT Development")
     */
    public Applicant(String firstName, String surname, String jobTitle, String department) {
        super(firstName, surname, department);
        this.jobTitle = jobTitle;
    }

    /**
     * Returns the job title of the applicant.
     * @return A string representing the applicant’s job title.
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * Returns a formatted string with all relevant information about the applicant.
     * Overrides the getDetails() method from the parent class to include job title and department.
     * @return A string like: "Jane Doe - Job Title: QA, Dept: IT Development"
     */
    @Override
    public String getDetails() {
        return firstName + " " + surname + " - Job Title: " + jobTitle + ", Dept: " + department;
    }
}