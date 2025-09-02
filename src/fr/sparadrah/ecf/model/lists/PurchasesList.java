package fr.sparadrah.ecf.model.lists;

import fr.sparadrah.ecf.model.Purchase;

import java.util.ArrayList;
import java.util.List;

public class PurchasesList {
    List<Purchase> purchases = new ArrayList<>();

    public List<Purchase> getPurchases() {
        return purchases;
    }
    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
    public void addPurchase(Purchase purchase){
        purchases.add(purchase);
    }
    public void removePurchase(Purchase purchase){
        purchases.remove(purchase);
    }
//    public Purchase findPurchaseByPInvoiceNum(String invoiceNumber){
//        for (Purchase purchase : purchases) {
//            if()
//        }
//    }

    public List<Purchase> findPurchaseByCustomerNir(String customerNir){
        List<Purchase> customerPurchases = new ArrayList<>();
        for (Purchase purchase : purchases) {
            if(customerNir.equalsIgnoreCase(purchase.getCustomer().getNir())){
                customerPurchases.add(purchase);
            }
        }
        return  customerPurchases;
    }
}
