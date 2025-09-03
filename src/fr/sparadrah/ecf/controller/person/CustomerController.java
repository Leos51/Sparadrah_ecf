package fr.sparadrah.ecf.controller.person;

import fr.sparadrah.ecf.model.person.Customer;
import fr.sparadrah.ecf.model.lists.person.CustomersList;
import fr.sparadrah.ecf.utils.exception.SaisieException;
import fr.sparadrah.ecf.view.consoleview.MainMenu;

public class CustomerController {

    public static void seedCustomersData() throws SaisieException {
        CustomersList.addCustomer(new Customer("Recto", "Verso", "3 rue Maurice de Broglie", "51000", "Chalons en Champagne", " 03 26 68 03 00", "rectoverso@gmail.com", "1825621486527", "18/12/1982" , null));
    }

    public static void displayCustomersData(){
        System.out.println("Liste des Clients:");
        System.out.println("--------------------");
        for(Customer customer : CustomersList.getCustomers()){
            System.out.println(customer.toString() );
        }
    }

    public static void displayCustomerDetails(Customer customer){
        System.out.println(customer.showDetails());
    }


}
