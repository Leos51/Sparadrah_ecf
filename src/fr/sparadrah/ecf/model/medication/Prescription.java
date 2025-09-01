package fr.sparadrah.ecf.model.medication;

import java.time.LocalDate;

public class Prescription {
    private LocalDate prescriptingDate;
    private String doctorName;
    private String customerName;
    private String[] medicationName;

    Prescription(LocalDate prescriptingDate, String doctorName, String customerName, String[] medicationName) {
        this.setPrescriptingDate(prescriptingDate);
        this.setDoctorName(doctorName);
        this.setCustomerName(customerName);
        this.setMedicationName(medicationName);
    }

    public LocalDate getPrescriptingDate() {
        return prescriptingDate;
    }
    public void setPrescriptingDate(LocalDate prescriptingDate) {
        this.prescriptingDate = prescriptingDate;
    }
    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String[] getMedicationName() {
        return medicationName;
    }
    public void setMedicationName(String[] medicationName) {
        this.medicationName = medicationName;
    }
}
