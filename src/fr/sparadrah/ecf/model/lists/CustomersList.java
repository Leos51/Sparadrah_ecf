package fr.sparadrah.ecf.model.lists;

import fr.sparadrah.ecf.model.entity.person.Customer;

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

    public void deleteCustomer(Customer customer) {
        getCustomers().remove(customer);
    }


}
