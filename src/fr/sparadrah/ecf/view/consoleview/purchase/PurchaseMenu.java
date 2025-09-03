package fr.sparadrah.ecf.view.consoleview.purchase;

import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.medicine.Medicine;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.purchase.Purchase;
import fr.sparadrah.ecf.model.purchase.PurchasedMedicine;
import fr.sparadrah.ecf.utils.UserInput;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.view.consoleview.MainMenu;

import java.util.ArrayList;
import java.util.List;

import static fr.sparadrah.ecf.controller.purchase.PurchaseController.purchaseMedicineInList;

public class PurchaseMenu {
    private void addPurchaseMenu(){
        System.out.println("-----------------------------");
        System.out.println("1 - Achat sur ordonnance");
        System.out.println("2 - Achat sans ordonnance");
        System.out.println("0 - Retour au menu principal");
    }

    private void choiceAddPurchaseMenu() throws SaisieException {
        int[] validChoices = {0,1,2};
        boolean valid = false;
        int userChoice;

        do {
            userChoice = UserInput.getIntValue("Votre Choix [1,2] ou [0] pour retourner au menu principal : ");

            for(int validChoice : validChoices){
                if(validChoice == userChoice){
                    valid = true;
                    break;
                }
            }
            switch (userChoice) {
                case 0 -> MainMenu.displayMainMenu();
                case 1 -> purchaseByPrescription();
                case 2 -> purchaseWhithoutPrescription();
                default -> System.out.println("choix invalide");
            }
        }while(!valid);

    }


    private void purchaseByPrescription(){
        System.out.println("Achat avec ordonnance");
    }
    private void purchaseWhithoutPrescription() throws SaisieException {
       List<PurchasedMedicine> temp = new ArrayList<>();

        System.out.println("Achat sans ordonnance");
        String customerName = UserInput.getStringValue("Saisir le numero de securité social du Client : ");
        Customer customer = CustomersList.findByNir(customerName);
        if(customer == null){
            System.err.println("Le nir n'est pas enregistré");
        }
        Purchase p = new Purchase(customer);
        System.out.println("Enregistrement des medicaments dans la liste d'achat :");
        String medicineName = UserInput.getStringValue("Nom du medicament : ");
        Medicine medicine = MedicineList.findMedicineByName(medicineName);
        if(medicine == null){
            throw new SaisieException("Medicament non inventorié ou saisie incorrect");
        }
        int quantity = UserInput.getIntValue("Quantite de ce medicament :");
        p.addMedicine(medicine, quantity);
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
