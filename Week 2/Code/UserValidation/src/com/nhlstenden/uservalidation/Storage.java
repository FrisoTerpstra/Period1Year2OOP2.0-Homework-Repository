package com.nhlstenden.uservalidation;

import java.util.ArrayList;
import java.util.List;

public class Storage
{
    private List<UserAccount> users;

    public Storage()
    {
        this.users = new ArrayList<>();
    }

    public List<UserAccount> getUsers()
    {
        return new ArrayList<>(this.users);
    }

    public void addUser(UserAccount userAccount)
    {
        if (userAccount == null)
        {
            throw new IllegalArgumentException("userAccount can not be null");
        }

        this.users.add(userAccount);
    }
}
