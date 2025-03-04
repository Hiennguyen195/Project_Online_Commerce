package com.example.projectcanhan.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class UserCreationRequest {

    @Size(min = 3, message = "Username must be at least 3 characters long")
    private String userName;
    @Size(min = 8, message = "Password must be at least 8 characters long")
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
