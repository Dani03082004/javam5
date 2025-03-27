package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.physics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class PhysicalDataTest {
    @Test
    void testGetFragile() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setFragile(true);
        assertTrue(physicalData.getFragile());
    }

    @Test
    void testGetFragileFalse() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setFragile(false);
        assertFalse(physicalData.getFragile());
    }

    @Test
    void testGetHigh() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setHigh(3.3);
        assertEquals(3.3, physicalData.getHigh());
    }

    @Test
    void testGetInstanceNotNull() {
        try {
            PhysicalData physicalData = PhysicalData.getInstance(10.0, 5.0, 15.0, 20.0, false);
            assertNotNull(physicalData);
        } catch (BuildException e) {
            fail("Error en el GetInstance de PhysicalData: " + e.getMessage());
        }
    }

    @Test
    void testGetInstanceWithInvalidHigh() {
        try {
            PhysicalData.getInstance(-10.0, 5.0, 15.0, 20.0, false);
            fail("Expected BuildException due to invalid high");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad high"));
        }
    }

    @Test
    void testGetInstanceWithInvalidWidth() {
        try {
            PhysicalData.getInstance(10.0, -5.0, 15.0, 20.0, false);
            fail("Expected BuildException due to invalid width");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad width"));
        }
    }

    @Test
    void testGetInstanceWithInvalidLength() {
        try {
            PhysicalData.getInstance(10.0, 5.0, -15.0, 20.0, false);
            fail("Expected BuildException due to invalid length");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad length"));
        }
    }

    @Test
    void testGetInstanceWithInvalidWeight() {
        try {
            PhysicalData.getInstance(10.0, 5.0, 15.0, -20.0, false);
            fail("Expected BuildException due to invalid weight");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad weight"));
        }
    }

    @Test
    void testGetInstanceWithInvalidValues() {
        try {
            PhysicalData.getInstance(-10.0, -5.0, -15.0, -20.0, false);
            fail("Expected BuildException due to invalid values");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad high"));
            assertTrue(e.getMessage().contains("Bad width"));
            assertTrue(e.getMessage().contains("Bad length"));
            assertTrue(e.getMessage().contains("Bad weight"));
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
    void testSetHighInvalid() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(-1, physicalData.setHigh(-10.0));
    }

    @Test
    void testSetHighValid() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(0, physicalData.setHigh(10.0));
        assertEquals(10.0, physicalData.getHigh());
    }

    @Test
    void testSetLengthInvalid() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(-1, physicalData.setLength(-1.0));
    }

    @Test
    void testSetLengthValid() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(0, physicalData.setLength(10.0));
        assertEquals(10.0, physicalData.getLength());
    }

    @Test
    void testSetWeightInvalid() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(-1, physicalData.setWeight(-5.0));
    }

    @Test
    void testSetWeightValid() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(0, physicalData.setWeight(10.0));
        assertEquals(10.0, physicalData.getWeight());
    }

    @Test
    void testSetWidthInvalid() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(-1, physicalData.setWidth(-5.0));
    }

    @Test
    void testSetWidthValid() {
        PhysicalData physicalData = new PhysicalData();
        assertEquals(0, physicalData.setWidth(10.0));
        assertEquals(10.0, physicalData.getWidth());
    }

    @Test
    void testToString() {
        PhysicalData physicalData = new PhysicalData();
        physicalData.setHigh(10.0);
        physicalData.setWidth(5.0);
        physicalData.setLength(15.0);
        physicalData.setWeight(20.0);
        physicalData.setFragile(false);
        assertEquals("PhysicalData[high=10.0, width=5.0, length=15.0, weight=20.0, fragile=false]",
                physicalData.toString());
    }
}