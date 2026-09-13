package com.nhlstenden.uservalidation;

import java.util.ArrayList;
import java.util.List;

public class ValidationService
{
    private List<Validation> validations;
    private Storage storage;

    public ValidationService(Storage storage)
    {
        if (storage == null)
        {
            throw new IllegalArgumentException("storage cannot be null");
        }

        this.storage = storage;
        this.validations = new ArrayList<>();
    }

    public void addValidation(Validation validation)
    {
        if (validation == null)
        {
            throw new IllegalArgumentException("validation cannot be null");
        }

        this.validations.add(validation);
    }

    public boolean validateAndStore(UserAccount userAccount)
    {
        if (userAccount == null)
        {
            throw new IllegalArgumentException("user account cannot be null");
        }

        for (Validation validation : this.validations)
        {
            if (!validation.validate(userAccount))
            {
                return false;
            }
        }

        this.storage.addUser(userAccount);
        return true;
    }

}
