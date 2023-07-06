package com.sign_up.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserDto implements Validator {
    private String username;
    private String firstName;
    private String lastName;
    private String phone;
    private String age;
    private String email;

    public UserDto() {
    }

    public UserDto(String username, String firstName, String lastName, String phone, String age, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.age = age;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", null, "First name is not empty");
        } else if (userDto.getFirstName().length() <= 5 || userDto.getFirstName().length() >= 45) {
            errors.rejectValue("firstName", null, "First name must be between 5 and 45");
        }

        if (userDto.getLastName().isEmpty()) {
            errors.rejectValue("lastName", null, "Last name is not empty");
        } else if (userDto.getLastName().length() <= 5 || userDto.getLastName().length() >= 45) {
            errors.rejectValue("lastName", null, "Last name must be between 5 and 45");
        }

        try {
            if (Integer.parseInt(userDto.getAge()) < 18) {
                errors.rejectValue("age",null, "Age must be great more than or equal 18");
            }
        } catch (NumberFormatException e) {
            errors.rejectValue("age",null, "Age must be number!");
        }

        if (!userDto.getPhone().matches("^(090|091|\\(84\\)\\+90|\\(84\\)\\+91)[\\d]{7}$")) {
            errors.rejectValue("phone", null, "Phone number is not matches!");
        }

        if (!userDto.getEmail().matches("^[\\w.]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+){1,2}$")) {
            errors.rejectValue("email", null, "Email is not matches!");
        }

        if (!userDto.getUsername().matches("^[a-z]{8,20}$")) {
            errors.rejectValue("username", null, "Username is not matches!");
        }
    }
}
