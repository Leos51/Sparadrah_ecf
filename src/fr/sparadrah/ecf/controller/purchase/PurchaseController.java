package fr.sparadrah.ecf.controller.purchase;

import fr.sparadrah.ecf.model.lists.purchase.PurchasesList;
import fr.sparadrah.ecf.model.purchase.Purchase;
import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.view.consoleview.purchase.PurchaseHistoryMenu;



public class PurchaseController {

    /**
     * Initialisation d'achats
     */
    public static void seedPurchaseData() {

        Customer c = CustomersList.findByNir("1885621486527");
        Purchase p1 = new Purchase(c, true);
        Purchase p2 = new Purchase(null, false);
        p1.setCustomer(c);
        p2.setCustomer(c);
        p1.addMedicine(MedicineList.findMedicineByName("Advil"), 2);
        p1.addMedicine(MedicineList.findMedicineByName("Doliprane"), 2);
        p1.addMedicine(MedicineList.findMedicineByName("Ibuprofen"), 2);
        p2.addMedicine(MedicineList.findMedicineByName("Doliprane"), 2);
        PurchasesList.addPurchase(p1);
        PurchasesList.addPurchase(p2);
    }


    /**
     * Affiche les achats effectué
     */
    public static void displayAllPurchases() {
        for (Purchase p : PurchasesList.getPurchases()) {
            System.out.println(p);
        }
    }

    /**
     * Ajoute un titre au dessus de l affichage des achat
     */
    public static void displayPurchaseData() {
        System.out.println("Historique des achats");
        System.out.println("---------------------");
        displayAllPurchases();
        PurchaseHistoryMenu.displayPurchaseHistoryMenu();
    }

    public static double calculateReimbursement(Purchase p, double totalPrice){

        double reimbursementRate = p.getCustomer().getMutualInsurance().getReimbursementRate();
        double reimbursement = totalPrice * reimbursementRate;
        return reimbursement;
    }

    public static double calculateTotal(Purchase p){
        double total = p.getPurchasedMedicines().stream().mapToDouble(item -> {
           double medPrice =  item.getMedicine().getPrice();
           int quantity = item.getQuantity();
           return medPrice * quantity;

        }).sum();
        return total;
    };

    public static void printLineReceipt(Purchase p){
        p.getPurchasedMedicines().forEach(item -> {
            String medName = item.getMedicine().getMedicineName();
            double medPrice = item.getMedicine().getPrice();
            int quantity = item.getQuantity();
            double lineTotal = medPrice * quantity;
            System.out.println(medName + " " + medPrice + " x " + quantity  + " " + lineTotal);
        });
    }












}
