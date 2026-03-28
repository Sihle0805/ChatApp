/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

import java.util.Scanner;

/**
 * Main entry point for the QuickChat application.
 * Handles the console-based registration and login flow (Part 1).
 *
 * NOTE: No GUIs or JOptionPane are used — console only.
 *
 * @author Student
 * @version 1.0
 */
public class ChatApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // A single helper Login used only to call the validation methods during input
        Login validator = new Login("", "", "", "", "");

        System.out.println("=== QuickChat – Registration ===\n");

        // ── First name (no validation rules) ─────────────────────────────────
        System.out.print("Enter your first name : ");
        String firstName = scanner.nextLine();

        // ── Last name (no validation rules) ──────────────────────────────────
        System.out.print("Enter your last name  : ");
        String lastName = scanner.nextLine();

        // ── Username – keep asking until input is valid ───────────────────────
        String username = "";
        while (true) {
            System.out.print("Enter a username      : ");
            username = scanner.nextLine();

            if (validator.checkUserName(username)) {
                System.out.println("Username successfully captured.\n");
                break;
            }
            System.out.println("Username is not correctly formatted; please ensure that "
                    + "your username contains an underscore and is no more than "
                    + "five characters in length.\n");
        }

        // ── Password – keep asking until input is valid ───────────────────────
        String password = "";
        while (true) {
            System.out.print("Enter a password      : ");
            password = scanner.nextLine();

            if (validator.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.\n");
                break;
            }
            System.out.println("Password is not correctly formatted; please ensure that "
                    + "the password contains at least eight characters, a capital "
                    + "letter, a number, and a special character.\n");
        }

        // ── Cell phone – keep asking until input is valid ─────────────────────
        String cellNumber = "";
        while (true) {
            System.out.print("Enter cell number (e.g +27812345678) : ");
            cellNumber = scanner.nextLine();

            if (validator.checkCellPhoneNumber(cellNumber)) {
                System.out.println("Cell phone number successfully added.\n");
                break;
            }
            System.out.println("Cell phone number incorrectly formatted or does not "
                    + "contain international code.\n");
        }

        // ── Build the registered user object ──────────────────────────────────
        Login login = new Login(firstName, lastName, username, password, cellNumber);
        System.out.println("Registration successful! Welcome, " + firstName + " " + lastName + ".");
        System.out.println("--------------------------------------\n");

        // ── Login – keep asking until credentials are correct ─────────────────
        System.out.println("=== QuickChat – Login ===\n");

        while (true) {
            System.out.print("Username : ");
            String enteredUsername = scanner.nextLine().trim();

            System.out.print("Password : ");
            String enteredPassword = scanner.nextLine().trim();

            System.out.println();
            System.out.println(login.returnLoginStatus(enteredUsername, enteredPassword));
            System.out.println();

            if (login.loginUser(enteredUsername, enteredPassword)) {
                break; // login successful – stop asking
            }
            // login failed – loop back and ask again automatically
        }

        scanner.close();
    }
}