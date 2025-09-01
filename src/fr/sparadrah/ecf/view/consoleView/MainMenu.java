package fr.sparadrah.ecf.view.consoleView;

import fr.sparadrah.ecf.utils.UserInput;

public class MainMenu {
    public static void displayMainMenu(){
        System.out.println("----------------");
        System.out.println("| \uD83E\uDE79 Sparadrah |");
        System.out.println("----------------");
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
                case 1 -> System.out.println("Votre choix : 1");
                case 2 -> System.out.println("Votre choix : 2");
                case 3 -> System.out.println("Votre choix : 3");
                case 4 -> System.out.println("Votre choix : 4");
                case 0 -> exitApp();
                default -> System.err.println("Choix invalide.");
            }
        }while(!valid);
    }

    private static void exitApp() {
        System.out.println("Au revoir");
        System.exit(0);
    }
}


