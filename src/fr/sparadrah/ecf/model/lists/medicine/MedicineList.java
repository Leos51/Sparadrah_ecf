package fr.sparadrah.ecf.model.lists.medicine;

import fr.sparadrah.ecf.model.medicine.Medicine;

import java.util.ArrayList;
import java.util.List;

public class MedicineList {
    private static List<Medicine> medicines = new ArrayList<Medicine>();

    public List<Medicine> getMedicineList() {
        return medicines;
    }
    public void setMedicineList(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    public static void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }


    public void deleteMedication(Medicine medicine) {
        this.medicines.remove(medicine);
    }

    public static List<Medicine> getMedicines() {
        return medicines;
    }

    public static Medicine findMedicineByName(String m){
        for (Medicine medicine : medicines) {
            if(m.equalsIgnoreCase(medicine.getMedicineName())){
                return medicine;
            }
        }
        return null;
    }
}
