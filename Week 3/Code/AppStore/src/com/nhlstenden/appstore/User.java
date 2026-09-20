package com.nhlstenden.appstore;

import java.time.LocalDate;
import java.time.Period;

public class User
{
    private String name;
    private String emailAddress;
    private LocalDate dateOfBirth;

    public User(String name, String emailAddress, LocalDate dateOfBirth)
    {
        this.setName(name);
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

    public String getEmailAddress()
    {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress)
    {
        if (EmailValidation.validate(emailAddress))
        {
            this.emailAddress = emailAddress;
        }
        else
        {
            this.emailAddress = null;
        }
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

        this.dateOfBirth = dateOfBirth;
    }

    public int getAge()
    {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }
}
