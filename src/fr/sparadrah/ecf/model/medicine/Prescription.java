package fr.sparadrah.ecf.model.medicine;

import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.utils.DateFormat;
import fr.sparadrah.ecf.utils.exception.SaisieException;

import java.beans.MethodDescriptor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prescription {
    private static LocalDate prescriptingDate;
    private static Doctor doctor;
    private static Customer customer;
    private static List<Medicine> prescriptedMedicines = new ArrayList<>();


    public Prescription(String prescriptingDate, Doctor doctor, Customer customer, List<Medicine> medicines) {
        setPrescriptingDate(prescriptingDate);
        setDoctor(doctor);
        setCustomer(customer);
        setPrescriptedMedicines(medicines);
    }

    public static LocalDate getPrescriptingDate() {
        return prescriptingDate;
    }
    public void setPrescriptingDate(String prescriptingDate) throws SaisieException {
        if(prescriptingDate == null || prescriptingDate.isEmpty()){
            throw new SaisieException("La date de prescription ne doit pas etre null ou vide !");
        }
        this.prescriptingDate = DateFormat.parseDateFromString(prescriptingDate);
    }
    public static Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) throws SaisieException {
        if(doctor == null){
            throw new SaisieException("Le medecin ne peut pas etre null");
        }
        this.doctor = doctor;
    }
    public static Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) throws SaisieException {
        if(customer == null){
            throw new SaisieException("Le client ne doit pas etre null");
        }
        this.customer = customer;
    }
    public static List<Medicine> getPrescriptedMedicines() {
        return prescriptedMedicines;
    }
    public void setPrescriptedMedicines(List<Medicine> medicines) throws SaisieException {
        if(medicines == null){
            throw new IllegalArgumentException("La liste des medicament ne peut pas etre null");
        }
        if(medicines.isEmpty()){
            throw new SaisieException("La liste de medicaments ne doit pas etre vide");
        }
        this.prescriptedMedicines = medicines;
    }

   public static void addMedicine(Medicine medicine) {
        if(medicine == null){
            throw new IllegalArgumentException("Le medicament ne peut pas etre null");
        }
        if(getPrescriptedMedicines().contains(medicine)){
            System.err.println("Medicament deja present dans la liste");

        }
        prescriptedMedicines.add(medicine);
   }

    public static void removeMedicine(Medicine medicine) throws SaisieException {
        if(medicine == null){
            throw new IllegalArgumentException("Le medicament ne peut pas etre null");
        }
        if(!prescriptedMedicines.contains(medicine)){
            throw new SaisieException("Le medicament n'est pas dans la liste")
        }
        prescriptedMedicines.remove(medicine);
    }

    @Override
    public String toString() {
        return "date prescription : " + getPrescriptingDate() + " - Customer : " + getCustomer();
    }
}
