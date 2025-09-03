package fr.sparadrah.ecf.view.consoleview;

import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.utils.UserInput;


public class DoctorMenu {
    public static void detailDoctorMenu(){
        System.out.println("------------------------------");
        System.out.println("Afficher les detail d'un medecin ?");
        System.out.println("1 - Choisir un medecin par num cerf");
        System.out.println("0 - Retour au menu principal");
        choiceDetailDoctorMenu();
    }

    public static void choiceDetailDoctorMenu(){
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
                    String r = UserInput.getStringValue("Saisir le N° du medecin : ");
                    Doctor d = DoctorList.findDoctorByCertifNum(r);
                    if(d == null){
                        System.err.println("Le numero n'existe pas");
                    }
                    else{
                        System.out.println(d.showDetails());
                    }
                }
                case 0 -> MainMenu.displayMainMenu();
                default -> System.err.println("Choix invalide.");
            }
        }while(!valid);
    }
}
