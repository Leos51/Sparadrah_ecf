package fr.sparadrah.ecf.model.lists;

import fr.sparadrah.ecf.model.medication.Medication;

import java.util.ArrayList;
import java.util.List;

public class MedicationList {
    private static List<Medication> medications = new ArrayList<Medication>();

    public List<Medication> getMedications() {
        return medications;
    }
    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public static void addMedication(Medication medication) {
        medications.add(medication);
    }


    public void deleteMedication(Medication medication) {
        this.medications.remove(medication);
    }
}
