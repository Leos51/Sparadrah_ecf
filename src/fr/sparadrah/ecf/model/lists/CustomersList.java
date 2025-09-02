package fr.sparadrah.ecf.model.lists;

import fr.sparadrah.ecf.model.person.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomersList {
    static List<Customer> customers =  new ArrayList<Customer>();

    public static List<Customer> getCustomers() {
        return customers;
    }
//    public void setCustomers(List<Customer> customers) {
//        this.customers = customers;
//    }

    public static void addCustomer(Customer customer) {
        getCustomers().add(customer);
    }

    public void removeCustomer(Customer customer) {
        getCustomers().remove(customer);
    }

    public Customer findByNIR(String nir) {
        for (Customer c : customers) {
            if (c.getNIR().equals(nir)) {
                return c;
            }
        }
        return null;
    }


}
