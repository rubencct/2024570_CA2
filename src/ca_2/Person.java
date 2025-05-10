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
 * This class represents a generic person with a first name and surname.
 * It is designed to be a base class for other types of people (e.g., Applicant).
 * Both attributes are protected so subclasses can access them directly if needed.
 */
public class Person {

    // The person's first name (e.g. "Emma")
    protected String firstName;

    // The person's surname or family name (e.g. "Murphy")
    protected String surname;

    /**
     * Constructor that creates a new Person object with the given names.
     * @param firstName The person's given name
     * @param surname The person's family name
     */
    public Person(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    /**
     * Returns the first name of the person.
     * @return A string representing the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the surname of the person.
     * @return A string representing the surname.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Returns the full name of the person in a readable format.
     * This method is often overridden in subclasses to include more details.
     * @return A string with first name and surname.
     */
    public String getDetails() {
        return firstName + " " + surname;
    }
}