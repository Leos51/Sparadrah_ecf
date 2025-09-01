package fr.sparadrah.ecf.model.entity.person;

import fr.sparadrah.ecf.model.entity.Entity;
import fr.sparadrah.ecf.utils.exception.SaisieException;

public class Person extends Entity {
    private String firstName;
    private String lastName;


    public Person(String lastName, String firstName, String adress, String postCode, String city, String phone, String email) throws SaisieException {
        super(adress, postCode, city, phone, email);
        this.setLastName(lastName);
        this.setFirstName(firstName);
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
