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

    public static List<Customer> filterCustomers(String pSearch) {
        String search = pSearch.toLowerCase().trim();
        List<Customer> filteredCustomers = getCustomers().stream()
                .filter(customer ->
                                customer.getFullName().toLowerCase().contains(search) ||
                                        customer.getNir().contains(search) ||
                                        customer.getEmail().contains(search) ||
                                        customer.getCity().toLowerCase().contains(search)

                        ).toList();
        return filteredCustomers;
    };

    public static Customer findByFullName(String fullName) {
        String search = fullName.toLowerCase().trim();
        for(Customer customer : getCustomers()) {
            if(customer.getFullName().toLowerCase().equalsIgnoreCase(search)) {
                return customer;
            }
        }
        return null;
    };


}
