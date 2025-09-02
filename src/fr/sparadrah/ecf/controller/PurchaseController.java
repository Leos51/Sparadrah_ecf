package fr.sparadrah.ecf.controller;

import fr.sparadrah.ecf.model.Purchase;
import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.lists.medicine.PurchasedMedicine;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Customer;

import java.time.LocalDate;

public class PurchaseController {
    public static void seedPurchaseData() {
        Customer c = CustomersList.findByNir("1825621486527");

        Purchase.addMedicine(MedicineList.findMedicineByName("Advil"), 2);
        Purchase.addMedicine(MedicineList.findMedicineByName("Doliprane"), 2);
        Purchase.addMedicine(MedicineList.findMedicineByName("Ibuprofen"), 6); // ⚠️ Stock insuffisant


        for (PurchasedMedicine item : Purchase.getPurchasedMedicines()) {
            System.out.println("🧾 " + item.getMedicine().getMedicineName() + " x" + item.getQuantity());
        }

    }



}
