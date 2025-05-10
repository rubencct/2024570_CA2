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
 * This is the main class of the StackFlow Systems - Applicant Management Console.
 * It acts as the central controller that handles all interactions between the user and the system.
 * 
 * The Main class presents a menu to the user, reads applicants from a file, 
 * allows manual and random data entry, sorting, and searching through applicants.
 */

import java.util.*;
import java.text.Normalizer;
import static ca_2.DataValidator.JOB_TITLES;
import static ca_2.DataValidator.DEPARTMENTS;

public class Main {

    // This method takes an integer from the user and returns the corresponding menu option enum
    // It helps make the switch statement more readable and manageable
    public static MenuOption getMenuOptionFromInt(int input) {
        switch (input) {
            case 1: return MenuOption.SORT;
            case 2: return MenuOption.SEARCH;
            case 3: return MenuOption.ADD_RECORDS;
            case 4: return MenuOption.GENERATE_RANDOM;
            case 5: return MenuOption.FULL_LIST;
            case 6: return MenuOption.EXIT;
            default: return null;
        }
    }

    // This helper function normalises user input by removing accents and converting it to lowercase
    // This is useful for making search operations more consistent and reliable
    public static String normalize(String input) {
        return Normalizer.normalize(input, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .toLowerCase();
    }

    // Recursive implementation of merge sort to sort the list of applicants
    // Merge sort is chosen to meet the CA2 requirement for a recursive sorting algorithm
    public static List<Applicant> mergeSort(List<Applicant> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Applicant> left = mergeSort(list.subList(0, mid));
        List<Applicant> right = mergeSort(list.subList(mid, list.size()));

        return merge(left, right);
    }

    // This function merges two sorted lists of applicants into one
    public static List<Applicant> merge(List<Applicant> left, List<Applicant> right) {
        List<Applicant> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i).getSurname().compareToIgnoreCase(right.get(j).getSurname()) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }
        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }

    public static void main(String[] args) {
        // Create a Scanner object to read user input from the console
        Scanner kbScanner = new Scanner(System.in);
        // Read the list of applicants from a text file using a helper class
        ArrayList<Applicant> applicants = FileReaderUtility.readApplicantsFromFile("ApplicantsForm.txt");
        // This boolean variable controls the main loop
        boolean exit = false;
        
        // Welcome message for the user
        System.out.println("Welcome to StackFlow Systems - Applicant Management Console");
        
        // Start of the main menu loop
        while (!exit) {
            // Display the menu and ensure user enters a valid option (from 1 to 6)
            int choice = -1;
            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. SORT");
                System.out.println("2. SEARCH");
                System.out.println("3. ADD RECORDS");
                System.out.println("4. GENERATE RANDOM");
                System.out.println("5. FULL LIST");
                System.out.println("6. EXIT");

                System.out.print("\nPlease enter your choice (1–6): ");
                String input = kbScanner.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    if (choice >= 1 && choice <= 6) break;
                    else System.out.println("Please enter a number between 1 and 6.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a numeric value between 1 and 6.");
                }
            }
            
            // Convert the valid numeric input into a MenuOption enum value
            MenuOption option = getMenuOptionFromInt(choice);
            if (option == null) {
                System.out.println("Invalid option.");
                continue;
            }
            // Switch block to handle each menu option
            switch (option) {
                case SORT:
                    // Sort applicants alphabetically by surname and display the first 20, JUST LIKE THE CA ASKED FOR.
                    System.out.println("\n--- FIRST 20 APPLICANTS SORTED ALPHABETICALLY BY SURNAME ---");
                    List<Applicant> sortedList = mergeSort(applicants);
                    for (int i = 0; i < Math.min(20, sortedList.size()); i++) {
                        System.out.println((i + 1) + ". " + sortedList.get(i).getDetails());
                    }
                    System.out.println();
                    break;

                case SEARCH:
                    // Search by name or surname, case insensitive and accents removed
                    System.out.print("Enter name or surname to search (or type 'cancel' to go back): ");
                    String searchInput = kbScanner.nextLine();
                    if (searchInput.equalsIgnoreCase("cancel")) {
                        System.out.println("Search cancelled.\n");
                        break;
                    }
                    String search = normalize(searchInput);
                    boolean found = false;
                    int count = 1;
                    System.out.println("\n--- Search Results ---");
                    for (Person a : applicants) {
                        String fullName = normalize(a.getFirstName() + " " + a.getSurname());
                        if (fullName.contains(search)) {
                            System.out.println(count + ". " + a.getDetails());
                            found = true;
                            count++;
                        }
                    }
                    if (!found) System.out.println("No match found.");
                    System.out.println();
                    break;

                case ADD_RECORDS:
                    // Manually add a new applicant by selecting from fixed valid lists
                    
                    //Insert Name
                    System.out.println("\nType 'cancel' at any point to return to the main menu.");
                    System.out.print("First name: ");
                    String first = kbScanner.nextLine();
                    if (first.equalsIgnoreCase("cancel")) break;
                    
                    //Validation to ensure the input is a valid name  
                    if (!first.matches("[a-zA-ZÀ-ÿ\\s'-]+")) {
                        System.out.println("Invalid first name. Only letters are allowed.");
                        break;
                    }
                    
                    //Insert Surname
                    System.out.print("Surname: ");
                    String last = kbScanner.nextLine();
                    if (last.equalsIgnoreCase("cancel")) break;
                    
                    //Validation to ensure surname is valid. 
                    if (!last.matches("[a-zA-ZÀ-ÿ\\s'-]+")) {
                        System.out.println("Invalid surname. Only letters are allowed.");
                        break;
                    }

                    // Select a valid job title from the list
                    System.out.println("\nSelect a Job Title (Manager Type):");
                    for (int i = 0; i < JOB_TITLES.length; i++) {
                        System.out.println((i + 1) + ". " + JOB_TITLES[i]);
                    }
                    int jobIndex;
                    while (true) {
                        System.out.print("Enter number for Job Title: ");
                        try {
                            jobIndex = Integer.parseInt(kbScanner.nextLine());
                            if (jobIndex >= 1 && jobIndex <= JOB_TITLES.length) break;
                        } catch (NumberFormatException ignored) {}
                        System.out.println("Invalid selection. Try again.");
                    }
                    String jobTitle = JOB_TITLES[jobIndex - 1];
                    System.out.println("\nYou selected: " + jobTitle + "\n");

                    // Select a valid department from the list
                    System.out.println("Select a Department:");
                    for (int i = 0; i < DEPARTMENTS.length; i++) {
                        System.out.println((i + 1) + ". " + DEPARTMENTS[i]);
                    }
                    int deptIndex;
                    while (true) {
                        System.out.print("Enter number for Department: ");
                        try {
                            deptIndex = Integer.parseInt(kbScanner.nextLine());
                            if (deptIndex >= 1 && deptIndex <= DEPARTMENTS.length) break;
                        } catch (NumberFormatException ignored) {}
                        System.out.println("Invalid selection. Try again.");
                    }
                    String dept = DEPARTMENTS[deptIndex - 1];
                    System.out.println("\nYou selected: " + dept + "\n");
                    
                    // Create and add the new applicant to the list
                    Applicant newApplicant = new Applicant(first, last, jobTitle, dept);
                    applicants.add(newApplicant);
                    System.out.println("Applicant added: " + newApplicant.getDetails() + "\n");
                    break;

                case GENERATE_RANDOM:
                    // Generate a random applicant and ensure no duplicates
                    String[] names = {"Jack", "Emma", "Sean", "Sophie", "Liam", "Chloe", "Noah", "Grace"};
                    String[] surnames = {"Murphy", "Kelly", "Doyle", "Byrne", "Walsh", "Ryan", "Smith", "O'Brien"};
                    String[] jobTitles = JOB_TITLES;
                    String[] departments = DEPARTMENTS;

                    Random rand = new Random();
                    System.out.println("\n--- 1 Random Applicant Generated ---");
                    Applicant randomApplicant;
                    boolean unique;

                    do {
                        String rFirst = names[rand.nextInt(names.length)];
                        String rLast = surnames[rand.nextInt(surnames.length)];
                        String rTitle = jobTitles[rand.nextInt(jobTitles.length)];
                        String rDept = departments[rand.nextInt(departments.length)];
                        
                        randomApplicant = new Applicant(rFirst, rLast, rTitle, rDept);

                        // Make sure this applicant does not already exist in the list
                        unique = applicants.stream().noneMatch(a ->
                            a.getFirstName().equalsIgnoreCase(rFirst)
                            && a.getSurname().equalsIgnoreCase(rLast)
                            && a.getJobTitle().equalsIgnoreCase(rTitle)
                            && a.getDepartment().equalsIgnoreCase(rDept)
                        );
                    } while (!unique);

                    applicants.add(randomApplicant);
                    System.out.println(applicants.size() + ". " + randomApplicant.getDetails());
                    System.out.println();
                    break;

                case FULL_LIST:
                    // Display every applicant currently stored in memory
                    System.out.println("\n--- Full List of All Applicants ---");
                    for (int i = 0; i < applicants.size(); i++) {
                        System.out.println((i + 1) + ". " + applicants.get(i).getDetails());
                    }
                    System.out.println();
                    break;

                case EXIT:
                    // Ask for confirmation before closing the program
                    System.out.print("Are you sure you want to exit? (Y/N): ");
                    String confirm = kbScanner.nextLine();
                    if (confirm.equalsIgnoreCase("Y")) {
                        System.out.println("Bye!");
                        System.out.println("Thanks for using StackFlow Systems - Applicant Management Console!\n");
                        exit = true;
                    } else {
                        System.out.println("Exit cancelled. Returning to menu.\n");
                    }
                    break;
            }
        }

        // Close the scanner before exiting the application
        kbScanner.close();
    }
}
