package fr.sparadrah.ecf.controller;

import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.medicine.Medicine;

public class MedicationController {
    public static void seedMedicationData() {
        MedicineList.addMedicine(new Medicine(1, "01-01-2020", 20,null ,"Advil"));
        MedicineList.addMedicine(new Medicine(3, "10_07_2019", 30, null, "Clamoxyl"));
        MedicineList.addMedicine(new Medicine(4, "25.12.2022", 15, null, "Pfizer"));
        MedicineList.addMedicine(new Medicine(5, "18 12 1995",10, null, "NoName"));
        MedicineList.addMedicine(new Medicine(6, "05/05/2023", 50, null, "ZymaD"));
        MedicineList.addMedicine(new Medicine(7, "30-08-2025", 100, null, "Aerius"));
    }
}
