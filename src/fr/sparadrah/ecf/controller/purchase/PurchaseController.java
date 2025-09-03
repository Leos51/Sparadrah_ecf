package fr.sparadrah.ecf.controller.purchase;

import fr.sparadrah.ecf.model.lists.purchase.PurchasesList;
import fr.sparadrah.ecf.model.medicine.Medicine;
import fr.sparadrah.ecf.model.purchase.Purchase;
import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.utils.UserInput;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.view.consoleview.purchase.PurchaseHistoryMenu;

import static fr.sparadrah.ecf.view.consoleview.MainMenu.displayMainMenu;


public class PurchaseController {

    /**
     * Initialisation d'achats
     */
    public static void seedPurchaseData() {
        Customer c = CustomersList.findByNir("1825621486527");
        Purchase p1 = new Purchase(null, false);
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


    /**
     *
     * @throws SaisieException
     */
    public static void purchaseMedicineInList() throws SaisieException {
        String medicineName = UserInput.getStringValue("Nom du medicament : ");
        Medicine medicine = MedicineList.findMedicineByName(medicineName);
        if(medicine == null){
            throw new SaisieException("Medicament non inventorié ou saisie incorrect");
        }

    }









}
