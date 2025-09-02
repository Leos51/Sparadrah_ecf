package fr.sparadrah.ecf.model.medicine;

import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.utils.DateFormat;

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
    public void setPrescriptingDate(String prescriptingDate) {
        this.prescriptingDate = DateFormat.parseDateFromString(prescriptingDate);
    }
    public static Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public static Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public static List<Medicine> getPrescriptedMedicines() {
        return prescriptedMedicines;
    }
    public void setPrescriptedMedicines(List<Medicine> medicines) {
        this.prescriptedMedicines = medicines;
    }

   public static void addMedicine(Medicine medicine) {
        prescriptedMedicines.add(medicine);
   }

    public static void removeMedicine(Medicine medicine) {
        prescriptedMedicines.remove(medicine);
    }

}
