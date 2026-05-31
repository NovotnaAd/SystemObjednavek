package org.example;

public class Customer {
    private String name;
    private String surname;
    private String email;

    public Customer(String name, String surname, String email) throws EmptyValueException, InvalidEmailException {
        if (name == null || name.trim().isEmpty()) {
            throw new EmptyValueException("Name cannot be null");
        }
        if (surname == null || surname.trim().isEmpty()) {
            throw new EmptyValueException("Surname cannot be null");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new EmptyValueException("Email cannot be null");
        }
        if(!email.contains("@") || (!email.endsWith(".com") && !email.endsWith(".cz"))) {
            throw new InvalidEmailException("Invalid email address");
        }
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
