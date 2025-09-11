package fr.sparadrah.ecf.model.lists.person;

import fr.sparadrah.ecf.model.person.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomersList {
    private static List<Customer> customers =  new ArrayList<Customer>();

    public static List<Customer> getCustomers() {
        return customers;
    }


    public static void addCustomer(Customer customer) {
        getCustomers().add(customer);
    }

    public static void removeCustomer(Customer customer) {
        getCustomers().remove(customer);
    }

    public static Customer findByNir(String nir) {
//        for (Customer c : customers) {
//            if (c.getNir().equals(nir)) {
//                return c;
//            }
//        }
        return customers
                .stream()
                .filter(c -> c.getNir().equals(nir))
                .findFirst()
                .orElse(null);
    }


}
