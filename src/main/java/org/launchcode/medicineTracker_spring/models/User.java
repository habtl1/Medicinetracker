package org.launchcode.medicineTracker_spring.models;

import java.util.Objects;
import java.util.regex.Pattern;


public class User {

    private int id;
    private static int nextId = 1;

    private String name;
    private Email email;
    private String password;

    // Initialize a unique ID.
    public User() {
        id = nextId;
        nextId++;
    }

    // Initialize the id and value fields.
    public User(String aName, String anEmail, String aPassword) {
        this();
        this.name = aName;
        this.email = anEmail;
        this.password = aPassword;

    }

    // Custom toString method.

    @Override
    public String toString() {
        String output = "";
        if (name.equals("")) {
            name = "Data not available";
        }
        if (email.getValue().equals("") || email.getValue() == null) {
            email.setValue("Data not available");
        }
        if (password.getValue().equals("") || password.getPassword() == null) {
            password.setValue("Data not available");
        }

        output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Email: %s\n" +
                "Password: %s\n", id, name, email, password);
        return output;
    }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    // Getters and Setters.
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean registerUser() {
        // Validate fields
        if (name == null || name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return false;
        }
        if (email == null || !isValidEmail(email)) {
            System.out.println("Invalid email address.");
            return false;
        }
        if (password == null || password.length() < 6) {
            System.out.println("Password must be at least 6 characters long.");
            return false;
        }

        return true;
    }
        private boolean isValidEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            return pattern.matcher(email).matches();
        }
    }



