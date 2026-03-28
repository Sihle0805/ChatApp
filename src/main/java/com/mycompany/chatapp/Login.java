/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;


/**
 * Login class handles user registration and authentication.
 * Validates username, password complexity, and South African cell phone numbers.
 *
 * @author Student
 * @version 1.0
 */
public class Login {

    // ── Stored user data ──────────────────────────────────────────────────────
    private String username;
    private String password;
    private String cellPhoneNumber;
    private String firstName;
    private String lastName;

    // ── Constructor ───────────────────────────────────────────────────────────

    /**
     * Creates a Login instance with the supplied user details.
     *
     * @param firstName       user's first name
     * @param lastName        user's last name
     * @param username        chosen username
     * @param password        chosen password
     * @param cellPhoneNumber South-African cell number with international code
     */
    public Login(String firstName, String lastName,
                 String username, String password, String cellPhoneNumber) {
        this.firstName       = firstName;
        this.lastName        = lastName;
        this.username        = username;
        this.password        = password;
        this.cellPhoneNumber = cellPhoneNumber;
    }

    // ── Validation methods (overloaded) ───────────────────────────────────────

    /**
     * Checks the stored username — used after the object is fully built.
     * Delegates to the parameterised version.
     */
    public boolean checkUserName() {
        return checkUserName(this.username);
    }

    