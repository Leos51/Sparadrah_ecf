package fr.sparadrah.ecf.model.person;

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




    @Override
    public String showDetails() {
        StringBuilder details = new StringBuilder();
        details.append(this);
        details.append("\n------------------");
        details.append(super.showDetails());
        return details.toString();
    }

    @Override
    public String toString() {
        return super.toString() + " - N° agréement : " + this.certificationNumber;
    }
}
