package fr.sparadrah.ecf.controller.medecine;

import fr.sparadrah.ecf.model.lists.medicine.CategoriesList;
import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.medicine.Category;
import fr.sparadrah.ecf.model.medicine.Medicine;
import fr.sparadrah.ecf.utils.exception.SaisieException;

public class MedicationController {
    public static void seedMedicationData() {
        try{
            Category c = CategoriesList.findCategoryByName("Analgésiques");

            Medicine doliprane = new Medicine(8,"18/10/1982",20, c,"Doliprane");
            Medicine ibuprofen = new Medicine(9,"02/03/2022",5, c, "Ibuprofen");
            MedicineList.addMedicine(new Medicine(1, "01/01/2020", 20, c ,"Advil"));
            MedicineList.addMedicine(new Medicine(3, "10/07/2019", 30, c, "Clamoxyl"));
            MedicineList.addMedicine(new Medicine(4, "25/12/2022", 15, c, "Pfizer"));
            MedicineList.addMedicine(new Medicine(5, "18/12/1995",10, c, "NoName"));
            MedicineList.addMedicine(new Medicine(6, "05/05/2023", 50, c, "ZymaD"));
            MedicineList.addMedicine(new Medicine(7, "30/08/2025", 100, c, "Aerius"));
            MedicineList.addMedicine(doliprane);
            MedicineList.addMedicine(ibuprofen);
        }catch(SaisieException e){
           System.err.println("Erreur initialisation Medicaments : " + e.getMessage());
        }

    }

    public static void displayInventory() {
        System.out.println("Inventaire des medicaments");
        System.out.println("--------------------------");
        for (Medicine medicine : MedicineList.getMedicines()) {
            System.out.println(medicine.toString());
        }

    }
}
