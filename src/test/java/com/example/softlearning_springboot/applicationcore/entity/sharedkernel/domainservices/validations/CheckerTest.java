package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.domainservices.validations.Checker.DateException;

// AssertTrue para comprobar si es verdadero, utiliza boleano
// AssertFalse para comprobar si es falso, utiliza boleano
// AssertEquals para comparar valores, utiliza valores
// 0 --> BUENO
// -1 --> MALO

class CheckerTest {

    @Test
    void testNotNegative() {
        assertEquals(-1, Checker.NotNegative(-5));
    }

    @Test
    void testNotNullEmptyString() {
        assertEquals(0, Checker.NotNullEmptyString("TestUnit")); 
    }

    @Test
    void testNotZeroNegative() {
        assertEquals(0, Checker.NotZeroNegative(3)); 
    }

    @Test
    void testPasswordMinLength() {
        assertEquals(0, Checker.PasswordMinLength("alumnat", 5));
    }

    @Test
    void testCheckDate() throws DateException {
        LocalDate fecha = Checker.checkDate("2025-03-20");
        String resultadofecha = fecha.toString();
        assertTrue(resultadofecha.equals("2025-03-20"));
    }

    @Test
    void testCheckDateTime() throws DateException {
        LocalDateTime fechahora = Checker.checkDateTime("2025-03-20 10:00:00");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String resultadofechahora = fechahora.format(formatter);
        assertTrue(resultadofechahora.equals("2025-03-20 10:00:00"));
    }

    @Test
    void testCheckDateTimes() throws DateException {
        LocalDateTime datehour = Checker.checkDateTimes("19-03-2025 10:00:00");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String resultadofechahora = datehour.format(formatter);
        assertTrue(resultadofechahora.equals("19-03-2025 10:00:00"));}

    @Test
    void testHasSpaces() {
        assertTrue(Checker.hasSpaces("Test Unit"));
    }

    @Test
    void testIsInt() {
        assertTrue(Checker.isInt(123));
    }

    @Test
    void testIsNegativeInt() {
        assertTrue(Checker.isNegativeInt(-3));
    }

    @Test
    void testIsValidEmailFormat() {
        assertTrue(Checker.isValidEmailFormat("tunit@gmail.com"));
    }

    @Test
    void testIsZero() {
        assertEquals(0, Checker.isZero(0)); 
    }

    @Test
    void testMinLength() {
        assertTrue(Checker.minLength("Java", 3));
    }

    @Test
    void testMinValue() {
        assertEquals(0,(Checker.minValue(10, 5)));
    }

    @Test
    void testNonNegative() {
        assertEquals(0, Checker.nonNegative(8));
    }

    @Test
    void testValidarDNI() {
        assertEquals(0, Checker.validarDNI("12345678A"));
    }
}
