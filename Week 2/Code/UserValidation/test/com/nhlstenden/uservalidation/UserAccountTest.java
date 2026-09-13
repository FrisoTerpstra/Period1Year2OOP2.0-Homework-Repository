package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserAccountTest
{
    private UserAccount userAccount;


    @BeforeEach
    void setup()
    {
        userAccount = new UserAccount("John", "123", "John@ram.com", LocalDate.of(2008, 1, 22));
    }

    @Test
    void testGetAge_dateOfBirthInFuture_throwsException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            userAccount.setDateOfBirth(LocalDate.of(2030, 2, 12));
        });

    }

    @Test
    void testSetName_getName_throwsException()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            userAccount.setName("");
        });
    }
}