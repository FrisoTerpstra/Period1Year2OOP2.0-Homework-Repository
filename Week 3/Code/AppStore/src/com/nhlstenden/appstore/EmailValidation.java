package com.nhlstenden.appstore;

public class EmailValidation
{
    public static boolean validate(String emailAddress)
    {
        if (emailAddress == null)
        {
            return false;
        }

        else
            if (!emailAddress.contains("@"))
            {
                return false;
            }

            else
                if (!emailAddress.contains("."))
                {
                    return false;
                }

        return true;
    }
}
