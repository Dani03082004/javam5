package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class PersonOBJTest {
    @Test
    void testGetInstanceNotNull() {
        try {
            PersonOBJ person = PersonOBJ.getInstance(1, "Perico", "Calle Perico", "Delgado", 648473821, 84839, "pericodelgado@gmail.com", "11-11-1990");
            assertNotNull(person);
        } catch (BuildException e) {
            fail("Error en el GetInstance de Person: " + e.getMessage());
        }
    }

    @Test
    void testGetInstancewithInvalidId() {
        try {
            PersonOBJ.getInstance(-1, "Perico", "Calle Perico", "Delgado", 648473821, 84839, "pericodelgado@gmail.com", "11-11-1990");
            fail("Expected BuildException due to invalid id");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad ID"));
        }
    }

    @Test
    void testGetInstancewithInvalidName() {
        try {
            PersonOBJ.getInstance(1, "O", "Calle Perico", "Delgado", 648473821, 84839, "pericodelgado@gmail.com", "11-11-1990");
            fail("Expected BuildException due to invalid name");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Name"));
        }
    }

    @Test
    void testGetInstancewithInvalidAddress() {
        try {
            PersonOBJ.getInstance(1, "Perico", "C", "Delgado", 648473821, 84839, "pericodelgado@gmail.com", "11-11-1990");
            fail("Expected BuildException due to invalid address");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Address"));
        }
    }

    @Test
    void testGetInstancewithInvalidSurname() {
        try {
            PersonOBJ.getInstance(1, "Perico", "Calle Perico", " ", 648473821, 84839, "pericodelgado@gmail.com", "11-11-1990");
            fail("Expected BuildException due to invalid Surname");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Surname"));
        }
    }

    @Test
    void testGetInstancewithInvalidPhoneNumber() {
        try {
            PersonOBJ.getInstance(1, "Perico", "Calle Perico", "Delgado", 0, 84839, "pericodelgado@gmail.com", "11-11-1990");
            fail("Expected BuildException due to invalid phone number");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Phone Number"));
        }
    }

    @Test
    void testGetInstancewithInvalidPostalCode() {
        try {
            PersonOBJ.getInstance(1, "Perico", "Calle Perico", "Delgado", 648473821, -1, "pericodelgado@gmail.com", "11-11-1990");
            fail("Expected BuildException due to invalid Postal Code");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Postal Code"));
        }
    }

    @Test
    void testGetInstancewithInvalidEmail() {
        try {
            PersonOBJ.getInstance(1, "Perico", "Calle Perico", "Delgado", 648473821, 8, "p", "11-11-1990");
            fail("Expected BuildException due to invalid Email");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Email"));
        }
    }

    @Test
    void testGetInstancewithInvalidBirthday() {
        try {
            PersonOBJ.getInstance(1, "Perico", "Calle Perico", "Delgado", 648473821, 8, "pericodelgado@gmail.com", null);
            fail("Expected BuildException due to invalid Birthday");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Birthday"));
        }
    }

    @Test
    void testGetInstancewithInvalidValues() {
        try {
            PersonOBJ.getInstance(-1, "P", "C", " ", -61, -8, "pm", null);
            fail("Expected BuildException due to invalid values");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad ID"));
            assertTrue(e.getMessage().contains("Bad Name"));
            assertTrue(e.getMessage().contains("Bad Address"));
            assertTrue(e.getMessage().contains("Bad Surname"));
            assertTrue(e.getMessage().contains("Bad Phone Number"));
            assertTrue(e.getMessage().contains("Bad Postal Code"));
            assertTrue(e.getMessage().contains("Bad Email"));
            assertTrue(e.getMessage().contains("Bad Birthday"));
        }
    }

    @Test
    void testGetAddress() {
        PersonOBJ person = new PersonOBJ();
        person.setAddress("Calle Perico");
        assertEquals("Calle Perico", person.getAddress());
    }

    @Test
    void testGetBirthday() {
        PersonOBJ person = new PersonOBJ();
        person.setBirthday("11-11-1990");
        assertEquals("11-11-1990", person.getBirthday());
    }

    @Test
    void testGetCognoms() {
        PersonOBJ person = new PersonOBJ();
        person.setCognoms("Delgado");
        assertEquals("Delgado", person.getCognoms());
    }

    @Test
    void testGetData() {
        PersonOBJ person = new PersonOBJ();
        person.setAddress("Calle Perico"); 
        person.setBirthday("11-11-1990");
        person.setCognoms("Delgado");
        person.setEmail("pericodelgado@gmail.com");
        person.setId(1);
        person.setName("Perico");
        person.setPhoneNumber(648473821);
        person.setPostalCode(84839);
        String expected = "ESTA ES LA INFORMACIÓN DE LA PERSONA: "
            + "id: 1, nombre: Perico, apellidos: Delgado, dirección: Calle Perico, teléfono: 648473821, "
            + "código Postal: 84839, correo Electrónico: pericodelgado@gmail.com, cumpleaños: 11-11-1990";
        String actual = person.getData();
        assertEquals(expected, actual);
    }

    @Test
    void testGetEmail() {
        PersonOBJ person = new PersonOBJ();
        person.setEmail("pericodelgado@gmail.com");
        assertEquals("pericodelgado@gmail.com", person.getEmail());
    }

    @Test
    void testGetId() {
        PersonOBJ person = new PersonOBJ();
        person.setId(1);
        assertEquals(1, person.getId());
    }

    @Test
    void testGetName() {
        PersonOBJ person = new PersonOBJ();
        person.setName("Perico");
        assertEquals("Perico", person.getName());
    }

    @Test
    void testGetPhoneNumber() {
        PersonOBJ person = new PersonOBJ();
        person.setPhoneNumber(648473821);
        assertEquals(648473821, person.getPhoneNumber());
    }

    @Test
    void testGetPostalCode() {
        PersonOBJ person = new PersonOBJ();
        person.setPostalCode(84839);
        assertEquals(84839, person.getPostalCode());
    }

    @Test
    void testSetAddressValid() {
        PersonOBJ person = new PersonOBJ();
        assertTrue(person.setAddress("Calle Perico"));
    }

    @Test
    void testSetAddressInValid() {
        PersonOBJ person = new PersonOBJ();
        assertFalse(person.setAddress("C"));
    }

    @Test
    void testSetBirthdayValid() {
        PersonOBJ person = new PersonOBJ();
        assertTrue(person.setBirthday("11-11-1990"));
    }

    @Test
    void testSetBirthdayInvalid() {
        PersonOBJ person = new PersonOBJ();
        assertFalse(person.setBirthday(null));
    }

    @Test
    void testSetCognomsValid() {
        PersonOBJ person = new PersonOBJ();
        assertTrue(person.setCognoms("Delgado"));
    }

    @Test
    void testSetCognomInvalid() {
        PersonOBJ person = new PersonOBJ();
        assertFalse(person.setCognoms("D"));
    }

    @Test
    void testSetEmailValid() {
        PersonOBJ person = new PersonOBJ();
        assertTrue(person.setEmail("pericodelgado@gmail.com"));
    }

    @Test
    void testSetEmailInvalid() {
        PersonOBJ person = new PersonOBJ();    
        assertFalse(person.setEmail(" "));
    }

    @Test
    void testSetIdValid() {
        PersonOBJ person = new PersonOBJ();
        assertTrue(person.setId(1));
    }

    @Test
    void testSetIdInvalid() {
        PersonOBJ person = new PersonOBJ();
        assertFalse(person.setId(-1));
    }

    @Test
    void testSetNameValid() {
        PersonOBJ person = new PersonOBJ();
        assertTrue(person.setName("Perico"));
    }

    @Test
    void testSetNameInvalid() {
        PersonOBJ person = new PersonOBJ();
        assertFalse(person.setName("P"));
    }

    @Test
    void testSetPhoneNumberValid() {
        PersonOBJ person = new PersonOBJ();
        assertTrue(person.setPhoneNumber(648473821));
    }

    @Test
    void testSetPhoneNumberInvalid() {
        PersonOBJ person = new PersonOBJ();
        assertFalse(person.setPhoneNumber(-1));
    }

    @Test
    void testSetPostalCodeValid() {
        PersonOBJ person = new PersonOBJ();
        assertTrue(person.setPostalCode(84839));
    }

    @Test
    void testSetPostalCodeInvalid() {
        PersonOBJ person = new PersonOBJ();
        assertFalse(person.setPostalCode(-8));
    }

    @Test
    void testToString() {
        PersonOBJ person = new PersonOBJ();
        person.setId(1);
        person.setName("Perico");
        person.setCognoms("Delgado");
        assertEquals("PersonOBJ [id=1, name=Perico, cognoms=Delgado]", person.toString());
    }
}
