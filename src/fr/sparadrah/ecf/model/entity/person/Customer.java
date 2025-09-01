package fr.sparadrah.ecf.model.entity.person;


import fr.sparadrah.ecf.utils.DateFormat;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.validator.Validator;

import java.time.LocalDate;

import static fr.sparadrah.ecf.utils.DateFormat.parseFR;

public class Customer extends Person {
    private String NIR; //  Le NIR (Numéro d'inscription au Répertoire) est aussi appelé numéro de Sécurité sociale.
    private LocalDate birthDate;
    private String insuranceCompagny;
    private String doctorName;


    public Customer(String lastName, String firstName, String adress, String postCode, String city, String phone, String email, String NIR , String birthDate) throws SaisieException {
        super(lastName, firstName, adress, postCode, city, phone, email);
        this.setBirthDate(birthDate);
        this.setInsuranceCompagny(insuranceCompagny);
        this.setDoctorName(doctorName);
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
        return DateFormat.formatFR(birthDate);
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = parseFR(birthDate);
    }
    public String getInsuranceCompagny() {
        return insuranceCompagny;
    }
    public void setInsuranceCompagny(String insuranceCompagny) {
        this.insuranceCompagny = insuranceCompagny;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
