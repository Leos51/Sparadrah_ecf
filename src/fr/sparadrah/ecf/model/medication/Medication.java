package fr.sparadrah.ecf.model.medication;

import fr.sparadrah.ecf.utils.DateFormat;

import java.time.LocalDate;

public class Medication {
    private String medicationName;
    private Category categoryName;
    private double price;
    private LocalDate startDate;
    private int quantity;


    public Medication(double price, LocalDate startDate, int quantity, Category categoryName, String medicationName) {
        this.setMedicationName(medicationName);
        this.setCategoryName(categoryName);
        this.setMedicationName(medicationName);
        this.setPrice(price);
        this.setStartDate(startDate);
        this.setQuantity(quantity);
    }

    public String getMedicationName() {
        return medicationName;
    }
    public void setMedicationName(String medicationName) {
        this.medicationName = medicationName;
    }
    public Category getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(Category categoryName) {
        this.categoryName = categoryName;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getStartDate() {
        return DateFormat.formatFR(startDate);
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
