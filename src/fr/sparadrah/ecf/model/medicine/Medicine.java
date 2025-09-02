package fr.sparadrah.ecf.model.medicine;

import fr.sparadrah.ecf.utils.DateFormat;

import java.time.LocalDate;

public class Medicine {
    private String medicineName;
    private Category categoryName;
    private double price;
    private LocalDate releaseDate;
    private int quantity;


    public Medicine(double price, String releaseDate, int quantity, Category categoryName, String medicationName) {
        this.setMedicineName(medicationName);
        this.setCategoryName(categoryName);
        this.setPrice(price);
        this.setReleaseDate(releaseDate);
        this.setQuantity(quantity);
    }

    public String getMedicineName() {
        return medicineName;
    }
    public void setMedicineName(String medicationName) {
        this.medicineName = medicineName;
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
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = DateFormat.parseDateFromString(releaseDate);
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int reduceQuantity(int quantityToReduce) {
        if (quantityToReduce > quantity) {
            System.err.println("Stock insuffisant : " +
             this.quantity
             + ". Restock necessaire");
        }
        return quantity - quantityToReduce;
    }

    public void reduceQuantityByOne() {
        if (quantity > 0) {
            quantity --;
        }

    }
}
