package fr.sparadrah.ecf.model.medicine;

import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.utils.DateFormat;

import java.beans.MethodDescriptor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Prescription {
    private LocalDate prescriptingDate;
    private Doctor doctor;
    private Customer customer;
    private List<Medicine> prescriptedMedicines = new ArrayList<>();


    Prescription(String prescriptingDate, Doctor doctor, Customer customer, List<Medicine> medicines) {
        this.setPrescriptingDate(prescriptingDate);
        this.setDoctor(doctor);
        this.setCustomer(customer);
        this.setPrescriptedMedicines(medicines);
    }

    public LocalDate getPrescriptingDate() {
        return prescriptingDate;
    }
    public void setPrescriptingDate(String prescriptingDate) {
        this.prescriptingDate = DateFormat.parseDateFromString(prescriptingDate);
    }
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List<Medicine> getPrescriptedMedicines() {
        return prescriptedMedicines;
    }
    public void setPrescriptedMedicines(List<Medicine> medicines) {
        this.prescriptedMedicines = medicines;
    }

   public void addMedicine(Medicine medicine) {
        this.prescriptedMedicines.add(medicine);
   }

    public void removeMedicine(Medicine medicine) {
        prescriptedMedicines.remove(medicine);
    }

}
