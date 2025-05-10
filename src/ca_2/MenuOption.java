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
 * This enum defines the available options in the main menu of the application.
 * Each value corresponds to one of the numbered choices the user sees in the console.
 * 
 * Using an enum improves clarity and helps avoid errors caused by using magic numbers (like 1, 2, 3...).
 * It's also easier to update or expand the menu in the future this way.
 */
public enum MenuOption {
    
    // Option to sort applicants by surname and show the first 20
    SORT,

    // Option to search for an applicant by name or surname
    SEARCH,

    // Option to manually add a new applicant through user input
    ADD_RECORDS,

    // Option to generate a random applicant with valid data
    GENERATE_RANDOM,

    // Option to display the full list of applicants in memory
    FULL_LIST, 

    // Option to exit the program safely
    EXIT
}