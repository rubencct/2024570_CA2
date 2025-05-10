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
 * This class stores predefined constants for valid job titles and departments.
 * These values are used throughout the program to validate input and generate random applicants.
 * Having a separate class for this helps ensure consistency and avoids hardcoding the same data in multiple places.
 */
public class DataValidator {

    // List of valid job titles that an applicant can hold
    // Used for validation, menu selection, and random generation
    public static final String[] JOB_TITLES = {
        "Manager", "Assistant Manager", "Senior Manager", "Marketing Specialist", "Junior Clerk",
        "Client Relations Coordinator", "Full-stack Developer", "Junior Bookkeeper", "Finance Analyst",
        "White-collar Worker", "Clerk", "Head Manager", "QA", "Sales Clerk", "HR Specialist",
        "Office Worker", "Client Relations Specialist", "Lead Designer", "Junior Developer",
        "Senior Analyst", "DevOps", "AI Developer", "Frontend Developer", "Backend Developer",
        "HR Analyst", "Desk Jockey", "Mobile Developer", "Team Lead", "Bookkeeper", "Support Clerk"
    };

    // List of valid departments across the company
    // These are linked with job titles and used to validate input
    public static final String[] DEPARTMENTS = {
        "IT Development", "Sales", "HR", "Finance", "Marketing",
        "Technical Support", "Customer Service", "Accounting", "Operations"
    };
}
