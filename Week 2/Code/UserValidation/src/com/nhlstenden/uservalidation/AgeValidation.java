package com.nhlstenden.uservalidation;

public class AgeValidation implements Validation
{
    private int minimumAge;

    public AgeValidation(int minimumAge)
    {
        this.setMinimumAge(minimumAge);
    }

    @Override
    public boolean validate(UserAccount userAccount)
    {
        if (userAccount == null)
        {
            throw new IllegalArgumentException("userAccount can not be null");
        }

        int age = userAccount.getAge();

        if (age < this.getMinimumAge())
        {
            return false;
        }

        return true;
    }

    public int getMinimumAge()
    {
        return this.minimumAge;
    }

    public void setMinimumAge(int minimumAge)
    {
        if (minimumAge < 0)
        {
            throw new IllegalArgumentException("minimum age can not be below zero");
        }

        this.minimumAge = minimumAge;
    }
}
