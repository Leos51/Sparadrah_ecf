package fr.sparadrah.ecf.controller;

import fr.sparadrah.ecf.model.Purchase;
import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Customer;

public class PurchaseController {
    public static void seedPurchaseData() {
        Customer c = CustomersList.findByNir("1825621486527");

        Purchase.addMedicine(MedicineList.findMedicineByName("Advil"), 2);
        Purchase.addMedicine(MedicineList.findMedicineByName("Clamoxyl"), 5);

        Purchase b = new Purchase(c,false, null);


    }



}
