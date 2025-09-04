package fr.sparadrah.ecf.controller;


import fr.sparadrah.ecf.view.consoleview.MainMenu;

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
        try{
            seedCategoriesData();
            seedMedicationData();
            seedMutualInsuranceData();
            seedDoctorData();
            seedCustomersData();
            seedPrecriptionData();
            seedPurchaseData();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }



        MainMenu.display();

    }
}