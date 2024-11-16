package org.launchcode.medicineTracker_spring;

import java.util.Objects;


public class User {

    private int id;
    private static int nextId = 1;

    private String name;
    private Email email;
    private Password password;

    // Initialize a unique ID.
    public User() {
        id = nextId;
        nextId++;
    }

    // Initialize the id and value fields.
    public User(String aName, Email anemail, Password apassword) {
        this();
        name = aName;
        Email = anemail;
        Password = apassword;

    }

}
