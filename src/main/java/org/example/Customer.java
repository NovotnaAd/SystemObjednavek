package org.example;

public class Customer {
    private String name;
    private String surname;
    private String email;

    public Customer(String name, String surname, String email) throws EmptyValueException, InvalidEmailException {
        if (name == null || surname == null) {
            throw new EmptyValueException("Name and surname cannot be null");
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
