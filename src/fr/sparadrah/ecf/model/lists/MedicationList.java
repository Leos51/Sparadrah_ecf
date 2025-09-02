package fr.sparadrah.ecf.model.lists;

import fr.sparadrah.ecf.model.medicine.Medicine;

import java.util.ArrayList;
import java.util.List;

public class MedicationList {
    private static List<Medicine> medicines = new ArrayList<Medicine>();

    public List<Medicine> getMedications() {
        return medicines;
    }
    public void setMedications(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public static void addMedication(Medicine medicine) {
        medicines.add(medicine);
    }


    public void deleteMedication(Medicine medicine) {
        this.medicines.remove(medicine);
    }
}
