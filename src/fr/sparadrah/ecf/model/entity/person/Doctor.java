package fr.sparadrah.ecf.model.entity.person;

import fr.sparadrah.ecf.utils.exception.SaisieException;

public class Doctor extends Person {
    private String certificationNumber;
    public Doctor(String lastName, String firstName, String adress, String postalCode, String city, String phone, String email, String certificationNumber) throws SaisieException {
        super(lastName, firstName, adress, postalCode, city, phone, email);
        this.setCertificationNumber(certificationNumber);
    }

    public String getCertificationNumber() {
        return certificationNumber;
    }

    public void setCertificationNumber(String certificationNumber) {
        this.certificationNumber = certificationNumber;
    }
}
