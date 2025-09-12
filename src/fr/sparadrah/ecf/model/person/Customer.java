package fr.sparadrah.ecf.model.person;


import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.utils.DateFormat;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.validator.Validator;

import java.time.LocalDate;


public class Customer extends Person {
    private String nir; //  Le NIR (Numéro d'inscription au Répertoire) est aussi appelé numéro de Sécurité sociale.
    private LocalDate birthDate;
    private MutualInsurance mutualInsurance;
    private Doctor doctor;

    public Customer(){
        super();
    }

    public Customer(String lastName, String firstName, String address, String postCode, String city, String phone, String email, String nir , String birthDate, MutualInsurance mutualInsurance, Doctor doctor) throws SaisieException {
        super(lastName, firstName, address, postCode, city, phone, email);
        this.setBirthDateFromString(birthDate);
        this.setMutualInsurance(mutualInsurance);
        this.setDoctor(doctor);
        this.setNir(nir);
    }

    /**
     * nir = numero de securité social
     * @return nir : String
     */
    public String getNir() {
        return nir;
    }
    public void setNir(String nir) throws SaisieException {
        if(!Validator.isValidNIR(nir)){
            throw new SaisieException("Erreur Saisie NIR :"+ nir.length());
        }
        this.nir = nir;
    }
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) throws SaisieException {
        if(birthDate == null){
            throw new SaisieException("Le date doit pas etre vide");
        }
        this.birthDate = birthDate;
    }

    /**
     * transforme la date de naissance en LocalDate pour l'enregistrement
     * @param birthDate : String
     */
    public void setBirthDateFromString(String birthDate) throws SaisieException {
        if (birthDate == null || birthDate.isEmpty()){
            throw new SaisieException("La date de naissance ne doit pas etre vide");
        }
        if (birthDate.length() != 10){
            throw new SaisieException("La date de format doit etre du type \"dd/MM/aaaa\"");
        }
//        this.setBirthDate(LocalDate.parse(birthDate));
        this.setBirthDate(DateFormat.parseDateFromString(birthDate));
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
    private void setDoctor(Doctor doctor) throws SaisieException {
        if(doctor == null){
            System.out.println("Le medecin n'est pas entré");
        }
        this.doctor = doctor;
    }

    public void setDoctorByLicenseNumber(String str) throws SaisieException {
        Doctor doctorTemp = DoctorList.findDoctorByLicenseNumber(str);
        if(doctorTemp == null){
            throw new SaisieException("Numéro d’agréement inconnu");
        }
        this.setDoctor(doctorTemp);
    }



    @Override
    public String showDetails() {
        StringBuilder details = new StringBuilder();
        details.append(this);
        details.append("\n------------------");
        details.append(super.showDetails());
        details.append("\nMutuelle : ");
        details.append(this.getMutualInsurance() != null?
                this.getMutualInsurance():
                "Pas de Mutuelle"
                );
        details.append("\nDoctor : ");
        details.append(this.getDoctor() != null?
                this.getDoctor():
                "Pas de medecin réferent"
        );
        return details.toString();
    }

    @Override
    public String toString() {
        return super.toString() +
                " - NIR : " + this.getNir();
    }
}
