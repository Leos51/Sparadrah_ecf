package fr.sparadrah.ecf.model.lists.medicine;

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

}
