package com.phuong.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 45)
    private String firstName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Size(min = 5, max = 45)
    private String lastName;

    @NotNull
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "^(0|84)[0-9]{9}$", message = "Phone number must have 9 digits and start with 0 or 84!")
    private String phoneNumber;

    @NotNull
    @PositiveOrZero(message = "Please enter the number!")
    @Min(18)
    private Integer age;

    @NotNull()
    @NotEmpty
    @NotBlank
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phoneNumber, Integer age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
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
    }
}
