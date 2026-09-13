package com.nhlstenden.uservalidation;

import java.time.LocalDate;
import java.time.Period;

public class UserAccount
{
    private String name;
    private String password;
    private String emailAddress;
    private LocalDate dateOfBirth;

    public UserAccount(String name, String password, String emailAddress, LocalDate dateOfBirth)
    {
        this.setName(name);
        this.setPassword(password);
        this.setEmailAddress(emailAddress);
        this.setDateOfBirth(dateOfBirth);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public String getPassword()
    {
        return this.password;
    }

    public void setPassword(String password)
    {
        if (password == null || password.isBlank())
        {
            throw new IllegalArgumentException("password cannot be null or blank");
        }

        this.password = password;
    }

    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        if (emailAddress == null || emailAddress.isBlank())
        {
            throw new IllegalArgumentException("emailAddress cannot be null or blank");
        }

        this.emailAddress = emailAddress;
    }

    public LocalDate getDateOfBirth()
    {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth)
    {
        if (dateOfBirth == null)
        {
            throw new IllegalArgumentException("dateOfBirth cannot be null");
        }

        if (dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException("date of birth can not be in the future");
        }

        this.dateOfBirth = dateOfBirth;
    }

    public int getAge()
    {
        if (this.dateOfBirth.isAfter(LocalDate.now()))
        {
            throw new IllegalArgumentException("date of birth can not be in the future");
        }

        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}