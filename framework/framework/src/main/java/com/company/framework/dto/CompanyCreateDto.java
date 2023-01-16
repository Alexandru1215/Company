package com.company.framework.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UniqueElements;

public class CompanyCreateDto {

    @NotBlank(message = "Company name is mandatory")

    private String name;
    @NotNull(message = "Register number cannot be null")

    @Min(value = 10000000000L)
    private Long registerNumber;

    @Email(message = "invalid e-mail")
    @NotBlank(message = "Email is mandatory")
    private String email;
    private String address;

    private String phoneNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(Long registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

