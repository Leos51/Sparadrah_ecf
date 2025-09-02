package fr.sparadrah.ecf.controller;


import fr.sparadrah.ecf.view.consoleview.MainMenu;

import static fr.sparadrah.ecf.controller.CategoriesController.seedCategoriesData;
import static fr.sparadrah.ecf.controller.CustomerController.seedCustomersData;
import static fr.sparadrah.ecf.controller.DoctorController.seedDoctorData;
import static fr.sparadrah.ecf.controller.InsuranceCompanyController.seedInsuranceCompanyData;
import static fr.sparadrah.ecf.controller.MedicationController.seedMedicationData;
import static fr.sparadrah.ecf.controller.PrescriptionController.seedPrecriptionData;
import static fr.sparadrah.ecf.controller.PurchaseController.seedPurchaseData;

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
            seedInsuranceCompanyData();
            seedDoctorData();
            seedCustomersData();
            seedInsuranceCompanyData();
            seedPrecriptionData();
            seedPurchaseData();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }




        MainMenu.displayMainMenu();

    }
}