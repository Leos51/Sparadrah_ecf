package fr.sparadrah.ecf.model.purchase;

import fr.sparadrah.ecf.model.medicine.Medicine;

public class CartItem {
    private Medicine medicine;
    private int quantity;


    public CartItem(Medicine medicine, int quantity) {
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

    public double getPrice() {
        return medicine.getPrice();
    }


    public double getLinePrice() {
        return this.getPrice() * this.getQuantity();
    }





    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Medicament : ").append(medicine);
        sb.append(", Quantité : ").append(quantity);
        return sb.toString();
    }
}
