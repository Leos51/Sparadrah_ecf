package fr.sparadrah.ecf.controller;

import fr.sparadrah.ecf.model.entity.person.Customer;
import fr.sparadrah.ecf.model.lists.CustomersList;
import fr.sparadrah.ecf.utils.exception.SaisieException;

public class CustomerController {

    public static void seedCustomersData() throws SaisieException {
        CustomersList.addCustomer(new Customer("Recto", "Verso", "3 rue Maurice de Broglie", "51000", "Chalons en Champagne", " 03 26 68 03 00", "rectoverso@gmail.com", "1825621486527"));
    }


}
