package fr.sparadrah.ecf.model;

import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.lists.medicine.PurchasedMedicine;
import fr.sparadrah.ecf.model.medicine.Medicine;
import fr.sparadrah.ecf.model.person.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private final LocalDate purchaseDate ;
    private Customer customer;
    private boolean isPrescriptionBased;
    private static List<PurchasedMedicine> purchasedMedicines = new ArrayList<PurchasedMedicine>();



    public Purchase(Customer customer, boolean isPrescriptionBased,  List<MedicineList> purchasedMedicines) {
        this.customer = customer;
        this.purchaseDate = LocalDate.now();
        this.isPrescriptionBased = isPrescriptionBased;

    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public List<PurchasedMedicine> getPurchasedMedicines() {
//        return purchasedMedicines;
//    }


    /**
     * @param medicines
     */
    public void setPurchasedMedicines(List<PurchasedMedicine> medicines) {
        purchasedMedicines = medicines;
    }
    public boolean isPrescriptionBased() {
        return isPrescriptionBased;
    }
    public void setPrescriptionBased(boolean isPrescriptionBased) {
        this.isPrescriptionBased = isPrescriptionBased;
    }

    public static void addMedicine(Medicine medicine, int quantity) {
        purchasedMedicines.add(new PurchasedMedicine(medicine,  quantity));
        medicine.reduceQuantity(quantity);
    }

    /**
     *
     * */
    public void removePurchasedMedicine(MedicineList medicine, int quantity) {
        purchasedMedicines.remove(medicine);//A creer : une condition permettant de retirer une certaine quantité seulement
    }

    public List<PurchasedMedicine> getPurchasedMedicines() {
        return new ArrayList<>(purchasedMedicines);
    }








}
