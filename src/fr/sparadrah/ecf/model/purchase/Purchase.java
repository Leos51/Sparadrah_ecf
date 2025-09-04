package fr.sparadrah.ecf.model.purchase;

import fr.sparadrah.ecf.model.lists.medicine.MedicineList;
import fr.sparadrah.ecf.model.medicine.Medicine;
import fr.sparadrah.ecf.model.medicine.Prescription;
import fr.sparadrah.ecf.model.person.Customer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Purchase {
    private LocalDate purchaseDate ;
    private Customer customer;
    private boolean isPrescriptionBased;
    private Prescription prescription;
    private List<PurchasedMedicine> purchasedMedicines = new ArrayList<PurchasedMedicine>();


    public Purchase(Customer customer) {

        this.setCustomer(customer);
        this.setPurchaseDate(LocalDate.now());
        this.setPrescriptionBased(false);
        this.purchasedMedicines = new ArrayList<>();
    }
    public Purchase(Customer customer, boolean isPrescriptionBased) {

        this.setCustomer(customer);
        this.setPurchaseDate(LocalDate.now());
        this.setPrescriptionBased(isPrescriptionBased);
        this.purchasedMedicines = new ArrayList<>();
    }

    public Purchase(LocalDate purchaseDate , Customer customer, boolean isPrescriptionBased) {
        this.setCustomer(customer);
        this.setPurchaseDate(purchaseDate);
        this.setPrescriptionBased(isPrescriptionBased);
        this.purchasedMedicines = new ArrayList<>();

    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Prescription getPrescription() {
        return prescription;
    }



    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }


    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }


    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

//    public List<PurchasedMedicine> getPurchasedMedicines() {
//        return purchasedMedicines;
//    }



    public void setPurchasedMedicines(List<PurchasedMedicine> medicines) {
        purchasedMedicines = medicines;
    }

    public boolean isPrescriptionBased() {
        return isPrescriptionBased;
    }

    public void setPrescriptionBased(boolean isPrescriptionBased) {
        this.isPrescriptionBased = isPrescriptionBased;
    }


    /**
     * Ajoute un medicament et sa quantité dans la liste d'achat
     * @param medicine Nom du medicament
     * @param quantity Quantité de medicament acheté par le client
     */
    public void addMedicine(Medicine medicine, int quantity) {

        this.purchasedMedicines.add(new PurchasedMedicine(medicine,  quantity));
        medicine.reduceStock(quantity);
    }

    public void reducePurchasedMedicine(Medicine medicine, int quantity) {

    }


    public void removePurchasedMedicine(MedicineList medicine) {
        purchasedMedicines.remove(medicine);//A creer : une condition permettant de retirer une certaine quantité seulement
    }

    public List<PurchasedMedicine> getPurchasedMedicines() {
        return new ArrayList<>(this.purchasedMedicines);
    }


    public String showDetails() {
        StringBuilder details = new StringBuilder();
        details.append(this);
        for(PurchasedMedicine p : this.purchasedMedicines) {
            details.append(p.toString());
        }
        details.append("\n");
        return details.toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Date d'achat : ").append(this.purchaseDate);
        sb.append(", Client : ").append(customer);
        return sb.toString();
    }
}
