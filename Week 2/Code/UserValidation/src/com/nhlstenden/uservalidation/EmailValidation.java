package com.nhlstenden.uservalidation;

public class EmailValidation implements Validation
{
    @Override
    public boolean validate(UserAccount userAccount)
    {

        if (userAccount == null)
        {
            throw new IllegalArgumentException("userAccount can not be null");
        }

        String email = userAccount.getEmailAddress();

        if (!email.contains("@") || !email.contains("."))
        {
            return false;
        }

        return true;
    }
}
