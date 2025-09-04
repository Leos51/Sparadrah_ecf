package fr.sparadrah.ecf.view.consoleview.purchase;

import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.medicine.Medicine;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.purchase.Purchase;
import fr.sparadrah.ecf.model.purchase.PurchasedMedicine;
import fr.sparadrah.ecf.utils.UserInput;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.utils.exception.StockInsuffisantException;
import fr.sparadrah.ecf.view.consoleview.MainMenu;

import java.util.ArrayList;
import java.util.List;

import static fr.sparadrah.ecf.controller.purchase.PurchaseController.purchaseMedicineInList;
import static fr.sparadrah.ecf.utils.UserInput.exitApp;

public class PurchaseMenu {

    public static void display() {
        String userChoice;
        while(true){
            System.out.println("-----------------------------");
            System.out.println("1 - Achat direct");
            System.out.println("2 - Achat avec ordonnance");
            System.out.println("0 - Retour au menu principal");
            System.out.println("Q - Quitter l'application");

            userChoice = UserInput.getStringValue("Votre Choix : ").trim().toUpperCase();
            switch (userChoice) {
                case "1" -> createPurchase(false);
                case "2" -> createPurchase(true);
                case "0" -> MainMenu.displayMainMenu();
                case "Q" -> exitApp();
                default -> System.err.println("Choix invalide");
            }
        }
    }

    private static void createPurchase(Boolean isPrescriptionBased){
        System.out.println("Achat de medicaments");
        System.out.println("-----------------------------");
        String str = isPrescriptionBased ?
                "Achat avec ordonnance":
                "Achat sans ordonnance";
        System.out.println(str);
        System.out.println("-----------------------------");

        // Saisie client
        String nir = UserInput.getStringValue("Numéro de sécurité sociale du client : ");
        Customer customer = CustomersList.findByNir(nir);
        if(customer == null){
            System.err.println("Client introuvable");
            return;
        }
        // Création de l’achat
        Purchase p = new Purchase(customer , isPrescriptionBased);

        // Ajout de medicament
        boolean addMed = false;
        do{
            String medicineName = UserInput.getStringValue("Nom du medicament : ");
            Medicine medicine = MedicineList.findMedicineByName(medicineName);
            if(medicine == null){
                System.err.println("Médicament introuvable");
                continue;
            }
            int quantity = UserInput.getIntValue("Quantite de ce medicament :");
            try{
                p.addMedicine(medicine, quantity);
            }catch(StockInsuffisantException e){
                System.err.println(e.getMessage());
            }
            p.addMedicine(medicine, quantity);
            String res;
            do{
                res = UserInput.getStringValue("Ajouter un autre medicament? (o/n)").trim().toLowerCase();
            }while(!res.equalsIgnoreCase("o")&&!res.equalsIgnoreCase("n") );

            addMed = res.equalsIgnoreCase("o");
        }while(addMed);
        System.out.println(" Achat enregistré !");









    }


    private void purchaseWhithoutPrescription() throws SaisieException {





        System.out.println("Enregistrement des medicaments dans la liste d'achat :");

        System.out.println("");








        String medecineName = UserInput.getStringValue("Saisir le nom du medicament : ");
        Medicine m = MedicineList.findMedicineByName(medecineName);
        if(m == null){
            System.err.println("Le medicament n'est pas inventorié");
        }
    }

    public void addMedToListMenu(){
        System.out.println("Ajouter un medicament?");
        System.out.println("1 - Ajouter un medicament");
        System.out.println("2 - Clore la liste des medicaments et continuer");
        System.out.println("0 - Annuler et retourner au menu principal");

    }
    public void choiceAddMedToListMenu() throws SaisieException {
        int[] validChoices = {0,1,2};
        boolean valid = false;
        int userChoice;

        do {
            userChoice = UserInput.getIntValue("Votre Choix [1,2] ou [0] pour annuler : ");

            for(int validChoice : validChoices){
                if(validChoice == userChoice){
                    valid = true;
                    break;
                }
            }
            switch (userChoice){
                case 0 -> MainMenu.displayMainMenu();
                case 1 -> purchaseMedicineInList();
                case 2 -> {System.out.println("Liste Prete");
                }
            }
        }while(!valid);

    }
}
