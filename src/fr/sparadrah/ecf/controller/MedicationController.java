package fr.sparadrah.ecf.controller;

import fr.sparadrah.ecf.model.lists.MedicationList;
import fr.sparadrah.ecf.model.medicine.Medicine;
import fr.sparadrah.ecf.utils.DateFormat;

public class MedicationController {
    public static void seedMedicationData() {
        MedicationList.addMedication(new Medicine(1, "01-01-2020", 20,null ,"Advil"));
        MedicationList.addMedication(new Medicine(3, "10_07_2019", 30, null, "Clamoxyl"));
        MedicationList.addMedication(new Medicine(4, "25.12.2022", 15, null, "Pfizer"));
        MedicationList.addMedication(new Medicine(5, "18 12 1995",10, null, "NoName"));
        MedicationList.addMedication(new Medicine(6, "05/05/2023", 50, null, "ZymaD"));
        MedicationList.addMedication(new Medicine(7, "30-08-2025", 100, null, "Aerius"));
    }
}
