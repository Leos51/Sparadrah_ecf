package fr.sparadrah.ecf.model.medicine;

import fr.sparadrah.ecf.utils.DateFormat;
import fr.sparadrah.ecf.utils.exception.StockInsuffisantException;

import java.time.LocalDate;

public class Medicine {
    private String medicineName;
    private Category categoryName;
    private double price;
    private LocalDate releaseDate;
    private int stockQuantity;
    private int threshold = 10;


    public Medicine(double price, String releaseDate, int stockQuantity, Category categoryName, String medicineName) {
        this.setMedicineName(medicineName);
        this.setCategoryName(categoryName);
        this.setPrice(price);
        this.setReleaseDate(releaseDate);
        this.setStock(stockQuantity);
    }

    public String getMedicineName() {
        return medicineName;
    }
    public void setMedicineName(String medicineName) {
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
    public int getStock() {
        return stockQuantity;
    }
    public void setStock(int quantity) {
        this.stockQuantity = quantity;
    }

    public void reduceStock(int quantityToReduce)  {
        if (quantityToReduce > this.stockQuantity) {
            throw new StockInsuffisantException("Stock insuffisant !");
        }
        this.stockQuantity -= quantityToReduce;
        if(isLowStock(threshold)) {
            System.out.println("Stock bas - A restocker : " + this.getMedicineName());
        }
    }

    public void reduceQuantityByOne() {
        if (stockQuantity > 0) {
            stockQuantity --;
        }
        if(isLowStock(threshold)) {
            System.out.println("Stock bas - A restocker : " + this.getMedicineName());
        }
    }

    public void restock(int quantity){
        this.stockQuantity += quantity;
    }


    public boolean isOutOfStock(){
        return this.stockQuantity == 0;
    }

    public boolean isLowStock(int threshold) {
       return this.getStock() <= threshold ;
    }




    @Override
    public String toString() {
        return "nom : " + medicineName + " " +
                ", Prix : " + price +
                ", Quantité Stock : " + this.getStock() +"\n";
    }
}
