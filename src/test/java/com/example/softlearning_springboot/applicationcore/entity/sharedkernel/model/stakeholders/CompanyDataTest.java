package com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.stakeholders;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.softlearning_springboot.applicationcore.entity.sharedkernel.model.exceptions.BuildException;

public class CompanyDataTest {

    private CompanyData companyData;

    @BeforeEach
    public void setUp() {
        companyData = new CompanyData();
    }

    @Test
    void testCompanyDataNotNull() {
        try {
            companyData = new CompanyData(100, "Tech Corp");
            assertNotNull(companyData);
        } catch (BuildException e) {
            fail("Error en el GetInstance de CompanyData: " + e.getMessage());
        }
    }

    @Test
    void testCompanyDatawithInvalidWorkers() {
        try {
            companyData = new CompanyData(-100, "Tech Corp");
            fail("Expected BuildException due to invalid Workers");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Workers"));
        }
    }

    @Test
    void testCompanyDatawithInvalidSocialReason() {
        try {
            companyData = new CompanyData(100, "Tec");
            fail("Expected BuildException due to invalid Social Reason");
        } catch (BuildException e) {
            assertTrue(e.getMessage().contains("Bad Social Reason"));
        }
    }

    @Test
    void testGetWorkers() throws BuildException {
        companyData.setWorkers(100);
        assertEquals(100, companyData.getWorkers());
    }

    @Test
    void testGetSocialReason() {
        companyData.setSocialReason("Tech Corp");
        assertEquals("Tech Corp", companyData.getSocialreason());
    }

    @Test
    void testSetInvalidWorkers() {
        CompanyData companyData = new CompanyData();
        assertFalse(companyData.setWorkers(-100));
    }

    @Test
    void testSetValidWorkers() {
        CompanyData companyData = new CompanyData();
        assertTrue(companyData.setWorkers(100));
    }

    @Test
    void testSetValidSocialReason() {
        CompanyData companyData = new CompanyData();
        assertTrue(companyData.setSocialReason("Tech Corp"));
    }

    @Test
    void testSetInvalidSocialReason() {
        CompanyData companyData = new CompanyData();
        assertFalse(companyData.setSocialReason(null));
    }

    @Test
    void testGetCompanyType() {
        try {
            companyData = new CompanyData(100, "Tech Corp");
            assertEquals("Medium Company", companyData.getCompanytype());  
        } catch (BuildException e) {
            fail("Bad CompanyData: " + e.getMessage());
        }
    }

    @Test
    void testSetValidWorkersBigCompany() {
        try {
            companyData = new CompanyData(300, "Tech Corp");
            assertEquals("Big Company", companyData.getCompanytype());  // Se espera "Big Company" por los 300 trabajadores
        } catch (BuildException e) {
            fail("Bad CompanyData: " + e.getMessage());
        }
    }

    @Test
    void testSetValidWorkersSmallCompany() {
        try {
            companyData = new CompanyData(30, "Tech Corp");
            assertEquals("Small Company", companyData.getCompanytype());  // Se espera "Small Company" por los 30 trabajadores
        } catch (BuildException e) {
            fail("Bad CompanyData: " + e.getMessage());
        }
    }

    @Test
    void testSetValidWorkersMediumCompany() {
        try {
            companyData = new CompanyData(100, "Tech Corp");
            assertEquals("Medium Company", companyData.getCompanytype());  // Se espera "Medium Company" por los 100 trabajadores
        } catch (BuildException e) {
            fail("Bad CompanyData: " + e.getMessage());
        }
    }
}
