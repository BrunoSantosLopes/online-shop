package ch.hesge.onlineshop.services;

import org.junit.jupiter.api.Test;
import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorServicesTest {

    @Inject
    private ValidatorServices validatorServices = new ValidatorServices();

    @Test
    void isInt() {
        Boolean bool = validatorServices.isInt("10");
        assertTrue(bool);

        Boolean nullValue = validatorServices.isInt(null);
        assertFalse(nullValue);

        Boolean emptyValue = validatorServices.isInt("");
        assertFalse(emptyValue);
    }

    @Test
    void isValidEmail() {
        Boolean boo = validatorServices.isValidEmail("abc@abc.ch");
        assertTrue(boo);

        Boolean nullValue = validatorServices.isValidEmail(null);
        assertFalse(nullValue);

        Boolean emptyValue = validatorServices.isValidEmail("");
        assertFalse(emptyValue);

        Boolean format = validatorServices.isValidEmail("abc@abc");
        assertFalse(format);

    }

    @Test
    void isValidNumberCard() {

        Boolean bool = validatorServices.isValidNumberCard("4242424242424242");
        assertTrue(bool);

        Boolean nullValue = validatorServices.isValidNumberCard(null);
        assertFalse(nullValue);

        Boolean emptyValue = validatorServices.isValidNumberCard("");
        assertFalse(emptyValue);

        Boolean format = validatorServices.isValidNumberCard("42424242424242421");
        assertFalse(format);
    }

    @Test
    void isValidMonth() {

        Boolean bool = validatorServices.isValidMonth("2");
        assertTrue(bool);

        Boolean nullValue = validatorServices.isValidMonth(null);
        assertFalse(nullValue);

        Boolean emptyValue = validatorServices.isValidMonth("");
        assertFalse(emptyValue);

        Boolean borneInf = validatorServices.isValidMonth("0");
        assertFalse(borneInf);

        Boolean borneSup = validatorServices.isValidMonth("13");
        assertFalse(borneSup);
    }

    @Test
    void isValidYear() {

        Boolean bool = validatorServices.isValidYear("20");
        assertTrue(bool);

        Boolean nullValue = validatorServices.isValidYear(null);
        assertFalse(nullValue);

        Boolean emptyValue = validatorServices.isValidYear("");
        assertFalse(emptyValue);

        Boolean borneInf = validatorServices.isValidYear("18");
        assertFalse(borneInf);

        Boolean borneSup = validatorServices.isValidYear("100");
        assertFalse(borneSup);
    }
}