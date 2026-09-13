package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AgeValidationTest
{
    private UserAccount userAccount;
    private AgeValidation ageValidation;

    @BeforeEach
    void setup()
    {
        userAccount = new UserAccount("John", "123", "John@ram.com", LocalDate.of(2008, 1, 22));
        ageValidation = new AgeValidation(18);
    }

    @Test
    void testValidate_minimumAgeMet_testPassed()
    {
        boolean result = ageValidation.validate(userAccount);
        assertTrue(result);
        //  or assertEquals(true, ageValidation.validate(userAccount));
    }
}