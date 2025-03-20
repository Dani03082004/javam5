package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

// AssertTrue para comprobar si es verdadero, utiliza boleano
// AssertFalse para comprobar si es falso, utiliza boleano
// AssertEquals para comparar valores, utiliza valores
// 0 --> BUENO
// -1 --> MALO

public class PhysicalDataTest {
    @Test
    void testGetFragile() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setFragile(true);
        assertTrue(physicalData.getFragile());
    }

    @Test
    void testGetHigh() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setHigh(3.3);
        assertEquals(3.3, physicalData.getHigh());
    }

    @Test
    void testGetInstance() {
        try {
            PhysicalData physicalData = PhysicalData.getInstance(10.0, 5.0, 15.0, 20.0, false);
            assertEquals(10.0, physicalData.getHigh());
            assertEquals(5.0, physicalData.getWidth());
            assertEquals(15.0, physicalData.getLength());
            assertEquals(20.0, physicalData.getWeight());
        } catch (BuildException e) {
            fail("Error en el GetInstance de PhysicalData");
        }
    }

    @Test
    void testGetLength() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setLength(15.0);
        assertEquals(15.0, physicalData.getLength());
    }

    @Test
    void testGetSize() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setHigh(10.0);
        physicalData.setWidth(5.0);
        physicalData.setLength(15.0);
        assertEquals("high: 10.0; width: 5.0; length: 15.0", physicalData.getSize());
    }

    @Test
    void testGetVolume() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setHigh(10.0);
        physicalData.setWidth(5.0);
        physicalData.setLength(15.0);
        assertEquals(750.0, physicalData.getVolume());
    }

    @Test
    void testGetWeight() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setWeight(20.0);
        assertEquals(20.0, physicalData.getWeight());
    }

    @Test
    void testGetWidth() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setWidth(5.0);
        assertEquals(5.0, physicalData.getWidth());
    }

    @Test
    void testSetFragile() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setFragile(false);
        assertFalse(physicalData.getFragile());
    }

    @Test
    void testSetHigh() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(0, physicalData.setHigh(10.0));
    }

    @Test
    void testSetLength() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(-1, physicalData.setLength(-1.0));
    }

    @Test
    void testSetWeight() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(-1, physicalData.setWeight(-5.0));
    }

    @Test
    void testSetWidth() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(-1, physicalData.setWidth(-5.0));
    }
}
