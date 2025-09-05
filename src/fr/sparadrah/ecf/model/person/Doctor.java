package fr.sparadrah.ecf.model.person;

import fr.sparadrah.ecf.utils.RegexPatterns;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.validator.Validator;

public class Doctor extends Person {
    private String licenseNumber;



    public Doctor(String lastName, String firstName, String adress, String postalCode, String city, String phone, String email, String licenseNumber) throws SaisieException {
        super(lastName, firstName, adress, postalCode, city, phone, email);
        this.setlicenseNumber(licenseNumber);
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setlicenseNumber(String licenseNumber) throws SaisieException {
        if (licenseNumber == null) {
            throw new SaisieException("Le numero d'agréement ne peut pas etre vide ou null");
        }
        if (!licenseNumber.matches(RegexPatterns.RPPS_REGEX)) {
            throw new SaisieException("Numero d'agréement invalide");
        }

        this.licenseNumber = licenseNumber;
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
        return super.toString() + " - N° agréement : " + this.licenseNumber;
    }
}
