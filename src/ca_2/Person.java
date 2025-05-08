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
 * Represents a generic person with a first name and a surname.
 * This class serves as a parent class for more specific types like Employee.
 */
public class Person {

    // Field for the person's first name
    private String firstName;

    // Field for the person's surname
    private String surname;

    /**
     * Constructor to initialise a new Person.
     * @param firstName The first name of the person.
     * @param surname The surname of the person.
     */
    public Person(String firstName, String surname) {
        this.firstName = firstName;
        this.surname = surname;
    }

    // Getter and setter for first name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and setter for surname
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Returns the full name of the person.
     * @return The concatenation of first name and surname.
     */
    public String getFullName() {
        return firstName + " " + surname;
    }
}
