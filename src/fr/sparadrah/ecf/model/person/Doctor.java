package fr.sparadrah.ecf.model.person;

import fr.sparadrah.ecf.utils.RegexPatterns;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.validator.Validator;

public class Doctor extends Person {
    private String rpps;

    public Doctor(){
        super();
    }

    public Doctor(String lastName, String firstName, String address, String postalCode, String city, String phone, String email, String rpps) throws SaisieException {
        super(lastName, firstName, address, postalCode, city, phone, email);
        this.setRpps(rpps);
    }

    public String getRpps() {
        return rpps;
    }

    public void setRpps(String rpps) throws SaisieException {
        if (rpps == null) {
            throw new SaisieException("Le numero d'agréement ne peut pas etre vide ou null");
        }
        if (!rpps.matches(RegexPatterns.RPPS_REGEX)) {
            throw new SaisieException("Numero d'agréement invalide");
        }

        this.rpps = rpps;
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
        return super.toString() + " - N° agréement : " + this.rpps;
    }
}
