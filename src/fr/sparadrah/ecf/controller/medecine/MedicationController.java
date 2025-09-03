package fr.sparadrah.ecf.controller.medecine;

import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.medicine.Medicine;

public class MedicationController {
    public static void seedMedicationData() {
        Medicine doliprane = new Medicine(8,"18/10/1982",20,null,"Doliprane");
        Medicine ibuprofen = new Medicine(9,"02/03/2022",5,null, "Ibuprofen");
        MedicineList.addMedicine(new Medicine(1, "01/01/2020", 20,null ,"Advil"));
        MedicineList.addMedicine(new Medicine(3, "10/07/2019", 30, null, "Clamoxyl"));
        MedicineList.addMedicine(new Medicine(4, "25/12/2022", 15, null, "Pfizer"));
        MedicineList.addMedicine(new Medicine(5, "18/12/1995",10, null, "NoName"));
        MedicineList.addMedicine(new Medicine(6, "05/05/2023", 50, null, "ZymaD"));
        MedicineList.addMedicine(new Medicine(7, "30/08/2025", 100, null, "Aerius"));
        MedicineList.addMedicine(doliprane);
        MedicineList.addMedicine(ibuprofen);


    }

    public static void displayInventory() {
        System.out.println("Inventaire des medicaments");
        System.out.println("--------------------------");
        for (Medicine medicine : MedicineList.getMedicines()) {
            System.out.println(medicine.toString());
        }

    }
}
