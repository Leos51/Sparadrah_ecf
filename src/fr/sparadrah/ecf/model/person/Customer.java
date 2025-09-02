package fr.sparadrah.ecf.model.person;


import fr.sparadrah.ecf.model.MutualInsurance;
import fr.sparadrah.ecf.utils.DateFormat;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.validator.Validator;

import java.time.LocalDate;


public class Customer extends Person {
    private String NIR; //  Le NIR (Numéro d'inscription au Répertoire) est aussi appelé numéro de Sécurité sociale.
    private LocalDate birthDate;
    private MutualInsurance mutualInsurance;
    private Doctor doctor;


    public Customer(String lastName, String firstName, String adress, String postCode, String city, String phone, String email, String NIR , String birthDate) throws SaisieException {
        super(lastName, firstName, adress, postCode, city, phone, email);
        this.setBirthDateFromString(birthDate);
        this.setMutualInsurance(mutualInsurance);
        this.setDoctor(doctor);
        this.setNIR(NIR);
    }

    public String getNIR() {
        return NIR;
    }
    public void setNIR(String NIR) throws SaisieException {
        if(!Validator.isValidNIR(NIR)){
            throw new SaisieException("Erreur Saisie NIR :"+ NIR.length());
        }
        this.NIR = NIR;
    }
    public String getBirthDate() {
        return DateFormat.formatDate(birthDate, "dd-MM-yyyy");
    }
    public void setBirthDateFromString(String birthDate) {
        this.birthDate = DateFormat.parseDateFromString(birthDate);
    }
    public MutualInsurance getMutualInsurance() {
        return mutualInsurance;
    }
    public void setMutualInsurance(MutualInsurance mutualInsurance) {
        this.mutualInsurance = mutualInsurance;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
