package fr.sparadrah.ecf.model.purchase;

import fr.sparadrah.ecf.model.medicine.Medicine;

public class PurchasedMedicine {
    private Medicine medicine;
    private int quantity;


    public PurchasedMedicine(Medicine medicine, int quantity) {
        this.setMedicine(medicine);
        this.setQuantity(quantity);
    }


    public void setMedicine(Medicine medicine) {
        this.medicine = medicine;
    }

    public Medicine getMedicine() {
        return medicine;
    }

    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }





    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Medicament : ").append(medicine);
        sb.append(", Quantité : ").append(quantity);
        return sb.toString();
    }
}
