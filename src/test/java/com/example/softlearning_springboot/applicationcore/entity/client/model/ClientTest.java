package com.example.softlearning_springboot.applicationcore.entity.client.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ClientTest {
    @Test
    void testGetAge() {
        Client client = new Client();
        client.setAge(20);
        assertEquals(20, client.getAge());
    }

    @Test
    void testGetCompanyData() {

    }

    @Test
    void testGetDNI() {
        Client client = new Client();
        client.setDNI("12345678A");
        assertEquals("12345678A", client.getDNI());
    }

    @Test
    void testGetInstance() {

    }

    @Test
    void testSetAge() {
        Client client = new Client();
        assertTrue(client.setAge(20));
    }

    @Test
    void testSetDNI() {
        Client client = new Client();
        assertTrue(client.setDNI("12345678A"));
    }

}
