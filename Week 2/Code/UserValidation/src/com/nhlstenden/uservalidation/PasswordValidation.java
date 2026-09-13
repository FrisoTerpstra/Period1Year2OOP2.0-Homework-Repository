package com.nhlstenden.uservalidation;

public class PasswordValidation implements Validation
{
    private boolean spaceAllowed;
    private boolean specialCharactersRequired;
    private boolean numbersRequired;
    private boolean lowercaseRequired;
    private boolean uppercaseRequired;

    public PasswordValidation(boolean spaceAllowed, boolean specialCharactersRequired, boolean numbersRequired, boolean lowercaseRequired, boolean uppercaseRequired)
    {
        this.spaceAllowed = spaceAllowed;
        this.specialCharactersRequired = specialCharactersRequired;
        this.numbersRequired = numbersRequired;
        this.lowercaseRequired = lowercaseRequired;
        this.uppercaseRequired = uppercaseRequired;
    }

    @Override
    public boolean validate(UserAccount userAccount)
    {
        if (userAccount == null)
        {
            throw new IllegalArgumentException("user account cannot be null");
        }

        String password = userAccount.getPassword();

        boolean hasLowercase = false;
        boolean hasUppercase = false;
        boolean hasNumber = false;
        boolean hasSpace = false;
        boolean hasSpecialCharacter = false;

        for (char character : password.toCharArray())
        {
            if (Character.isLowerCase(character))
            {
                hasLowercase = true;
            }

            if (Character.isUpperCase(character))
            {
                hasUppercase = true;
            }

            if (Character.isDigit(character))
            {
                hasNumber = true;
            }

            if (character == ' ')
            {
                hasSpace = true;
            }

            if (!Character.isLetterOrDigit(character) && character != ' ')
            {
                hasSpecialCharacter = true;
            }
        }

        if (lowercaseRequired && !hasLowercase)
        {
            return false;
        }

        if (uppercaseRequired && !hasUppercase)
        {
            return false;
        }

        if (numbersRequired && !hasNumber)
        {
            return false;
        }

        if (!spaceAllowed && hasSpace)
        {
            return false;
        }

        if (specialCharactersRequired && !hasSpecialCharacter)
        {
            return false;
        }

        return true;
    }
}
