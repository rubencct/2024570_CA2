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
 * This utility class is responsible for reading applicant data from a text file.
 * It transforms each valid row from the file into an Applicant object
 * and adds it to a list that can be used in the program.
 */

import java.io.*;
import java.util.*;


public class FileReaderUtility {

    /**
     * Reads applicant records from a given text file (in this case ApplicantsForm.txt).
     * Skips the header line and parses the remaining lines to extract:
     * first name, surname, department and job title.
     *
     * @param filename The name of the text file containing applicant data
     * @return A list of Applicant objects created from the file
     */
    public static ArrayList<Applicant> readApplicantsFromFile(String filename) {
        ArrayList<Applicant> applicants = new ArrayList<>();

        // Try-with-resources ensures the file gets closed automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            boolean skipHeader = true;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {

                // Skip the first line, which is usually the header
                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                // Split the line by commas
                String[] parts = line.split(",");

                // Check if the line has enough values to extract required fields
                if (parts.length >= 9) {
                    String firstName = parts[0].trim();   // Column 1: First Name
                    String surname = parts[1].trim();     // Column 2: Surname
                    String dept = parts[5].trim();        // Column 6: Department
                    String jobTitle = parts[7].trim();    // Column 8: Job Title

                    // Create new applicant and add to the list
                    applicants.add(new Applicant(firstName, surname, jobTitle, dept));
                }
            }

        } catch (IOException e) {
            // Handle file not found or read errors
            System.out.println("Sorry, there was an error while looking for your file: " + e.getMessage());
        }

        return applicants;
    }
}