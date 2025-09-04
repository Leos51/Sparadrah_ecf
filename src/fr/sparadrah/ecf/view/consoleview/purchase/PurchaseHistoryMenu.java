package fr.sparadrah.ecf.view.consoleview.purchase;

import fr.sparadrah.ecf.controller.person.DoctorController;
import fr.sparadrah.ecf.controller.purchase.PurchaseController;
import fr.sparadrah.ecf.model.lists.purchase.PurchasesList;
import fr.sparadrah.ecf.model.purchase.Purchase;
import fr.sparadrah.ecf.utils.UserInput;

import java.util.ArrayList;
import java.util.List;

import static fr.sparadrah.ecf.view.consoleview.MainMenu.displayMainMenu;

public class PurchaseHistoryMenu {

    /**
     * Menu Historique d'achat
     */
    public static void displayPurchaseHistoryMenu(){
        System.out.println("---------------");
        System.out.println("1 - Filtrer par date");
        System.out.println("2 - Filtrer sur une periode precise");
        System.out.println("3 - Filtrer les achats du jour");
        System.out.println("4 - Afficher les detail d'un achat");
        System.out.println("0 - Retour");
        choicePurchaseHistoryMenu();

    }

    /**
     * Switchcase pour le menu de l'historique
     */
    public static void choicePurchaseHistoryMenu(){
        List<Purchase> purchases = new ArrayList<>();
        int[] validChoices = {0, 1, 2, 3, 4};
        boolean valid = false;
        int userChoice;
        do {
            userChoice = UserInput.getIntValue("Votre Choix [1-4] ou [0] pour retour : ");

            for(int validChoice : validChoices){
                if(userChoice == validChoice){
                    valid = true;
                    break;
                }
            }

            switch (userChoice) {
                case 1 -> {
                    String date = UserInput.getStringValue("Saisie de la date (dd/MM/aaaa)");
                    purchases = PurchasesList.findPurchaseByDate(date);
                    if(purchases.isEmpty()){
                        System.err.println("Pas d'achat");
                    }
                    for(Purchase purchase : purchases){
                        System.out.println(purchase);
                    }
                    displayPurchaseHistoryMenu();
                }
                case 2  -> {
                    String startdate = UserInput.getStringValue("Date debut (dd/MM/aaaa)");
                    String endDate = UserInput.getStringValue("Date fin (dd/MM/aaaa)");
                    purchases = PurchasesList.findPurchasebyPeriod(startdate, endDate);
                    if(purchases.isEmpty()){
                        System.err.println("Pas d'achat");
                    }
                    for(Purchase purchase : purchases){
                        System.out.println(purchase);
                    }
                    displayPurchaseHistoryMenu();
                }
                case 3 -> {
                    purchases = PurchasesList.findPurchaseOfDay();
                    if(purchases.isEmpty()){
                        System.err.println("Pas d'achat");
                    }
                    for(Purchase purchase : purchases){
                        System.out.println(purchase);
                    }
                    displayPurchaseHistoryMenu();
                }
                case 4 -> {
                    displaydetailPurchaseMenu();
                }
                case 0 -> displayMainMenu();
                default -> System.err.println("Erreur");
            }
        }while(!valid);
    }


    private static void displaydetailPurchaseMenu(){
        System.out.println("saisir l'id de l'achat :");
        String id = UserInput.getStringValue("ID pour ");
    }
}
