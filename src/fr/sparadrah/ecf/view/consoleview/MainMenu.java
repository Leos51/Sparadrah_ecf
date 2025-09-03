package fr.sparadrah.ecf.view.consoleview;

import fr.sparadrah.ecf.controller.person.CustomerController;
import fr.sparadrah.ecf.controller.person.DoctorController;
import fr.sparadrah.ecf.controller.purchase.PurchaseController;

import fr.sparadrah.ecf.utils.UserInput;


/**
 * affiche le menu principal
 */
public class MainMenu {
    public static void displayMainMenu(){
        System.out.println("---------------------------------");
        System.out.println("| \uD83E\uDE79 Sparadrah - Menu Principal |");
        System.out.println("---------------------------------");
        System.out.println("1 - Effectuer un achat");
        System.out.println("2 - Consulter l'historique d'achat");
        System.out.println("3 - Consulter les medecins");
        System.out.println("4 - Consulter les clients");
        System.out.println("0 - Quitter");
        System.out.println("----------------");
        choiceMainMenu();
    }

    public static void choiceMainMenu(){
        int[] validChoices = {0, 1, 2, 3, 4};
        boolean valid = false;
        int userChoice;
        do{
            userChoice = UserInput.getIntValue("Votre Choix [1-4] ou [0] pour quitter : ");

            for(int validChoice : validChoices){
                if(userChoice == validChoice){
                    valid = true;
                    break;
                }
            }
            switch (userChoice) {
                case 1 -> {

                }
                case 2 -> PurchaseController.displayPurchaseData();
                case 3 -> {
                    DoctorController.displayDoctors();
                    DoctorMenu.detailDoctorMenu();
                }
                case 4 -> {
                    CustomerController.displayCustomersData();
                    CustomerMenu.detailCustomerMenu();
                }
                case 0 -> exitApp();
                default -> System.err.println("Choix invalide.");
            }
        }while(!valid);
    }

    /**
     * Permet de sortir de l'application
     */
    private static void exitApp() {
        System.out.println("Au revoir");
        System.exit(0);
    }
}


