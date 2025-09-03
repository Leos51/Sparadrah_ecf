package fr.sparadrah.ecf.view.consoleview;

import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.utils.UserInput;

public class CustomerMenu {
    public static void detailCustomerMenu(){
        System.out.println("------------------------------");
        System.out.println("Afficher les detail d'un client ?");
        System.out.println("1 - Choisir un client par numSecu");
        System.out.println("0 - Retour au menu principal");
        choiceDetailCustomerMenu();
    }

    public static void choiceDetailCustomerMenu(){
        int[] validChoices = {0, 1};
        boolean valid = false;
        int userChoice;

        do{
            userChoice = UserInput.getIntValue("Votre Choix [1] ou [0] pour retourner au menu principal : ");

            for(int validChoice : validChoices){
                if(userChoice == validChoice){
                    valid = true;
                    break;
                }
            }
            switch (userChoice) {
                case 1 -> {
                    String r = UserInput.getStringValue("Saisir le N° de secu : ");
                    Customer c = CustomersList.findByNir(r);
                    if(c == null){
                        System.err.println("Le numero n'existe pas");
                    }
                    else{
                        System.out.println(c.showDetails());
                    }
                }
                case 0 -> MainMenu.displayMainMenu();
                default -> System.err.println("Choix invalide.");
            }
        }while(!valid);
    }
}
