package fr.sparadrah.ecf.controller;


import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.utils.UserInput;
import fr.sparadrah.ecf.view.consoleview.MainMenu;
import fr.sparadrah.ecf.view.swingview.MainFrame;

import static fr.sparadrah.ecf.controller.medecine.CategoriesController.seedCategoriesData;
import static fr.sparadrah.ecf.controller.medecine.MedicationController.seedMedicationData;
import static fr.sparadrah.ecf.controller.medecine.PrescriptionController.seedPrecriptionData;
import static fr.sparadrah.ecf.controller.person.CustomerController.seedCustomersData;
import static fr.sparadrah.ecf.controller.person.DoctorController.seedDoctorData;
import static fr.sparadrah.ecf.controller.person.MutualInsuranceController.seedMutualInsuranceData;
import static fr.sparadrah.ecf.controller.purchase.PurchaseController.seedPurchaseData;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.run();
        }

        private void run(){
            initData();
//            askConsoleOrSwing();
startSwing();







    }

    private void askConsoleOrSwing(){
        int rep;
        do{
            System.out.println("1 - Demarrer en mode console");
            System.out.println("2 - Demarrer en mode fenetre");
            rep = UserInput.getIntValue("Votre Choix :");
            switch(rep){
                case 1-> startConsole();
                case 2 -> startSwing();
                default -> System.err.println("Choix invalide. Réessayez!");
            }
        }while(rep != 1 && rep != 2);

    }


    private void startConsole(){
        MainMenu.display();
    }

    private void startSwing(){
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }

    private void initData() {
        try{
            seedCategoriesData();
            seedMedicationData();
            seedMutualInsuranceData();
            seedDoctorData();
            seedCustomersData();
            seedPrecriptionData();
            seedPurchaseData();
            System.out.println("Nombre client : " + CustomersList.getCustomers().size());
        }catch(Exception e){
            System.err.println("Erreur init" + e.getMessage());;
        }
    }
}