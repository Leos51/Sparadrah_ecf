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


    public void removeMedicine(Medicine medicine) {
        this.medicines.remove(medicine);
    }

    public static List<Medicine> getMedicines() {
        return medicines;
    }

    /**
     * Reduit la quantité en stock d’un médicament donné.
     * Stock -= Quantité
     * @param medecineName nom du medicament
     * @param quantity  Quantité a retirer de la quantité en stock
     */
    public void reduceStock(String medecineName ,int quantity) {
        Medicine m = MedicineList.findMedicineByName( medecineName );
        assert m != null;
        m.reduceStock(quantity);
    }

    /**
     * Augmente la quantité en stock d’un médicament donné.
     * Stock += quantité
     * @param medecineName nom du medicament
     * @param quantity  Quantité à ajouter au stock
     */
    public void restock(String medecineName, int quantity) {
        Medicine m = MedicineList.findMedicineByName( medecineName );
        assert m != null;
        m.restock(quantity);

    }

    /**
     *
     * @param m Nom du medicament
     * @return Medicament recherché
     */
    public static Medicine findMedicineByName(String m){
        for (Medicine medicine : medicines) {
            if(m.equalsIgnoreCase(medicine.getMedicineName())){
                return medicine;
            }
        }
        return null;
    }
}
