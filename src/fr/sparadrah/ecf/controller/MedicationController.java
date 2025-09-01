package fr.sparadrah.ecf.controller;

import fr.sparadrah.ecf.model.lists.CategoriesList;
import fr.sparadrah.ecf.model.lists.MedicationList;
import fr.sparadrah.ecf.model.medication.Medication;
import fr.sparadrah.ecf.utils.DateFormat;

import java.time.LocalDate;

public class MedicationController {
    public static void seedMedicationData() {
        MedicationList.addMedication(new Medication(1, DateFormat.parseFR("01-01-2020"), 20,null ,"Advil"));
        MedicationList.addMedication(new Medication(3, DateFormat.parseFR("10-07-2019"), 30, null, "Clamoxyl"));
        MedicationList.addMedication(new Medication(4, DateFormat.parseFR("25-12-2022"), 5, null, "Pfizer"));
        MedicationList.addMedication(new Medication(5, DateFormat.parseFR("18-12-1995"), 10, null, "NoName"));
        MedicationList.addMedication(new Medication(6, DateFormat.parseFR("05-05-2023"), 50, null, "ZymaD"));
        MedicationList.addMedication(new Medication(7, DateFormat.parseFR("30-08-2025"), 100, null, "Aerius"));
    }
}
