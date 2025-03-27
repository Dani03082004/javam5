package com.example.softlearning_springboot.applicationcore.entity.client.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;
import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders.CompanyData;

public class ClientTest {

    private Client client;

    @BeforeEach
    public void setUp() {
        client = new Client();
    }

    @Test
    void testGetInstanceNotNull() {
        try {
            Client client = Client.getInstance(1, "Casi", "Avenida Grande", "Ildoste", 1234567890, 12345, "casildo@gmail.com", "1990-01-01", "12345678A", 30, 100, "Tech Corp");
            assertNotNull(client);
        } catch (BuildException e) {
            fail("Error en el GetInstance de Client: " + e.getMessage());
        }
    }

    @Test
    void testGetInstancewithInvalidId() {
        try {
            Client.getInstance(-1, "Casi", "Avenida Grande", "Ildo", 1234567890, 12345, "casildo@gmail.com", "1990-01-01", "12345678A", 30, 100, "Tech Corp");
            fail("Expected BuildException due to invalid id");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad ID"));
        }
    }

    @Test
    void testGetInstancewithInvalidName() {
        try {
            Client.getInstance(1, "C", "Avenida Grande", "Ildo", 1234567890, 12345, "casildo@gmail.com", "1990-01-01", "12345678A", 30, 100, "Tech Corp");
            fail("Expected BuildException due to invalid name");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Name"));
        }
    }

    @Test
    void testGetInstancewithInvalidAddress() {
        try {
            Client.getInstance(1, "Casi", null, "Ildo", 1234567890, 12345, "casildo@gmail.com", "1990-01-01", "12345678A", 30, 100, "Tech Corp");
            fail("Expected BuildException due to invalid address");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Address"));
        }
    }

    @Test
    void testGetInstancewithInvalidSurname() {
        try {
            Client.getInstance(1, "Casi", "Avenida Grande", " ", 1234567890, 12345, "casildo@gmail.com", "1990-01-01", "12345678A", 30, 100, "Tech Corp");
            fail("Expected BuildException due to invalid Surname");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Surname"));
        }
    }

    @Test
    void testGetInstancewithInvalidPhoneNumber() {
        try {
            Client.getInstance(1, "Casi", "Avenida Grande", "Ildo", -12, 12345, "casildo@gmail.com", "1990-01-01", "12345678A", 30, 100, "Tech Corp");
            fail("Expected BuildException due to invalid phone number");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Phone Number"));
        }
    }

    @Test
    void testGetInstancewithInvalidPostalCode() {
        try {
            Client.getInstance(1, "Casi", "Avenida Grande", "Ildo", 1234567890, -123, "casildo@gmail.com", "1990-01-01", "12345678A", 30, 100, "Tech Corp");
            fail("Expected BuildException due to invalid Postal Code");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Postal Code"));
        }
    }

    @Test
    void testGetInstancewithInvalidEmail() {
        try {
            Client.getInstance(1, "Casi", "Avenida Grande", "Ildo", 1234567890, 12345, "c", "1990-01-01", "12345678A", 30, 100, "Tech Corp");
            fail("Expected BuildException due to invalid Email");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Email"));
        }
    }

    @Test
    void testGetInstancewithInvalidBirthday() {
        try {
            Client.getInstance(1, "Casi", "Avenida Grande", "Ildo", 1234567890, 12345, "casildo@gmail.com", null, "12345678A", 30, 100, "Tech Corp");
            fail("Expected BuildException due to invalid Birthday");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Birthday"));
        }
    }

    @Test
    void testGetInstancewithInvalidDNI() {
        try {
            Client.getInstance(1, "Casi", "Avenida Grande", "Ildo", 1234567890, 12345, "casildo@gmail.com", "1990-01-01", "1234567", 30, 100, "Tech Corp");
            fail("Expected BuildException due to invalid DNI");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad DNI"));
        }
    }

    @Test
    void testGetInstancewithInvalidAge() {
        try {
            Client.getInstance(1, "Casi", "Avenida Grande", "Ildo", 1234567890, 12345, "casildo@gmail.com", "1990-01-01", "12345678A", -30, 100, "Tech Corp");
            fail("Expected BuildException due to invalid Age");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Age"));
        }
    }

    @Test
    void testGetInstancewithInvalidWorkers() {
        try {
            Client.getInstance(1, "Casi", "Avenida Grande", "Ildo", 1234567890, 12345, "casildo@gmail.com", "1990-01-01", "12345678A", 30, -100, "Tech Corp");
            fail("Expected BuildException due to invalid Workers");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Workers"));
        }
    }

    @Test
    void testGetInstancewithInvalidSocialReason() {
        try {
            Client.getInstance(1, "Casi", "Avenida Grande", "Ildo", 1234567890, 12345, "casildo@gmail.com", "1990-01-01", "12345678A", 30, 100, "Tec");
            fail("Expected BuildException due to invalid Social Reason");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Social Reason"));
        }
    }

    @Test
    void testGetAge() {
        client.setAge(20);
        assertEquals(20, client.getAge());
    }

    @Test
    void testValidSetAge() {
        assertTrue(client.setAge(20));
    }

    @Test 
    void testInvalidSetAge() {
        assertFalse(client.setAge(-1));
    }

    @Test
    void testGetDNI() {
        client.setDNI("12345678A");
        assertEquals("12345678A", client.getDNI());
    }

    @Test
    void testSetValidDNI() {
        assertTrue(client.setDNI("12345678A"));
    }

    @Test
    void testSetInvalidDNI() {
        assertFalse(client.setDNI("invalid-dni"));
    }

    @Test
    void testToString() {
        client.setDNI("12345678A");
        client.setAge(30);
        assertEquals("Client [dni=12345678A, age=30]", client.toString());
    }

    @Test
    void testGetData() throws BuildException {
        CompanyData companyData = new CompanyData(100, "Tech Corp");
        client.setCompanyData(companyData);
        client.setDNI("12345678A");
        client.setAge(30);

        String expectedData = " su DNI es: 12345678A, su edad es: 30 años, tipo de empresa: " 
            + companyData.getCompanytype() + ", número de trabajadores: 100, razón social: Tech Corp";

        assertEquals(expectedData, client.getData());
    }

    @Test
    void testGetContactData() throws BuildException {
        CompanyData companyData = new CompanyData(100, "Tech Corp");
        client.comp = companyData;
    
        client.setDNI("12345678A");
        client.setAge(30);
        client.setName("Casi");
        client.setCognoms("Ildoste"); 
        client.setAddress("Avenida Grande");
        client.setEmail("casildo@gmail.com");
        client.setPhoneNumber(1234567890);
        client.setPostalCode(12345);
    
        String expectedContactData = "ESTA ES LA INFORMACIÓN DEL CLIENTE:  su nombre es: Casi, sus apellidos son: Ildoste, la dirección es: Avenida Grande, su correo electrónico es: casildo@gmail.com, el teléfono correspondiente es: 1234567890, el código postal es: 12345, su DNI es: 12345678A, su edad es: 30 años, tipo de empresa: Medium Company, número de trabajadores: 100, razón social: Tech Corp";
        
        assertEquals(expectedContactData, client.getContactData());
    }
    
}
