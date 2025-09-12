package fr.sparadrah.ecf.controller.person;

import fr.sparadrah.ecf.model.lists.person.DoctorList;
import fr.sparadrah.ecf.model.lists.person.MutualInsuranceList;
import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.model.person.Doctor;
import fr.sparadrah.ecf.model.person.MutualInsurance;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.view.consoleview.MainMenu;

public class CustomerController {

    public static void seedCustomersData() throws SaisieException {

        Doctor selectedDoctor1 = DoctorList.findDoctorByLicenseNumber("12345678913");
        Doctor selectedDoctor2 = DoctorList.findDoctorByLicenseNumber("12345678076");



        MutualInsurance selectedMutual = MutualInsuranceList.getMutualInsuranceList().getFirst();

        CustomersList.addCustomer(new Customer("Recto", "Verso", "3 rue Maurice de Broglie", "51000", "Chalons en Champagne", " 03 26 68 03 00", "rectoverso@gmail.com", "1885621486527", "18/01/1988" , selectedMutual, selectedDoctor1));
        CustomersList.addCustomer(new Customer("Lunch", "Happy", "10 rue des hauts", "51510", "Soudail", " 03 26 68 02 00", "happylunch@gmail.com", "1885621486522", "18/01/1782" , selectedMutual, selectedDoctor2 ));
    }

    public static void displayCustomersData(){
        System.out.println("Liste des Clients:");
        System.out.println("--------------------");
//        for(Customer customer : CustomersList.getCustomers()){
//            System.out.println(customer.toString() );
//        }
        CustomersList.getCustomers().forEach(System.out::println);
    }
}
