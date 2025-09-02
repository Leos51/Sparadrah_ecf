package fr.sparadrah.ecf.test;

import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static fr.sparadrah.ecf.utils.UserInput.capitalize;
import static org.junit.jupiter.api.Assertions.*;
class CustomerTest {
    Customer customer;

    @BeforeEach
    void setUp() throws SaisieException {
        customer = new Customer("Recto", "Verso", "3 rue Maurice de Broglie", "51000", "Chalons en Champagne", " 03 26 68 03 00", "rectoverso@gmail.com", "1825194528231", "28-02-2010");
    }

    @AfterEach
    void tearDown() {
        customer = null;
    }

    @Test
    void getFirstName() {
        assertEquals("Verso", customer.getFirstName());
    }

    @ParameterizedTest(name = "{0} : le setter fonctionne correctement")
    @ValueSource(strings = {"Verso", "verso", "VERSO ", " verSo", "Heat",} )
    void setFirstNameTest_Success(String name) {
        customer.setFirstName(name);
        assertEquals(capitalize(name.trim()), customer.getFirstName());
    }

    @Test
    void getLastName() {
    }

    @ParameterizedTest(name = "{0} : le setter fonctionne correctement")
    @ValueSource(strings = {"Verso", "verso", "VERSO ", " verSo", "Heat",} )
    void setLastNameTest_Success(String name) {
        customer.setLastName(name);
        assertEquals(capitalize(name.trim()), customer.getLastName());
    }

    @Test
    void getAdress() {
    }

    @Test
    void setAdress() {
    }

    @Test
    void getPostCode() {
    }

    @Test
    void setPostCode() {
    }

    @Test
    void getCity() {
    }

    @Test
    void setCity() {
    }

    @Test
    void getPhone() {
    }

    @ParameterizedTest(name = "{0} : le setter fonctionne correctement")
    @ValueSource(strings = {"0123456789", "01 23 45 67 89", "01.23.45.67.89", "+33-1.23.45.67.89", "+33 - 123 456 789"} )
    void testSetPhone_Success(String phone) throws SaisieException {
        customer.setPhone(phone);
        assertEquals(phone, customer.getPhone());
    }

    @ParameterizedTest(name = "{0} : le setter leve une exception correctement")
    @ValueSource(strings = {"Verso", " 1link103@live.fr", "reD51@"} )
    void testSetEmail_Fail(String email) {
        assertThrows(Exception.class, () -> customer.setEmail(email));

    }

    @Test
    void getEmail() {
        assertEquals("rectoverso@gmail.com", customer.getEmail());
    }

    @ParameterizedTest(name = "{0} : le setter fonctionne correctement")
    @ValueSource(strings = {"leo@mail.com", "link103@live.fr", "reD51@orange.fr"} )
    void testSetEmail_Success(String email) throws SaisieException {
        customer.setEmail(email);
        assertEquals(email, customer.getEmail());
    }


    @Test
    void testGetNIR() {
        assertEquals("1825194528231", customer.getNIR());
    }

    @Test
    void setSecuNumber() {
    }

    @Test
    void getBirthDate() {
    }

    @Test
    void setBirthDate() {
    }

    @Test
    void getInsuranceCompagny() {
    }

    @Test
    void setInsuranceCompagny() {
    }

    @Test
    void getDoctorName() {
    }

    @Test
    void setDoctorName() {
    }
}