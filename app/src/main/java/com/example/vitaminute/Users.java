package com.example.vitaminute;

public class Users {
    private String name, surname , email, phone;

    // constructor
    public Users() {}

    // getters
    public String getName() {
        return name;
    }

    public String getSurname() { return surname; }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
