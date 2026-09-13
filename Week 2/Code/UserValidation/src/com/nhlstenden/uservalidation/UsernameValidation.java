package com.nhlstenden.uservalidation;

public class UsernameValidation implements Validation
{
    private Storage storage;

    public UsernameValidation(Storage storage)
    {
        this.setStorage(storage);
    }

    @Override
    public boolean validate(UserAccount userAccount)
    {
        if (userAccount == null)
        {
            throw new IllegalArgumentException("user account can not be null");
        }

        for (UserAccount user : storage.getUsers())
        {
            if (user.getName().equals(userAccount.getName()))
            {
                return false;
            }
        }

        return true;
    }

    public Storage getStorage()
    {
        return this.storage;
    }

    public void setStorage(Storage storage)
    {
        if (storage == null)
        {
            throw new IllegalArgumentException("storage can not be null");
        }

        this.storage = storage;
    }
}
