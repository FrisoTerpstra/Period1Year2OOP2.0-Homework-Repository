package com.nhlstenden.uservalidation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ValidationServiceTest
{
    private ValidationService validationService;
    private Storage storage;
    private UserAccount userAccount1;
    private UserAccount userAccount2;
    private PasswordValidation passwordValidation;
    private EmailValidation emailValidation;
    private AgeValidation ageValidation;
    private UsernameValidation usernameValidation;

    @BeforeEach
    void setup()
    {
        storage = new Storage();
        validationService = new ValidationService(storage);
        userAccount1 = new UserAccount("John", "Lekker!1", "John@ram.com", LocalDate.of(2008, 1, 22));
        userAccount2 = new UserAccount("John", "Lekker!11", "John@fram.com", LocalDate.of(2008, 1, 22));
        passwordValidation = new PasswordValidation(true, true, true, true, true);
        emailValidation = new EmailValidation();
        ageValidation = new AgeValidation(18);
        usernameValidation = new UsernameValidation(storage);
    }

    @Test
    void testValidateAndStore_checkAllValidations_shouldBeTrue()
    {
        validationService.addValidation(passwordValidation);
        validationService.addValidation(emailValidation);
        validationService.addValidation(ageValidation);
        validationService.addValidation(usernameValidation);

        boolean result = validationService.validateAndStore(userAccount1);

        assertTrue(result);

        assertEquals(1, storage.getUsers().size());
    }

    @Test
    void testValidateAndStore_sameNameTwice_shouldBeFalse()
    {
        validationService.addValidation(passwordValidation);
        validationService.addValidation(emailValidation);
        validationService.addValidation(ageValidation);
        validationService.addValidation(usernameValidation);

        validationService.validateAndStore(userAccount2);

        boolean result = validationService.validateAndStore(userAccount1);

        assertFalse(result);
    }
}